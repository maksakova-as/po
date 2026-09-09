# Сервис резервного копирования

- Идентификатор сущности: `seaf.company.ta.services.backups`
- Файл схемы: `_metamodel_/seaf-company-ta/services/backup.yaml`
- Ключи объектов в YAML: `backup`

## Схема связей

```mermaid
flowchart LR
    SRC[Сервис резервного копирования]
    T1[Зона доступности]
    T2[Аппаратная система хранения]
    T3[Сетевое устройство]
    T4[Сервер]
    T5[Пользовательское устройство]
    T6[Кластер виртуализации]
    T7[Вычислительный сервис]
    T8[Кластер Кубернетес]
    T9[Сервис кибербезопасности]
    T10[Сервис мониторинга]
    T11[Сетевая инфраструктура]
    T12[Система хранения данных]
    T13[Офис или точка присутствия]
    T14[Центр обработки данных]
    SRC -- availabilityzone --> T1
    SRC -- backed_up_services --> T2
    SRC -- backed_up_services --> T3
    SRC -- backed_up_services --> T4
    SRC -- backed_up_services --> T5
    SRC -- backed_up_services --> T6
    SRC -- backed_up_services --> T7
    SRC -- backed_up_services --> T8
    SRC -- backed_up_services --> T9
    SRC -- backed_up_services --> T10
    SRC -- backed_up_services --> T11
    SRC -- backed_up_services --> T12
    SRC -- location --> T13
    SRC -- location --> T14
    SRC -- network_connection --> T11
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `availabilityzone` | `seaf.company.ta.services.dc_azs` (Зона доступности) |
| `backed_up_services` | `seaf.company.ta.components.hw_storages` (Аппаратная система хранения); `seaf.company.ta.components.networks` (Сетевое устройство); `seaf.company.ta.components.servers` (Сервер (предложение по схеме)); `seaf.company.ta.components.user_devices` (Пользовательское устройство); `seaf.company.ta.services.cluster_virtualizations` (Кластер виртуализации); `seaf.company.ta.services.compute_services` (Вычислительный сервис); `seaf.company.ta.services.k8s` (Kubernetes кластер); `seaf.company.ta.services.kbs` (Сервис кибербезопасности); `seaf.company.ta.services.monitorings` (Сервис мониторинга); `seaf.company.ta.services.networks` (Сетевая инфраструктура); `seaf.company.ta.services.storages` (Система хранения данных) |
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |

## Варианты oneOf

Вариантов `oneOf` нет.
