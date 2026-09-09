# Kubernetes HPA

- Идентификатор сущности: `seaf.company.ta.components.k8s_hpa`
- Файл схемы: `_metamodel_/seaf-company-ta/components/k8s_hpa.yaml`
- Ключи объектов в YAML: `k8s_hpa`

## Схема связей

```mermaid
flowchart LR
    SRC[Автомасштабирование Кубернетес]
    T1[Кластер Кубернетес]
    T2[Развертывание в Кубернетес]
    SRC -- cluster --> T1
    SRC -- target --> T2
```

## Связи по полям

| Поле | Целевые сущности |
|---|---|
| `cluster` | `seaf.company.ta.services.k8s` (Kubernetes кластер) |
| `target` | `seaf.company.ta.services.k8s_deployments` (Kubernetes deployment) |

## Варианты oneOf

Вариантов `oneOf` нет.
