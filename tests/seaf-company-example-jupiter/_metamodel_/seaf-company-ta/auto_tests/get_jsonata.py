import sys
import urllib.error
import urllib.parse
import urllib.request
from pathlib import Path


def main():
    try:
        sys.stdout.reconfigure(encoding="utf-8")
    except AttributeError:
        pass

    if len(sys.argv) < 2:
        print("Usage: python get_jsonata.py <expr-file>", file=sys.stderr)
        sys.exit(1)

    path = Path(sys.argv[1])
    expr = path.read_text(encoding="utf-8")
    encoded = urllib.parse.quote(expr, safe="")
    url = f"http://127.0.0.1:8080/core/storage/jsonata/{encoded}"
    try:
        with urllib.request.urlopen(url) as resp:
            print(resp.read().decode("utf-8"))
    except urllib.error.HTTPError as exc:
        body = exc.read().decode("utf-8", errors="replace")
        print(f"HTTP {exc.code}: {body}")
        sys.exit(exc.code)


if __name__ == "__main__":
    main()
