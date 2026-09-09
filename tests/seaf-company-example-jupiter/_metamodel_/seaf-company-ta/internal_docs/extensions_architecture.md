# Extensions Architecture (`_extensions`)

## Что перенесено
- `app` -> `_extensions/app`
- `kadzo` -> `_extensions/kadzo`
- `reverse` -> `_extensions/reverse`
- `ta/seaf1_datasets` -> `_extensions/seaf1_datasets`
- `docs` (R41 + editable tables) -> `_extensions/ta_docs`

Все extension-модули подключаются только через `root.yaml`.
Точка входа: `_metamodel_/seaf-company-ta/_extensions/_root.yaml`.
`seaf1_datasets` сохранен в `_extensions`, но по умолчанию отключен в `_extensions/_root.yaml`.

## Структура модулей
- `app`
  - `systems/datasets/root.yaml` + `dataset_parts/*`
  - `systems/presentations/root.yaml`
  - `docs/README.md`
- `kadzo`
  - `datasets/root.yaml` + `dataset_parts/{20_network,30_platform,40_ops_security}`
  - `docs/README.md`, `docs/dataset_logic.md`
- `reverse`
  - `datasets/root.yaml` + `dataset_parts/{advanced,vmware_onprem}`
  - `presentations/root.yaml` + `servers/root.yaml`
  - `docs/README.md`
  - `dev/jsonata_tests/*` и `dev/build_datasets.py`
- `seaf1_datasets`
  - `datasets/root.yaml` + `dataset_parts/{10_location,20_network,30_platform,40_ops_security,50_k8s,60_environment,80_views}`
  - `docs/README.md`
- `ta_docs`
  - `r41/docs/root.yaml` + `r41/datasets/root.yaml`
  - `r41/datasets/dataset_parts/{10_sources,20_compat,30_merge}`
  - `editable_tables/root.yaml` (отключены по умолчанию)

## Принципы порядка
- Один dataset-файл = один `dataset id`.
- В начале каждого dataset-файла:
  - `# Назначение: ...`
  - `# Используется: ...`
- Подключение dataset-файлов только через `dataset_parts/root.yaml`.

## Дальнейшие улучшения
1. Вынести `reverse/dev` в отдельный tooling-пакет, чтобы исключить случайный импорт dev-артефактов.
2. Добавить smoke-тесты на целостность extension-root цепочки (разрешение всех imports).
3. Добавить линтер на правило "dataset id = имя файла".
4. Для `seaf1_datasets` зафиксировать флаг включения через `configs.yaml` и убрать неиспользуемые dataset parts после стабилизации миграции.
