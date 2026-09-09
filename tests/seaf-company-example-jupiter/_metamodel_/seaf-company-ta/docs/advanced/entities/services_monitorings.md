# Сервис мониторинга

- Идентификатор сущности: `seaf.company.ta.services.monitorings`
- Файл схемы: `_metamodel_/seaf-company-ta/services/monitoring.yaml`
- Ключи объектов в YAML: `monitoring`

## Схема связей

```mermaid
flowchart LR
    SRC[Сервис мониторинга]
    T1[Зона доступности]
    T2[Офис или точка присутствия]
    T3[Центр обработки данных]
    T4[Сервер]
    T5[Сервис резервного копирования]
    T6[Кластер виртуализации]
    T7[Вычислительный сервис]
    T8[Кластер Кубернетес]
    T9[Сервис кибербезопасности]
    T10[Сетевая инфраструктура]
    T11[Система хранения данных]
    SRC -- availabilityzone --> T1
    SRC -- location --> T2
    SRC -- location --> T3
    SRC -- monitored_services --> T4
    SRC -- monitored_services --> T5
    SRC -- monitored_services --> T6
    SRC -- monitored_services --> T7
    SRC -- monitored_services --> T8
    SRC -- monitored_services --> T9
    SRC -- monitored_services --> T10
    SRC -- monitored_services --> T11
    SRC -- network_connection --> T10
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `availabilityzone` | `seaf.company.ta.services.dc_azs` (Зона доступности) |
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `monitored_services` | `seaf.company.ta.components.servers` (Сервер (предложение по схеме)); `seaf.company.ta.services.backups` (Сервис резервного копирования); `seaf.company.ta.services.cluster_virtualizations` (Кластер виртуализации); `seaf.company.ta.services.compute_services` (Вычислительный сервис); `seaf.company.ta.services.k8s` (Kubernetes кластер); `seaf.company.ta.services.kbs` (Сервис кибербезопасности); `seaf.company.ta.services.networks` (Сетевая инфраструктура); `seaf.company.ta.services.storages` (Система хранения данных) |
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |

## Варианты oneOf

Вариантов `oneOf` нет.
