import sys
import os
import yaml
import json
import urllib.request
import urllib.parse
import argparse
from pathlib import Path

# Configuration
REPO_ROOT = Path(__file__).resolve().parents[5]
ARCHITECTURE_PATH = str(REPO_ROOT / "architecture" / "ta")
BACKEND_URL = "http://127.0.0.1:8080"
CONFIG_PATH = r"_metamodel_/seaf-company-ta/ta/configs.yaml"

# Mapping: Dataset ID -> { "entity": SEAF2_Entity, "seaf1": SEAF1_Path, "reverse": Reverse_Path }
DATASET_INFO = {
    "seaf.company.ds.ta.dc_regions": {
        "entity": "seaf.company.ta.services.dc_regions",
        "seaf1": "seaf.ta.services.dc_region",
        "reverse": "reverse2seaf2.ds.ta.reverse.dc_regions"
    },
    "seaf.company.ds.ta.dc_azs": {
        "entity": "seaf.company.ta.services.dc_azs",
        "seaf1": "seaf.ta.services.dc_az",
        "reverse": "reverse2seaf2.ds.ta.reverse.dc_az"
    },
    "seaf.company.ds.ta.dcs": {
        "entity": "seaf.company.ta.services.dcs",
        "seaf1": "seaf.ta.services.dc",
        "reverse": "reverse2seaf2.ds.ta.reverse.dcs"
    },
    "seaf.company.ds.ta.dc_offices": {
        "entity": "seaf.company.ta.services.dc_offices",
        "seaf1": "seaf.ta.services.office"
    },
    "seaf.company.ds.ta.networks": {
        "entity": "seaf.company.ta.services.networks",
        "seaf1": "seaf.ta.services.network",
        "reverse": "reverse2seaf2.ds.ta.reverse.networks"
    },
    "seaf.company.ds.ta.network_segments": {
        "entity": "seaf.company.ta.services.network_segments",
        "seaf1": "seaf.ta.services.network_segment",
        "reverse": "reverse2seaf2.ds.ta.reverse.network_segments"
    },
    "seaf.company.ds.ta.network_links": {
        "entity": "seaf.company.ta.services.network_links",
        "seaf1": "seaf.ta.services.network_link"
    },
    "seaf.company.ds.ta.logical_links": {
        "entity": "seaf.company.ta.services.logical_links",
        "seaf1": "seaf.ta.services.logical_link",
        "reverse": "reverse2seaf2.ds.ta.reverse.logical_links"
    },
    "seaf.company.ds.ta.software": {
        "entity": "seaf.company.ta.services.softwares",
        "seaf1": "seaf.ta.services.software"
    },
    # Standard entities (mostly SEAF2)
    "seaf.company.ds.ta.compute_services": {
        "entity": [
            "seaf.company.ta.services.compute_services",
            "seaf.company.ta.services.clusters"
        ],
        "seaf1": [
            "seaf.ta.services.compute_service",
            "seaf.ta.services.cluster"
        ],
        "reverse": [
            "reverse2seaf2.ds.ta.reverse.elbs",
            "reverse2seaf2.ds.ta.reverse.dmss_clusters",
            "reverse2seaf2.ds.ta.reverse.rdss_clusters"
        ]
    },
    "seaf.company.ds.ta.cluster_virtualizations": {
        "entity": "seaf.company.ta.services.cluster_virtualizations",
        "seaf1": "seaf.ta.services.cluster_virtualization",
        "reverse": "reverse2seaf2.ds.ta.reverse.cluster_virtualizations"
    },
    "seaf.company.ds.ta.storages": {
        "entity": "seaf.company.ta.services.storages",
        "seaf1": "seaf.ta.services.storage",
        "reverse": "reverse2seaf2.ds.ta.reverse.storages"
    },
    "seaf.company.ds.ta.hw_storages": { "entity": "seaf.company.ta.components.hw_storages" },
    "seaf.company.ds.ta.servers": {
        "entity": "seaf.company.ta.components.servers",
        "seaf1": "seaf.ta.components.server",
        "reverse": "reverse2seaf2.ds.ta.reverse.servers"
    },
    "seaf.company.ds.ta.k8s": {
        "entity": "seaf.company.ta.services.k8s",
        "seaf1": "seaf.ta.services.k8s",
        "reverse": "reverse2seaf2.ds.ta.reverse.k8s"
    },
    "seaf.company.ds.ta.backup": {
        "entity": "seaf.company.ta.services.backups",
        "seaf1": "seaf.ta.services.backup",
        "reverse": "reverse2seaf2.ds.ta.reverse.backups"
    },
    "seaf.company.ds.ta.monitoring": {
        "entity": "seaf.company.ta.services.monitorings",
        "seaf1": "seaf.ta.services.monitoring",
        "reverse": "reverse2seaf2.ds.ta.reverse.monitoring"
    },
    "seaf.company.ds.ta.kb": { "entity": "seaf.company.ta.services.kbs" },
    "seaf.company.ds.ta.network_components": {
        "entity": "seaf.company.ta.components.networks",
        "seaf1": "seaf.ta.components.network",
        "reverse": [
            "reverse2seaf2.ds.ta.reverse.network_components",
            "reverse2seaf2.ds.ta.reverse.nat_gateways",
            "reverse2seaf2.ds.ta.reverse.vpn_gateways",
            "reverse2seaf2.ds.ta.reverse.elb_network_components"
        ]
    },
    "seaf.company.ds.ta.user_devices": { "entity": "seaf.company.ta.components.user_devices" },
    "seaf.company.ds.ta.environments": { "entity": "seaf.company.ta.services.environments" },
    "seaf.company.ds.ta.stands": { "entity": "seaf.company.ta.services.stands" },
    "seaf.company.ds.ta.k8s_namespaces": {
        "entity": "seaf.company.ta.components.k8s_namespaces",
        "seaf1": "seaf.ta.components.k8s_namespace"
    },
    "seaf.company.ds.ta.k8s_deployments": {
        "entity": "seaf.company.ta.services.k8s_deployments",
        "seaf1": "seaf.ta.components.k8s_deployment"
    },
    "seaf.company.ds.ta.k8s_hpas": { "entity": "seaf.company.ta.components.k8s_hpa" },
    "seaf.company.ds.ta.k8s_nodes": { "entity": "seaf.company.ta.components.k8s_nodes" }
}

