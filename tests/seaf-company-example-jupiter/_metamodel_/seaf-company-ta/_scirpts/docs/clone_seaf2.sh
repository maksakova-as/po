#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
# FIX: Убраны лишние пробелы в конце URL (критично!)
BASE_URL="https://sberworks.ru/bitbucket-ci/scm/kbdzo"
MAIN_REPO="seaf-company-example-jupiter"
MAIN_URL="$BASE_URL/$MAIN_REPO.git"

CERT_P12_DEFAULT=""
CERT_PEM_DEFAULT=""

# Allow overrides
CERT_P12="${CERT_P12:-}"
CERT_PEM="${CERT_PEM:-}"
CERT_KEY="${CERT_KEY:-}"
USE_P12="${USE_P12:-}"
SSL_VERIFY="${SSL_VERIFY:-false}"
CA_CERT="${CA_CERT:-}"
CONNECT_TIMEOUT="${CONNECT_TIMEOUT:-}"
LOW_SPEED_LIMIT="${LOW_SPEED_LIMIT:-}"
LOW_SPEED_TIME="${LOW_SPEED_TIME:-}"
RETRY_COUNT="${RETRY_COUNT:-3}"
RETRY_SLEEP="${RETRY_SLEEP:-5}"
GIT_PROXY="${GIT_PROXY:-}"
REPOS="${REPOS:-}"
AUTO_ALL="${AUTO_ALL:-}"
SKIP_MAIN="${SKIP_MAIN:-}"
USE_WHIPTAIL="${USE_WHIPTAIL:-}"

# Global variables for extracted certs
GLOBAL_CERT_PEM=""
GLOBAL_KEY_PEM=""
TMP_DIR=""

log() { printf '%s\n' "$*"; }

has_cmd() { command -v "$1" >/dev/null 2>&1; }

ensure_git() {
  if ! has_cmd git; then
    log "ERROR: git is not installed or not in PATH."
    exit 1
  fi
}

cleanup() {
  if [[ -n "$TMP_DIR" && -d "$TMP_DIR" ]]; then
    rm -rf "$TMP_DIR"
  fi
}
trap cleanup EXIT

find_certificate() {
  # Search in current directory
  log "Searching for certificates in $ROOT_DIR..."

  # Check for P12
  if [[ -z "$CERT_P12" ]]; then
      local p12_found
      p12_found="$(find "$ROOT_DIR" -maxdepth 1 -name "*.p12" | head -n 1)"
      if [[ -n "$p12_found" ]]; then
        CERT_P12="$p12_found"
        log "Found P12 certificate: $CERT_P12"
      fi
  fi

  # Check for PEM
  if [[ -z "$CERT_PEM" ]]; then
      local pem_found
      pem_found="$(find "$ROOT_DIR" -maxdepth 1 -name "*.pem" | head -n 1)"
      if [[ -n "$pem_found" ]]; then
        CERT_PEM="$pem_found"
        log "Found PEM certificate: $CERT_PEM"
      fi
  fi

  # If we have at least one, we are good.
  if [[ -n "$CERT_P12" || -n "$CERT_PEM" ]]; then
      return 0
  fi

  # Interactive prompt if neither found
  if is_tty; then
    echo "" >&2
    echo "No certificates (.p12 or .pem) found in $ROOT_DIR." >&2
    echo "Please provide the path to your certificate file." >&2
    while true; do
      read -r -e -p "Certificate path (.p12 or .pem): " input_path < /dev/tty
      # Expand tilde if present
      input_path="${input_path/#\~/$HOME}"
      if [[ -f "$input_path" ]]; then
        if [[ "$input_path" == *.p12 ]]; then
          CERT_P12="$input_path"
        else
          CERT_PEM="$input_path"
        fi
        echo "" >&2
        break
      else
        echo "❌ File not found: $input_path" >&2
        echo "Please try again." >&2
      fi
    done
  else
    log "ERROR: No certificates found and no TTY for interactive prompt."
    log "Please set CERT_P12 or CERT_PEM environment variables."
    exit 1
  fi
}

