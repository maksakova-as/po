import csv
import json
import os
import urllib.parse
import urllib.request
from collections import defaultdict
from pathlib import Path

# Config
BACKEND_URL = "http://127.0.0.1:8080"
OUTPUT_DIR = Path(__file__).resolve().parent
OUTPUT_JSON_FILE = OUTPUT_DIR / "urls.json"
OUTPUT_MD_FILE = OUTPUT_DIR / "urls.md"
OUTPUT_CSV_FILE = OUTPUT_DIR / "urls.csv"
MAX_CARDS_PER_SOURCE = int(os.environ.get("MAX_CARDS_PER_SOURCE", "2"))
REQUEST_TIMEOUT_SEC = 15

# Entity -> dataset mapping used for card sampling.
# Keep in sync with TA datasets and presentations coverage.
ENTITIES = [
    ("seaf.company.ta.services.dc_regions", "seaf.company.ds.ta.dc_regions"),
    ("seaf.company.ta.services.dc_azs", "seaf.company.ds.ta.dc_azs"),
    ("seaf.company.ta.services.dcs", "seaf.company.ds.ta.dcs"),
    ("seaf.company.ta.services.dc_offices", "seaf.company.ds.ta.dc_offices"),
    ("seaf.company.ta.services.network_segments", "seaf.company.ds.ta.network_segments"),
    ("seaf.company.ta.services.networks", "seaf.company.ds.ta.networks"),
    ("seaf.company.ta.services.network_links", "seaf.company.ds.ta.network_links"),
    ("seaf.company.ta.services.logical_links", "seaf.company.ds.ta.logical_links"),
    ("seaf.company.ta.services.softwares", "seaf.company.ds.ta.software"),
    ("seaf.company.ta.services.compute_services", "seaf.company.ds.ta.compute_services"),
    ("seaf.company.ta.services.cluster_virtualizations", "seaf.company.ds.ta.cluster_virtualizations"),
    ("seaf.company.ta.components.servers", "seaf.company.ds.ta.servers"),
    ("seaf.company.ta.services.storages", "seaf.company.ds.ta.storages"),
    ("seaf.company.ta.services.k8s", "seaf.company.ds.ta.k8s"),
    ("seaf.company.ta.services.backups", "seaf.company.ds.ta.backup"),
    ("seaf.company.ta.services.monitorings", "seaf.company.ds.ta.monitoring"),
    ("seaf.company.ta.components.networks", "seaf.company.ds.ta.network_components"),
    ("seaf.company.ta.components.user_devices", "seaf.company.ds.ta.user_devices"),
    ("seaf.company.ta.services.environments", "seaf.company.ds.ta.environments"),
    ("seaf.company.ta.components.hw_storages", "seaf.company.ds.ta.hw_storages"),
    ("seaf.company.ta.services.k8s_deployments", "seaf.company.ds.ta.k8s_deployments"),
    ("seaf.company.ta.components.k8s_hpa", "seaf.company.ds.ta.k8s_hpas"),
    ("seaf.company.ta.components.k8s_namespaces", "seaf.company.ds.ta.k8s_namespaces"),
    ("seaf.company.ta.components.k8s_nodes", "seaf.company.ds.ta.k8s_nodes"),
    ("seaf.company.ta.services.kbs", "seaf.company.ds.ta.kb"),
    ("seaf.company.ta.services.stands", "seaf.company.ds.ta.stands"),
]

def run_jsonata(query):
    encoded = urllib.parse.quote(query, safe="")
    url = f"{BACKEND_URL}/core/storage/jsonata/{encoded}"
    try:
        with urllib.request.urlopen(url, timeout=REQUEST_TIMEOUT_SEC) as response:
            return json.loads(response.read().decode('utf-8'))
    except Exception as e:
        print(f"DEBUG: Query failed: {query} -> {e}")
        return None

def classify_source(obj_id: str, obj: dict) -> str:
    if obj_id.startswith("seaf1."):
        return "seaf1"
    if obj_id.startswith("reverse."):
        return "reverse"
    if isinstance(obj, dict):
        src = obj.get("source") or obj.get("reverse_source") or obj.get("__entity_title__")
        if isinstance(src, str) and "reverse" in src.lower():
            return "reverse"
    return "seaf2"