def load_config():
    if not os.path.exists(CONFIG_PATH):
        return {"seaf2", "seaf1", "reverse"} # Default fallback
    
    try:
        with open(CONFIG_PATH, 'r', encoding='utf-8') as f:
            data = yaml.safe_load(f)
            # Traverse: seaf.configs -> seaf.company.ta -> data_sources -> enabled
            sources = data.get("seaf.configs", {}).get("seaf.company.ta", {}).get("data_sources", {}).get("enabled", [])
            return set(sources) if sources else {"seaf2", "seaf1", "reverse"}
    except Exception as e:
        print(f"Warning: Failed to load config: {e}")
        return {"seaf2", "seaf1", "reverse"}

def get_file_counts(path):
    counts = {}
    if not os.path.exists(path):
        return counts

    for root, _, files in os.walk(path):
        for file in files:
            if file.lower().endswith(('.yaml', '.yml')):
                if "_test_" in file.lower():
                    continue
                file_path = os.path.join(root, file)
                try:
                    with open(file_path, 'r', encoding='utf-8') as f:
                        data = yaml.safe_load(f)
                        if not data:
                            continue
                        for key, value in data.items():
                            if key.startswith("seaf.company.ta."):
                                count = len(value) if isinstance(value, (dict, list)) else 0
                                counts[key] = counts.get(key, 0) + count
                except:
                    pass
    return counts

def run_request(encoded_query):
    url = f"{BACKEND_URL}/core/storage/jsonata/{encoded_query}"
    try:
        with urllib.request.urlopen(url) as response:
            result = response.read().decode('utf-8')
            try:
                return json.loads(result)
            except:
                return result
    except Exception as e:
        return f"ERR: {e}"

def fetch_count_root_key(key):
    if not key: return 0
    if isinstance(key, (list, tuple)):
        return sum(fetch_count_root_key(item) for item in key)
    # Query: ($count($keys($."key")))
    # Works for both SEAF2 entities and SEAF1 legacy paths at root
    query = f'($count($keys($."{key}")))'
    res = run_request(urllib.parse.quote(query, safe=""))
    return res if isinstance(res, int) else 0

def fetch_count_reverse(path):
    if not path: return 0
    if isinstance(path, (list, tuple)):
        return sum(fetch_count_reverse(item) for item in path)
    # Reverse is a dataset. Fetch result size.
    res = run_request(urllib.parse.quote(path, safe=""))
    if isinstance(res, (dict, list)):
        return len(res)
    return 0

def fetch_count_dataset(ds_id):
    res = run_request(urllib.parse.quote(ds_id, safe=""))
    if isinstance(res, (dict, list)):
        return len(res)
    return 0

def main():
    parser = argparse.ArgumentParser(description="Check data flow completeness.")
    parser.add_argument("filter", nargs="?", help="Filter by Dataset ID or Entity ID (substring match)")
    args = parser.parse_args()

    enabled_sources = load_config()
    print(f"Enabled Sources: {enabled_sources}")
    
    print(f"{ 'Dataset ID':<45} | {'File':<5} | {'Lake':<5} | {'S1':<5} | {'Rev':<5} | {'Total':<5} | {'DS':<5} | {'St'}")
    print("-" * 110)

    file_counts = get_file_counts(ARCHITECTURE_PATH)

    for ds_id, info in DATASET_INFO.items():
        entity_filter_text = " ".join(info["entity"]) if isinstance(info["entity"], (list, tuple)) else info["entity"]
        if args.filter and args.filter.lower() not in ds_id.lower() and args.filter.lower() not in entity_filter_text.lower():
            continue

        entity_id = info["entity"]
        
        # 1. SEAF2 (File & Lake)
        c_file = sum(file_counts.get(item, 0) for item in entity_id) if isinstance(entity_id, (list, tuple)) else file_counts.get(entity_id, 0)
        c_lake = fetch_count_root_key(entity_id)
        
        # 2. SEAF1
        c_seaf1 = 0
        if "seaf1" in enabled_sources and info.get("seaf1"):
            c_seaf1 = fetch_count_root_key(info.get("seaf1"))
            
        # 3. Reverse
        c_rev = 0
        if "reverse" in enabled_sources and info.get("reverse"):
            c_rev = fetch_count_reverse(info.get("reverse"))
            
        # 4. Dataset (Actual)
        c_ds = fetch_count_dataset(ds_id)
        
        # 5. Expected Total
        c_total = c_lake + c_seaf1 + c_rev
        
        # Status
        status = "OK"
        if c_total != c_ds:
            status = "DIFF"
        if c_file != c_lake:
            status = "SYNC!" # File vs Lake mismatch
            
        print(f"{ds_id:<45} | {c_file:<5} | {c_lake:<5} | {c_seaf1:<5} | {c_rev:<5} | {c_total:<5} | {c_ds:<5} | {status}")

if __name__ == "__main__":
    main()
