# Логическая связь

- Идентификатор сущности: `seaf.company.ta.services.logical_links`
- Файл схемы: `_metamodel_/seaf-company-ta/services/logical_link.yaml`
- Ключи объектов в YAML: `logical_link`

## Схема связей

```mermaid
flowchart LR
    SRC[Логическая связь]
    T1[Аппаратная система хранения]
    T2[Сетевое устройство]
    T3[Сервер]
    T4[Пользовательское устройство]
    T5[Сервис резервного копирования]
    T6[Кластер виртуализации]
    T7[Вычислительный сервис]
    T8[Зона доступности]
    T9[Офис или точка присутствия]
    T10[Регион ЦОДов]
    T11[Центр обработки данных]
    T12[Кластер Кубернетес]
    T13[Сервис кибербезопасности]
    T14[Сервис мониторинга]
    T15[Сетевые связанности]
    T16[Сетевой сегмент]
    T17[Сетевая инфраструктура]
    T18[Система хранения данных]
    SRC -- source --> T1
    SRC -- source --> T2
    SRC -- source --> T3
    SRC -- source --> T4
    SRC -- source --> T5
    SRC -- source --> T6
    SRC -- source --> T7
    SRC -- source --> T8
    SRC -- source --> T9
    SRC -- source --> T10
    SRC -- source --> T11
    SRC -- source --> T12
    SRC -- source --> T13
    SRC -- source --> T14
    SRC -- source --> T15
    SRC -- source --> T16
    SRC -- source --> T17
    SRC -- source --> T18
    SRC -- target --> T1
    SRC -- target --> T2
    SRC -- target --> T3
    SRC -- target --> T4
    SRC -- target --> T5
    SRC -- target --> T6
    SRC -- target --> T7
    SRC -- target --> T8
    SRC -- target --> T9
    SRC -- target --> T10
    SRC -- target --> T11
    SRC -- target --> T12
    SRC -- target --> T13
    SRC -- target --> T14
    SRC -- target --> T15
    SRC -- target --> T16
    SRC -- target --> T17
    SRC -- target --> T18
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `source` | `seaf.company.ta.components.hw_storages` (Аппаратная система хранения); `seaf.company.ta.components.networks` (Сетевое устройство); `seaf.company.ta.components.servers` (Сервер (предложение по схеме)); `seaf.company.ta.components.user_devices` (Пользовательское устройство); `seaf.company.ta.services.backups` (Сервис резервного копирования); `seaf.company.ta.services.cluster_virtualizations` (Кластер виртуализации); `seaf.company.ta.services.compute_services` (Вычислительный сервис); `seaf.company.ta.services.dc_azs` (Зона доступности); `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dc_regions` (Регион ЦОДов); `seaf.company.ta.services.dcs` (Центр обработки данных); `seaf.company.ta.services.k8s` (Kubernetes кластер); `seaf.company.ta.services.kbs` (Сервис кибербезопасности); `seaf.company.ta.services.monitorings` (Сервис мониторинга); `seaf.company.ta.services.network_links` (Сетевые связанности); `seaf.company.ta.services.network_segments` (Сетевой сегмент); `seaf.company.ta.services.networks` (Сетевая инфраструктура); `seaf.company.ta.services.storages` (Система хранения данных) |
| `target` | `seaf.company.ta.components.hw_storages` (Аппаратная система хранения); `seaf.company.ta.components.networks` (Сетевое устройство); `seaf.company.ta.components.servers` (Сервер (предложение по схеме)); `seaf.company.ta.components.user_devices` (Пользовательское устройство); `seaf.company.ta.services.backups` (Сервис резервного копирования); `seaf.company.ta.services.cluster_virtualizations` (Кластер виртуализации); `seaf.company.ta.services.compute_services` (Вычислительный сервис); `seaf.company.ta.services.dc_azs` (Зона доступности); `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dc_regions` (Регион ЦОДов); `seaf.company.ta.services.dcs` (Центр обработки данных); `seaf.company.ta.services.k8s` (Kubernetes кластер); `seaf.company.ta.services.kbs` (Сервис кибербезопасности); `seaf.company.ta.services.monitorings` (Сервис мониторинга); `seaf.company.ta.services.network_links` (Сетевые связанности); `seaf.company.ta.services.network_segments` (Сетевой сегмент); `seaf.company.ta.services.networks` (Сетевая инфраструктура); `seaf.company.ta.services.storages` (Система хранения данных) |

## Варианты oneOf

Вариантов `oneOf` нет.
