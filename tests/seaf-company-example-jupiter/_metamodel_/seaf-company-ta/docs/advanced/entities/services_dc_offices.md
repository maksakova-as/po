# Офис или точка присутствия

- Идентификатор сущности: `seaf.company.ta.services.dc_offices`
- Файл схемы: `_metamodel_/seaf-company-ta/services/dc_office.yaml`
- Ключи объектов в YAML: `dc_office`

## Схема связей

```mermaid
flowchart LR
    SRC[Офис или точка присутствия]
    T1[Регион ЦОДов]
    SRC -- region --> T1
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `region` | `seaf.company.ta.services.dc_regions` (Регион ЦОДов) |

## Варианты oneOf

Вариантов `oneOf` нет.
