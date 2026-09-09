# Code Style для метамоделей SEAF/Jupiter

## 1. Общие договорённости
- **Формат файлов** — YAML в UTF‑8, отступ 2 пробела. Табуляция и смешанные отступы запрещены.
- **Имена файлов** отражают содержание (`entities.yaml`, `datasets.yaml`, `presentations/list.yaml`). Для экспериментальных материалов используем суффиксы `_dev` или папку `__dev__`.
- **Порядок секций** в YAML: комментарии → корневой ключ (`entities`, `datasets`, `functions`, `imports`) → дочерние блоки. Внутри объекта придерживаемся очередности: `title`, `description`, `type`, далее свойства.
- **Докстроки** формулируем в императиве («Опишите», «Укажите»), избегаем повторов. Для многострочных описаний используем блочный литерал `|`.

## 2. JSON Schema / YAML-схемы

### 2.1 Каркас сущности
Каждый файл `entities.yaml` начинается с:
```yaml
entities:
  seaf.company.domain.entity_id:
    title: &entity_title ...
    description: &entity_description ...
    schema:
      title: *entity_title
      description: *entity_description
      $defs: {}
      patternProperties:
        "^([a-zA-Z0-9_-]+)(\\.[a-zA-Z0-9_-]+)+$":
          title: *entity_title
          description: *entity_description
          type: object
          allOf: []
      properties: {}
```
- `title` — лаконичное имя сущности, `description` — зачем используется.
- Используем YAML-якоря (`&entity_title` / `*entity_title`), чтобы не дублировать название и описание в `schema`.
- `patternProperties` задаём регулярным выражением `^([a-zA-Z0-9_-]+)(\.[a-zA-Z0-9_-]+)+$` — оно едино для всех сущностей, чтобы ID имел вид `company.domain.object`.
- `schema` описывает JSONSchema для хранения данных. Всегда включаем `$defs`, даже если он пуст — это упрощает расширения.
- Идентификаторы сущностей (`entities:`) всегда во множественном числе (`seaf.company.app.systems`), а объекты (`objects:`) — в единственном:
  ```yaml
  entities:
    seaf.company.app.systems:
      ...
      objects:
        system:
          route: "/"
          title: Система
          symbol: system
  ```
  Тогда ссылки оформляем как `"#/$rels/seaf.company.app.systems.system"`.

### 2.2 Использование `$defs` и `$ref`
- Базовые наборы атрибутов выносим в `$defs` с пространством имён `seaf.company.def.*` или `seaf.def.*`. Например, `seaf.company.def.ai.basic_attributes` в `_metamodel_/seaf-company-ai/ai/defs.yaml`.
- Повторно используемые блоки подключаем через `allOf` + `$ref`. Порядок записи: сначала общие блоки (наследование), затем локальные `properties`.
- Для ссылок на другие сущности применяем `$ref: "#/$rels/<entity_id>"`. Никогда не шьём «сырые» ключи — это ломает валидацию.
- Если нужно задать значение по умолчанию, описываем его рядом со свойством (`default:`) и не забываем перечислить возможные `enum`.

**Стиль именования $defs**
- Выносим в пространства `seaf.company.def.<domain>.<entity>`. Пример (см. `ba/channels/entities.yaml`):
  ```yaml
  $defs:
    seaf.company.def.ba.channel_common:
      type: object
      properties: ...
  ```
- Затем `patternProperties` используют `allOf` с этим `$defs`.

**Пример** (`_metamodel_/seaf-company-ai/ai/agents/entities.yaml`):

```yaml
attributes:
  title:
    $ref: "#/$defs/seaf.company.def.ai.basic_attributes/properties/title"
  lifecycle_stage:
    allOf:
      - $ref: "#/$defs/seaf.def.lifecycle_stage/properties/lifecycle_stage"
    default: "Используется"
  realized_in:
    $ref: "#/$defs/seaf.company.def.ai.realized_in/properties/realized_in"
```

Здесь:
- базовый `title` приходит из общего `$defs`;
- `lifecycle_stage` наследует справочник стадий и задаёт default;
- `realized_in` использует унифицированный формат ссылок на системы/агентов.

