# Центр обработки данных

- Идентификатор сущности: `seaf.company.ta.services.dcs`
- Файл схемы: `_metamodel_/seaf-company-ta/services/dc.yaml`
- Ключи объектов в YAML: `dc`

## Схема связей

```mermaid
flowchart LR
    SRC[Центр обработки данных]
    T1[Зона доступности]
    SRC -- availabilityzone --> T1
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `availabilityzone` | `seaf.company.ta.services.dc_azs` (Зона доступности) |

## Варианты oneOf

Вариантов `oneOf` нет.
