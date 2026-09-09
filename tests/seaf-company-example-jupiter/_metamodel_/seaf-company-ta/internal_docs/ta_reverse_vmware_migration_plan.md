# План миграции: VMware On-Prem Reverse → SEAF2 TA

Документ описывает, как перевести данные реверса VMware On-Prem (SEAF1) в сущности SEAF2, чтобы они отображались в таблицах и визуализациях домена TA.

## 1. Как устроены датасеты реверса (reverse2seaf2)

**Точка входа:**
- `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/root.yaml`
  - импортирует `dataset_parts/root.yaml`

**Сборка датасетов:**
- `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/*.yaml`
  - каждая часть формирует `reverse2seaf2.ds.ta.reverse.*`

**Как это попадает в SEAF2 UI:**
- `_metamodel_/seaf-company-ta/ta/datasets.yaml` для ряда витрин (`seaf.company.ds.ta.*`)
  делает merge:
  - `seaf2` (обычные SEAF2 объекты)
  - `seaf1` (legacy `seaf.ta.*`)
  - `reverse` (вычисляется из `reverse2seaf2.ds.ta.reverse.*`)
- порядок приоритета задаётся в `_metamodel_/seaf-company-ta/configs.yaml` (`seaf.company.ta.data_sources`).

**Ключевое ограничение:**
Текущие reverse2seaf2 датасеты ориентированы на `seaf.ta.reverse.servers_list` (Cloud.ru/Advanced).
VMware On-Prem сейчас публикует данные напрямую в `seaf.ta.*`, а не в `seaf.ta.reverse.servers_list`,
поэтому для VMware нужен отдельный путь.

## 2. Как устроены мои TA-датасеты (seaf.company.ds.ta.*)

Основной файл: `_metamodel_/seaf-company-ta/ta/datasets.yaml`.

Принцип работы:
1. Каждая витрина (`seaf.company.ds.ta.<entity>`) берёт данные из:
   - SEAF2 (`seaf.company.ta.*`)
   - SEAF1 (`seaf.ta.*`) → маппит в `seaf.company.ta.*` с префиксом `seaf1.`
   - Reverse (`reverse2seaf2.ds.ta.reverse.*`) → добавляет объекты с префиксом `reverse.`
2. UI (таблицы/карточки/визуализации) читает только `seaf.company.ds.ta.*`.

Вывод: чтобы VMware On-Prem оказался в таблицах/визуализациях SEAF2, нужно:
- либо использовать **SEAF1 overlay** (уже есть, если `seaf.ta.*` заполнены),
- либо добавить **reverse2seaf2-мэппинг** специально для VMware.

## 3. План миграции VMware On-Prem → SEAF2

### 3.1 Быстрый путь (SEAF1 overlay)
**Что получим:**
- ВМ и сети появятся в `seaf.company.ds.ta.servers` и `seaf.company.ds.ta.networks`
  с ID вида `seaf1.<legacy_id>`.

**Что нужно:**
1) Убедиться, что `seaf.ta.services.dc` заполнены (для меню/группировок).
2) Данные VMware уже лежат в:
   - `seaf.ta.components.server` (VMs)
   - `seaf.ta.services.network` (networks/dvportgroups)
3) Включён источник `seaf1` в `_metamodel_/seaf-company-ta/configs.yaml`
   (уже включён по умолчанию).

**Ограничения:**
- сущности `vdcs`, `vapps`, `hosts`, `dvswitches` напрямую в SEAF2-TA не попадут,
  т.к. для них нет мэппинга в `seaf.company.ds.ta.*`.

### 3.2 Полный путь (reverse2seaf2 для VMware On-Prem)
**Цель:** добавить VMware в reverse2seaf2, чтобы объекты имели `reverse.*` ID и были
полноценно связаны (AZ/DC/Networks/Clusters).

#### Новые датасеты reverse2seaf2 (план)
- `reverse2seaf2.ds.ta.reverse.vmware.servers`
- `reverse2seaf2.ds.ta.reverse.vmware.cluster_virtualizations`
- `reverse2seaf2.ds.ta.reverse.vmware.networks`
- `reverse2seaf2.ds.ta.reverse.vmware.network_segments`
- `reverse2seaf2.ds.ta.reverse.vmware.network_components`

