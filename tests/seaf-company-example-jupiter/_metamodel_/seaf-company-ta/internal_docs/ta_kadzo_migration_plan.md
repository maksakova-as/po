# План миграции: KA DZO (v2025) → SEAF2 TA (v4)

**Версия:** 4.0 (С чеклистом и обоснованием)
**Статус:** Готов к исполнению
**Дата:** 02.02.2026

## 1. Описание задачи и Контекст

**Цель:** Обеспечить отображение данных технической архитектуры, описанных в формате КА ДЗО (`kadzo`), в целевых витринах и UI платформы SEAF2 (ArchTool).

**Источники информации:**
При подготовке плана были проанализированы следующие артефакты:
1.  **Данные источника:** Файлы `ka_dzo/KA/v2023/technical/tech_services.yaml` и `softwares.yaml`. Выявлено, что сущность `tech_services` в КА ДЗО является "зонтичной" и содержит объекты, которые в SEAF2 разнесены по разным типам (БД, Мониторинг, Кластеры и т.д.).
2.  **Метамодель SEAF2:**
    *   `services/compute_service.yaml`: Обнаружено жесткое ограничение поля `service_type` (enum), требующее точного маппинга строк.
    *   `services/monitoring.yaml`, `backup.yaml`: Выявлены обязательные поля (`role`, `network_connection`, `path`), отсутствующие в источнике, что требует создания значений по умолчанию.
    *   `services/cluster.yaml`: Определены критерии для выделения кластеров (HA = Yes).
3.  **Прецеденты:** Изучен план `ta_reverse_vmware_migration_plan.md`, принята аналогичная стратегия "наложения" (overlay) через датасеты.

**Архитектурный вызов:**
Основная сложность — трансформация "на лету" (без изменения исходников) плоского списка `tech_services` в строго типизированную структуру SEAF2 с разветвленной логикой (Routing) и обогащением обязательными атрибутами.

---

## 2. Чек-лист реализации (Execution Checklist)

### Этап 1: Подготовка окружения
- [x] **1.1 Обновление конфигурации:**
    - Добавить источник `kadzo` в `_metamodel_/seaf-company-ta/configs.yaml`.
    - Установить приоритет (ниже `seaf1`, выше `reverse` или по согласованию).
- [x] **1.2 Структура каталогов:**
    - Создать `_metamodel_/seaf-company-ta/kadzo/ta/`
    - Создать `_metamodel_/seaf-company-ta/kadzo/ta/dataset_parts/`

### Этап 2: Реализация трансформации (Dataset Parts)
Необходимо создать JSONata-файлы в `dataset_parts/` для каждой целевой сущности:
- [x] **2.1 `softwares.yaml`:** Прямой перенос из `kadzo.softwares`.
- [x] **2.2 `storages.yaml`:** Фильтр по классу "СУБД", "Кэш".
- [x] **2.3 `monitoring.yaml`:** Фильтр по классу "Мониторинг". Заполнение `role=['Monitoring']`, `ha=false`.
- [x] **2.4 `backups.yaml`:** Фильтр по классу "Резервное копирование". Заполнение `path='/'`.
- [x] **2.5 `network_components.yaml`:** Фильтр по классу "Шлюзы", "Proxy".
- [x] **2.6 `clusters.yaml`:** Логика выделения HA-систем (`high_availability.type == "Да"`).
- [x] **2.7 `compute_services.yaml`:**
    - Фильтр "Остальные".
    - Реализация маппинга строк `class` -> `enum service_type`.

### Этап 3: Сборка и Интеграция
- [ ] **3.1 Реестр датасетов:** Создать `_metamodel_/seaf-company-ta/kadzo/ta/datasets.yaml`, описывающий все созданные выше parts.
- [ ] **3.2 Точка входа (Merge):** Модифицировать основной файл `_metamodel_/seaf-company-ta/ta/datasets.yaml`. Добавить ветку `kadzo` в `$merge` для витрин:
    - `seaf.company.ds.ta.software`
    - `seaf.company.ds.ta.storages`
    - `seaf.company.ds.ta.monitoring`
    - `seaf.company.ds.ta.backup`
    - `seaf.company.ds.ta.network_components`
    - `seaf.company.ds.ta.clusters`
    - `seaf.company.ds.ta.compute_services`

### Этап 4: Верификация
- [ ] **4.1 Backend Check:** `docker restart archtool` -> проверка логов и `/problems/`.
- [ ] **4.2 Автотесты:** сначала `auto_tests/completeness_test`, затем `auto_tests/ui_test`.
- [ ] **4.3 API Check:** Запрос JSONata для проверки наличия объектов с префиксом `kadzo.*`.
- [ ] **4.4 UI Check:** Проверка отображения карточек и списков в браузере (Github, MySQL, Nginx).

