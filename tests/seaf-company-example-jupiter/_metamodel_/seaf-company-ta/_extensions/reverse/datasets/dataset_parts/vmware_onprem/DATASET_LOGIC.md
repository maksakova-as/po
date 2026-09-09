# Логика датасетов reverse VMware On‑Prem

## Где находится исходный слой
- Реверс VMware импортируется в data-lake через файлы в `architecture/.../_reverse/*` (или аналогичные по проекту).
- Ключевые сущности data-lake:
  - `seaf.ta.components.server` (VM),
  - `seaf.ta.reverse.vmwareonprem.hosts` (ESXi),
  - `seaf.ta.reverse.vmwareonprem.vdcs` (VDC),
  - `seaf.ta.reverse.vmwareonprem.networks`, `dvportgroups`, `dvswitches` и др.
- Общая конфигурация реверса: `seaf.ta.reverse.general` (например в `architecture/.../ka.yaml`).

## Как устроены конвертеры
- Файлы в этой папке (`vmware_onprem/*.yaml`) содержат dataset'ы `reverse2seaf2.ds.ta.reverse.vmware.*`.
- Их задача: превратить реверс‑сущности в формат SEAF2 (`seaf.company.ds.ta.*`).
- Примеры:
  - `vmware_servers.yaml` → серверы (VM + ESXi)
  - `vmware_networks.yaml` → сети
  - `vmware_cluster_virtualizations.yaml` → кластеры виртуализации
  - `vmware_network_components.yaml` → сетевые компоненты

## Нормализация идентификаторов
- Идентификаторы приводятся к формату `reverse.<entity>...` с `normalize()`:
  - lowercase, замена не‑[a‑z0‑9-] на точки, чистка двойных точек.
- Для VDC используется `normalize_vdc()` → замена `vdc.` на `vdcs.`.

## Привязка к ЦОД
- VDC → DC строится через `seaf.ta.reverse.vmwareonprem.vdcs`.
- `vdc.dc` нормализуется и мапится к `seaf1.<dc_id>`.
- Итоговое поле `location` у серверов и сетей заполняется ссылкой на DC.

## Связи и поля серверов
- VM из `seaf.ta.components.server` + ESXi из `seaf.ta.reverse.vmwareonprem.hosts` объединяются в `seaf.company.ds.ta.servers`.
- В `vmware_servers.yaml`:
  - `virtualization` → кластер виртуализации (на основе VDC)
  - `subnets` → сети VM по portgroup / dvportgroup
  - `is_part_of` → связь с тех. сервисами КА ДЗО (через теги)

## Маппинг тех. сервисов (VM → КА ДЗО)
- Теги берутся из `reverse.tags` или `tags` VM.
- Список релевантных тегов определяется в `seaf.ta.reverse.general.config.entities.<org>.vmwareonprem.tags.tech_params`.
- Значения тегов конвертируются в ссылки на `kadzo.*`:
  - мониторинг/логирование → `kadzo.monitoring.<id>`
  - backup → `kadzo.backup.<id>`
  - прочее (включая HA) → `kadzo.compute.<id>`

## Где контролировать включение
- В `_metamodel_/seaf-company-ta/configs.yaml`:
  - `data_sources.enabled` включает/выключает `reverse`
  - `data_sources.priority` задаёт приоритет merge

## Практика проверки
- Backend:
  - `/core/storage/release-data-profile/%2Fdatasets%2Fseaf.company.ds.ta.servers`
  - `/core/storage/release-data-profile/%2Fdatasets%2Fseaf.company.ds.ta.networks`
  - `/core/storage/release-data-profile/%2Fdatasets%2Fseaf.company.ds.ta.cluster_virtualizations`
- UI:
  - карточка сервера (links/is_part_of)
  - карточка кластера виртуализации

---

# Частые проблемы
- Пустой `is_part_of`: обычно не читается `seaf.ta.reverse.general` или теги не совпадают с `tech_params`.
- Некорректные сети: проверь `dvportgroup` ↔ `network` mapping.
- Ошибки «Not a diagram file»: повреждённый dataset/профиль, либо конфликт данных.

---

# Нерешённая проблема (актуально на 2026‑02‑05)

## Симптом
- У VM `reverse.server.vmwareonprem.dochka.gora.server.vm-8334` поле `is_part_of` остаётся пустым,
  хотя в `reverse.tags` есть `dochka.tech_params-01: dochka.tech_services.sys_id_34_Zabbix`.
- В debug‑метриках сервера видно:
  - `tag_map_value_01` = `dochka.tech_services.sys_id_34_Zabbix` (тег читается)
  - `tech_values_count = 0`, `resolved_services_count = 0`
  - `kadzo_services_present = true`, `kadzo_services_has_34 = true`

## Почему это важно
- `is_part_of` используется в карточке сервера для отображения «Технического сервиса».
- Без `is_part_of` в UI не будет ссылок на техсервисы КА ДЗО.

## Где смотреть
- Конвертер: `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/vmware_onprem/vmware_servers.yaml`
- Исходные теги: `architecture/.../_reverse/vc1/vms_datacenter-3.yaml`
- Конфиг тегов: `architecture/.../_reverse/ka.yaml` (`seaf.ta.reverse.general`)
- КА ДЗО: `architecture/.../repo_-expert/KA/v2023/technical/tech_services.yaml`

## Что нужно сделать дальше (пошагово)
1) **Проверить вычисление `tech_values`**  
   Сейчас `tech_values_count = 0`, хотя `tag_map_value_01` корректный.  
   Надо проверить, почему `tech_values` не извлекается из `tag_map`:
   - сравнить `$tag_map."dochka.tech_params-01"` и `$lookup($tag_map, "dochka.tech_params-01")`
   - проверить, как формируются `tech_tags` (должны содержать `dochka.tech_params-01` и т.д.)

2) **Упростить извлечение `tech_values`**  
   Если доступ по ключу в JSONata нестабилен, временно собрать вручную:
   - `[$tag_map."dochka.tech_params-01", $tag_map."dochka.tech_params-02", ...]`
   - затем отфильтровать пустые и пробельные значения

3) **Проверить `resolved_services`**  
   После восстановления `tech_values` убедиться, что:
   - `resolve_kadzo_service("dochka.tech_services.sys_id_34_Zabbix")`
     → `kadzo.monitoring.dochka.tech_services.sys_id_34_Zabbix`

4) **Проверить итоговый `is_part_of`**  
   Перезапустить контейнер и проверить:
   - `/core/storage/release-data-profile/%2Fdatasets%2Fseaf.company.ds.ta.servers`
   - наличие `is_part_of = [\"kadzo.monitoring.dochka.tech_services.sys_id_34_Zabbix\"]`

5) **Проверить UI**  
   В карточке сервера должна появиться строка «Технический сервис» со ссылкой.

## Примечания
- У VM встречаются **дубли ключа `tags`** (сначала `tags: []`, ниже `reverse.tags`).
  YAML оставляет только последний ключ. Нужно, чтобы активным был `reverse.tags`.
- `release-data-profile` может временно отдавать ошибки сразу после рестарта.
  Делать 1–2 повтора с паузой.

