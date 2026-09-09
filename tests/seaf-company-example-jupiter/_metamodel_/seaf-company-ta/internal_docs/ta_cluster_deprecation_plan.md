# План отказа от сущности `seaf.company.ta.services.clusters`

## Цель

Отказаться от отдельной сущности `seaf.company.ta.services.clusters` и перенести ее семантику в `seaf.company.ta.services.compute_services`, чтобы:

- убрать дублирование моделей "кластер" и "вычислительный сервис";
- унифицировать ссылки из других сущностей на один тип технического сервиса;
- упростить датасеты, правила, таблицы и визуализации.

## Режим миграции

Одномоментный полный переход (single cutover):

- без промежуточных заглушек и alias-датасетов для `clusters`;
- без временного dual-mode в прод-модели;
- после релиза сущность `seaf.company.ta.services.clusters` и датасет `seaf.company.ds.ta.clusters` отсутствуют.

## Статус выполнения (2026-02-15)

Миграция выполнена в полном объеме:

- сущность `seaf.company.ta.services.clusters` удалена из модели;
- датасет `seaf.company.ds.ta.clusters` удален;
- конвертация legacy/reverse/KADZO кластеров перенаправлена в `seaf.company.ta.services.compute_services`;
- ссылки из сервисов и компонентов переведены с `cluster` на `compute_service`;
- R41 датасеты переведены на `compute_service` (без отдельного слоя `cluster`).

Проверки после cutover:

- `seaf.company.ds.ta.compute_services = 96`;
- `seaf.company.ds.ta.clusters` отсутствует (источник не найден);
- в `seaf.company.ds.ta.all_objects` объектов с `__entity_id__ = seaf.company.ta.services.clusters` нет;
- UI smoke тест (`auto_tests/ui_test/run_ui_smoke_test.js`): `Passed 126/126`, `Failed 0`.

## Контрольные счетчики (baseline)

Снято перед миграцией (backend, включены источники `seaf2`, `seaf1`, `reverse`):

- `seaf.company.ds.ta.clusters = 25`
- `seaf.company.ds.ta.compute_services = 71`

Команды фиксации baseline:

```powershell
py -3 _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py clusters
py -3 _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py compute_services
```

Целевой контроль после cutover:

- `seaf.company.ds.ta.clusters` отсутствует (или счетчик `0`, если временно оставлен только для техдолга в ветке разработки);
- `seaf.company.ds.ta.compute_services_after = 71 + 25 = 96`;
- проверка выполняется по таблицам и датасетам backend.

Фактический результат после cutover:

- `seaf.company.ds.ta.compute_services_after = 96` (соответствует расчету `71 + 25`);
- `seaf.company.ds.ta.clusters` отсутствует;
- прирост `compute_services` подтвержден.

Источники сравнения:

- `_metamodel_/seaf-company-ta/services/cluster.yaml`
- `_metamodel_/seaf-company-ta/services/compute_service.yaml`
- `_metamodel_/seaf-company-ta/services/base_entity.yaml`

## Сравнение свойств

### Схемы объектов (property-level)

| Свойство | `clusters` | `compute_services` | Разница |
|---|---|---|---|
| `title` (из base) | есть | есть | Разницы нет |
| `description` (из base) | есть | есть | Разницы нет |
| `app_components` (из base) | есть | есть | Разницы нет |
| `stand` (из base) | есть | есть | Разницы нет |
| `external_id` (из base) | есть | есть | Разницы нет |
| `availabilityzone` | `array[dc_az]` | `array[dc_az]` | Разницы нет |
| `location` | `array[dc \| dc_office]` | `array[dc \| dc_office]` | Разницы нет |
| `network_connection` | `array[network]` | `array[network]` | Разницы нет |
| `service_type` | `string` (свободный) | `string` c `enum` | В `compute_services` значение ограничено справочником |
| `fqdn` | есть (`string`) | нет | Есть только у `clusters`, в целевую модель не переносится |
| `reservation_type` | есть (`string`) | нет | Переносится в структуру `high_availability.capacity_reservation_type` |
| `high_availability` | нет | нет (текущее состояние) | Добавляется в `compute_services` как новое целевое свойство |