usage() {
  cat <<'USAGE'
Usage: clone_seaf2.sh [OPTIONS]

Description:
  This script automates the cloning and setup of the SEAF2 architecture repository
  and its metamodel extensions. It handles certificate-based authentication,
  dependency resolution, and configuration updates.

Default Behavior (No Arguments):
  1. Detects available certificates (.p12 or .pem) in the current directory.
  2. Prompts for the P12 password if necessary (and converts it to PEM for future use).
  3. Clones/Updates the main repository (seaf-company-example-jupiter).
  4. Opens an interactive menu (whiptail) to select which metamodel extensions to clone.
  5. Updates packages.yaml to reflect the selected modules.

Options:
  -h, --help       Show this help message and exit.
  --all            Skip the interactive menu and clone ALL available metamodel repositories.
  --repos "list"   Skip the interactive menu and clone only the specified repositories.
                   Format: Comma-separated list (e.g., "seaf-common,seaf-company-ta").
  --no-main        Skip cloning/updating the main repository. Useful if you are already
                   inside the repository or only want to update extensions.
  --use-p12        Force usage of P12 certificate even if a PEM is present (rarely needed).

Examples:
  ./clone_seaf2.sh                 # Standard interactive run
  ./clone_seaf2.sh --all           # Clone everything unattended
  ./clone_seaf2.sh --repos "seaf-common"  # Clone only seaf-common
  ./clone_seaf2.sh --no-main       # Update extensions only (assumes main repo exists)

Environment Variables:
  CERT_PEM, CERT_P12, CERT_PASSWORD  Override certificate paths and password.
  SSL_VERIFY, SSL_BACKEND            Control Git SSL behavior.
  RETRY_COUNT, RETRY_SLEEP           Configure network retry logic.
USAGE
}

parse_args() {
  while (( "$#" )); do
    case "$1" in
      --all) AUTO_ALL="1" ;;
      --repos) shift; REPOS="${1:-}" ;;
      --use-p12) USE_P12="1" ;;
      --no-main) SKIP_MAIN="1" ;;
      -h|--help) usage; exit 0 ;;
      *) log "Unknown arg: $1"; usage; exit 1 ;;
    esac
    shift
  done
}

is_tty() {
  [[ -t 0 ]]
}

all_repos() {
  printf '%s\n' \
    "seaf-common" \
    "seaf-company-ai" \
    "seaf-company-artefacts" \
    "seaf-company-base" \
    "seaf-company-da" \
    "seaf-company-kadzo" \
    "seaf-company-ta" \
    "seaf-toolkit-mm_viewer"
}

prompt_password_if_needed() {
  # 1. Check if we have a usable PEM (must have private key)
  if [[ -f "$CERT_PEM" ]]; then
     if grep -qE "BEGIN (PRIVATE KEY|RSA PRIVATE KEY|EC PRIVATE KEY)" "$CERT_PEM" 2>/dev/null; then
         # Valid PEM found, no password needed for P12
         return 0
     fi
  fi

  # 2. If no valid PEM, but P12 exists, prompt for password
  if [[ -f "$CERT_P12" ]] && [[ -z "${CERT_PASSWORD:-}" ]] && is_tty; then
    echo "" >&2
    read -r -s -p "Enter P12 certificate password: " CERT_PASSWORD < /dev/tty || true
    echo "" >&2
    echo "" >&2
  fi
}

