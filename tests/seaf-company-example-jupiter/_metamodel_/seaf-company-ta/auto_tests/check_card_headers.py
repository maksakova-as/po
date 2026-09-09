from __future__ import annotations

import sys
from pathlib import Path
from typing import Dict, Any

import yaml

ROOT = Path(__file__).resolve().parents[1]
PRESENTATIONS_DIR = ROOT / "presentations"
WIDGETS_DIR = ROOT / "widgets"


def load_yaml(path: Path) -> Dict[str, Any]:
    try:
        with path.open("r", encoding="utf-8") as f:
            data = yaml.safe_load(f) or {}
        if not isinstance(data, dict):
            return {}
        return data
    except Exception as exc:
        print(f"ERROR: Failed to parse {path}: {exc}")
        return {}


def collect_entities(paths: list[Path]) -> Dict[str, Dict[str, Any]]:
    entities: Dict[str, Dict[str, Any]] = {}
    for path in paths:
        data = load_yaml(path)
        ent_map = data.get("entities")
        if not isinstance(ent_map, dict):
            continue
        for ent_id, ent_body in ent_map.items():
            if not isinstance(ent_body, dict):
                continue
            entities.setdefault(ent_id, {})[str(path)] = ent_body
    return entities


def get_presentations(ent_body: Dict[str, Any]) -> Dict[str, Any]:
    pres = ent_body.get("presentations")
    return pres if isinstance(pres, dict) else {}


def has_header_widget(card: Dict[str, Any]) -> bool:
    widgets = card.get("widgets")
    if not isinstance(widgets, dict):
        return False
    return "header" in widgets


def has_header_presentation(presentations: Dict[str, Any]) -> bool:
    return "header" in presentations


def main() -> int:
    pres_files = sorted(PRESENTATIONS_DIR.glob("*.yaml"))
    widget_files = sorted(WIDGETS_DIR.glob("*.yaml"))

    pres_entities = collect_entities(pres_files)
    widget_entities = collect_entities(widget_files)

    failures = []

    for ent_id, ent_files in pres_entities.items():
        if not ent_id.startswith("seaf.company.ta."):
            continue
        for path_str, ent_body in ent_files.items():
            presentations = get_presentations(ent_body)
            card = presentations.get("card")
            if not isinstance(card, dict):
                continue

            # direct header widget on card
            header_on_card = has_header_widget(card)

            # header widget in widgets file for this entity
            widget_header = False
            widget_header_presentation = False
            if ent_id in widget_entities:
                for _wpath, wbody in widget_entities[ent_id].items():
                    wpresentations = get_presentations(wbody)
                    wcard = wpresentations.get("card")
                    if isinstance(wcard, dict) and has_header_widget(wcard):
                        widget_header = True
                    if has_header_presentation(wpresentations):
                        widget_header_presentation = True

            # header presentation in the presentation file
            header_presentation = has_header_presentation(presentations)

            if not header_on_card and not widget_header:
                failures.append(
                    {
                        "entity": ent_id,
                        "file": path_str,
                        "issue": "missing header widget",
                    }
                )

            if not header_presentation and not widget_header_presentation:
                failures.append(
                    {
                        "entity": ent_id,
                        "file": path_str,
                        "issue": "missing header presentation",
                    }
                )

    if failures:
        print("FAIL: header checks failed")
        for item in failures:
            print(f"- {item['entity']} | {item['issue']} | {item['file']}")
        return 1

    print("OK: all TA cards have header widget and presentation")
    return 0


if __name__ == "__main__":
    sys.exit(main())
