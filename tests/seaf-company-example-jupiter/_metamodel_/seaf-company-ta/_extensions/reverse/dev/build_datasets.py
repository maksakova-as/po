from pathlib import Path
import yaml
parts_dir = Path('reverse2seaf2/ta/dataset_parts')
combined = {'datasets': {}}
for part in sorted(parts_dir.glob('*.yaml')):
    data = yaml.safe_load(part.read_text(encoding='utf-8'))
    combined['datasets'].update(data.get('datasets', {}))
out_path = Path('reverse2seaf2/ta/datasets.yaml')
out_path.write_text(yaml.safe_dump(combined, sort_keys=False, allow_unicode=True), encoding='utf-8')
