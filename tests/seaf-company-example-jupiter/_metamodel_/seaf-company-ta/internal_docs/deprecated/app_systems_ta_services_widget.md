# Виджет «Технические сервисы» в карточке прикладных систем
Документ объединяет краткое описание, быстрый запуск и историю изменений по виджету «Технические сервисы», который показывает инфраструктурные зависимости прикладной системы на основании ссылок в поле `app_components`.
## Что видно в карточке
- **Таблица «Технические сервисы».** Данные приходят из `seaf.company.ds.app.systems_ta_services`: датасет собирает все TA‑объекты с заполненным `app_components`, а презентация `ta_services` фильтрует строки по `id` системы.
- **Граф «Ресурсно-сервисная модель».** Датасет `seaf.company.ds.app.systems_dependency_graph` строит граф APP → техсервисы → зоны/ЦОДы/сети/кластер, презентация `resource_map_graph` отображает его через PlantUML (шаблон `templates/resource_map_graph.puml`). Виджет `ta_services_graph` расположен рядом с таблицей, поэтому оба представления доступны одновременно.
## Быстрый старт
1. Выполните перезагрузку backend (см. `Docs/operations_manual.md`).
2. Откройте карточку нужной системы, например `http://localhost:8080/entities/seaf.company.app.systems/card?id=jupiter.app_system.aihub`.
3. (Опционально) убедитесь, что нет ошибок валидации (см. `Docs/operations_manual.md`).
4. Внизу карточки должен появиться блок «Технические сервисы» с записями из TA‑сущностей (для `aihub` это `jupiter.k8s.01`, `jupiter.monitoring.elk`, `jupiter.monitoring.zabbix`, `jupiter.backup.cyberbackup`). 
## Реализация
### Табличный слой
- **Датасет `seaf.company.ds.app.systems_ta_services`** (`_metamodel_/seaf-company-ta/app/systems/datasets.yaml`) подтягивает TA-объекты из `seaf.ds.objects_by_entities` и хранит `__id__`, `__entity_id__`, `title`, `description`, `app_components`.
- **Презентация `ta_services`** (`.../presentations/ta_services.yaml`) нормализует `app_components` в массив, фильтрует строки по `id` системы и отображает тип сервиса по `__entity_id__`.
- **Виджет `ta_services`** (`.../presentations/ta_services_widget.yaml`) подключён к карточке с `align="v"`, `order=4000`, поэтому таблица всегда доступна.
### Граф зависимостей
- **Датасет `seaf.company.ds.app.systems_dependency_graph`** (тот же `datasets.yaml`) строит APP → техсервисы → зоны/ЦОДы/сети/кластеры по `seaf.company.ds.ta.all_objects`, добавляя ссылки, цвета и нормализованные идентификаторы.
- **Презентация `resource_map_graph`** (`.../presentations/resource_map_graph.yaml` + `templates/resource_map_graph.puml`) отдаёт объект `{graph}` DocPlantUML и строит кликабельную диаграмму.
- **Виджет `ta_services_graph`** (`.../presentations/ta_services_widget.yaml`, `order=4050`) располагается рядом с таблицей и показывает визуальный срез без изменений старого UX.
### Данные
- `architecture/ta/k8s.yaml` содержит `app_components` (например, `jupiter.k8s.01`).
- `architecture/ta/storage.yaml` дополняет зависимость S3/CEPH-служб (`jupiter.obj_storage.cloud_s3`, `jupiter.sw_storage.01` и т.д.).
- При необходимости добавляем те же поля в monitoring/backup, чтобы система появлялась и в таблице, и в графе.
## История изменений и ссылки на файлы
| Дата        | Файл                                         | Что изменено                                                                                  |
|-------------|----------------------------------------------|------------------------------------------------------------------------------------------------|
| 2025‑11‑22   | `_metamodel_/seaf-company-ta/app/systems/datasets.yaml`            | Добавлен датасет `seaf.company.ds.app.systems_ta_services` (JSONata выборка TA‑сущностей).      |
| 2025‑11‑22   | `_metamodel_/seaf-company-ta/app/systems/presentations/ta_services.yaml` | Создана презентация, выводящая таблицу с названием, типом и описанием сервисов.                |
| 2025‑11‑22   | `_metamodel_/seaf-company-ta/app/systems/presentations/ta_services_widget.yaml` | Виджет подключён к карточке прикладной системы.                                               |
| 2025‑11‑22   | `_metamodel_/seaf-company-ta/app/systems/presentations/_root.yaml` | Добавлены ссылки на новые презентации.                                                        |
| 2025‑11‑22   | `architecture/ta/k8s.yaml`                                         | В `app_components` кластера `jupiter.k8s.01` добавлен `jupiter.app_system.aihub`.              |
| 2025‑11‑24   | `architecture/ta/storage.yaml`                                      | В `app_components` storage-сервисов добавлены ссылки на `jupiter.app_system.aihub` и связанные компоненты. |
| 2025‑11‑24   | `_metamodel_/seaf-company-ta/app/systems/datasets.yaml`            | Добавлен датасет `seaf.company.ds.app.systems_dependency_graph` для построения графов зависимостей.       |
| 2025‑11‑24   | `_metamodel_/seaf-company-ta/app/systems/presentations/resource_map_graph.yaml` | Добавлена PlantUML‑презентация `resource_map_graph` и виджет `ta_services_graph` с визуальной картой.     |
| 2025‑11‑22   | `_metamodel_/seaf-company-ta/app/systems/datasets.yaml` / `presentations/ta_services.yaml` | Обновлено подключение к `seaf.ds.objects_by_entities`, чтобы корректно считывать TA‑сущности. |
Все актуальные инструкции и описание изменений собраны в этом документе; отдельные файлы `QUICKSTART_ta_services.md` и `CHANGELOG_ta_services_widget.md` больше не используются.
