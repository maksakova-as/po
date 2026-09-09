# Визуализации, таблицы и виджеты SEAF

Документ описывает, как в Jupiter создаются представления ArchTool: таблицы (`type: table`), карточки (`mkr-grid`), деревья, summary и встраиваемые виджеты.

## 1. Базовая структура presentations
- Каждый домен держит презентации в `.../<domain>/presentations/*.yaml`.
- Корневая структура:
  ```yaml
  entities:
    seaf.company.app.systems:
      presentations:
        list:
          title: ...
          type: table
          origin: seaf.company.ds.app.systems
          source: >
            ( jq выражение )
  ```
- `origin` указывает датасеты, которые нужны в `source`. Это может быть строка или объект с алиасами.
- `source` — jq/Jsonata-скрипт, который возвращает данные в формате, ожидаемом презентацией.

## 2. Таблицы (list)
Основной пример — `_metamodel_/seaf-company-base/app/systems/presentations/list.yaml`.

```yaml
headers:
  - value: id
    text: Идентификатор
    link: link
  - value: title
    text: Название
    align: left
origin: seaf.company.ds.app.systems
source: >
  (
  $.*@$val.{
      "id": $val.__id__,
      "link": "/entities/" & $val.__entity_id__ & "/card?id=" & $val.__id__,
      "title": $val.title,
      ...
  }[];
  )
```

Как использовать:
1. Определяем заголовки (`headers`) и соответствующие поля.
2. Подготавливаем ссылку на карточку (`/entities/<entity>/card?id=<id>`), чтобы клики работали.
3. Сортировку, фильтры и форматирование добавляем внутри jq (например, `$sort`, `$map`).

## 3. Карточки (card, summary)
Карточки строятся на типе `mkr-grid` и комбинируют виджеты. См. `_metamodel_/seaf-company-base/app/systems/presentations/card.yaml`.

```yaml
params:
  type: object
  properties:
    id: { type: string }
  required: [id]
type: mkr-grid
origin:
  objects: seaf.ds.objects
source: >
  (
  $obj := $lookup(objects, $params.id);
  $seaf_fn_combine_widgets($self, $obj.__entity_id__, $obj.__id__);
  )
```

Шаги:
1. Определяем входные параметры (обычно `id`).
2. Загружаем объект из `seaf.ds.objects` или витрин домена.
3. Вызываем `$seaf_fn_combine_widgets`, чтобы подключить карточку и связанные виджеты (описаны в `presentations/<section>.yaml`).
4. Дополнительные блоки (header, stakeholders, tree) описываем отдельными презентациями и подключаем через `combine_widgets`.

Summary и tree работают похожим образом (`type: table` / `type: tree`). Файлы можно подсмотреть в `_metamodel_/seaf-company-base/app/systems/presentations/summary.yaml` и `tree.yaml`.

## 4. Виджеты
Виджеты расширяют карточки других доменов. Пример из `_metamodel_/seaf-company-artefacts/ba/widgets/clients.yaml`:

```yaml
entities:
  seaf.company.ba.clients:
    presentations:
      card:
        widgets:
          artefacts:
            title: Упоминание объекта в артефактах
            presentation: artefacts
            align: "v"
            order: 2000
            style:
              margin: 4px
              padding: 0px
              border: true

      artefacts:
        params:
          type: object
          properties:
            id: { type: string }
          required: [id]
        type: table
        headers: [...]
        origin:
          linked_objects: seaf.company.ds.artefacts.by_changed_objects
        source: >
          (
          $data2present := $lookup(linked_objects, $params.id);
          $data2present#$i^(<change_finish_date).{ ... }
          )
```

Алгоритм добавления виджета:
1. В карточке определяем блок `widgets.<alias>` и указываем существующую презентацию (`presentation`), позиционирование (`align`, `order`, `style`).
2. Ниже создаём саму презентацию (часто `type: table`), задаём `params` (обычно `id`), `headers` и `source`.
3. Если требуется внешний датасет, добавляем его в `origin`. В примере используется коллекция `seaf.company.ds.artefacts.by_changed_objects`.

## 5. Виджеты TA и PlantUML
- Карточки TA теперь реальны: `seaf.ta.components.servers/presentations/server.yaml` использует `type: mkr-grid` и три виджета — таблицу характеристик, диаграмму размещения (`server_location_topology`) и диаграмму сетевых связей (`server_network_topology`).
- Каждый виджет — отдельная презентация с `params.id`, поэтому ArchTool автоматически пробрасывает идентификатор сервера в Jsonata-скрипты.

