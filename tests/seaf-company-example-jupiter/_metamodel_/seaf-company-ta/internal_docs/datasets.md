# Datasets в репозитории Jupiter

## 1. Назначение
Datasets (`datasets.yaml`) — это витрины данных, которые берут объекты из озера (`seaf.ds.objects`, `seaf.ds.objects_by_entities` и т.д.) и подготавливают их для презентаций/виджетов. В Jupiter каждый домен (BA, APP, DA, AI, TA и т.д.) содержит собственные `datasets.yaml`, чтобы таблицы и карточки могли обращаться к упорядоченным структурам.

## 2. Основные паттерны

### 2.1 Прямой экспорт сущностей
Используется для типовых списков. Пример из `_metamodel_/seaf-company-base/app/systems/datasets.yaml`:
```yaml
datasets:
  seaf.company.ds.app.systems:
    description: |
      Коллекция прикладных систем компании
    origin: seaf.ds.objects_by_entities
    source: >
      (
        $."seaf.company.app.systems"
      )
```
- `origin` указывает базовое озеро (в данном случае `objects_by_entities`).
- `source` возвращает доступные сущности `seaf.company.app.systems`.

### 2.2 Расширение данными из других витрин
Некоторые витрины тянут дополнительные данные. Пример из `_metamodel_/seaf-company-base/_shared/services/presentations/list.yaml`:
```yaml
origin: seaf.company.ds.services
source: >
  (
    $.*@$val.{
      "id": $val.__id__,
      "link": "/entities/" & $val.__entity_id__ & "/card?id=" & $val.__id__,
      "title": $val.title,
      "lifecycle_stage": $val.lifecycle_stage,
      "description": $val.description
    }[];
  )
```
- Витрина `seaf.company.ds.services` описана в `_shared/services/datasets.yaml`.  
- Презентация разворачивает коллекцию в таблицу, добавляя ссылки.

### 2.3 Трансформация и Lookup
Иногда нужно подтянуть заголовки связанных сущностей. Пример из `_metamodel_/seaf-company-da/da/logical_entities/presentations/list.yaml`:
```yaml
origin:
  objects: seaf.company.ds.da.logical_entities
  all_objects: seaf.ds.objects
source: >
  (
    $objects := objects;
    $all_objects := all_objects;
    $each($objects, function($val, $key){(
      $agg := $seaf_fn_get_object_info($val.aggregat, $all_objects);
      {
        "id": $val.__id__,
        "object_link": "/entities/" & $val.__entity_id__ & "/card?id=" & $val.__id__,
        "title": $val.title,
        "category": $val.category ~> $join(", "),
        "aggregat": $agg.title,
        "aggregat_link": $agg.link_to_card
      }
    )})[];
  )
```
- Используется функция `$seaf_fn_get_object_info` для получения заголовка агрегата.

## 3. Практические советы

1. **Выбор `origin`**  
   - `seaf.ds.objects` — когда нужны “сырые” объекты и требуется сложная трансформация.  
   - `seaf.ds.objects_by_entities` — если нужна быстро разворачиваемая коллекция по сущности.  
   - Собственные витрины (например, `seaf.company.ds.app.systems`) — удобны для переиспользования в нескольких презентациях.

2. **Имена витрин**  
   - Придерживайтесь `seaf.company.ds.<domain>.<name>`.
   - В `presentations` ссылайтесь на эти имена, чтобы не дублировать бизнес-логику.

3. **Использование функций**  
   - Функции из `_metamodel_/seaf-common/common/functions/utils.yaml` (например, `$seaf_fn_get_object_info`) помогают строить ссылки/названия.

4. **Отладка**  
   - Используйте Dochub playground или jsonata-cli с собранным `build/output.json`, чтобы видеть результат выражений до интеграции в UI.