setup_certs() {
  local use_p12=""
  if [[ -n "$USE_P12" ]]; then
    use_p12="1"
  elif [[ -f "$CERT_PEM" ]]; then
    use_p12=""
  elif [[ -f "$CERT_P12" ]]; then
    use_p12="1"
  fi

  if [[ -n "$use_p12" ]]; then
    if [[ ! -f "$CERT_P12" ]]; then
      log "ERROR: P12 certificate not found at $CERT_P12"
      exit 1
    fi
    if has_cmd openssl; then
      if [[ -z "$TMP_DIR" ]]; then
        TMP_DIR="$(mktemp -d)"
      fi
      local cert_pem="$TMP_DIR/cert.pem"
      local key_pem="$TMP_DIR/key.pem"
      local pass_arg="pass:"
      if [[ -n "${CERT_PASSWORD:-}" ]]; then
        pass_arg="pass:$CERT_PASSWORD"
      fi

      log "Extracting certificates from $CERT_P12..."
      while true; do
          if openssl pkcs12 -in "$CERT_P12" -clcerts -nokeys -out "$cert_pem" -passin "$pass_arg" 2>/dev/null && \
             openssl pkcs12 -in "$CERT_P12" -nocerts -nodes -out "$key_pem" -passin "$pass_arg" 2>/dev/null; then

             # Save decrypted PEM for future runs to avoid password prompt
             local p12_name
             p12_name="$(basename "$CERT_P12")"
             local new_pem="$ROOT_DIR/${p12_name%.*}.pem"

             log "Saving decrypted PEM to $new_pem for future use..."
             cat "$cert_pem" "$key_pem" > "$new_pem"

             break
          else
             log "ERROR: Failed to extract certificates (wrong password?)."
             if is_tty; then
                 echo "" >&2
                 read -r -s -p "Please re-enter P12 password: " CERT_PASSWORD < /dev/tty
                 echo "" >&2
                 echo "" >&2
                 pass_arg="pass:$CERT_PASSWORD"
             else
                 exit 1
             fi
          fi
      done

      GLOBAL_CERT_PEM="$cert_pem"
      GLOBAL_KEY_PEM="$key_pem"
    else
      # OpenSSL not found, will rely on git's direct P12 support if possible
      log "WARNING: openssl not found, relying on git PKCS12 support."
    fi
  elif [[ -f "$CERT_PEM" ]]; then
      # PEM available directly
      if [[ -z "$CERT_KEY" ]]; then
         # Check for private key using grep (rg might not be installed)
         if ! grep -qE "BEGIN (PRIVATE KEY|RSA PRIVATE KEY|EC PRIVATE KEY)" "$CERT_PEM" 2>/dev/null; then
            if [[ -f "$CERT_P12" ]]; then
               log "INFO: PEM has no private key, but P12 found. Switching to P12 usage."
               # Recursively call setup_certs with forced P12
               USE_P12=1 setup_certs
               return
            else
               log "ERROR: PEM has no private key and no P12 found. Set CERT_KEY or provide a valid P12."
               exit 1
            fi
         fi
      fi
  else
    log "ERROR: certificate not found. Expected \$CERT_P12 or \$CERT_PEM"
    exit 1
  fi
}

git_with_cert() {
  local args=()

  # Certificate-based auth
  # Attempt to cache credentials to reuse login if cert auth fails and fallback to Basic Auth happens
  args+=( -c "credential.helper=cache" )

    if [[ -n "$GLOBAL_CERT_PEM" && -n "$GLOBAL_KEY_PEM" ]]; then
       args+=( -c "http.sslCert=$GLOBAL_CERT_PEM" -c "http.sslKey=$GLOBAL_KEY_PEM" )
    elif [[ -f "$CERT_PEM" ]]; then
       args+=( -c "http.sslCert=$CERT_PEM" )
       if [[ -n "$CERT_KEY" ]]; then
         args+=( -c "http.sslKey=$CERT_KEY" )
       fi
    elif [[ -f "$CERT_P12" ]]; then
       # Fallback to direct P12 usage if openssl wasn't available
       args+=( -c "http.sslCert=$CERT_P12" -c "http.sslCertType=PKCS12" )
       if [[ -n "${CERT_PASSWORD:-}" ]]; then
         args+=( -c "http.sslCertPassword=$CERT_PASSWORD" )
       fi
    fi

  # Common options
  if [[ -n "${SSL_BACKEND:-}" ]]; then
    args+=( -c "http.sslBackend=$SSL_BACKEND" )
  fi
  if [[ -n "$GIT_PROXY" ]]; then
    args+=( -c "http.proxy=$GIT_PROXY" )
  fi
  if [[ -n "$CA_CERT" ]]; then
    args+=( -c "http.sslCAInfo=$CA_CERT" )
  fi
  if [[ "$SSL_VERIFY" == "false" || "$SSL_VERIFY" == "0" ]]; then
    args+=( -c http.sslVerify=false )
  fi
  if [[ -n "$CONNECT_TIMEOUT" ]]; then
    args+=( -c "http.connectTimeout=$CONNECT_TIMEOUT" )
  fi
  if [[ -n "$LOW_SPEED_LIMIT" ]]; then
    args+=( -c "http.lowSpeedLimit=$LOW_SPEED_LIMIT" )
  fi
  if [[ -n "$LOW_SPEED_TIME" ]]; then
    args+=( -c "http.lowSpeedTime=$LOW_SPEED_TIME" )
  fi

  git "${args[@]}" "$@"
}

with_retries() {
  local n=1
  local max="$RETRY_COUNT"
  local sleep_s="$RETRY_SLEEP"
  while true; do
    if "$@"; then
      return 0
    fi
    if (( n >= max )); then
      return 1
    fi
    log "Retrying in ${sleep_s}s... ($n/$max)"
    sleep "$sleep_s"
    ((n++))
  done
}

