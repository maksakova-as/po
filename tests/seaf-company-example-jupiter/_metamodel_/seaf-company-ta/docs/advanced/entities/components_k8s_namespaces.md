# Kubernetes namespace

- Идентификатор сущности: `seaf.company.ta.components.k8s_namespaces`
- Файл схемы: `_metamodel_/seaf-company-ta/components/k8s_namespaces.yaml`
- Ключи объектов в YAML: `k8s_namespace`

## Схема связей

```mermaid
flowchart LR
    SRC[Пространство имен Кубернетес]
    T1[Кластер Кубернетес]
    SRC -- cluster --> T1
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `cluster` | `seaf.company.ta.services.k8s` (Kubernetes кластер) |

## Варианты oneOf

Вариантов `oneOf` нет.