## 4. Пример для TA (Jupiter)
В `seaf-company-example-jupiter/_metamodel_/seaf-company-ta/ta/datasets.yaml` описаны витрины для регионов и AZ:
```yaml
datasets:
  seaf.company.ds.ta.dc_regions:
    origin: seaf.ds.objects
    source: >
      (
        $."seaf.ta.services.dc_regions"
      )

  seaf.company.ds.ta.dc_azs:
    origin:
      objects: seaf.ds.objects
    source: >
      (
        objects."seaf.ta.services.dc_azs"
      )

  seaf.company.ds.ta.dcs:
    origin:
      objects: seaf.ds.objects
    source: >
      (
        objects."seaf.ta.services.dcs"
      )
```
Они далее используются в `presentations/dc_region.yaml` и `presentations/dc_az.yaml`, где список разворачивается в таблицу, а карточки тянут заголовки/ссылки через `lookup`.

## 5. Checklist при добавлении нового `datasets.yaml`
1. Определить источник (`seaf.ds.objects` / `objects_by_entities` / другая витрина).  
2. Добавить описание `description`.  
3. Убедиться, что `source` возвращает объект или массив, понятный презентациям.  
4. **Императив**: на каждую новую сущность обязательно заводится отдельная витрина, и все таблицы/карточки/виджеты работают только через неё (не обращаются напрямую к `seaf.ds.objects`).  
5. Если атрибут в схеме — ссылка (`$ref` на другую сущность), таблицы и карточки обязаны выводить кликабельные значения (`link` или `link_to_card`), а не просто текст. Пример:  
   ```yaml
    {
      "field": "Зона доступности",
      "value": $lookup($az, $obj.availabilityzone).title,
      "link": "/entities/seaf.ta.services.dc_azs/card?id=" & $obj.availabilityzone
    }
   ```
   — так в карточке ЦОДа значение ведёт в карточку зоны.  
6. Обновить презентации/виджеты, чтобы использовать новую витрину.  
7. Запустить стандартную команду проверки/сборки репозитория (ту же, что команда использует перед публикацией) и убедиться, что данные корректно отображаются в UI или playground.

## 6. Пример агрегирующего датасета для нескольких сущностей
Для карточки K8s кластера был добавлен датасет `seaf.company.ds.ta.k8s_cluster_objects`, который собирает ноды, namespace, deployments и HPA в один список с признаком кластера:
```yaml
origin:
  objects: seaf.ds.objects_by_entities
source: >
  (
    $nodes := objects."seaf.company.ta.components.k8s_nodes";
    $namespaces := objects."seaf.company.ta.components.k8s_namespaces";
    $deployments := objects."seaf.company.ta.services.k8s_deployments";
    $hpas := objects."seaf.company.ta.components.k8s_hpa";
    $first_id := function($v){
      (
        $type($v) = "array" ? $v : ($exists($v) ? [$v] : [])
      ).(
        $type($) = "object"
          ? ($exists($.id) ? $.id : ($exists($.__id__) ? $.__id__ : $))
          : $
      )[0]
    };
    [
      $nodes.*.{ "cluster": $first_id(cluster), "title": title, "link": "/entities/" & __entity_id__ & "/card?id=" & __id__, "type": "Node" },
      $namespaces.*.{ "cluster": $first_id(cluster), "title": title, "link": "/entities/" & __entity_id__ & "/card?id=" & __id__, "type": "Namespace" },
      $deployments.*.{ "cluster": $first_id(cluster), "title": title, "link": "/entities/" & __entity_id__ & "/card?id=" & __id__, "type": "Deployment" },
      $hpas.*.{ "cluster": $first_id(cluster), "title": title, "link": "/entities/" & __entity_id__ & "/card?id=" & __id__, "type": "HPA" }
    ][]
  )
	```
	Датасет удобно использовать в карточке без дополнительной логики, фильтруя по `cluster`.

## 7. Похожий датасет для кластеров виртуализации
В карточке виртуализационных кластеров используется `seaf.company.ds.ta.cluster_virtualization_infra_objects`: он собирает storage/backup/monitoring/policy и сразу связывает строки с кластером. В `source` кешируется набор виртуализаций и по каждому строит строки вида `{"cluster": "...", "title": "...", "link": "...", "type": "Backup/Monitoring/Security"}`; затем фильтруются только валидные записи.