clone_or_update() {
  local url="$1" dest="$2"
  if [[ -d "$dest/.git" ]]; then
    if git_with_cert -C "$dest" rev-parse --verify HEAD >/dev/null 2>&1; then
      log "Updating $dest"
      with_retries git_with_cert -C "$dest" pull --ff-only
    else
      log "Repo at $dest is incomplete; re-cloning."
      rm -rf -- "$dest"
      with_retries git_with_cert clone "$url" "$dest"
    fi
  else
    log "Cloning $url -> $dest"
    with_retries git_with_cert clone "$url" "$dest"
  fi
}

select_repos() {
  if [[ -n "$REPOS" ]]; then
    echo "$REPOS" | tr ',' '\n'
    return 0
  fi
  if [[ -n "$AUTO_ALL" ]]; then
    all_repos
    return 0
  fi
  if ! is_tty; then
    log "No TTY detected; defaulting to all repositories. Set REPOS or --repos to narrow." >&2
    all_repos
    return 0
  fi

  local choices=()
  local selected=()

  choices+=("seaf-common" "SEAF2 core types/datasets/functions" "OFF")
  choices+=("seaf-company-ai" "SEAF2 AI architecture extension" "OFF")
  choices+=("seaf-company-artefacts" "SEAF2 artefacts extension" "OFF")
  choices+=("seaf-company-base" "SEAF2 company base metamodel" "OFF")
  choices+=("seaf-company-da" "SEAF2 data architecture extension" "OFF")
  choices+=("seaf-company-kadzo" "SEAF2 KA DZO export" "OFF")
  choices+=("seaf-company-ta" "SEAF2 technical architecture" "OFF")
  choices+=("seaf-toolkit-mm_viewer" "SEAF2 metamodel/model viewer" "OFF")

  local try_whiptail=""
  if [[ -n "$USE_WHIPTAIL" ]]; then
    try_whiptail="1"
  elif [[ -n "${TERM:-}" && "${TERM:-}" != "dumb" ]] && has_cmd whiptail; then
    try_whiptail="1"
  fi

  if [[ -n "$try_whiptail" ]]; then
    echo "" >&2
    echo "┌─────────────────────────────────────────────────────────────┐" >&2
    echo "│   Select SEAF2 metamodel repositories to clone/update       │" >&2
    echo "└─────────────────────────────────────────────────────────────┘" >&2
    echo "" >&2

    local whiptail_out
    whiptail_out="$(whiptail --title "SEAF2 Metamodel Repositories" \
      --checklist "\nUse SPACE to toggle selection, TAB/ARROWS to navigate, ENTER to confirm" 20 90 10 \
      "${choices[@]}" 3>&1 1>&2 2>&3)" || true

    # Whiptail returns "repo1" "repo2" ...
    # We strip quotes and populate the array
    local no_quotes="${whiptail_out//\"/}"
    # Read space-separated words into array
    read -r -a selected <<< "$no_quotes"
  fi

  if (( ${#selected[@]} == 0 )); then
    echo "" >&2
    echo "┌─────────────────────────────────────────────────────────────┐" >&2
    echo "│   Select SEAF2 metamodel repositories to clone/update       │" >&2
    echo "├─────────────────────────────────────────────────────────────┤" >&2
    echo "│  1) seaf-common          SEAF2 core types/datasets         │" >&2
    echo "│  2) seaf-company-ai      SEAF2 AI architecture             │" >&2
    echo "│  3) seaf-company-artefacts  SEAF2 artefacts extension      │" >&2
    echo "│  4) seaf-company-base    SEAF2 company base metamodel      │" >&2
    echo "│  5) seaf-company-da      SEAF2 data architecture           │" >&2
    echo "│  6) seaf-company-kadzo   SEAF2 KA DZO export               │" >&2
    echo "│  7) seaf-company-ta      SEAF2 technical architecture      │" >&2
    echo "│  8) seaf-toolkit-mm_viewer  SEAF2 metamodel/model viewer   │" >&2
    echo "└─────────────────────────────────────────────────────────────┘" >&2
    echo "" >&2
    echo "Enter numbers separated by spaces (e.g. \"1 4 8\"), or press ENTER for none:" >&2
    # FIX: Явное чтение из терминала для корректной работы в подпроцессах
    read -r -a nums < /dev/tty
    echo "" >&2

    for n in "${nums[@]:-}"; do
      case "$n" in
        1) selected+=("seaf-common");;
        2) selected+=("seaf-company-ai");;
        3) selected+=("seaf-company-artefacts");;
        4) selected+=("seaf-company-base");;
        5) selected+=("seaf-company-da");;
        6) selected+=("seaf-company-kadzo");;
        7) selected+=("seaf-company-ta");;
        8) selected+=("seaf-toolkit-mm_viewer");;
      esac
    done
  fi

  if (( ${#selected[@]} == 0 )); then
    echo "⚠️  No repositories selected." >&2
    echo "" >&2
  else
    echo "✅ Selected repositories:" >&2
    for item in "${selected[@]}"; do
      echo "   • ${item//\"/}" >&2
    done
    echo "" >&2
  fi

  # ВАЖНО: Выводим ТОЛЬКО имена репозиториев в stdout (без лишних сообщений)
  for item in "${selected[@]:-}"; do
      echo "${item//\"/}"
  done
}

update_packages_yaml() {
  local yaml_file="$ROOT_DIR/$MAIN_REPO/_metamodel_/packages.yaml"
  if [[ ! -f "$yaml_file" ]]; then
    log "WARNING: packages.yaml not found at $yaml_file"
    return 0
  fi

  log "Updating packages.yaml configuration..."

  local repos=(
    "seaf-common"
    "seaf-company-ai"
    "seaf-company-artefacts"
    "seaf-company-base"
    "seaf-company-da"
    "seaf-company-kadzo"
    "seaf-company-ta"
    "seaf-toolkit-mm_viewer"
  )

  for repo in "${repos[@]}"; do
    local repo_dir="$ROOT_DIR/$MAIN_REPO/_metamodel_/$repo"
    local entry="$repo/package.yaml"

    # Simple pattern for sed (assumes / delimiter is NOT used in sed command)
    # We use | delimiter in sed to safely handle slashes in filenames
    # We allow . to match literal dot (regex any char) which is fine here

    if [[ -d "$repo_dir" ]]; then
        # Enable: Uncomment if commented
        # Matches: optional spaces, hash, optional spaces, dash, optional spaces, entry, capturing rest
        sed -i -E "s|^[[:space:]]*#[[:space:]]*-[[:space:]]*$entry(.*)|  - $entry\1|" "$yaml_file"
    else
        # Disable: Comment if active
        # Matches: optional spaces, dash, optional spaces, entry, capturing rest
        # We start with ^[[:space:]]*- so we don't match already commented lines
        sed -i -E "s|^[[:space:]]*-[[:space:]]*$entry(.*)|#  - $entry\1|" "$yaml_file"
    fi
  done
}

verify_repo() {
  local dest="$1"
  if [[ ! -d "$dest/.git" ]]; then
    log "ERROR: $dest is missing .git"
    return 1
  fi
  if ! git -C "$dest" rev-parse --verify HEAD >/dev/null 2>&1; then
    log "ERROR: $dest has no commits (clone likely incomplete)"
    return 1
  fi
  return 0
}

main() {
  parse_args "$@"
  ensure_git
  find_certificate
  prompt_password_if_needed
  setup_certs

  log "Starting SEAF2 clone..."
  echo "" >&2

  # FIX: mapfile захватывает ТОЛЬКО имена репозиториев (все промпты уходят в stderr)
  mapfile -t repos < <(select_repos)
  if (( ${#repos[@]} == 0 )); then
    log "No repositories selected. Exiting."
    exit 1
  fi

  if [[ -z "$SKIP_MAIN" ]]; then
    clone_or_update "$MAIN_URL" "$ROOT_DIR/$MAIN_REPO"
  fi

  local mm_dir="$ROOT_DIR/$MAIN_REPO/_metamodel_"
  if [[ ! -d "$mm_dir" ]]; then
    log "Creating directory: $mm_dir"
    mkdir -p "$mm_dir"
  fi

  for repo in "${repos[@]}"; do
    local url="$BASE_URL/$repo.git"
    local dest="$mm_dir/$repo"
    clone_or_update "$url" "$dest"
  done

  log "Verifying clones..."
  if [[ -z "$SKIP_MAIN" ]]; then
    verify_repo "$ROOT_DIR/$MAIN_REPO" || exit 1
  fi
  for repo in "${repos[@]}"; do
    verify_repo "$mm_dir/$repo" || exit 1
  done

  update_packages_yaml

  echo "" >&2
  log "✅ Done. SEAF2 environment is ready."
}

main "$@"