Далее эти датасеты добавляются в merge в `seaf.company.ds.ta.*` (reverse-ветка).

## 4. Мэппинг сущностей VMware → SEAF2

| Источник (SEAF1 reverse) | Целевая сущность SEAF2 | Итоговый ID | Комментарий по полям |
|---|---|---|---|
| `seaf.ta.components.server` с `reverse_type=VMwareOnprem` | `seaf.company.ta.components.servers` | `reverse.server.vmwareonprem.<id>` или `seaf1.<id>` | VM → виртуальный сервер. `type="Виртуальный"`, `virtualization` ссылается на кластер, `subnets` → `networks`, `location` → DC |
| `seaf.ta.reverse.vmwareonprem.hosts` | `seaf.company.ta.components.servers` | `reverse.server.vmwareonprem.host.<id>` | Host → физический сервер. `type="Физический"`, `vendor/model/os` из `product.*`, `location` из связанного VDC/DC |
| `seaf.ta.reverse.vmwareonprem.vdcs` | `seaf.company.ta.services.cluster_virtualizations` | `reverse.cluster_virtualization.vmwareonprem` | VDC как источник локации; кластер единый. `hypervisor="VMware vSphere"`, `network_connection` из `networks`, `location` из `dc` |
| `seaf.ta.services.network` (VMware network / dvportgroup) | `seaf.company.ta.services.networks` | `reverse.network.vmwareonprem.<id>` | Тип `LAN`, `segment` → из DC/дефолтных сегментов, `location` → DC |
| `seaf.ta.components.network` (dvswitches) | `seaf.company.ta.components.networks` | `reverse.netcomp.vmwareonprem.<id>` | Сетевой компонент. `location` из VDC/DC, связи к сетям из `gatewayinterfaces` |
| `seaf.ta.reverse.vmwareonprem.vapps` | `seaf.company.ta.services.compute_services` (опционально) | `reverse.compute_service.<vapp_id>` | Опциональная миграция: vApp как вычислительный сервис/группа ВМ |

Примечание: если остаёмся на SEAF1 overlay, ID будут `seaf1.*`, без генерации `reverse.*`.

## 4.1 Решение по VMware (принято)
- **Кластер виртуализации один:** все ESXi‑хосты входят в единый кластер `reverse.cluster_virtualization.vmwareonprem`.
- **VDC игнорируем:** не используем как отдельную сущность SEAF2, но извлекаем из него `dc` для локации.
- **vApp игнорируем.**

## 4.2 VMware reverse2seaf2 (реализация)
Добавлены отдельные датасеты:
- `reverse2seaf2.ds.ta.reverse.vmware.dcs` → строится из `seaf.ta.services.dc`
- `reverse2seaf2.ds.ta.reverse.vmware.network_segments` → дефолтные сегменты per DC
- `reverse2seaf2.ds.ta.reverse.vmware.networks` → из `seaf.ta.services.network` с `reverse_type=VMwareOnprem`
- `reverse2seaf2.ds.ta.reverse.vmware.cluster_virtualizations` → один кластер для всех ESXi/VMS
- `reverse2seaf2.ds.ta.reverse.vmware.servers` → VMs из `seaf.ta.components.server` + hosts из `seaf.ta.reverse.vmwareonprem.hosts`
- `reverse2seaf2.ds.ta.reverse.vmware.network_components` → dvswitches из `seaf.ta.components.network`

В `seaf-company-ta/ta/datasets.yaml` reverse‑merge расширен, чтобы добавлять VMware объекты
в `dcs`, `network_segments`, `networks`, `cluster_virtualizations`, `servers`, `network_components`.

### 4.3 Сделано по факту (текущий статус)
**Датасеты/структура:**
- Reverse‑датасеты разложены по подпапкам: `reverse/ta/dataset_parts/{advanced,vmware_onprem}` + обновлён `root.yaml`.
- VMware reverse2seaf2‑датасеты подключены в `seaf.company.ds.ta.*` (networks, network_segments, network_components, servers, cluster_virtualizations, dcs).

