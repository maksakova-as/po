# План модернизации: совместное сосуществование SEAF2 + SEAF1 + Reverse (TA)

## 0. Контекст и цель

Цель — сделать **SEAF2 (namespace, сущности, таблицы, PlantUML, названия)** единственным “языком UI”, но при этом разрешить подключение данных из трёх источников:

1) **SEAF2 данные** (обычные YAML-объекты, попадающие в `seaf.ds.objects_by_entities`)
2) **SEAF1 данные** (legacy namespace `seaf.ta.*`)
3) **Reverse данные** (генерируемые витринами `reverse2seaf2.ds.ta.reverse.*`)

Требование: поддержать **одновременную работу** источников (SEAF2 + Reverse, либо SEAF2 + SEAF1 + Reverse) без переписывания UI по каждой сущности.

Область изменений: пакет TA:
- `_metamodel_/seaf-company-ta/`

## 1. Ключевая идея архитектуры

Свести все источники к одному “контракту” данных для UI:

- UI (tables/PlantUML/widgets) работает **только** с `seaf.company.ta.*` сущностями и **только** через витрины `seaf.company.ds.ta.*`.
- Все “подмешивания” делаются **в одном месте** — в `_metamodel_/seaf-company-ta/ta/datasets.yaml`.
- Карточки (`card`) должны уметь открывать “виртуальные” объекты (которые не лежат в `seaf.ds.objects`) → нужен fallback lookup.

## 2. Реальность ограничений

### 2.1 Что реально обеспечить
- Таблицы и PlantUML: да. Они читают данные из `origin` (витрин) → достаточно сделать витрины композитными.
- Открытие карточек для “виртуальных” объектов: да, если карточки ищут объект не только в `seaf.ds.objects`, но и в `seaf.company.ds.ta.all_objects` (или аналогичной “универсальной” витрине).

### 2.2 Что не будет “как у настоящих объектов” без материализации
- Валидация/rules, которые смотрят в data lake (`seaf.ds.objects_by_entities`), не увидят объектов, которые существуют только как результат datasets (`source` JSONata). Это нормально для режима “UI-агрегации”; если нужна валидация, данные нужно материализовать в `architecture/ta/*.yaml`.

## 3. Механизм переключения источников

Управление режимами без переписывания виджетов:

- В TA конфиге `_metamodel_/seaf-company-ta/ta/configs.yaml`:
  - `ta.data_sources.enabled: ["seaf2", "seaf1", "reverse"]`
  - `ta.data_sources.priority: ["seaf2", "seaf1", "reverse"]` (порядок merge = приоритет данных)

В `ta/datasets.yaml` каждая витрина строится как:
- `seaf2_part` (из `seaf.ds.objects_by_entities`)
- `seaf1_part` (маппинг из `seaf.ta.*` в `seaf.company.ta.*` + префикс `seaf1.` в ID)
- `reverse_part` (из `reverse2seaf2.ds.ta.reverse.*`)
- финальный результат: `$merge([part1, part2, part3])` по `priority`

## 4. План изменений по слоям

### 4.1 Слой витрин (datasets) — основной фронт работ
Файл: `_metamodel_/seaf-company-ta/ta/datasets.yaml`

Цель: сделать `seaf.company.ds.ta.*` композитными (SEAF2 + SEAF1 + Reverse) и добавить всё важное в `seaf.company.ds.ta.all_objects`.

### 4.2 Слой карточек (presentations) — fallback lookup
Карточки должны искать объект:
1) в `seaf.ds.objects` (обычные SEAF2 объекты),
2) если не нашли — в `seaf.company.ds.ta.all_objects` (виртуальные SEAF1/Reverse объекты).

### 4.3 Слой PlantUML — устойчивость к ID и синтаксису
Типовые причины массовых падений PlantUML/JSONata после агрегации источников:
- неверные регулярные выражения в JSONata (нужны литералы `/pattern/`, а не строка `"pattern"`, где это важно для движка),
- несанитизированные alias/идентификаторы в PlantUML (точки/дефисы/скобки ломают “as <id>”),
- случайные переносы строк внутри PlantUML label (должно быть `\\n` внутри строки, а не реальный newline),
- ошибки `Attempted to invoke a non-function` из-за пропущенного `&` (конкатенации строк).

## 5. Проверки и инструментирование (обязательный цикл)

Перед редактированием датасетов/виджетов — проверять backend, чтобы не чинить “призраки”:

1) Problems:
```powershell
curl -s http://127.0.0.1:8080/core/storage/problems/
```

