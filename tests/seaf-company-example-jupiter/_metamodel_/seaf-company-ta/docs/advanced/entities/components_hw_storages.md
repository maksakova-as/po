# Аппаратная система хранения

- Идентификатор сущности: `seaf.company.ta.components.hw_storages`
- Файл схемы: `_metamodel_/seaf-company-ta/components/hw_storage.yaml`
- Ключи объектов в YAML: `hw_storage`

## Схема связей

```mermaid
flowchart LR
    SRC[Аппаратная система хранения]
    T1[Офис или точка присутствия]
    T2[Центр обработки данных]
    T3[Сетевая инфраструктура]
    T4[Система хранения данных]
    SRC -- location --> T1
    SRC -- location --> T2
    SRC -- network_connection --> T3
    SRC -- sw_storage_connected --> T4
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |
| `sw_storage_connected` | `seaf.company.ta.services.storages` (Система хранения данных) |

## Варианты oneOf

Вариантов `oneOf` нет.
