# SEAF2: краткое устройство для ИИ-агента

## 1) Что такое SEAF2
SEAF2 — это среда для описания архитектуры (TA) и публикации данных через набор метамоделей, датасетов и документов (docs). Основной цикл: данные → датасеты (JSONata) → сущности/представления → документы/таблицы/схемы в UI.

## 2) Главные каталоги в репозитории
- `architecture/` — пользовательские данные (домены, архитектурные сущности, reverse-импорт и т.п.).
- `_metamodel_/seaf-company-ta/` — метамодель технической архитектуры (TA): сущности, датасеты, меню, документы, конфиги.
- `_metamodel_/seaf-company-ta/internal_docs/` — внутренние заметки/планы/операционные инструкции.

## 3) Источники данных (data_sources)
SEAF2 поддерживает несколько источников, управляемых через `_metamodel_/seaf-company-ta/configs.yaml`:
- `seaf2` — «нативные» данные SEAF2 (company.ta.*).
- `seaf1` — наследованные данные (seaf.ta.*).
- `reverse` — данные обратной инженерии (reverse2seaf2.* и vmware on-prem).

`data_sources.enabled` управляет включением источников, а `data_sources.priority` — приоритетом мержа.

## 4) Конфиги
- `_metamodel_/seaf-company-ta/configs.yaml` — флаги включения источников и порядок мержа.
- Конфиги доступны в JSONata как `$"seaf.configs"."seaf.company.ta"`.

## 5) Датасеты
### 5.1 Где находятся
- `_metamodel_/seaf-company-ta/ta/datasets.yaml` — основные датасеты, которые создают «боевые» сущности.
- `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/` — модульные датасеты reverse (advanced, vmware onprem, схемы и т.д.).
- `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/root.yaml` — корневой импорт reverse-датасетов.

### 5.2 Как работают
- Датасеты описаны на JSONata и могут использовать `$eval` для вызова других датасетов.
- В контексте JSONata доступны:
  - `data_lake` — всё содержимое озера данных,
  - `datasets` — реестр датасетов (их `source`).
- Мерж данных делается через `$merge` в зависимости от `data_sources.enabled/priority`.

## 6) Документы (docs) и меню
- `_metamodel_/seaf-company-ta/_extensions/ta_docs/` — документные расширения TA (R41 + editable tables).
- `_metamodel_/seaf-company-ta/menu/` — меню, управляющее видимостью пунктов.
- Меню может скрывать пункты, проверяя `data_sources.enabled` (через `visible`/JSONata).

## 7) Озеро данных (data lake)
- Формируется из `architecture/domains.yaml` и подключённых источников.
- Важно: без включения доменов/источников в `architecture/domains.yaml` данные не попадают в систему.

## 8) Проверка и отладка
### 8.1 Проверка датасетов (backend)
- Проверять через HTTP:
  - `http://127.0.0.1:8080/core/storage/jsonata/<dataset_id>`
- Это первичная проверка корректности JSONata.

### 8.2 Проверка UI
- Таблицы и карточки:
  - `/entities/<entity_id>/list`
  - `/entities/<entity_id>/card?id=<object_id>`
- Документы:
  - `/entities/docs/blank?dh-doc-id=<doc_id>`

### 8.3 Логи
- Логи backend: `C:\Users\aaksi\Documents\SEAF2-PROD\.seaf_log`.
- Ошибки по JSONata обычно фиксируются как `manifest-cache` или `datasets-calculate`.

## 9) Жизненный цикл изменений (обязательная последовательность)
1. Проверка запросов/датасетов в backend (curl/jsonata).
2. Правки файлов.
3. Перезапуск контейнера (docker restart).
4. Проверка датасетов в backend.
5. Запуск автотестов датасетов.
6. Проверка UI (таблицы/карточки/документы).
7. Финальный прогон через web (если предписан в ops manual).

## 10) Типовые проблемы
- Пустые результаты: источник данных не включён в `architecture/domains.yaml` или `data_sources.enabled`.
- “Not a diagram file”: doc ссылается на dataset, который не возвращает корректную структуру.
- Дубликаты: отсутствие дедупликации по `external_id/legacy_id/source_key`.

---
Если нужно дополнить (например, схемы r41/seaf1/reverse, правила дедупликации, формат reverse-датасетов), добавь отдельный раздел.