### Обязательные поля

| Сущность | `required` |
|---|---|
| `clusters` | `network_connection` |
| `compute_services` | `service_type`, `network_connection` |

### Вывод по разнице

1. `compute_services` уже покрывает большую часть полей `clusters`.
2. `fqdn` исключается из целевой модели и не мигрируется.
3. Семантика `reservation_type` переносится в `high_availability.capacity_reservation_type`.
4. В `compute_services` добавляется объект `high_availability` для параметров отказоустойчивости.
5. `service_type` в `compute_services` остается с текущим `enum` без изменений.
6. Основной риск миграции: значения `service_type` из `clusters`, не входящие в текущий `enum`.

## План наполнения `compute_services` свойствами кластера

## Фаза 1. Выравнивание схемы

Цель: сделать `compute_services` способным хранить все данные кластера без потерь.

Шаги:

1. В `_metamodel_/seaf-company-ta/services/compute_service.yaml` добавить свойства:
   - `high_availability: object`
   - структура:
     - `high_availability.type` (`enum`: `Да`, `Нет`)
     - `high_availability.capacity_reservation_type` (`enum`: `Отсутствует`, `StandBy`, `Active`)
     - `high_availability.capacity_management` (`enum`: `Отсутствует`, `Частичное`, `Полное`)
   - `required` для `high_availability`:
     - `type`
     - `capacity_reservation_type`
     - `capacity_management`
   - эталонный YAML-фрагмент для включения:

```yaml
properties:
  high_availability:
    title: Параметры отказоустойчивости
    description: >
      Отказоустойчивость - это способность объекта сохранять работоспособность в случае отказа одного или нескольких (различных) его компонентов в пределах одной зоны доступности.
    type: object
    properties:
      type:
        title: Высокая доступность объекта управления (HA)
        description: >
          Свойство объекта, обозначающее его способность (реализованную) сохранять работоспособность в случае отказа одного или нескольких (различных) его компонентов в пределах одной зоны доступности.
          \n- "Да" для объекта, построенного на принципах НА
          \n- "Нет" для объекта, не реализующего НА
        enum:
          - Да
          - Нет
      capacity_reservation_type:
        title: "Тип резервирования \nв пределах одной зоны доступности"
        description: >
          Тип резервирования мощностей в пределах одной зоны доступности.
          В качестве значений должны использоваться значения соответствующего справочника.
        enum:
          - Отсутствует
          - StandBy
          - Active
      capacity_management:
        title: "Полнота резервирования \nв пределах одной зоны доступности"
        description: >
          В качестве значений должны использоваться значения соответствующего справочника.
          \n - "Отсутствует" если резервирование не реализовано ни для одного из компонентов объекта
          \n - "Частичное" если:
          \n             * резервирование реализовано не для всех компонентов объекта,
          \n             * либо для некоторых компонентов вычислительные мощности зарезервированы не в полном объеме,
          \n             * либо для statefull компонентов данные зарезервированы не в полном объеме
          \n - "Полное" если вычислительные мощности зарезервированы в полном объеме для всех компонентов, и для statefull компонентов данные зарезервированы в полном объеме
        enum:
          - Отсутствует
          - Частичное
          - Полное
    required:
      - type
      - capacity_reservation_type
      - capacity_management
```
2. Зафиксировать ограничение по `service_type`:
   - `enum` в `compute_services` не меняется;
   - подготовить таблицу нормализации значений `clusters.service_type -> compute_services.service_type` только в рамках существующего `enum`.
