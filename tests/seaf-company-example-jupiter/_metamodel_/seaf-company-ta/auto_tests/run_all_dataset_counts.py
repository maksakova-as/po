import subprocess
import sys
from pathlib import Path

DATASET_IDS = [
    "seaf.company.ds.ta.compute_services",
    "seaf.company.ds.ta.dc_regions",
    "seaf.company.ds.ta.dc_azs",
    "seaf.company.ds.ta.dcs",
    "seaf.company.ds.ta.dc_offices",
    "seaf.company.ds.ta.networks",
    "seaf.company.ds.ta.network_segments",
    "seaf.company.ds.ta.cluster_virtualizations",
    "seaf.company.ds.ta.storages",
    "seaf.company.ds.ta.k8s",
    "seaf.company.ds.ta.backup",
    "seaf.company.ds.ta.monitoring",
    "seaf.company.ds.ta.kb",
    "seaf.company.ds.ta.network_links",
    "seaf.company.ds.ta.logical_links",
    "seaf.company.ds.ta.environments",
    "seaf.company.ds.ta.stands",
    "seaf.company.ds.ta.software",
    "seaf.company.ds.ta.hw_storages",
    "seaf.company.ds.ta.servers",
    "seaf.company.ds.ta.network_components",
    "seaf.company.ds.ta.user_devices",
    "seaf.company.ds.ta.k8s_namespaces",
    "seaf.company.ds.ta.k8s_deployments",
    "seaf.company.ds.ta.k8s_hpas",
    "seaf.company.ds.ta.k8s_nodes",
    "seaf.company.ds.ta.all_objects", # Complex
    "seaf.company.ds.ta.k8s_cluster_objects" # Complex
]

def main():
    script_dir = Path(__file__).parent
    test_script_path = script_dir / "test_dataset_count.py"
    software_refs_script = script_dir / "completeness_test" / "check_softwares_refs.py"
    
    all_passed = True
    results = {}

    for dataset_id in DATASET_IDS:
        print(f"Running test for {dataset_id}...")
        try:
            result = subprocess.run(
                [sys.executable, str(test_script_path), dataset_id],
                capture_output=True,
                text=True,
                check=True,
                encoding="utf-8"
            )
            # Example output: "Dataset 'id' contains X items."
            output_line = result.stdout.strip()
            if "contains" in output_line:
                count_str = output_line.split("contains ")[1].split(" items")[0]
                results[dataset_id] = int(count_str)
                print(f"  {output_line}")
            else:
                results[dataset_id] = f"Error: {output_line}"
                print(f"  {output_line}")
                all_passed = False

        except subprocess.CalledProcessError as e:
            print(f"  Test failed for {dataset_id}.", file=sys.stderr)
            print(f"  Stdout: {e.stdout}", file=sys.stderr)
            print(f"  Stderr: {e.stderr}", file=sys.stderr)
            results[dataset_id] = f"Failed: {e.stderr.strip()}"
            all_passed = False
        except Exception as e:
            print(f"  An unexpected error occurred for {dataset_id}: {e}", file=sys.stderr)
            results[dataset_id] = f"Unexpected Error: {e}"
            all_passed = False
    
    print("\n--- Summary of Dataset Counts ---")
    for dataset, count in results.items():
        print(f"{dataset}: {count}")

    print("\nRunning software reference check...")
    try:
        subprocess.run(
            [sys.executable, str(software_refs_script)],
            check=True,
            encoding="utf-8"
        )
    except subprocess.CalledProcessError:
        all_passed = False

    if all_passed:
        print("\nAll dataset count tests passed.")
        sys.exit(0)
    else:
        print("\nSome dataset count tests failed or had issues.")
        sys.exit(1)

if __name__ == "__main__":
    main()
