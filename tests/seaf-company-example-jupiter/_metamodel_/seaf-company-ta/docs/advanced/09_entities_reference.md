# Справочник сущностей TA

Документ содержит прямые ссылки на главы по каждой сущности.
В каждой главе есть: схема связей, таблица ссылочных полей, варианты `oneOf`.

## Технические сервисы

### Базовая сущность

- [Базовая сущность технического сервиса](entities/services_base_entity.md) — `seaf.company.ta.services.entity`

### Локационный контур

- [Регион ЦОДов](entities/services_dc_regions.md) — `seaf.company.ta.services.dc_regions`
- [Зона доступности](entities/services_dc_azs.md) — `seaf.company.ta.services.dc_azs`
- [Центр обработки данных](entities/services_dcs.md) — `seaf.company.ta.services.dcs`
- [Офис или точка присутствия](entities/services_dc_offices.md) — `seaf.company.ta.services.dc_offices`
- [Окружение](entities/services_environments.md) — `seaf.company.ta.services.environments`
- [Стенд](entities/services_stands.md) — `seaf.company.ta.services.stands`

### Сетевой контур

- [Сетевой сегмент](entities/services_network_segments.md) — `seaf.company.ta.services.network_segments`
- [Сетевая инфраструктура](entities/services_networks.md) — `seaf.company.ta.services.networks`
- [Сетевые связанности](entities/services_network_links.md) — `seaf.company.ta.services.network_links`
- [Логическая связь](entities/services_logical_links.md) — `seaf.company.ta.services.logical_links`

### Платформы и хранение

- [Кластер виртуализации](entities/services_cluster_virtualizations.md) — `seaf.company.ta.services.cluster_virtualizations`
- [Вычислительный сервис](entities/services_compute_services.md) — `seaf.company.ta.services.compute_services`
- [Kubernetes кластер](entities/services_k8s.md) — `seaf.company.ta.services.k8s`
- [Kubernetes deployment](entities/services_k8s_deployments.md) — `seaf.company.ta.services.k8s_deployments`
- [Аппаратная система хранения](entities/services_hw_storages.md) — `seaf.company.ta.services.hw_storages`
- [Система хранения данных](entities/services_storages.md) — `seaf.company.ta.services.storages`
- [Программное обеспечение](entities/services_softwares.md) — `seaf.company.ta.services.softwares`

### Эксплуатация и безопасность

- [Сервис мониторинга](entities/services_monitorings.md) — `seaf.company.ta.services.monitorings`
- [Сервис резервного копирования](entities/services_backups.md) — `seaf.company.ta.services.backups`
- [Сервис кибербезопасности](entities/services_kbs.md) — `seaf.company.ta.services.kbs`

## Технические компоненты

### Вычислительные компоненты

- [Сервер (предложение по схеме)](entities/components_servers.md) — `seaf.company.ta.components.servers`
- [Kubernetes нода](entities/components_k8s_nodes.md) — `seaf.company.ta.components.k8s_nodes`
- [Kubernetes namespace](entities/components_k8s_namespaces.md) — `seaf.company.ta.components.k8s_namespaces`
- [Kubernetes HPA](entities/components_k8s_hpa.md) — `seaf.company.ta.components.k8s_hpa`

### Сеть и хранение

- [Сетевое устройство](entities/components_networks.md) — `seaf.company.ta.components.networks`
- [Аппаратная система хранения](entities/components_hw_storages.md) — `seaf.company.ta.components.hw_storages`

### Пользовательский контур

- [Пользовательское устройство](entities/components_user_devices.md) — `seaf.company.ta.components.user_devices`

## Сущности с вариантами `oneOf`

- [Сервис кибербезопасности](entities/services_kbs.md) — `seaf.company.ta.services.kbs`
- [Сетевая инфраструктура](entities/services_networks.md) — `seaf.company.ta.services.networks`
- [Система хранения данных](entities/services_storages.md) — `seaf.company.ta.services.storages`