3. Зафиксировать правило маппинга:
   - `clusters.service_type -> compute_services.service_type`
   - `clusters.reservation_type -> compute_services.high_availability.capacity_reservation_type`
   - `clusters.fqdn -> не переносится`

Критерий готовности:

- любой объект из `seaf.company.ta.services.clusters` валидируется как объект `seaf.company.ta.services.compute_services` без потери полей.

## Фаза 2. Одномоментная миграция данных в датасеты

Цель: начать публиковать данные кластеров через `seaf.company.ds.ta.compute_services`.

Шаги:

1. Обновить сборку `seaf.company.ds.ta.compute_services` в `_metamodel_/seaf-company-ta/ta/datasets.yaml`:
   - включить merge источника `seaf.company.ta.services.clusters` (seaf2),
   - включить legacy `seaf.ta.services.cluster` (seaf1) с конвертацией в `compute_services`,
   - включить reverse-кластеры с конвертацией в `compute_services`,
   - включить KADZO-кластеры с конвертацией в `compute_services`.
2. В том же релизе удалить `seaf.company.ds.ta.clusters` из `_metamodel_/seaf-company-ta/ta/datasets.yaml` и из зависимых агрегатов (`all_objects` и др.).
3. Выбрать стратегию идентификаторов:
   - рекомендовано сохранить существующие `cluster_id` как `id` объекта в `compute_services`, чтобы избежать массового перелинкования.
4. Выполнить контроль счетчиков после миграции:
   - `compute_services_after = compute_services_before + clusters_before`;
   - проверить значения по backend и по таблице `/entities/seaf.company.ta.services.compute_services/list`.

Критерий готовности:

- карточки и список `compute_services` содержат бывшие кластеры;
- датасет `seaf.company.ds.ta.clusters` отсутствует.
- счетчик `compute_services` вырос на исходное количество `clusters`.

## Фаза 2.1. Миграция датасетов схемы Р41

Цель: чтобы схемы Р41 не зависели от удаленной сущности `clusters` и брали бывшие кластеры из `compute_services`.

Шаги:

1. Обновить маппинг в `_metamodel_/seaf-company-ta/_extensions/ta_docs/r41/datasets/root.yaml`:
   - убрать использование `seaf.ta.services.cluster`/`seaf.company.ta.services.clusters` как отдельного слоя;
   - включить данные бывших кластеров через `seaf.ta.services.compute_service`/`seaf.company.ta.services.compute_services`.
2. Обновить reverse части Р41:
   - `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/schema_r41_reverse.yaml`
   - `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/schema_r41_seaf1.yaml`
   - исключить публикацию кластеров в отдельный ключ Р41, перенаправить в compute services.
3. Проверить все документы Р41:
   - `/docs/seaf.ta.docs.schema_r41`
   - `/docs/seaf.ta.docs.schema_r41_seaf1`
   - `/docs/seaf.ta.docs.schema_r41_reverse`
4. Зафиксировать отдельный контроль количества объектов Р41 по compute services до/после миграции.

Критерий готовности:

- схемы Р41 строятся без сущности `clusters`;
- объекты бывших кластеров отображаются как `compute_services`.

## Фаза 3. Перевод ссылок с `cluster` на `compute_service`

Цель: убрать зависимость остальных сущностей от `clusters`.

Минимальный набор файлов для изменения ссылок:

- `_metamodel_/seaf-company-ta/services/backup.yaml`
- `_metamodel_/seaf-company-ta/services/kb.yaml`
- `_metamodel_/seaf-company-ta/services/logical_link.yaml`
- `_metamodel_/seaf-company-ta/services/monitoring.yaml`
- `_metamodel_/seaf-company-ta/components/server.yaml`

Шаги:

1. Во всех `anyOf` удалить `$ref` на `seaf.company.ta.services.clusters.cluster` после переноса данных.
2. Для специализированного поля `monitoring.cluster_ref`:
   - заменить тип ссылки на `compute_service`, или
   - переименовать поле в нейтральное (`service_ref`) и мигрировать данные.