### 2.3 Порядок свойств
Внутри каждого свойства придерживаемся последовательности:
1. `title`
2. `description`
3. `type` / `anyOf` / `enum`
4. Ссылки (`$ref`)
5. Ограничения (`minLength`, `pattern`, `items`, `properties`)
6. `default`

`required` перечисляем отдельным массивом после `properties`. Если атрибут входит в несколько наборов, `required` храним в соответствующем `$defs`.

### 2.4 patternProperties
- Используем, когда ключи объектов кодируют смысл (`^([a-z0-9_]+\\.)+(adr)\\..+$`). Регулярные выражения документируем комментариями и примерами.
- Каждый `patternProperties` оформляем как полноценную сущность: `title`, `description`, `type`. Далее включаем общее наследование (`allOf`) и локальные атрибуты.
- Если нужно полностью ограничить структуру, включаем `additionalProperties: false` (или `unevaluatedProperties` при наличии поддержки).

**Пример** (`_metamodel_/seaf-company-artefacts/artefacts/art_adr.yaml`):

```yaml
patternProperties:
  "^([a-zA-Z0-9_-]+\\.)+(adr)(\\.[a-zA-Z0-9_-]+)+$":
    title: "ADR"
    description: >
      Артефакт Architecture decision record ...
    type: object
    allOf:
      - $ref: "#/$defs/seaf.company.def.artefact_basic_attributes"
      - $ref: "#/$defs/seaf.company.def.artefact_stakeholders"
    properties:
      type:
        title: Тип
        enum:
          - Обоснование архитектурного решения (ADR)
        default: Обоснование архитектурного решения (ADR)
```

Регулярка комментируется рядом, наследуем общие блоки через `allOf`, далее задаём доменный атрибут `type`.

### 2.5 Объекты и массивы
- Для массивов всегда задаём `items` и уточняем тип (`type: object`). Если допустимы ссылки, добавляем `$ref` прямо внутри `items`.
- Для объектов со свободными атрибутами используем `additionalProperties: false`, чтобы явно белить список разрешённых свойств.
- Порядок в массиве `items` важен для однотипных объектов; при необходимости комментируем поля, чтобы читателю было понятно назначение.

### 2.6 Конфиги и менюшки
- `configs.yaml` описывает параметры визуализации. Структура: `entities:`, далее по доменам `seaf.company.<domain>.<section>`.
- В `menus.yaml` сперва объявляем функцию или сущность, затем задаём массив путей. Комбинируем с `seaf_fn_generate_menu_item`, чтобы поддерживать абсолютные и относительные пути.

**Пример конфигов** (`_metamodel_/seaf-company-base/app/systems/configs.yaml`):

```yaml
entities:
  seaf.company.app.systems:
    title: "Прикладные системы"
    root_menu: "APP/Системы"
    root_menu_order: 3
```

**Пример меню** (`_metamodel_/seaf-company-base/app/systems/menus.yaml`):

```yaml
menus:
  seaf.company.app.systems:
    title: "Системы"
    items:
      - "Список"
      - "Карточка"
      - "Дерево"
```

Абсолютные пути задаём через `/APP/...`, относительные собираются автоматически на базе `root_menu`.

**Корневое меню домена**
- В файле `configs.yaml` домена задаём отображение в главном меню ArchTool:
  ```yaml
  seaf.configs:
    seaf.company.ta:
      root_menu: "Техническая архитектура"
      root_menu_order: 5000
  ```
- `root_menu` — подпись раздела, `root_menu_order` управляет позицией (меньше значение → выше в списке). Принята сетка в 1000 пунктов: например, BA=2000, DA=3000, APP=4000, TA=5000, CYBERSEC=6000.

## 3. Работа с `$rels`
- Ссылки на объекты объявляем только после того, как соответствующая сущность импортирована (`imports` в `_root.yaml`). Нарушение порядка приведёт к ошибкам резолва.
- Для ссылок на другие метамодели используем их namespace (`seaf.company.ba.products.product`, `kadzo.v2023.channels`). Не изобретаем собственные id.
- Если сущность может ссылаться на несколько доменов, перечисляем все варианты в `anyOf` или `oneOf` и даём подсказку по выбору (см. `seaf.company.def.ai.business_usages`).

