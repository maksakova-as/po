# Сетевое устройство

- Идентификатор сущности: `seaf.company.ta.components.networks`
- Файл схемы: `_metamodel_/seaf-company-ta/components/network.yaml`
- Ключи объектов в YAML: `network_component`

## Схема связей

```mermaid
flowchart TD
    SRC[Сетевое устройство]
    BASE[Базовые поля]
    EXT[Расширение ДЗО]
    TYPE{Вариант по type}
    ROUTE[Маршрутизатор]
    SWITCH[Коммутатор]
    FIREWALL[Межсетевой экран]
    BAL[Балансировщик]
    OTHER[Другие типы]
    SRC --> BASE
    SRC --> EXT
    SRC --> TYPE
    TYPE --> ROUTE
    TYPE --> SWITCH
    TYPE --> FIREWALL
    TYPE --> BAL
    TYPE --> OTHER
```

```mermaid
flowchart LR
    SRC[Сетевое устройство]
    T1[Офис или точка присутствия]
    T2[Центр обработки данных]
    T3[Сетевая инфраструктура]
    T4[Сетевой сегмент]
    T5[Стенд]
    SRC -- location --> T1
    SRC -- location --> T2
    SRC -- network_connection --> T3
    SRC -- segment --> T4
    SRC -- stand --> T5
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |
| `segment` | `seaf.company.ta.services.network_segments` (Сетевой сегмент) |
| `stand` | `seaf.company.ta.services.stands` (Стенд) |

## Варианты oneOf

Вариантов `oneOf` нет. Ветвление задается полем `type` (перечень типов устройств).