**Известные проблемы**
- Следите за синтаксисом Jsonata в server-mode: внутри функций нельзя ставить `;` и важно обрабатывать массивы/оба варианта `object/array` в датасетах (используйте `$lookup` + `~> $filter` и компактные вспомогательные функции).
- Таблицы инфраструктуры для compute/k8s исправлены: сбор строк идёт из `seaf.ds.objects`, для списков используется `to_list`, а для поиска объектов — `$lookup(objects, $id)`.

### 4.1 Карточка K8s (виджеты)
- `k8s_networks`: дата-сет `seaf.company.ds.ta.networks` + `...network_segments`, формирует роль (управляющая/прикладная) и ссылки на сегменты.
- `k8s_nodes`: использует агрегирующий датасет `seaf.company.ds.ta.k8s_cluster_objects` (см. Docs/datasets.md), в `source` только фильтр по `cluster`.
	- **`k8s_infra`**: собирает backup/monitoring/security для кластера напрямую из `seaf.ds.objects`:
	  - `to_list` нормализует атрибут в массив.
	  - `$lookup(objects, $id)` ищет любые объекты (backup/monitoring/kb).
	  - Ряды объединяются и фильтруются через `$filter($exists($v.title))`.
	Такой подход устойчив к формату датасета (array/object) и не требует промежуточных присваиваний.

### 4.2 Карточка кластеров виртуализации
- `cluster_virtualization_infra`: использует агрегирующий датасет `seaf.company.ds.ta.cluster_virtualization_infra_objects` (см. Docs/datasets.md) и просто фильтрует по `cluster`.
- Сети остаются прежними: `cluster_virtualization_networks` читает `seaf.company.ds.ta.networks`. Блоки по серверам разделены на два виджета:
  - `cluster_virtualization_cluster_servers` берёт сырые серверы из `seaf.ds.objects_by_entities` и отфильтровывает тех, у кого в `is_part_of_cluster_virtualization` присутствует ID кластера (физические узлы/GPU и т.п.).
  - `cluster_virtualization_guest_servers` работает с тем же источником, но отбирает объекты по полю `virtualization` (гостевые ВМ и другие нагрузки, размещённые на кластере).
  Такое деление облегчает навигацию: в карточке видно, какие сервера формируют сам кластер, а какие крутятся внутри него.

### 5.1 Карточка сервера
```yaml
card:
  type: mkr-grid
  widgets:
    details:
      presentation: server_card_details
    location_topology:
      presentation: server_location_topology
```
- `server_card_details` сохраняет прежнюю таблицу атрибутов. Она читает датасеты серверов, локаций, кластеров и вычислительных сервисов и возвращает строки вида `{"field": "...", "value": "...", "link": "..."}`.
- В таблице и карточке показываются сети из `subnets`: список подсетей подтягивается через `seaf.company.ds.ta.networks`, а строке «Сеть» в карточке присваивается ссылка на карточку соответствующей сети.

### 5.2 Где расположен сервер
- `type: plantuml`. Jsonata возвращает готовую строку `@startuml ... @enduml`.
- Источники: `seaf.company.ds.ta.servers`, `...dc_regions`, `...dc_azs`, `...dcs`, `...dc_offices`.
- Берём только первую локацию из `server.location` (или первую зону доступности) и строим цепочку регион → AZ → ЦОД/офис → сервер. Лишние уровни опускаем автоматически.
- Если нет данных о локации, показываем note «Нет данных о расположении», чтобы карточка оставалась стабильной.

- PlantUML формируется в Jsonata: массив строк собирается функцией `$join("\n")`, за счёт чего можно динамически управлять skin параметрами и блоками без шаблонов.
- Когда добавляются новые поля (например, подключения к storage), можно описывать дополнительные виджеты тем же образом — достаточно создать презентацию и подключить её в `card.widgets`.
#### Цветовая схема и шаблон
- Чтобы DocPlantUML правильно применил оформление, карточка использует шаблон `widgets/templates/server_location.puml`, которому Jsonata отдаёт объект `{"diagram": "@startuml..."}`. Это копирует подход прикладного слоя (`app/systems/presentations/tree.yaml`), где PlantUML-презентации всегда работают через шаблон.
- В Jsonata-выражении запрещено использовать `$not` и `$type` — в встроенном рантайме DocHub они отсутствуют. Вместо этого вводим флаги `$no_dc`, `$no_office`, `$no_az` (сравнение с `false`) и проверку массивов через `$exists($array[0])`.
- Цвета подложки и стрелок задаются `skinparam backgroundColor #ffffff`, `skinparam rectangle/node {...}` и `skinparam arrowColor`/`arrowFontColor`. При необходимости достаточно обновить эти блоки в `widgets/server.yaml`, чтобы все карточки получили новую схему.