## 4. Структура каталогов
- Каждый домен имеет `_root.yaml`, который перечисляет `imports` в порядке: `configs`, `datasets`, `entities`, `menus`, `presentations`/`widgets`. Это облегчает навигацию и предсказуемо формирует UI.
- Презентации (`presentations/*.yaml`) хранятся отдельно для карточек, списков, summary, tree. Имена файлов отражают блок UI.
- Виджеты (`widgets/*.yaml`) располагаются в пакете, который расширяет другую сущность (например, артефакты → `ba/widgets/clients.yaml`).
- Папка `__dev__` предназначена для экспериментальных материалов. Никакие боевые импорты на неё не ссылаются.

## 5. Комментарии и документация
- Большие блоки сопровождаем комментариями `# ...` перед секцией, а не внутри объектов, чтобы не мешать диффам.
- Markdown‑шаблоны (`templates/*.md`) оформляем короткими заголовками, используем переменные ArchTool (`{{title}}`). Описываем все параметры в docstring файла.
- В README каждого пакета упоминаем: назначение пакета, зависимость от других модулей, способ подключения (`imports`).

## 6. Checklist перед коммитом
1. `yamllint` (или `python -c "import yaml"` с загрузкой файла) проходит без ошибок.
2. Валидация Dochub/SEAF (`dochub validate`) не выдаёт предупреждений.
3. Все новые `$ref` проверены: сущность существует и импортирована.
4. Меню и презентации обновлены синхронно с новыми сущностями.
5. Документация (`codex.md`, `codestyle.md`) отражает изменения, если они затрагивают общие правила.

## 7. Алгоритм добавления новой сущности
1. **Схема**: в соответствующем `entities.yaml` создаём новую запись внутри `entities`. Подключаем базовые `$defs`, описываем `patternProperties` или `objects` и задаём `required`.
2. **Datasets**: в `datasets.yaml` формируем витрины (`seaf.company.ds.<domain>.<section>`) для списков и выборок. Часто нужна пара коллекций: плоский список и представление по сущности.
3. **Configs**: обновляем `configs.yaml`, чтобы задать меню, сортировку и прочие параметры для новой сущности.
4. **Меню**: в `menus.yaml` добавляем пункт внутри `menus.<entity_id>.items`. При необходимости обновляем root menu.
5. **Presentations**: создаём минимум `list` и `card` в `presentations/*.yaml`; подключаем виджеты через `$seaf_fn_combine_widgets`.
6. **Widgets/Интеграции**: если сущность должна появиться в карточках других доменов, добавляем файлы в `widgets/`.
7. **Импорты**: в `_root.yaml` проверяем, что новые файлы подключены через `imports`.
8. **Архитектурные данные**: в каталоге `architecture/<domain>` заводим примеры объектов с соблюдением ID правил.

## 8. Правила именования идентификаторов
- Формат: `company.domain.object`, где:
  - `company` — идентификатор компании (для Jupiter: `jupiter`, `sber.rtcom.jupiter` и т.п. в зависимости от сегментов);
  - `domain` — сокращение домена (`app_system`, `srv`, `ai_agent`, `product`, `bt`, `adr`, `ka`, `pattern`);
  - `object` — локальный идентификатор (snake case или kebab case, без пробелов).
- Количество сегментов компании определяется конфигом `global.company_id_segments_number` (см. `seaf_fn_split_object_key`). Если компания многосоставная (`sber.rtcom.jupiter`), указываем число 3, чтобы функции правильно выделяли домен и объект.
- Для вложенных объектов используем `is_part_of` с родительским ID вместо дополнительного уровня в идентификаторе (пример: `jupiter.app_system.efs_news_editor` является частью `jupiter.app_system.efs`).
- IDs должны быть стабильными — никаких кириллиц, пробелов, спецсимволов. Только `[a-z0-9_-.]`.
- Для артефактов используем шаблон `<company>.<type>.<slug>` (`jupiter.adr.doc_01`, `jupiter.ka.doc_2025_03`, `jupiter.pattern.034`) в соответствии с `patternProperties`.