2) Проверка датасета на backend:
```powershell
curl -s "http://127.0.0.1:8080/core/storage/jsonata/<dataset_id>"
```

3) UI smoke:
- генерация URL: `_metamodel_/seaf-company-ta/auto_tests/ui_test/generate_test_urls.py`
- smoke: `_metamodel_/seaf-company-ta/auto_tests/ui_test/run_ui_smoke_test.js`

## 6. Риски и решения

- **Риск:** конфликты при merge (`$merge`) и перетирание данных.  
  **Решение:** разные ID для SEAF1/Reverse (`seaf1.*`, `reverse.*`) и контролируемый `priority`.
- **Риск:** карточки не открываются для “виртуальных” объектов.  
  **Решение:** fallback `seaf.ds.objects` → `seaf.company.ds.ta.all_objects`.
- **Риск:** графы/PlantUML падают на синтаксисе/alias.  
  **Решение:** санитизация `as <id>` через `$replace(id, /[^A-Za-z0-9_]/, "_")` и контроль `\\n` в label.

## 7. Ожидаемый результат

- SEAF2 остаётся основным UI-контрактом (`seaf.company.ta.*`).
- Данные из SEAF2/SEAF1/Reverse могут подключаться одновременно.
- Таблицы/PlantUML автоматически видят агрегированные данные через `seaf.company.ds.ta.*`.
- Карточки открываются для объектов из любого источника через fallback.

---

# Отчет о ходе выполнения (актуально на 2025‑12‑15)

## ✅ Выполнено

### Конфигурация источников
- `_metamodel_/seaf-company-ta/ta/configs.yaml`: флаги `enabled/priority` для `seaf2/seaf1/reverse`.

### Композитные датасеты TA
- Внедрён паттерн merge (SEAF2 + SEAF1 + Reverse) для ключевых витрин и их включение в `seaf.company.ds.ta.all_objects` (включая `networks`, `network_segments`, `network_links`, `network_components` и др.).

### Fallback lookup для карточек
- Карточки ищут объект сначала в `seaf.ds.objects`, затем в `seaf.company.ds.ta.all_objects` (для SEAF1/Reverse).

### Починка массовых WARN по сетевым карточкам
- Исправлены JSONata/PlantUML проблемы (регексы как `/.../`, санитизация `as <id>`, корректные `\\n` в label, устранение синтаксических ошибок) для:
  - `seaf.company.ta.services.networks`
  - `seaf.company.ta.services.network_segments`
  - `seaf.company.ta.components.networks` (network_components)
  - `seaf.company.ta.services.network_links` (включая кейс `Attempted to invoke a non-function`)

### Автотесты и triage карточек
- `run_ui_smoke_test.js` отличает:
  - “страница не грузится” (hard),
  - “страница грузится, но есть ошибки” (soft markers),
  - проблемы PlantUML/DataProfile по HTTP 4xx/5xx.
- Добавлен сбор payload при ошибках `seafplantuml` для диагностики.
- Добавлены режимы:
  - несколько фильтров за один запуск,
  - сохранение результатов в отдельные файлы через `--out <prefix>`.

## 🚧 В работе / Техдолг

### “Граф технических зависимостей” (SEAF1/Reverse)
Текущее состояние:
- `seaf.company.ds.app.systems_dependency_graph` строится и работает для SEAF2.

Ограничение:
- Для SEAF1/Reverse связи “APP → TA‑сервис” зависят от `app_components`, которые должны содержать **ID из `seaf.company.app.systems`**.
- В reverse‑витринах многие TA‑объекты не содержат `app_components` (нужно завести маппинг/обогащение).

### Проблемы reverse‑dataset’ов (вне TA UI‑контракта)
В `core/storage/problems` могут оставаться ошибки в legacy reverse‑ветке (`seaf.ta.reverse.general.*`). Это отдельная зона ответственности; приоритет — не ломать `seaf.company.ds.ta.*` и UI.

## 📅 Ближайшие шаги (чтобы закрывать “план” по факту)

1) Доделать обогащение `app_components` для Reverse (и при необходимости для SEAF1) так, чтобы граф зависимостей отражал связи между приложениями и TA‑сервисами.
2) Расширить smoke‑покрытие для остальных сущностей, где есть PlantUML/таблицы, и вести triage через `--out <prefix>`.
3) Держать цикл “сначала backend‑проверка, потом правка”: `problems` → `jsonata/<dataset>` → UI smoke.