def get_sample_cards(dataset_id: str):
    data = run_jsonata(dataset_id)
    if not isinstance(data, dict) or not data:
        return []

    buckets = defaultdict(list)
    for obj_id, obj in data.items():
        if not isinstance(obj_id, str):
            continue
        if obj_id.startswith("$") or obj_id in ["docs", "template", "default"]:
            continue
        if not isinstance(obj, dict):
            continue
        title = obj.get("title")
        if not isinstance(title, str) or not title.strip():
            # still add, but with no expectedTitle
            title = None
        buckets[classify_source(obj_id, obj)].append((obj_id, title))

    selected = []
    for source in ["seaf2", "seaf1", "reverse"]:
        items = buckets.get(source, [])
        for obj_id, title in items[:MAX_CARDS_PER_SOURCE]:
            expected_title = title if source == "seaf2" else None
            selected.append({"id": obj_id, "expectedTitle": expected_title, "source": source})
    return selected

def main():
    urls = []

    for entity_id, dataset_id in ENTITIES:
        urls.append(
            {
                "type": "List",
                "name": entity_id,
                "url": f"{BACKEND_URL}/entities/{entity_id}/list",
                "dataset": dataset_id,
            }
        )

        for card in get_sample_cards(dataset_id):
            obj_id = card["id"]
            urls.append(
                {
                    "type": "Card",
                    "name": f"{entity_id} / {obj_id}",
                    "url": f"{BACKEND_URL}/entities/{entity_id}/card?id={obj_id}",
                    "dataset": dataset_id,
                    "id": obj_id,
                    "source": card["source"],
                    "expectedTitle": card["expectedTitle"],
                }
            )

    with open(OUTPUT_JSON_FILE, "w", encoding="utf-8") as f:
        json.dump(urls, f, indent=2, ensure_ascii=False)

    # Write Markdown and CSV for manual review.
    md_lines = []
    md_lines.append("# UI Test URLs")
    md_lines.append("")
    md_lines.append(f"Generated: `{len(urls)}` URLs")
    md_lines.append("")
    md_lines.append("| Type | Entity | ID | Source | Dataset | URL | ExpectedTitle |")
    md_lines.append("|---|---|---|---|---|---|---|")

    def split_entity_and_id(name: str):
        if " / " in name:
            entity, obj_id = name.split(" / ", 1)
            return entity, obj_id
        return name, ""

    for item in urls:
        entity, obj_id = split_entity_and_id(item.get("name", ""))
        md_lines.append(
            "| {type} | {entity} | {obj_id} | {source} | {dataset} | [link]({url}) | {title} |".format(
                type=(item.get("type") or ""),
                entity=(entity or ""),
                obj_id=(obj_id or ""),
                source=(item.get("source") or ""),
                dataset=(item.get("dataset") or ""),
                url=(item.get("url") or ""),
                title=((item.get("expectedTitle") or "") if item.get("type") == "Card" else ""),
            )
        )

    OUTPUT_MD_FILE.write_text("\n".join(md_lines), encoding="utf-8")

    with open(OUTPUT_CSV_FILE, "w", encoding="utf-8", newline="") as f:
        writer = csv.DictWriter(
            f,
            fieldnames=["type", "entity", "id", "source", "dataset", "url", "expectedTitle"],
        )
        writer.writeheader()
        for item in urls:
            entity, obj_id = split_entity_and_id(item.get("name", ""))
            writer.writerow(
                {
                    "type": item.get("type") or "",
                    "entity": entity or "",
                    "id": item.get("id") or obj_id or "",
                    "source": item.get("source") or "",
                    "dataset": item.get("dataset") or "",
                    "url": item.get("url") or "",
                    "expectedTitle": item.get("expectedTitle") or "",
                }
            )

    print(f"Generated {len(urls)} URLs in {OUTPUT_JSON_FILE}")
    print(f"Wrote: {OUTPUT_MD_FILE}")
    print(f"Wrote: {OUTPUT_CSV_FILE}")

if __name__ == "__main__":
    main()
