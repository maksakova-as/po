# Kubernetes кластер

- Идентификатор сущности: `seaf.company.ta.services.k8s`
- Файл схемы: `_metamodel_/seaf-company-ta/services/k8s.yaml`
- Ключи объектов в YAML: `k8s`

## Схема связей

```mermaid
flowchart LR
    SRC[Кластер Кубернетес]
    T1[Зона доступности]
    T2[Офис или точка присутствия]
    T3[Центр обработки данных]
    T4[Сетевая инфраструктура]
    T5[Сервис кибербезопасности]
    T6[Стенд]
    SRC -- availabilityzone --> T1
    SRC -- location --> T2
    SRC -- location --> T3
    SRC -- management_networks --> T4
    SRC -- network_connection --> T4
    SRC -- registries --> T5
    SRC -- stand --> T6
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `availabilityzone` | `seaf.company.ta.services.dc_azs` (Зона доступности) |
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `management_networks` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |
| `registries` | `seaf.company.ta.services.kbs` (Сервис кибербезопасности) |
| `stand` | `seaf.company.ta.services.stands` (Стенд) |

## Варианты oneOf

Вариантов `oneOf` нет.
