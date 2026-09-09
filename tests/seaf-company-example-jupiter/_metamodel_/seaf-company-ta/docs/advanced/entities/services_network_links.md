# Сетевые связанности

- Идентификатор сущности: `seaf.company.ta.services.network_links`
- Файл схемы: `_metamodel_/seaf-company-ta/services/network_links.yaml`
- Ключи объектов в YAML: `network_link`

## Схема связей

```mermaid
flowchart LR
    SRC[Сетевые связанности]
    T1[Сетевая инфраструктура]
    SRC -- network_connection --> T1
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `network_connection` | `seaf.company.ta.services.networks` (Сетевая инфраструктура) |

## Варианты oneOf

Вариантов `oneOf` нет.