UI‑ссылки для проверки витрин (KA DZO):
- Software: `http://127.0.0.1:8080/entities/seaf.company.ta.services.softwares/list`
- Storages: `http://127.0.0.1:8080/entities/seaf.company.ta.services.storages/list`
- Monitoring: `http://127.0.0.1:8080/entities/seaf.company.ta.services.monitorings/list`
- Backup: `http://127.0.0.1:8080/entities/seaf.company.ta.services.backups/list`
- Network components: `http://127.0.0.1:8080/entities/seaf.company.ta.components.networks/list`
- Clusters: `http://127.0.0.1:8080/entities/seaf.company.ta.services.clusters/list`
- Compute services: `http://127.0.0.1:8080/entities/seaf.company.ta.services.compute_services/list`

---

## 3. Стратегия маппинга и роутинга

### 3.1 Таблица маршрутизации (Routing Table)

| Класс КА ДЗО (`class`) | Условие (Condition) | Целевая сущность SEAF2 |
|---|---|---|
| **Все классы** из `kadzo.softwares` | Всегда | `seaf.company.ds.ta.software` |
| **Средства мониторинга**, **Системы логирования** | Всегда | `seaf.company.ds.ta.monitoring` |
| **Системы резервного/архивного копирования** | Всегда | `seaf.company.ds.ta.backup` |
| **Сервера/кластеры серверов приложений**, **Интеграционная шина**, **СУБД**, **Кэш** | Если `high_availability.type` == "Да" | `seaf.company.ds.ta.clusters` |
| **Остальные классы** (в т.ч. СУБД/Шина без HA) | Всегда | `seaf.company.ds.ta.compute_services` |

---

## 4. Детальный маппинг полей (Field Mapping)

ID генерируется как `kadzo.<entity_type>.<original_id>`.

### 4.1 Compute Services (Вычислительные сервисы)
**Цель:** `seaf.company.ds.ta.compute_services`

**Маппинг типов (class → service_type):**

| Класс КА ДЗО | Значение service_type в SEAF2 |
|---|---|
| СУБД | СУБД |
| Кэш, распределенный кеш | Распределенный кэш |
| Файловый ресурс | Файловый ресурс (FTP, NFS, SMB, S3 и т.д.) |
| Шлюзы, Балансировщики, Proxy | Шлюз, Балансировщик, прокси |
| Средства управления ИТ-службой, ИТ-инфраструктурой и ИТ-активами | Управление ИТ-службой, ИТ-инфраструктурой и ИТ-активами (CMDB, ITSM и т.д.) |
| Средства управления и автоматизации | Управление и автоматизацией (Ansible, Terraform, Jenkins и т.д.) |
| Инфраструктура удаленного доступа | Инфраструктура удаленного доступа |
| Средства коммуникации | Коммуникации (АТС, Почта, мессенджеры, СМС шлюзы и т.д.) |
| Интеграционная шина | Интеграционная шина (MQ, ETL, API) |
| Средства (инструменты) управления разработкой и хранения кода | Управление разработкой и хранения кода (Gitlab, Jira и т.д.) |
| Сервера/кластеры серверов приложений | Серверы приложений и т.д. |
| Системы управления большими данными и аналитической обработки больших объёмов данных | Серверы приложений и т.д. |
| *Любой другой класс* | Серверы приложений и т.д. |

**Обязательные поля (Defaults):**
- `location`: `[]`
- `availabilityzone`: `[]`
- `network_connection`: `[]`

### 4.2 Clusters (Кластеры)
**Цель:** `seaf.company.ds.ta.clusters`
**Маппинг:**
- `title` -> `title`
- `service_type` -> `class` (или маппинг из п. 4.1)
- `reservation_type` -> `high_availability.capacity_reservation_type`
- `network_connection` -> `[]`

### 4.3 Monitoring (Мониторинг)
**Цель:** `seaf.company.ds.ta.monitoring`
**Defaults:**
- `role`: `["Monitoring"]`
- `ha`: `false`
- `network_connection`: `[]`
- `monitored_services`: `[]`

### 4.4 Backup (Резервное копирование)
**Цель:** `seaf.company.ds.ta.backup`
**Defaults:**
- `path`: `"/"`
- `network_connection`: `[]`
- `backed_up_services`: `[]`

### 4.5 Software (ПО)
**Цель:** `seaf.company.ds.ta.software`
**Defaults:**
- `type`: `"Открытая"`
- `support`: `"Нет"`
- `expiration`: `"Бессрочно"`
- `lic_qty`: `0`
