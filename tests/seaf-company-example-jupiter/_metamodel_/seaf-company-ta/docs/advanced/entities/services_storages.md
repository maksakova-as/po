# Система хранения данных

- Идентификатор сущности: `seaf.company.ta.services.storages`
- Файл схемы: `_metamodel_/seaf-company-ta/services/storage.yaml`
- Ключи объектов в YAML: `storage`

## Схема связей

```mermaid
flowchart LR
    SRC[Система хранения данных]
    T1[Зона доступности]
    T2[Аппаратная система хранения]
    T3[Офис или точка присутствия]
    T4[Центр обработки данных]
    T5[Сетевая инфраструктура]
    T6[Программное обеспечение]
    SRC -- availabilityzone --> T1
    SRC -- hw_storage_connected --> T2
    SRC -- location --> T3
    SRC -- location --> T4
    SRC -- network_connection --> T5
    SRC -- softwares --> T6
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `availabilityzone` | `seaf.company.ta.services.dc_azs` (Зона доступности) |
| `hw_storage_connected` | `seaf.company.ta.components.hw_storages` (Аппаратная система хранения) |
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |
| `softwares` | `seaf.company.ta.services.softwares` (Программное обеспечение) |

## Варианты oneOf

| Уровень | Вариант | Маркер варианта | Обязательные поля |
|---|---|---|---|
| Объект | Вариант 1 | Software Defined Storage | `type`, `softwares`, `volume`, `network_connection` |
| Объект | Вариант 2 | Simple Storage Service | `type`, `availabilityzone`, `network_connection` |