Критерий готовности:

- в `services/*.yaml` и `components/*.yaml` нет обязательных ссылок на `clusters`.

## Фаза 4. UI, меню, editable tables, презентации

Цель: убрать пользовательскую поверхность `clusters`.

Шаги:

1. Вывести из меню сущность `seaf.company.ta.services.clusters`:
   - `_metamodel_/seaf-company-ta/menu/ta.yaml`
2. Перенести/объединить представления:
   - `presentations/cluster.yaml` -> `presentations/compute_service.yaml`
   - `widgets/platform.yaml`, `widgets/server.yaml`, `widgets/network.yaml` (убрать dataset `seaf.company.ds.ta.clusters`)
3. Деактивировать/удалить таблицу редактирования кластеров:
   - `_metamodel_/seaf-company-ta/_extensions/ta_docs/editable_tables/clusters_edit_table.yaml`
   - `_metamodel_/seaf-company-ta/_extensions/ta_docs/editable_tables/menu/clusters.yaml`

Критерий готовности:

- в UI нет отдельного раздела кластеров;
- данные кластеров доступны через compute services.

## Фаза 5. Reverse/KADZO и документация

Цель: завершить отказ от `clusters` как от самостоятельной модели.

Шаги:

1. Перенастроить reverse-конвертеры:
   - `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/advanced/clusters.yaml`
   - публикация в `compute_services` вместо `clusters`.
2. Перенастроить KADZO-поток:
   - `_metamodel_/seaf-company-ta/_extensions/kadzo/datasets/dataset_parts/compute_services.yaml`
3. Перенастроить SEAF1-конвертацию:
   - `_metamodel_/seaf-company-ta/_extensions/seaf1_datasets/datasets/dataset_parts/clusters.yaml` (перенос логики в поток `compute_services`).
4. Выполнить полный аудит всех старых правил конвертации в кластеры и перевести на `compute_services`:
   - искать и устранить все вхождения `__entity_id__: "seaf.company.ta.services.clusters"`;
   - искать и устранить все вхождения `seaf.ta.services.cluster` в логике маппинга.
5. Обновить документацию и внутренние карты датасетов:
   - `_metamodel_/seaf-company-ta/internal_docs/datasets_ta.md`
   - связанные migration-plan документы.

Критерий готовности:

- новые загрузки reverse/KADZO/SEAF1 не создают объектов `clusters`;
- все исторические конверторы кластера выдают `compute_services`.

## Фаза 6. Финальная очистка после cutover

Шаги:

1. Удалить entity `seaf.company.ta.services.clusters` и все прямые ссылки на нее:
   - `services/*`, `components/*`, `presentations/*`, `widgets/*`, `menu/*`, `_extensions/ta_docs/editable_tables/*`.
2. Удалить файлы и пункты меню/таблиц, относящиеся только к кластерам.
3. Зафиксировать запрет на повторное введение сущности `clusters` в правилах разработки метамодели.

Критерий готовности:

- в модели, датасетах и UI полностью отсутствует сущность `clusters` и ее артефакты.

## Минимальный чек-лист проверки после каждого этапа

1. Проверка JSONata/датасета в backend (`/core/storage/jsonata/...`).
2. Перезапуск контейнера и проверка проблем (`/core/storage/problems/`).
3. Прогон `completeness_test`.
4. Прогон автотестов датасетов.
5. Финальная проверка UI (list/card/table для `compute_services`, а затем отсутствие `clusters`).
6. Проверка счетчиков после cutover:
   - `compute_services_after = compute_services_before + clusters_before`
   - таблица `compute_services` отражает прирост на количество кластеров baseline.
7. Проверка Р41:
   - все три схемы Р41 открываются и строятся;
   - в Р41 нет отдельного слоя кластеров, бывшие кластеры идут через `compute_services`.


