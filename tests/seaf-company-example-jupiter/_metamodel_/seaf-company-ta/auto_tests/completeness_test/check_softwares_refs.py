import json
import sys
import urllib.parse
import urllib.request

BACKEND_URL = "http://127.0.0.1:8080"

TARGETS = {
    "seaf.company.ds.ta.k8s": [
        "jupiter.k8s.01",
        "jupiter.k8s.02",
        "jupiter.k8s.llm.01",
    ],
    "seaf.company.ds.ta.storages": [
        "jupiter.obj_storage.cloud_s3",
        "jupiter.obj_storage.vk_s3",
        "jupiter.sw_storage.01",
    ],
}


def query(expr: str):
    encoded = urllib.parse.quote(expr, safe="")
    url = f"{BACKEND_URL}/core/storage/jsonata/{encoded}"
    with urllib.request.urlopen(url) as response:
        return json.loads(response.read().decode("utf-8"))


def to_array(value):
    if isinstance(value, list):
        return value
    if value is None:
        return []
    return [value]


def main():
    try:
        software_catalog = query("seaf.company.ds.ta.software")
    except Exception as exc:
        print(f"FAIL: cannot load software catalog: {exc}")
        return 1

    software_ids = set(software_catalog.keys()) if isinstance(software_catalog, dict) else set()
    errors = []

    for dataset_id, object_ids in TARGETS.items():
        try:
            dataset = query(dataset_id)
        except Exception as exc:
            errors.append(f"{dataset_id}: cannot load dataset: {exc}")
            continue

        if not isinstance(dataset, dict):
            errors.append(f"{dataset_id}: expected object dataset, got {type(dataset).__name__}")
            continue

        for object_id in object_ids:
            item = dataset.get(object_id)
            if not isinstance(item, dict):
                errors.append(f"{dataset_id}/{object_id}: object not found")
                continue

            if "software" in item and item.get("software") not in (None, ""):
                errors.append(f"{dataset_id}/{object_id}: legacy field 'software' must be empty or absent")

            refs = to_array(item.get("softwares"))
            if not refs:
                errors.append(f"{dataset_id}/{object_id}: 'softwares' must contain at least one reference")
                continue

            for ref in refs:
                if ref not in software_ids:
                    errors.append(f"{dataset_id}/{object_id}: unknown software ref '{ref}'")

    if errors:
        print("FAIL: software reference checks failed")
        for error in errors:
            print(f" - {error}")
        return 1

    print("OK: software reference checks passed")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
