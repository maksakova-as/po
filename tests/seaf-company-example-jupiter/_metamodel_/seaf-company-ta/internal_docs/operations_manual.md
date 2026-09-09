# Operations Manual: Backend, API, UI, автопроверки

Короткий набор команд и приёмов для диагностики ArchTool (DocHub) и проверки TA через backend/API и автотесты.

## 0) Обязательная последовательность работы

Эта последовательность обязательна для всех изменений TA:

1. Проверка кода в backend (статус + problems).
2. Редактирование кода.
3. Перезапуск контейнера.
4. Проверка датасетов.
5. Автотесты датасетов (Completeness Test).
6. Проверка UI (web/Playwright).

Если шаг провалился — исправить причину и повторить цикл с шага 1.

## 1) Перезапуск backend (Hard Reload)

После правок в `_metamodel_` (datasets/presentations/widgets) или при странном кэше:

```powershell
docker restart archtool
```

Обычно backend поднимается за ~35–60 секунд.

## 1.1) Профили источников данных (performance mode)

Профиль задается в `_metamodel_/seaf-company-ta/configs.yaml`:

```yaml
seaf.configs:
  seaf.company.ta:
    data_sources:
      profile: seaf2_only | seaf2_seaf1 | full_with_reverse
```

Поддерживаемые профили:
- `seaf2_only` — минимальная задержка, только источник `seaf2`.
- `seaf2_seaf1` — рабочий режим без reverse.
- `full_with_reverse` — полный режим (`seaf2 + seaf1 + kadzo + reverse`) для интеграций и сверок.

Если профиль не задан, используются `data_sources.enabled/priority`.

## 2) Быстрая диагностика

### 2.1 Problems (ошибки обсчёта датасетов)

```powershell
curl -s http://127.0.0.1:8080/core/storage/problems/
```

Если в списке есть датасеты `seaf.company.ds.*` — UI может ломаться (карточки, виджеты, графы).

### 2.2 Проверка UI

Главная:
`http://127.0.0.1:8080/`

Карточка сущности:
`http://127.0.0.1:8080/entities/<entity>/card?id=<id>`

Список сущности:
`http://127.0.0.1:8080/entities/<entity>/list`

Карточка АС (проверка виджета Kubernetes deployments при наличии связей через `app_components`):
`http://127.0.0.1:8080/entities/seaf.company.app.systems/card?id=<id>`

## 3) API (полезные endpoints)

- `GET /core/storage/jsonata/<dataset_id>`
  - Пример:
    ```powershell
    curl -s "http://127.0.0.1:8080/core/storage/jsonata/seaf.company.ds.ta.all_objects"
    ```

- `GET /core/storage/problems/`
  - Список проблем обсчёта (см. выше).

- `GET /core/storage/release-data-profile/<path>`
  - Используется UI для таблиц/профиля; 4xx/5xx здесь часто проявляются как ошибки в карточках.

## 4) Автотесты

См. также: `_metamodel_/seaf-company-ta/auto_tests/README.md`

### 4.1 Completeness Test

```powershell
python _metamodel_\seaf-company-ta\auto_tests\completeness_test\check_data_flow.py
```

Пример проверки одного ключа:
```powershell
python _metamodel_\seaf-company-ta\auto_tests\completeness_test\check_data_flow.py "network_components"
```

Обязательное правило порядка: сначала выполняется `Completeness Test`, затем запускаются UI‑автотесты (web/Playwright) из раздела 4.2.

### 4.2 UI Smoke Test (таблица ссылок + ошибки PlantUML/DataProfile)

1) Сгенерировать ссылки (из backend dataset’ов `seaf.company.ds.ta.*`):
```powershell
cd _metamodel_\seaf-company-ta\auto_tests\ui_test
python generate_test_urls.py
```

Артефакты для ручной проверки:
- `_metamodel_/seaf-company-ta/auto_tests/ui_test/urls.md`
- `_metamodel_/seaf-company-ta/auto_tests/ui_test/urls.csv`

2) Запустить smoke:
```powershell
cd _metamodel_\seaf-company-ta\auto_tests\ui_test
node run_ui_smoke_test.js
```

Фильтр по `name` (подстрока, можно несколько):
```powershell
node run_ui_smoke_test.js "services.networks"
node run_ui_smoke_test.js "services.networks" "services.network_segments" "components.networks"
node run_ui_smoke_test.js "services.networks,services.network_segments,components.networks"
```

Чтобы сохранять результаты в отдельные файлы и не перетирать `results.*`:
```powershell
node run_ui_smoke_test.js --out results.networking "services.networks" "services.network_segments" "components.networks"
```

Результаты:
- По умолчанию: `_metamodel_/seaf-company-ta/auto_tests/ui_test/results.md` (таблица со ссылками), `results.csv`, `results.json`
- С `--out <prefix>`: `_metamodel_/seaf-company-ta/auto_tests/ui_test/<prefix>.md` (таблица со ссылками), `<prefix>.csv`, `<prefix>.json`

Обязательство: финальный прогон UI‑проверки через web (браузерный запуск Playwright) выполняется после всех правок и перезапуска backend.

### 4.3 Проверка наличия заголовков на карточках TA

```powershell
python _metamodel_\seaf-company-ta\auto_tests\check_card_headers.py
```

Скрипт проверяет, что на каждой карточке TA есть header‑виджет и header‑presentation.

## 5) Диагностика: «Граф технических зависимостей»

В TA-приложении граф строится из датасета:
- `seaf.company.ds.app.systems_dependency_graph` (файл: `_metamodel_/seaf-company-ta/_extensions/app/systems/datasets/root.yaml`)

### Что проверять, если граф пустой/сломался

1) `Problems`:
```powershell
curl -s http://127.0.0.1:8080/core/storage/problems/
```

2) Сам датасет графа:
```powershell
curl -s "http://127.0.0.1:8080/core/storage/jsonata/seaf.company.ds.app.systems_dependency_graph"
```

3) Ключевые причины, которые встречались:
- **JSONata parse error** (например, `No terminating / in regular expression`) — часто из-за регулярных выражений/флагов, несовместимых с JSONata-движком.
- **Неверная структура индекса TA** — если `seaf.company.ds.ta.all_objects` уже является map `id -> object`, то его нельзя превращать через `$merge(ta_all.*)`, иначе связи исчезают.
- **Потеря `app_components`** — если у TA-объектов не заполняется `app_components`, то ребра «APP → сервис» не появятся.

Примечание про SEAF1/Reverse: для отображения связей в графе значения `app_components` у TA-объектов должны совпадать с ID из `seaf.company.app.systems` (иначе для SEAF1/Reverse связи могут отсутствовать даже при наличии `app_components`).

После правок — `docker restart archtool`.

