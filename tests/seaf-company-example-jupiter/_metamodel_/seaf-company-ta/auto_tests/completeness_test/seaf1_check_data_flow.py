import sys
import os
import yaml
import json
import urllib.request
import urllib.parse
import urllib.error
from pathlib import Path

# Configuration
ARCHITECTURE_PATH = r"C:\Users\aaksi\Documents\SEAF2-PROD\seaf-company-example-jupiter\architecture\SEAF1\seaf-dzo-example\architecture\ta\home_cinema"
BACKEND_URL = "http://127.0.0.1:8080"

# Mapping: Dataset ID -> Legacy Entity ID (SEAF1 style found in files)
DATASET_MAPPING = {
    "seaf.company.ds.ta.dc_regions": "seaf.ta.services.dc_region",
    "seaf.company.ds.ta.dc_azs": "seaf.ta.services.dc_az",
    "seaf.company.ds.ta.dcs": "seaf.ta.services.dc",
    "seaf.company.ds.ta.dc_offices": "seaf.ta.services.office",
    "seaf.company.ds.ta.networks": "seaf.ta.services.network",
    "seaf.company.ds.ta.network_segments": "seaf.ta.services.network_segment",
    "seaf.company.ds.ta.compute_services": ["seaf.ta.services.compute_service", "seaf.ta.services.cluster"],
    "seaf.company.ds.ta.cluster_virtualizations": "seaf.ta.services.cluster_virtualization",
    "seaf.company.ds.ta.storages": "seaf.ta.services.storage",
    "seaf.company.ds.ta.hw_storages": "seaf.ta.components.hw_storage",
    "seaf.company.ds.ta.servers": "seaf.ta.components.server",
    "seaf.company.ds.ta.k8s": "seaf.ta.services.k8s",
    "seaf.company.ds.ta.backup": "seaf.ta.services.backup",
    "seaf.company.ds.ta.monitoring": "seaf.ta.services.monitoring",
    "seaf.company.ds.ta.kb": "seaf.ta.services.kb",
    "seaf.company.ds.ta.software": "seaf.ta.services.software",
    "seaf.company.ds.ta.network_components": "seaf.ta.components.network",
    "seaf.company.ds.ta.user_devices": "seaf.ta.components.user_device",
    "seaf.company.ds.ta.network_links": "seaf.ta.services.network_links", 
    "seaf.company.ds.ta.logical_links": "seaf.ta.services.logical_link",
    "seaf.company.ds.ta.environments": "seaf.ta.services.environment",
    "seaf.company.ds.ta.stands": "seaf.ta.services.stand",
    "seaf.company.ds.ta.k8s_namespaces": "seaf.ta.components.k8s_namespace",
    "seaf.company.ds.ta.k8s_deployments": "seaf.ta.components.k8s_deployment",
    "seaf.company.ds.ta.k8s_hpas": "seaf.ta.components.k8s_hpa",
    "seaf.company.ds.ta.k8s_nodes": "seaf.ta.components.k8s_node"
}

def get_file_counts(path):
    counts = {}
    if not os.path.exists(path):
        print(f"Error: Path not found: {path}", file=sys.stderr)
        return counts

    for root, _, files in os.walk(path):
        for file in files:
            if file.lower().endswith(('.yaml', '.yml')):
                file_path = os.path.join(root, file)
                try:
                    with open(file_path, 'r', encoding='utf-8') as f:
                        data = yaml.safe_load(f)
                        if not data:
                            continue
                        for key, value in data.items():
                            if key.startswith("seaf.ta."):
                                count = 0
                                if isinstance(value, dict):
                                    count = len(value)
                                elif isinstance(value, list):
                                    count = len(value)
                                counts[key] = counts.get(key, 0) + count
                except Exception as e:
                    print(f"Warning: Failed to parse {file}: {e}", file=sys.stderr)
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

def get_lake_count(entity_id):
    if isinstance(entity_id, (list, tuple)):
        total = 0
        for item in entity_id:
            c = get_lake_count(item)
            total += c if isinstance(c, int) else 0
        return total
    # Query: ($count($keys($."entity_id")))
    # This counts keys in the root object for the given entity path
    query = f'($count($keys($."{entity_id}")))'
    encoded = urllib.parse.quote(query, safe="")
    res = run_request(encoded)
    return res

def get_dataset_count(dataset_id):
    # Query: dataset_id (Direct dataset fetch)
    # Then count in Python
    encoded = urllib.parse.quote(dataset_id, safe="")
    res = run_request(encoded)
    
    if isinstance(res, (dict, list)):
        return len(res)
    if isinstance(res, str) and res.startswith("ERR"):
        return res
    if res is None: # Empty dataset might return null
        return 0
    return 0

def main():
    print("Starting SEAF1 -> SEAF2 Data Flow Check...")
    print(f"Architecture Path: {ARCHITECTURE_PATH}")
    print(f"Backend URL: {BACKEND_URL}")
    print("-" * 130)
    print(f"{'Dataset ID':<45} | {'Source Entity ID (File)':<40} | {'File':<5} | {'Lake':<5} | {'DS':<5} | {'Status'}")
    print(f"{'(Query: DS ID)':<45} | {'(Query: $count($keys($[entity_id])))':<40} | {'':<5} | {'':<5} | {'':<5} | {''}")
    print("-" * 130)

    file_counts = get_file_counts(ARCHITECTURE_PATH)

    for ds_id, entity_id in DATASET_MAPPING.items():
        if isinstance(entity_id, (list, tuple)):
            count_file = sum(file_counts.get(item, 0) for item in entity_id)
            entity_display = ", ".join(entity_id)
        else:
            count_file = file_counts.get(entity_id, 0)
            entity_display = entity_id
        count_lake = get_lake_count(entity_id)
        count_ds = get_dataset_count(ds_id)
        
        status = "OK"
        if isinstance(count_lake, int) and isinstance(count_ds, int):
            if count_file != count_lake or count_file != count_ds:
                status = "DIFF"
        else:
            status = "ERR?"
        
        s_lake = str(count_lake) if isinstance(count_lake, int) else str(count_lake)
        s_ds = str(count_ds) if isinstance(count_ds, int) else str(count_ds)
        
        print(f"{ds_id:<45} | {entity_display:<40} | {count_file:<5} | {s_lake:<5} | {s_ds:<5} | {status}")

    print("-" * 130)
    print("Check Complete.")

if __name__ == "__main__":
    main()
