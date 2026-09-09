# Codex: метамодель и архитектура компании «Jupiter»

## 1. Навигация по репозиторию
- `_metamodel_/` — подключенные пакеты SEAF2: общие базовые определения (`seaf-common`), отраслевые модули (base, da, ai, artefacts, kadzo, ta) и папка `_custom_` с доработками под Jupiter. Файл `packages.yaml` управляет порядком импорта пакетов и явно исключает устаревший `SEAF1`.
- `architecture/` — учебное описание ландшафта Jupiter, построенное на подключенной метамодели. Файл `domains.yaml` связывает домены (app, ba, da, ai и т.д.). Вложенные каталоги повторяют структуру пакетов, при этом `architecture/SEAF1` оставлен только для истории и полностью игнорируется.
- Корень содержит вспомогательные файлы (`README.md`, `repo.yaml`, `dochub.yaml`, лицензии). Для работы достаточно правок внутри двух каталогов выше.

## 2. Пакеты и файлы метамодели (`_metamodel_/`)

### 2.1 packages.yaml
Файл `_metamodel_/packages.yaml` задаёт очередь импорта пакетов. Сначала подключаются базовые библиотеки (`seaf-common`, `seaf-company-base`, `seaf-company-da`), далее — тематические расширения (`seaf-company-ai`, `seaf-company-artefacts`, `seaf-company-kadzo`), и только после этого загружается `_custom_`. Строки для технической архитектуры (`seaf-company-ta`) и MM Viewer из тулкита закомментированы: это подсказка, какие модули можно включить при необходимости.

### 2.2 seaf-common — обязательные определения
- `common/_root.yaml` агрегирует наборы: `configs.yaml` (глобальные конфигурации репозитория: структура ключей, количество сегментов в ID компании, секции `global` и `<domain.domain>`), `defs.yaml` (базовые атрибуты сущностей, этапы жизненного цикла, модель стейкхолдеров, shared-секции для reuse), `data_types.yaml` (JSONSchema-описание типов данных вроде стандартов дат), `datasets.yaml` (готовые jq-функции для получения коллекций объектов, ссылок, отчётов), `functions/_root.yaml` (утилиты, меню, деревья, виджеты). Здесь же расположен `dochub_patching/` — набор аспектов, компонентов, контекстов и docs для интеграции с Dochub.
- `functions/menus.yaml`, `functions/trees.yaml`, `functions/utils.yaml`, `functions/widgets.yaml` содержат jq-скрипты: построение меню по конфигам, генерацию деревьев сущностей, поиск информации об объекте, генерацию карточек.
- `__dev__/welcome.yaml` и `__dev__/test.yaml` дают минимальные шаблоны для обкатки функций, `issues.txt` фиксирует известные ограничения.
- Типовые инфраструктурные файлы (`README.md`, `LICENSE`, `COMMUNITY.md`, `dochub.yaml`, `.gitignore`) описывают назначение пакета и правила вклада.

### 2.3 seaf-company-base — корпоративные домены
Назначение: описать стандартные сущности бизнес-, приложенческой, изменений, кибербезопасности и данных.

- `package.yaml` фиксирует метаданные пакета и зависимости от dochub.
- `_shared/`:
  - `functions/` (entities, datasets, menus, presentations) — позволяет переиспользовать карточки функций, деревья и списки.
  - `services/` — аналогичный набор для ИТ‑сервисов, включая расширенные представления (`card.yaml`, `integration_params.yaml`, `sla.yaml`, `tree.yaml`).
  - `systems/defs.yaml` — общий словарь атрибутов систем и L2-компонентов.
  - `templates/` — markdown и PlantUML-шаблоны для описаний (header.md, summary.md, tree.puml).
  - `sys_components.yaml` — связь систем с компонентами.
- Доменные каталоги (`app/`, `ba/`, `change/`, `cybersec/`, `da/`) имеют одинаковую структуру:
  - `_root.yaml` подключает `configs.yaml`, `datasets.yaml`, `entities.yaml`, `menus.yaml` и `presentations/`.
  - `configs.yaml` объявляет параметры отображения (названия меню, сортировку и т.п.).
  - `entities.yaml` — основное JSONSchema-описание сущностей (например, `app/systems/entities.yaml` содержит атрибуты систем, компонентов и интеграций).
  - `datasets.yaml` описывает производные коллекции (фильтры, списки связей).
  - `menus.yaml` строит дерево навигации Dochub для конкретного домена.
  - `presentations/` содержит готовые карточки, списки, summary, stakeholders, tree и др., что формирует UI в ArchTool.
