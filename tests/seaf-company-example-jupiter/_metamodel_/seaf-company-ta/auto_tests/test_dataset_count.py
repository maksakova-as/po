import sys
import subprocess
import json
from pathlib import Path

def run_jsonata_query(query_string):
    script_dir = Path(__file__).resolve().parent
    helper = script_dir / "get_jsonata.py"
    temp_file = script_dir / "temp_jsonata_query.jsonata"
    temp_file.write_text(query_string, encoding="utf-8")
    
    try:
        result = subprocess.run(
            [sys.executable, str(helper), str(temp_file)],
            capture_output=True,
            text=True,
            check=True,
            encoding="utf-8"
        )
        return result.stdout.strip()
    except subprocess.CalledProcessError as e:
        print(f"Error running JSONata query: {e}", file=sys.stderr)
        print(f"Stdout: {e.stdout}", file=sys.stderr)
        print(f"Stderr: {e.stderr}", file=sys.stderr)
        sys.exit(1)
    finally:
        temp_file.unlink(missing_ok=True)

def main():
    if len(sys.argv) < 2:
        print("Usage: python test_dataset_count.py <dataset_id>", file=sys.stderr)
        sys.exit(1)
    
    dataset_id = sys.argv[1]
    
    # Query the dataset
    json_output = run_jsonata_query(dataset_id)
    
    if not json_output:
        print(f"Dataset '{dataset_id}' returned empty output.", file=sys.stderr)
        sys.exit(1)
        
    try:
        data = json.loads(json_output)
        if isinstance(data, dict):
            count = len(data)
        elif isinstance(data, list):
            count = len(data)
        else:
            count = 0 # Or 1 if it's a single value
            print(f"Warning: Dataset '{dataset_id}' returned a non-object/non-array type. Count set to 0.", file=sys.stderr)
        
        print(f"Dataset '{dataset_id}' contains {count} items.")
        sys.exit(0)
            
    except json.JSONDecodeError:
        print(f"Error: Could not decode JSON from dataset '{dataset_id}' output.", file=sys.stderr)
        print(f"Output: {json_output}", file=sys.stderr)
        sys.exit(1)

if __name__ == "__main__":
    main()