### 5.3 Сетевые подключения сервера
- В карточке добавлен третий виджет `server_network_topology`, который также использует шаблон `widgets/templates/server_location.puml`, но строит диаграмму `Сервер → Сети → Сегменты → ЦОД/офис`.
- Источники: `seaf.company.ds.ta.servers`, `...networks`, `...network_segments`, `...dcs`, `...dc_offices`. Jsonata тянет сети из `server.subnets`, lookup-ит сегмент `network.segment[0]` и определяет локацию через `network.location[0]` или `segment.location`.
- Чтобы повторно использовать стиль, в Jsonata собрана та же шапка `@startuml` со светлой схемой (`backgroundColor #fff`, голубые границы, отключённый shadowing). Результат передаём в шаблон как `{diagram: "..."}`.
- При построении диаграммы нужно убирать дубли: строки с описанием узлов и связей прогоняем через `$distinct`, а идентификаторы узлов очищаем функцией `$replace(<id>, "[^A-Za-z0-9_]", "_")`, чтобы PlantUML принимал их. При отсутствии сетей карточка показывает заметку «Нет данных о сетевых подключениях`.
- Подписи всех узлов (сетей, сегментов, ЦОДов, регионов/AZ/офисов) формируются в формате `Название [[/entities/...]]`, поэтому в готовой диаграмме клики ведут прямо на карточки объектов — это тот же приём, что используется в `app/systems/presentations/tree.yaml`.

### 5.4 План расширения визуализаций TA
1. **Приоритетные сущности**: сервер (шлактическая/дисковая топология), `storage`/`hw_storage`, кластеры/compute services, `network`/`network_segment`, `k8s`/`k8s_nodes`, monitoring/backup/security.
2. **Данные**: убедиться, что нужные связь (`subnets`, `storage`, `is_part_of_cluster`, `k8s_nodes`, `network_links` и т.д.) реально заполнены; при необходимости пополнить `datasets`.
3. **Шаблоны**: переиспользовать `server_location.puml` или добавить новые (`network_flow.puml`, `cluster_map.puml`) с кликабельными подписи.
4. **Jsonata**: писать выражения с fallback (note при отсутствии), `~> $distinct` и очисткой идентификаторов `$replace`, добавлять ссылки `[[/entities/...]]`.
5. **Документация**: каждую новую схему описывать в этом файле (источник данных, параметры, шаблон, назначение).
6. **Этапность**: начать с серверов/кластеров (максимальный эффект), затем двигаться к сетям и Kubernetes, после чего — к monitoring/backup/security.

### 5.5 Практика для новых PlantUML-виджетов (TA)
- Для цепочек «родитель → дети» (AZ/ЦОД, Офис/Регион, Сегмент/Сети) используйте кликабельный синтаксис `node "Название [[/entities/...]]" as node_id`, чтобы текст не содержал служебных пометок.
- В среде DocHub отсутствуют функции `$not` и `$type` в некоторых версиях Jsonata: вместо них используйте сравнения (`$flag = false`) и `$exists($array[0])`. Пример: в `hw_storage_location_topology` проверка отсутствия ЦОДа записана как `($has_dc = false)`, а массив рёбер собирается через список + `$join("")`, чтобы избежать парсинговых ошибок.
- Источники (`origin`) должны соответствовать используемым переменным в выражении (например, при `objects_by_entities` доступен `objects`, при строковом `origin: seaf.ds.objects` — корневой `$`).
- Для связей с массивами допускайте обе формы значений (`string` или `array`) в атрибутах типа `availabilityzone`/`segment`: проверяйте `$type(...)` и применяйте `in` для массивов.
- Если нужно многократное использование шапки стиля, вынесите её в отдельный шаблон (как `widgets/templates/server_location.puml`) и пробрасывайте в PlantUML `{diagram: ...}`.

## 5. Markdown-шаблоны и визуальные документы
- Шаблоны лежат в `presentations/templates/*.md`. Например, `_metamodel_/seaf-company-artefacts/artefacts/presentations/templates/main.md`.
- Привязка к шаблону делается в YAML артефакта (`template: ka_doc_2025_03.md`).
- При генерации ArchTool подставляет данные в плейсхолдеры (`{{title}}`, `{{description}}`). Поэтому внутри шаблонов используем минимальное форматирование и явно описываем секции.

## 6. Чеклист при добавлении визуализации
1. Создайте или обновите `datasets` для новых представлений (иначе `origin` нечего будет читать).
2. Определите presentation в нужном файле, пропишите `title`, `type`, `headers`/`params`.
3. Прогоните jq-выражение через `dochub playground` или локальный `jq`/`yq`, чтобы убедиться, что структура корректна.
4. Если нужно встроить виджет в карточку другого домена, обновите соответствующий файл в `widgets/`.
5. Обновите документацию (`codestyle.md` / `visualizations.md`), если вводите новое соглашение.