- `__dev__/` добавляет демонстрационные конфиги и встраиваемое приветствие (`welcome.yaml`) для быстрого старта.

### 2.4 seaf-company-da — архитектура данных
- `da/_root.yaml` импортирует пять подсекций: `aggregats`, `business_terms`, `logical_entities`, `logical_links`, `physical_tables` и их `presentations`.
- `da/*/entities.yaml` задают схемы для доменов данных: агрегации (иерархия доменов, owner, unit), бизнес-термины (гербары терминов), логические сущности/связи (структура атрибутов, флаги PDN/CDE), физические таблицы (разрез хранилища).
- В `presentations/` лежат карточки, списки и таблицы для каждого типа (например, `business_terms/presentations/list.yaml`).
- `da/configs.yaml` задаёт меню и опции отображения, `da/datasets.yaml` формирует витрины (все термины, связи по домену и т.д.).
- `_docs/da_description.md` — текстовое описание домена (подключается через `_docs/_root.yaml`).
- `_shared/templates/` хранит markdown-шаблоны для документации.

### 2.5 seaf-company-ai — слой ИИ
- `ai/_root.yaml` импортирует `configs.yaml`, `defs.yaml`, `agents/` и `models/`.
- `defs.yaml` расширяет базовые атрибуты: специфические поля для ИИ (capabilities, business_usages, realized_in, memory, guardrails, инструменты, стеки и т.д.), общие справочники (delivery_type, stakeholders, feedbacks).
- `agents/`:
  - `_root.yaml`, `datasets.yaml`, `entities.yaml`, `menus.yaml`.
  - `entities.yaml` описывает ИИ-агентов, шаги управления, память, инструменты, петли обратной связи, guardrails, ai_stack.
  - `presentations/` содержит карточку агента, списки capabilities, stakeholders, tools, memory, models и т.д. (файлы `ai_stack.yaml`, `business_usages.yaml`, `tools.yaml` и др.).
- `models/`:
  - `_root.yaml`, `datasets.yaml`, `entities.yaml`, `menus.yaml`.
  - `content.yaml` — каталог типовых моделей (линейка GigaChat, embeddings и др.) с vendor, delivery_type, hyperparameters, training_datasets.
  - `presentations/` формируют карточку модели, параметры, список стейкхолдеров, summary.
- `_shared` предоставляет общие виджеты/утилиты (папка отсутствует, т.к. всё в `defs.yaml`).

### 2.6 seaf-company-artefacts — архитектурные документы
- `artefacts/_root.yaml` тянет `artefacts.yaml` и специализированные настройки (`art_adr.yaml`, `art_ka.yaml`, `art_pattern.yaml`).
- `artefacts.yaml` задаёт общую сущность `seaf.company.artefacts` с базовыми атрибутами (статус, версия, авторы, ссылки, шаблоны, генерация меню/TOC). `art_*.yaml` добавляют patternProperties для ADR, KA и паттернов, чтобы отделить разные классы документов.
- `artefacts/presentations/`:
  - `_root.yaml` плюс `helpers.yaml` с наборами форматирующих функций.
  - `list.yaml` и `main.yaml` создают списки артефактов и основную карточку.
  - `templates/` содержит markdown-шаблоны (`main.md`, `doc_header.md`, `change_scope.md`, `changed_objects.md`, `ref_list.md`), которые используются при генерации документов.
- Доменные интеграции:
  - `app/widgets/`, `ba/widgets/`, `change/widgets/`, `cybersec/widgets/`, `da/widgets/`, `services/widgets/` — расширяют UI карточек соответствующих доменов, добавляя блоки с артефактами.
  - Каждый каталог имеет `_root.yaml` и набор файлов по сущностям (например, `da/widgets/logical_entities.yaml` формирует раздел «Артефакты» в карточке логической сущности).
- Прочее: `__dev__/welcome.yaml` и `README.md` с назначением пакета.

