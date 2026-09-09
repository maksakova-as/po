# Автотесты TA

В репозитории есть два набора автопроверок для технической архитектуры (TA) в ArchTool (DocHub):

1) **Completeness Test** — проверяет связку `File → Lake → Dataset` и совместимость источников (SEAF2/SEAF1/Reverse).
2) **UI Smoke Test** — открывает страницы `/entities/.../list` и `/entities/.../card` и фиксирует сетевые/JS/PlantUML ошибки.

## Требования

- Python 3
- Node.js 16+
- Playwright (Chromium)
- Запущенный backend ArchTool: `http://127.0.0.1:8080`

---

## 1) Completeness Test

Запуск:
```powershell
python _metamodel_\seaf-company-ta\auto_tests\completeness_test\check_data_flow.py
```

Пример проверки одного ключа (быстро):
```powershell
python _metamodel_\seaf-company-ta\auto_tests\completeness_test\check_data_flow.py "network_components"
```

Интерпретация отчёта:
- `File` — объекты в YAML (SEAF2, папка `architecture/ta`)
- `Lake` — объекты в data-lake
- `S1` — legacy namespace (`seaf.ta.*`)
- `Rev` — reverse datasets (`reverse2seaf2.ds.ta.reverse.*`)
- `DS` — композитный датасет `seaf.company.ds.ta.*`
- `St`: `OK` / `DIFF` / `SYNC!`

---

## 2) UI Smoke Test

Путь: `_metamodel_\seaf-company-ta\auto_tests\ui_test\`

### Установка
```powershell
cd _metamodel_\seaf-company-ta\auto_tests\ui_test
npm install
npx playwright install chromium
```

### Генерация набора URL’ов

Тест строит список страниц из backend dataset’ов `seaf.company.ds.ta.*`:
- URL списка `/entities/<entity>/list`
- несколько карточек `/entities/<entity>/card?id=<id>` для SEAF2 + `seaf1.*` + `reverse.*`

```powershell
cd _metamodel_\seaf-company-ta\auto_tests\ui_test
python generate_test_urls.py
```

Настройки:
- `MAX_CARDS_PER_SOURCE` (env var) — сколько карточек брать на источник (по умолчанию `2`).

Артефакты для ручной проверки:
- `_metamodel_/seaf-company-ta/auto_tests/ui_test/urls.md`
- `_metamodel_/seaf-company-ta/auto_tests/ui_test/urls.csv`

### Запуск smoke

```powershell
cd _metamodel_\seaf-company-ta\auto_tests\ui_test
node run_ui_smoke_test.js
```

Фильтр по `name` (подстрока, можно несколько):
```powershell
node run_ui_smoke_test.js "services.network_segments"
node run_ui_smoke_test.js "services.networks" "services.network_segments" "components.networks"
node run_ui_smoke_test.js "services.networks,services.network_segments,components.networks"
```

Чтобы сохранять результаты в отдельные файлы и не перетирать `results.*`:
```powershell
node run_ui_smoke_test.js --out results.networking "services.networks" "services.network_segments" "components.networks"
```

### Результаты

Артефакты:
- По умолчанию: `_metamodel_/seaf-company-ta/auto_tests/ui_test/results.md` (таблица + статусы), `results.csv`, `results.json`
- С `--out <prefix>`: `_metamodel_/seaf-company-ta/auto_tests/ui_test/<prefix>.md`, `<prefix>.csv`, `<prefix>.json`

Статусы:
- `OK` — страница открылась и отрисовалась
- `WARN` — страница открылась, но есть ошибки (PlantUML / data-profile / console/page errors / маркеры)
- `FAIL` — страница не открылась или сломалась
