# Сервер (предложение по схеме)

- Идентификатор сущности: `seaf.company.ta.components.servers`
- Файл схемы: `_metamodel_/seaf-company-ta/components/server.yaml`
- Ключи объектов в YAML: `server`

## Схема связей

```mermaid
flowchart TD
    SRC[Сервер]
    BASE[Базовые поля]
    VAR{Вариант по type}
    PHY[Физический сервер]
    PHYDZO[Физический сервер ДЗО]
    VIRT[Виртуальный сервер]
    SRC --> BASE
    SRC --> VAR
    VAR --> PHY
    VAR --> PHYDZO
    VAR --> VIRT
```

```mermaid
flowchart LR
    SRC[Сервер]
    AZ[Зона доступности]
    DC[ЦОД]
    OFC[Офис]
    NET[Сеть]
    VC[Кластер виртуализации]
    CS[Вычислительный сервис]
    K8S[Кластер Кубернетес]
    BCK[Сервис резервного копирования]
    MON[Сервис мониторинга]
    KB[Сервис кибербезопасности]
    HWS[Аппаратная система хранения]
    STOR[Система хранения данных]
    SOFT[Программное обеспечение]
    STAND[Стенд]
    APPS[Прикладные системы и компоненты]

    SRC -- availabilityzone --> AZ
    SRC -- location --> DC
    SRC -- location --> OFC
    SRC -- subnets --> NET
    SRC -- virtualization --> VC
    SRC -- storage --> HWS
    SRC -- is_part_of --> VC
    SRC -- is_part_of --> CS
    SRC -- is_part_of --> K8S
    SRC -- is_part_of --> BCK
    SRC -- is_part_of --> MON
    SRC -- is_part_of --> KB
    SRC -- is_monitoring_connected --> MON
    SRC -- is_backup_connected --> BCK
    SRC -- sw_storage_connected --> STOR
    SRC -- softwares --> SOFT
    SRC -- stand --> STAND
    SRC -- app_components --> APPS
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `availabilityzone` | `seaf.company.ta.services.dc_azs` (Зона доступности) |
| `location` | `seaf.company.ta.services.dcs` (ЦОД); `seaf.company.ta.services.dc_offices` (Офис) |
| `subnets` | `seaf.company.ta.services.networks` (Сеть) |
| `virtualization` | `seaf.company.ta.services.cluster_virtualizations` (Кластер виртуализации) |
| `storage` | `seaf.company.ta.components.hw_storages` (Аппаратная система хранения) |
| `is_part_of` | `seaf.company.ta.services.cluster_virtualizations`; `seaf.company.ta.services.compute_services`; `seaf.company.ta.services.k8s`; `seaf.company.ta.services.backups`; `seaf.company.ta.services.monitorings`; `seaf.company.ta.services.kbs` |
| `is_monitoring_connected` | `seaf.company.ta.services.monitorings` (Сервис мониторинга) |
| `is_backup_connected` | `seaf.company.ta.services.backups` (Сервис резервного копирования) |
| `sw_storage_connected` | `seaf.company.ta.services.storages` (Система хранения данных) |
| `softwares` | `seaf.company.ta.services.softwares` (Программное обеспечение) |
| `stand` | `seaf.company.ta.services.stands` (Стенд) |
| `app_components` | `seaf.company.ai.agents`; `seaf.company.app.systems`; `seaf.company.cybersec.systems`; `kadzo.v2023.systems`; `kadzo.v2023.kb_systems`; `kadzo.v2023.tech_services`; `components` |

## Варианты oneOf

| Уровень | Вариант | Маркер варианта | Обязательные поля |
|---|---|---|---|
| Объект | Физический сервер | `type = Физический` | `type`, `vendor`, `model`, `fqdn`, `cpu`, `ram`, `disks`, `nic_qty` |
| Объект | Физический сервер ДЗО | `type = Физический` | `type`, `vendor`, `model`, `fqdn`, `cpu`, `ram`, `disks`, `nic_qty` |
| Объект | Виртуальный сервер | `type = Виртуальный` | `type`, `fqdn`, `virtualization`, `cpu`, `ram`, `disks` |