### 2.7 seaf-company-kadzo — экспорт в формат КАДЗО
- `kadzo/_root.yaml` подключает `configs.yaml`, `datasets.yaml`, `functions.yaml`, `transformations/_root.yaml`, `transformations_impl/`, `export/`.
- `functions.yaml` содержит jq-функции по конвертации деревьев SEAF в структуры КАДЗО и валидации данных.
- `transformations/entities.yaml` описывает промежуточные сущности КАДЗО (каналы, продукты, задачи, цели).
- `transformations_impl/*.yaml` реализуют конкретные правила трансформации для каналов, клиентов, целей, процессов, продуктов, стратегий, задач (каждый файл — набор jq-правил).
- `export/export.yaml` и `export/export_one_file.yaml` — два варианта выгрузки (по файлам и в один YAML). Jupiter использует версию «multi-file» плюс шаблон экспорта одного файла.
- `_shared` отсутствует — все зависимости подтягиваются через core пакеты.

### 2.8 seaf-company-ta — техническая архитектура
- `ta/components.yaml` определяет сущности технических компонентов (серверы, СХД, устройства, Kubernetes).
- `ta/services.yaml` — сущности технических сервисов (регионы, AZ, ЦОД, сети, мониторинг, кластеры, storage).
- `ta/environments.yaml` — окружения, стенды, привязка сервисов.
- README описывает методологию (технические компоненты, сервисы, шаблоны визуализации), а также структуру каталогов и порядок использования.

### 2.9 `_custom_` — расширения под Jupiter
- `package.yaml` объявляет пакет `jupiter_custom` и импортирует `*_root.yaml` всех локальных доменов. Здесь задаются vendor, версия, описание, список зависимостей (dochub).
- Каталоги `app/`, `ba/`, `cybersec/`, `da/`, `ta/`, `change/`, `artefacts/` содержат по `_root.yaml`, подключающие конкретные патчи/виджеты. Например, `da/patch.yaml` отключает стандартный doc `seaf.company.doc.da.description`.
- `_shared/export.yaml` — настройка объединённых выгрузок (необходима для одновременного экспорта artefacts/da/widgets).
- `mm_viewer/er_diagrams.yaml` и `mm_viewer/obj_diagrams.yaml` задают наборы диаграмм для MM Viewer: кастомные карты объектов SEAF, подсветку групп (бизнес, приложения, ИИ, TA, DA, CHANGE), правила раскраски связей.
- `__dev__/welcome.yaml` формирует приветственный баннер при подключении кастомных настроек.

## 3. Архитектурные данные (`architecture/`)

### 3.1 Общая шина
- `domains.yaml` импортирует все домены Jupiter (app, ba, da, ai, artefacts, change, cybersec, services, functions, kadzo). TA оставлен комментариями (данных пока нет).
- `functions/_root.yaml` и `functions/functions.yaml` описывают функциональные блоки (ведение и публикация новостей, доставка, личные кабинеты, антивирус, ЭЦП). Связи `is_part_of` формируют иерархию (например, `jupiter.function.ai_news_summary` — часть `jupiter.function.news_management`).
- `services/_root.yaml` и `services/services.yaml` описывают соответствующие ИТ‑сервисы: API публикации новостей, UI редактора, AI summary, доставка, антивирус. Каждый сервис заполняет атрибуты SLA, интеграции, RPO/RTO, связанные данные и спецификации.

### 3.2 Бизнес-архитектура (`ba/`)
- `_root.yaml` импортирует четыре файлы: `channels.yaml`, `clients.yaml`, `processes.yaml`, `products.yaml`.
- `clients.yaml` детализирует клиентские сегменты (физические лица, молодые люди, сотрудники, редакторы) с метриками MAU/DAU, связями с ИТ‑сервисами.
- `products.yaml` описывает продуктовую линейку (цифровой контент, новости, знания, маркетинговые товары, мерч) и связь с каналами/клиентами.
- `channels.yaml` перечисляет каналы (website, shopping centre, company office и т.д.), `processes.yaml` — ключевые процессы (например, knowledge_management).
- Все файлы используют ключи `jupiter.<domain>.<object>` и ссылаются на сервисы/функции из предыдущего раздела.

### 3.3 Приложения (`app/`)
- `_root.yaml` → `systems/_root.yaml`, далее:
  - `systems/systems.yaml` — основной каталог систем (MES Одежда, ECM Новости, TMS, TMS-подсистемы, 1C ERP). Каждая запись содержит класс, критичность, владельцев, RPO/RTO, реализуемые функции, интеграции с сервисами, параметры доступности, мониторинг.
  - `systems/aihub.yaml` — описание мультиагентной платформы и вложенного компонента deepseek.
  - `systems/efs.yaml` — фронт сотрудников (ЕФС) плюс связанные L2-компоненты (`seaf.company.sys_components` секция внизу файла).
  - `2del-intgr_contracts.yaml` иллюстрирует возможную модель интеграционных контрактов (API news publish, AI summary, доставка), хотя название подсказывает, что файл предназначен к удалению.

