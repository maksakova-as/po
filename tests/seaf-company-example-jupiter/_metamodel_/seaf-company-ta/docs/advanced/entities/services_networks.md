# Сетевая инфраструктура

- Идентификатор сущности: `seaf.company.ta.services.networks`
- Файл схемы: `_metamodel_/seaf-company-ta/services/network.yaml`
- Ключи объектов в YAML: `network`

## Схема связей

```mermaid
flowchart TD
    SRC[Сетевая инфраструктура]
    BASE[Базовые поля]
    VAR{Вариант по type}
    WAN[Внешняя сеть]
    LAN[Локальная сеть]
    SRC --> BASE
    SRC --> VAR
    VAR --> WAN
    VAR --> LAN
```

```mermaid
flowchart LR
    SRC[Сетевая инфраструктура]
    T1[Офис или точка присутствия]
    T2[Центр обработки данных]
    T3[Сетевой сегмент]
    SRC -- location --> T1
    SRC -- location --> T2
    SRC -- segment --> T3
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `location` | `seaf.company.ta.services.dc_offices` (Офис или точка присутствия); `seaf.company.ta.services.dcs` (Центр обработки данных) |
| `segment` | `seaf.company.ta.services.network_segments` (Сетевой сегмент) |

## Варианты oneOf

| Уровень | Вариант | Маркер варианта | Обязательные поля |
|---|---|---|---|
| Объект | Внешняя сеть | `type = WAN` | `type`, `location`, `wan_ip`, `provider` |
| Объект | Локальная сеть | `type = LAN` | `type`, `location`, `lan_type`, `ipnetwork` |
