# TA Dataset Parts

Разбиение большого файла `ta/datasets.yaml` на части.

Правила:
- один файл = один dataset id;
- все подключения идут через `ta/dataset_parts/root.yaml`;
- в начале каждого файла есть комментарии `Назначение` и `Используется`.

Группы:
- `00_bootstrap` — конфиг и кэши;
- `10_location` — регионы/AZ/ЦОД/офисы;
- `20_network` — сегменты/сети/сетевые связи/сетевые компоненты;
- `30_platform` — compute/virtualization/storage/servers/software;
- `40_ops_security` — backup/monitoring/kb;
- `50_k8s` — k8s и производные объекты;
- `60_environment` — окружения и стенды;
- `70_indexes` — ускоряющие индексы;
- `80_views` — агрегированные представления.
