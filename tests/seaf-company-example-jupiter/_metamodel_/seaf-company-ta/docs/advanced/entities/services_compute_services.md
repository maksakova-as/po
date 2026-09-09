# Вычислительный сервис

- Идентификатор сущности: `seaf.company.ta.services.compute_services`
- Файл схемы: `_metamodel_/seaf-company-ta/services/compute_service.yaml`
- Ключи объектов в YAML: `compute_service`

## Схема связей

```mermaid
flowchart LR
    SRC[Вычислительный сервис]
    T1[Зона доступности]
    T2[Офис или точка присутствия]
    T3[Центр обработки данных]
    T4[Сетевая инфраструктура]
    SRC -- availabilityzone --> T1
    SRC -- location --> T2
    SRC -- location --> T3
    SRC -- network_connection --> T4
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `availabilityzone` | `seaf.company.ta.services.dc_azs` (Зона доступности) |
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |

## Варианты oneOf

Вариантов `oneOf` нет.
