# Логика датасетов КА ДЗО (kadzo)

## Где находится исходный слой
- Исходные сущности КА ДЗО импортируются из `architecture/.../repo_*` и попадают в data-lake под ключами вроде `kadzo.v2023.tech_services`, `kadzo.v2023.tech_params`, `kadzo.v2023.systems` и т.д.
- В TA домене используется «конвертерный» слой в `_metamodel_/seaf-company-ta/_extensions/kadzo/datasets/dataset_parts/*.yaml`.

## Как устроены конвертеры
- Каждый файл в `_extensions/kadzo/datasets/dataset_parts` содержит один или несколько dataset'ов формата `kadzo.ds.ta.*`.
- Эти dataset'ы **не рисуют UI напрямую**, они служат источником для агрегирующих datasets в `_metamodel_/seaf-company-ta/_metamodel_/seaf-company-ta/ta/datasets.yaml`.
- Пример: `_extensions/kadzo/datasets/dataset_parts/monitoring.yaml` строит `kadzo.ds.ta.monitoring` из `kadzo.v2023.tech_services` по фильтру классов (`Средства мониторинга`, `Системы логирования`).

## Встраивание в агрегированные TA datasets
- В `_metamodel_/seaf-company-ta/_metamodel_/seaf-company-ta/ta/datasets.yaml` собираются итоговые коллекции `seaf.company.ds.ta.*`.
- Каждая такая коллекция (например `seaf.company.ds.ta.monitoring`) **мержит** источники:
  - `seaf2` (ручные данные),
  - `seaf1` (legacy),
  - `kadzo` (через `kadzo.ds.ta.*`),
  - `reverse` (через `reverse2seaf2.ds.ta.reverse.*`).
- Включение/исключение источников задаётся в `seaf-company-example-jupiter/_metamodel_/seaf-company-ta/configs.yaml`:
  - `seaf.configs.seaf.company.ta.data_sources.enabled`
  - `seaf.configs.seaf.company.ta.data_sources.priority`

## Связь с реверсом VMware
- Конвертер VMware (reverse) может ссылаться на объекты КА ДЗО через `kadzo.v2023.tech_services`.
- Для мониторинга/backup вычисляется целевой тип:
  - мониторинг/логирование → `kadzo.monitoring.<id>`
  - backup → `kadzo.backup.<id>`
  - прочее (включая HA) → `kadzo.compute.<id>`
- Эти id попадают в `seaf.company.ds.ta.servers.is_part_of` и используются в карточках сервера.

## Практика проверки
- Сначала проверяем backend: `/core/storage/release-data-profile/...`
- Потом UI: карточки и таблицы.
- Включаем автотесты после `completeness_test`.

---

# Точки входа для отладки
- Data-lake: `/core/storage/release-data-profile/%2Fdata%2Fkadzo.v2023.tech_services`
- Конвертер: `_metamodel_/seaf-company-ta/_extensions/kadzo/datasets/dataset_parts/*`
- Итоговые datasets: `_metamodel_/seaf-company-ta/_metamodel_/seaf-company-ta/ta/datasets.yaml`

