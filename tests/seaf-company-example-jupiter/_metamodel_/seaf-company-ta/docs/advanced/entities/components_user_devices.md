# Пользовательское устройство

- Идентификатор сущности: `seaf.company.ta.components.user_devices`
- Файл схемы: `_metamodel_/seaf-company-ta/components/user_device.yaml`
- Ключи объектов в YAML: `user_device`

## Схема связей

```mermaid
flowchart LR
    SRC[Пользовательское устройство]
    T1[Офис или точка присутствия]
    T2[Центр обработки данных]
    T3[Сетевая инфраструктура]
    T4[Сетевые связанности]
    T5[Сетевой сегмент]
    SRC -- location --> T1
    SRC -- location --> T2
    SRC -- network_connection --> T3
    SRC -- network_connection_devices --> T4
    SRC -- segment --> T5
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |
| `network_connection_devices` | `seaf.company.ta.services.network_links` (Сетевые связанности) |
| `segment` | `seaf.company.ta.services.network_segments` (Сетевой сегмент) |

## Варианты oneOf

Вариантов `oneOf` нет.