**VMware сети/сегменты:**
- Исправлена нормализация `vdc.* → vdcs.*` (иначе не находился DC).
- Сегмент сети теперь ссылается на `reverse.segment.vmware.<dc>.VMWARE-LAN` без `seaf1.`.
- Сегменты VMware формируются в `reverse2seaf2.ds.ta.reverse.vmware.network_segments`.

**VMware свитчи (dvswitches):**
- `network_connection` для свитча строится через `dvportgroups` (по `original_id`), сети связываются с `reverse.netcomp.vmwareonprem.*`.
- `location` свитча подтягивается из VDC/DC (привязка к `seaf1.<dc>`).

**DC/данные озера:**
- Возвращён импорт `dc.yaml` для `dochka` (иначе `seaf1.dochka.dc1` не попадал в `seaf.company.ds.ta.dcs`).
- Убраны пустые элементы в `dc_id`/`reverse.subnet_titles` в reverse‑yaml.
- Удалены дублирующие импорты `reverse-test/*` (оставлены `vc1`/`vc2`), чтобы исключить повторение ошибок.
- Исправлена поломка YAML в `vc2/vms_datacenter-3.yaml` (список `subnet_titles`).

**Schema r41:**
- Добавлен конфиг `schema_r41_plural.include_reverse`.
- Исправлена JSONata‑логика `fallback` (иначе падал `$merge`).
- Разделены документы/источники R41: `seaf.ta.docs.schema_r41`, `seaf.ta.docs.schema_r41_seaf1`, `seaf.ta.docs.schema_r41_reverse`.
- Для SEAF1 добавлен совместимый датасет `seaf.company.ds.ta.schema_r41_seaf1_compat` с нормализацией `isp/network_links/network_connection`, фильтрацией битых ссылок и очисткой `null`.
- `_extensions/ta_docs/r41/docs/schema_r41_seaf1.yaml` переведён на `seaf.company.ds.ta.schema_r41_seaf1_compat`.
- Проверено открытие в вебе:
  - `/docs/seaf.ta.docs.schema_r41`
  - `/docs/seaf.ta.docs.schema_r41_seaf1`
  - `/docs/seaf.ta.docs.schema_r41_reverse`
  - ошибка `Not a diagram file` не воспроизводится.

## 5. Изменения в `seaf-company-ta/ta/datasets.yaml` (план)

В reverse-ветках merge для следующих витрин добавить VMware-датасеты:
- `seaf.company.ds.ta.servers` → добавить merge с `reverse2seaf2.ds.ta.reverse.vmware.servers`
- `seaf.company.ds.ta.cluster_virtualizations` → добавить `reverse2seaf2.ds.ta.reverse.vmware.cluster_virtualizations`
- `seaf.company.ds.ta.networks` → добавить `reverse2seaf2.ds.ta.reverse.vmware.networks`
- `seaf.company.ds.ta.network_segments` → добавить `reverse2seaf2.ds.ta.reverse.vmware.network_segments`
- `seaf.company.ds.ta.network_components` → добавить `reverse2seaf2.ds.ta.reverse.vmware.network_components`
- (опционально) `seaf.company.ds.ta.compute_services` → `reverse2seaf2.ds.ta.reverse.vmware.vapps`

## 6. Проверки после миграции

1) Backend:
```
docker restart archtool
curl -s http://127.0.0.1:8080/core/storage/problems/
```

2) JSONata:
```
curl -s http://127.0.0.1:8080/core/storage/jsonata/seaf.company.ds.ta.servers
curl -s http://127.0.0.1:8080/core/storage/jsonata/seaf.company.ds.ta.networks
curl -s http://127.0.0.1:8080/core/storage/jsonata/seaf.company.ds.ta.cluster_virtualizations
```

3) UI:
- `/entities/seaf.company.ta.components.servers/list`
- `/entities/seaf.company.ta.services.networks/list`
- `/entities/seaf.company.ta.services.cluster_virtualizations/list`

## 7. Решения, которые нужно принять

1) Используем ли быстрый SEAF1 overlay (минимум работ) или делаем полноценный reverse2seaf2 слой?
2) Как трактовать `vdcs`:
   - как `cluster_virtualizations` (рекомендуется),
   - или как `dcs` (если нужен прямой DC‑контейнер).
3) Нужно ли переносить `vapps` в `compute_services` (или оставить только в SEAF1 reverse)?

