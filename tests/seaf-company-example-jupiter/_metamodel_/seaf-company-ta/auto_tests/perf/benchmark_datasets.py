import argparse
import json
import statistics
import time
import urllib.error
import urllib.parse
import urllib.request
from datetime import datetime
from pathlib import Path


DEFAULT_DATASETS = [
    "seaf.company.ds.ta.schema_r41_plural",
    "seaf.company.ds.ta.all_objects",
    "seaf.company.ds.ta.kb_links",
    "seaf.company.ds.ta.k8s_infra_objects",
    "seaf.company.ds.ta.cluster_virtualization_infra_objects",
    "seaf.company.ds.ta.servers",
    "seaf.company.ds.ta.network_components",
    "seaf.company.ds.app.systems_dependency_graph",
    "seaf.company.ds.app.systems_deployment_topology",
]


def query_dataset(base_url: str, dataset_id: str) -> tuple[float, int, int | None, str | None]:
    encoded = urllib.parse.quote(dataset_id, safe="")
    url = f"{base_url}/core/storage/jsonata/{encoded}"
    started = time.perf_counter()
    try:
        with urllib.request.urlopen(url, timeout=180) as response:
            payload = response.read()
        elapsed_ms = (time.perf_counter() - started) * 1000.0
        size_bytes = len(payload)
        try:
            parsed = json.loads(payload.decode("utf-8"))
            if isinstance(parsed, dict) or isinstance(parsed, list):
                item_count = len(parsed)
            else:
                item_count = 1
        except Exception:
            item_count = None
        return elapsed_ms, size_bytes, item_count, None
    except urllib.error.HTTPError as err:
        elapsed_ms = (time.perf_counter() - started) * 1000.0
        return elapsed_ms, 0, None, f"HTTP {err.code}"
    except Exception as err:  # noqa: BLE001
        elapsed_ms = (time.perf_counter() - started) * 1000.0
        return elapsed_ms, 0, None, str(err)


def percentile(values: list[float], p: float) -> float:
    if not values:
        return 0.0
    if len(values) == 1:
        return values[0]
    idx = (len(values) - 1) * p
    low = int(idx)
    high = min(low + 1, len(values) - 1)
    frac = idx - low
    return values[low] * (1.0 - frac) + values[high] * frac


def run_benchmark(base_url: str, datasets: list[str], warmup: int, runs: int) -> list[dict]:
    results = []
    for dataset in datasets:
        for _ in range(warmup):
            query_dataset(base_url, dataset)
        measures = []
        sizes = []
        item_count = None
        error = None
        for _ in range(runs):
            elapsed_ms, size_bytes, count, err = query_dataset(base_url, dataset)
            if err:
                error = err
            else:
                measures.append(elapsed_ms)
                sizes.append(size_bytes)
                item_count = count
        if error:
            results.append(
                {
                    "dataset": dataset,
                    "error": error,
                    "runs": runs,
                }
            )
            continue
        measures_sorted = sorted(measures)
        results.append(
            {
                "dataset": dataset,
                "runs": runs,
                "item_count": item_count,
                "payload_bytes": int(statistics.mean(sizes)) if sizes else 0,
                "min_ms": round(min(measures_sorted), 1),
                "median_ms": round(statistics.median(measures_sorted), 1),
                "p95_ms": round(percentile(measures_sorted, 0.95), 1),
                "max_ms": round(max(measures_sorted), 1),
            }
        )
    return results


def write_markdown(path: Path, base_url: str, warmup: int, runs: int, results: list[dict]) -> None:
    lines = [
        "# Dataset benchmark",
        "",
        f"- Date: {datetime.now().isoformat(timespec='seconds')}",
        f"- Backend: `{base_url}`",
        f"- Warmup: `{warmup}`",
        f"- Runs: `{runs}`",
        "",
        "| Dataset | Items | Payload bytes | min ms | median ms | p95 ms | max ms | Status |",
        "|---|---:|---:|---:|---:|---:|---:|---|",
    ]
    for row in results:
        if "error" in row:
            lines.append(f"| `{row['dataset']}` | - | - | - | - | - | - | {row['error']} |")
        else:
            lines.append(
                f"| `{row['dataset']}` | {row['item_count'] if row['item_count'] is not None else '-'} | "
                f"{row['payload_bytes']} | {row['min_ms']} | {row['median_ms']} | {row['p95_ms']} | "
                f"{row['max_ms']} | OK |"
            )
    path.write_text("\n".join(lines) + "\n", encoding="utf-8")


def main() -> None:
    parser = argparse.ArgumentParser(description="Benchmark TA/app datasets via backend JSONata endpoint.")
    parser.add_argument("--base-url", default="http://127.0.0.1:8080")
    parser.add_argument("--warmup", type=int, default=1)
    parser.add_argument("--runs", type=int, default=5)
    parser.add_argument(
        "--out-md",
        default="_metamodel_/seaf-company-ta/internal_docs/dataset_speedup_baseline.md",
    )
    parser.add_argument("--out-json", default="_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_results.json")
    parser.add_argument("--datasets", nargs="*", default=DEFAULT_DATASETS)
    args = parser.parse_args()

    results = run_benchmark(args.base_url, args.datasets, args.warmup, args.runs)
    out_md = Path(args.out_md)
    out_json = Path(args.out_json)
    out_md.parent.mkdir(parents=True, exist_ok=True)
    out_json.parent.mkdir(parents=True, exist_ok=True)
    write_markdown(out_md, args.base_url, args.warmup, args.runs, results)
    out_json.write_text(json.dumps(results, ensure_ascii=False, indent=2), encoding="utf-8")
    print(f"Wrote: {out_md}")
    print(f"Wrote: {out_json}")


if __name__ == "__main__":
    main()