### 3.4 Архитектура данных (`da/`)
- `aggregats.yaml` формирует иерархию доменов данных (домен 1 → поддомены 1.1/1.2).
- `business_terms/bterms.yaml` — словарь бизнес-терминов (model, material, color, employee и т.д.) с владельцами, датами создания, статусами.
- `logical_layer/logical_entities.yaml` — логические сущности (модель изделия, цвет, размер, сотрудник, дизайнер, технолог) с атрибутами, ссылками на бизнес-термины, master-системы, агрегаты и флаги PDN/CDE.
- `logical_layer/logical_links.yaml` описывает отношения между сущностями (например, связи «модель содержит цвет»).
- `physical_layer/tables.yaml` хранит описание таблиц хранилища (имена, системы-владельцы, движки, атрибуты).
- `aggregats/_root.yaml`, `business_terms/_root.yaml`, `logical_layer/_root.yaml`, `physical_layer/_root.yaml` управляют импортом, `da/_root.yaml` связывает всё вместе.

### 3.5 ИИ-ландшафт (`ai/`)
- `_root.yaml` + `agents.yaml` и `models.yaml`.
- `agents.yaml` содержит два полноценных примера: `jupiter.ai_agent.assets_checker` (агент проверки активов) и `assets_checker_alt`. Указываются жизненный цикл, критичность, capabilities, business_usages (связь с каналами, процессами, продуктами), stakeholders, используемые модели, память, domain_knowledge, tools, control_flows, feedbacks и стек технологий. Агент привязан к инициативе `jupiter.activity.2025_aiagent1` и системам (`jupiter.app_system.aihub`).
- `models.yaml` описывает управляемые модели (например, `jupiter.ai_model.deepseek_general_llm`) с vendor, версиями, целями использования, типом доставки и размещением (`realized_in` на `aihub_model_ds1`).

### 3.6 Кибербезопасность (`cybersec/`)
- `systems.yaml` фиксирует защитные решения (антивирус Касперского, ЭЦП, их подсистемы), включая классы, размещение и связи с функциями/сервисами.

### 3.7 Управление изменениями (`change/`)
- `goals.yaml` определяет стратегические и технологические цели (охват рынка, цифровизация, миграция на Platform V).
- `activities.yaml` описывает инициативы и проекты (программа L2P и дочерние проекты по миграции, ИИ-инициатива). Каждая активность ссылается на цели через `realizes`, содержит статусы, плановые сроки, комментарии.

### 3.8 Артефакты (`artefacts/`)
- `adr/` — пример ADR (`adr_doc_01.yaml` + `adr_doc_01.md`) с шаблоном и заполненными атрибутами.
- `ka/` — две концептуальные архитектуры (`ka_doc_2025_03`, `ka_doc_2025_05`) со связанными drawio/png диаграммами и markdown-шаблонами. YAML-описание перечисляет артефакты, связанные изменения по доменам (ba, da, app, cybersec, ta), ссылки на активности и задачи.
- `patterns/` — архитектурный паттерн (файл `pattern_034.yaml`, markdown и изображение) с оглавлением, ссылками, статусом.

### 3.9 Kadzo экспорт (architecture/kadzo)
- Зеркалирует структуру пакета `seaf-company-kadzo`: `export.yaml` и `export_one_file.yaml` включают Jupiter-данные в готовом формате отчётности. Эти файлы можно подключить к пайплайну выгрузки без дополнительных настроек.

### 3.10 TA
- `ta/_root.yaml` пока содержит только TODO-комментарий о подключении `ta_services.yaml`. Данные технической архитектуры для Jupiter не заведены, но метамодель готова их принять.

## 4. Использование материала
1. Для расширения метамодели подключайте новые пакеты в `_metamodel_/packages.yaml`, соблюдая порядок (общие → доменные → кастомные).
2. При описании новых объектов ориентируйтесь на схемы `entities.yaml` соответствующих доменов и на примеры из `architecture/`.
3. Виджеты/презентации живут в `presentations/` и `widgets/`: правки там сразу меняют UI в ArchTool.
4. Для экспорта в КАДЗО используйте готовые сценарии `kadzo/export/*.yaml`.
5. Артефакты ведите через `architecture/artefacts/*`, используя шаблоны из `seaf-company-artefacts/artefacts/presentations/templates`.

