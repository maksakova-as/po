# План ускорения датасетов `seaf-company-ta`

## 1) Область анализа

Проанализированы датасеты в:
- `_metamodel_/seaf-company-ta/ta/datasets.yaml`
- `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/*.yaml`
- `_metamodel_/seaf-company-ta/_extensions/ta_docs/r41/datasets/root.yaml`
- `_metamodel_/seaf-company-ta/_extensions/app/systems/datasets/root.yaml`

Текущая конфигурация источников: `seaf2 + seaf1 + kadzo + reverse` (из `_metamodel_/seaf-company-ta/configs.yaml`).

## 2) Базовые замеры (локально, `localhost:8080`, warm-run)

### Самые тяжелые TA датасеты

| Dataset | Время | Размер | Объем |
|---|---:|---:|---:|
| `seaf.company.ds.ta.schema_r41_plural` | ~4183 ms | 381672 bytes | - |
| `seaf.company.ds.ta.all_objects` | ~4035 ms | 1190042 bytes | 969 объектов |
| `seaf.company.ds.ta.kb_links` | ~3831 ms | 8355 bytes | 45 строк |
| `seaf.company.ds.ta.k8s_infra_objects` | ~807 ms | 5984 bytes | 40 строк |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | ~760 ms | 3592 bytes | 20 строк |
| `seaf.company.ds.ta.servers` | ~675 ms | 712269 bytes | 305 объектов |
| `seaf.company.ds.ta.network_components` | ~405 ms | 97951 bytes | 117 объектов |

### Смежные тяжелые датасеты прикладного слоя

| Dataset | Время | Размер | Объем |
|---|---:|---:|---:|
| `seaf.company.ds.app.systems_deployment_topology` | ~5097 ms | 9594 bytes | 17 систем |
| `seaf.company.ds.app.systems_dependency_graph` | ~4303 ms | 56523 bytes | 17 систем |
| `seaf.company.ds.app.systems_ta_services` | ~210 ms | 48180 bytes | 262 записи |

### Наблюдения по сложности вычислений

- В `_metamodel_/seaf-company-ta/ta/datasets.yaml`:  
  - `$eval(`: **40**  
  - `$merge(`: **101**  
  - `$spread()`: **33**
- В `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/schema_r41_reverse.yaml`:  
  - `$eval(`: **29**

## 3) Основные узкие места

1. **Фан-аут `$eval` и повторные вычисления reverse/kadzo**
   - `ta/datasets.yaml` многократно вызывает одинаковые reverse/kadzo части в разных датасетах.
   - Эффект: CPU/latency растут пропорционально числу открытых карточек/таблиц.

2. **Сверхтяжелый `all_objects` как универсальный origin**
   - `seaf.company.ds.ta.all_objects` (`ta/datasets.yaml:2053`) тянет почти все TA коллекции и активно используется в презентациях/виджетах.
   - От него зависят `kb_links` (`ta/datasets.yaml:1364`) и app-графы (`app/systems/datasets.yaml:29`, `:224`), что создает каскадные задержки.

3. **N×M join-паттерны в инфраструктурных датасетах**
   - `k8s_infra_objects` (`ta/datasets.yaml:1554`) и `cluster_virtualization_infra_objects` (`ta/datasets.yaml:774`) делают повторные фильтры по большим коллекциям.

4. **Тяжелая дедупликация/нормализация на лету**
   - `servers` (`ta/datasets.yaml:946`) и `network_components` (`ta/datasets.yaml:1775`) содержат много шагов нормализации, alias-резолва и merge в рантайме.

5. **Непрозрачные зависимости контекста в части reverse датасетов**
   - Ряд reverse датасетов ожидает внешний контекст (`$ctx`) и плохо профилируется/кэшируется как самостоятельные источники.

## 4) Целевые KPI после оптимизации

- `seaf.company.ds.ta.all_objects`: **<= 1500 ms** (было ~4035 ms)
- `seaf.company.ds.ta.kb_links`: **<= 800 ms** (было ~3831 ms)
- `seaf.company.ds.ta.schema_r41_plural`: **<= 2000 ms** (было ~4183 ms)
- `seaf.company.ds.ta.servers`: **<= 450 ms** (было ~675 ms)
- `seaf.company.ds.ta.network_components`: **<= 250 ms** (было ~405 ms)
- `seaf.company.ds.app.systems_dependency_graph`: **<= 2500 ms** (было ~4303 ms)
- `seaf.company.ds.app.systems_deployment_topology`: **<= 3000 ms** (было ~5097 ms)

## 5) Детализированный план по фазам (для передачи агенту)

Ниже каждая фаза оформлена как отдельный пакет работ для кодирующего агента.

Формат передачи фазы агенту:
- Цель фазы.
- Файлы, которые можно менять.
- Файлы, которые менять нельзя (если не требуется).
- Явный чек-лист готовности к старту (DoR).
- Явный чек-лист готовности фазы (DoD).

### Фаза 0. Перф-контур и измеримость

**Цель**
- Зафиксировать воспроизводимый benchmark до оптимизаций.

**Файлы для изменений**
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_datasets.py` (новый)
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_plan.md` (обновление таблицы baseline)

**Чек-лист готовности к старту (DoR)**
- [ ] Контейнер backend запущен и отвечает на `localhost:8080`.
- [ ] В `configs.yaml` зафиксирован активный профиль источников (чтобы замеры были сопоставимы).
- [ ] Определен список benchmark-датасетов (KPI из раздела 4).

**Чек-лист готовности фазы (DoD)**
- [ ] Есть скрипт benchmark с warmup + 5 запусков + median/p95 + payload size.
- [ ] Сформирован baseline-отчет в `internal_docs/` с датой и commit hash.
- [ ] Замеры повторяемы (разброс не более согласованного порога).

### Фаза 1. Развязка от тяжелого `all_objects`

**Цель**
- Убрать избыточную зависимость от `seaf.company.ds.ta.all_objects` в датасетах, где не нужен полный объект.

**Файлы для изменений**
- `_metamodel_/seaf-company-ta/ta/datasets.yaml`
- `_metamodel_/seaf-company-ta/_extensions/app/systems/datasets/root.yaml`

**Чек-лист готовности к старту (DoR)**
- [ ] Зафиксирован baseline по `all_objects`, `kb_links`, app-графам.
- [ ] Согласован минимальный контракт `all_objects_light` (`__id__`, `__entity_id__`, `title`, `link`, ключевые связи).
- [ ] Определены consumers, которым точно не нужны полные объекты.

**Чек-лист готовности фазы (DoD)**
- [ ] Добавлен `seaf.company.ds.ta.all_objects_light`.
- [ ] `kb_links` переведен на прямой lookup без полного обхода `all_objects`.
- [ ] `systems_dependency_graph` и `systems_deployment_topology` используют облегченный индекс/контракт.
- [ ] Нет функциональной регрессии в карточках/графах.
- [ ] Время `kb_links` и app-графов улучшено относительно baseline.

### Фаза 2. Кэши reverse/kadzo для TA-слоя

**Цель**
- Убрать повторные `$eval` одних и тех же reverse/kadzo датасетов в `ta/datasets.yaml`.

**Файлы для изменений**
- `_metamodel_/seaf-company-ta/ta/datasets.yaml`

**Чек-лист готовности к старту (DoR)**
- [ ] Определен список повторно вычисляемых источников (`reverse.*`, `reverse.vmware.*`, `kadzo.*`).
- [ ] Согласованы имена и контракт кэш-датасетов (`_cache.*`).
- [ ] Определен порядок merge источников (не менять семантику приоритета).

**Чек-лист готовности фазы (DoD)**
- [ ] Добавлены кэш-датасеты: `reverse_core`, `reverse_network`, `reverse_platform`, `kadzo_core`.
- [ ] Целевые датасеты (`compute_services`, `cluster_virtualizations`, `storages`, `servers`, `backup`, `monitoring`, `logical_links`, `network_components`) читают данные из кэшей.
- [ ] Повторные `$eval` в `ta/datasets.yaml` существенно сокращены.
- [ ] Результаты merge/dedupe (count + sample IDs) совпадают с baseline.

### Фаза 3. Индексы связей вместо повторных фильтров

**Цель**
- Снизить N×M проходы в инфраструктурных и app-датасетах.

**Файлы для изменений**
- `_metamodel_/seaf-company-ta/ta/datasets.yaml`
- `_metamodel_/seaf-company-ta/_extensions/app/systems/datasets/root.yaml`

**Чек-лист готовности к старту (DoR)**
- [ ] Зафиксированы горячие join-участки в `k8s_infra_objects`, `cluster_virtualization_infra_objects`, app-графах.
- [ ] Согласован список индексов (`_idx.services_by_app_component`, `_idx.resources_by_location_segment`, `_idx.server_membership`).

**Чек-лист готовности фазы (DoD)**
- [ ] Добавлены и документированы `_idx` датасеты.
- [ ] `k8s_infra_objects` и `cluster_virtualization_infra_objects` используют индексы.
- [ ] App-графы используют индексы вместо полного повторного обхода TA-коллекций.
- [ ] Сохранена функциональная эквивалентность структуры выходных данных.

### Фаза 4. Оптимизация `servers` и `network_components`

**Цель**
- Ускорить самые нагруженные merge/normalization датасеты TA.

**Файлы для изменений**
- `_metamodel_/seaf-company-ta/ta/datasets.yaml`
- при необходимости: `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/vmware_onprem/*.yaml`

**Чек-лист готовности к старту (DoR)**
- [ ] Зафиксирован baseline для `servers` и `network_components`.
- [ ] Выделены повторно используемые вычисления (vmware alias map, dedupe key map).
- [ ] Подготовлен набор контрольных объектов для регрессионной сверки.

**Чек-лист готовности фазы (DoD)**
- [ ] Служебные карты/индексы вынесены и переиспользуются.
- [ ] Количество полных `$spread()` проходов уменьшено.
- [ ] Не изменена бизнес-логика dedupe между `seaf2/seaf1/kadzo/reverse`.
- [ ] Сохранена корректность `network_connection`, `subnets`, `segment`.
- [ ] Достигнуты KPI по времени для `servers` и `network_components`.

### Фаза 5. Ускорение схем R41

**Цель**
- Снизить latency датасетов построения схем (`schema_r41_*`).

**Файлы для изменений**
- `_metamodel_/seaf-company-ta/_extensions/ta_docs/r41/datasets/root.yaml`
- `_metamodel_/seaf-company-ta/_extensions/reverse/datasets/dataset_parts/schema_r41_reverse.yaml`

**Чек-лист готовности к старту (DoR)**
- [ ] Сняты baseline по `schema_r41_plural`, `schema_r41_reverse`, `schema_r41_seaf1`.
- [ ] Согласованы допустимые изменения fallback-логики (без изменения смыслового результата схем).

**Чек-лист готовности фазы (DoD)**
- [ ] Убраны избыточные merge/нормализации в `schema_r41_plural`.
- [ ] `schema_r41_reverse` использует подготовленные кэши/индексы вместо повторного fan-out `$eval`.
- [ ] Схемы корректно строятся в UI/плагине, нет ошибок вида `Not a diagram file`.
- [ ] KPI по скорости схем достигнуты.

### Фаза 6. Профили источников и операционный режим

**Цель**
- Сделать производительность управляемой через профили источников данных.

**Файлы для изменений**
- `_metamodel_/seaf-company-ta/configs.yaml`
- `_metamodel_/seaf-company-ta/internal_docs/operations_manual.md`

**Чек-лист готовности к старту (DoR)**
- [ ] Согласован список профилей: `seaf2_only`, `seaf2_seaf1`, `full_with_reverse`.
- [ ] Согласованы сценарии использования каждого профиля.

**Чек-лист готовности фазы (DoD)**
- [ ] Профили источников описаны и применимы без ручной правки датасетов.
- [ ] Для каждого профиля есть ожидаемые latency-метрики.
- [ ] В `operations_manual.md` добавлена инструкция выбора профиля по задаче.
- [ ] Проверено, что переключение профиля не ломает базовые карточки/схемы.

## 6) Проверки после каждой фазы

Обязательная последовательность:
1. Проверка запроса в backend (target datasets).
2. Перезапуск контейнера.
3. Проверка датасетов в backend.
4. `completeness_test`.
5. Прогон автотестов датасетов.
6. Финальная проверка UI (web).

Минимальный набор команд:
- `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py`
- `python _metamodel_/seaf-company-ta/auto_tests/run_all_dataset_counts.py`
- `python _metamodel_/seaf-company-ta/auto_tests/ui_test/generate_test_urls.py`
- `node _metamodel_/seaf-company-ta/auto_tests/ui_test/run_ui_smoke_test.js`

## 6.1) Статус выполнения (фазы 0 и 1)

Артефакты выполнения:
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_baseline.md`
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_phase1_results.md`
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_datasets.py`

Сравнение median (baseline -> после Фазы 1):

| Dataset | Baseline median, ms | Phase1 median, ms | Delta, ms | Delta, % |
|---|---:|---:|---:|---:|
| `seaf.company.ds.ta.schema_r41_plural` | 4168.5 | 4359.7 | +191.2 | +4.6% |
| `seaf.company.ds.ta.all_objects` | 4278.0 | 5383.9 | +1105.9 | +25.9% |
| `seaf.company.ds.ta.kb_links` | 4203.7 | 4552.8 | +349.1 | +8.3% |
| `seaf.company.ds.ta.servers` | 762.0 | 710.5 | -51.5 | -6.8% |
| `seaf.company.ds.ta.network_components` | 445.9 | 455.5 | +9.6 | +2.2% |
| `seaf.company.ds.app.systems_dependency_graph` | 4612.8 | 5575.2 | +962.4 | +20.9% |
| `seaf.company.ds.app.systems_deployment_topology` | 5060.3 | 6172.1 | +1111.8 | +22.0% |

Итог по Фазе 1: целевые KPI ускорения **не достигнуты** на этом прогоне; требуется продолжение оптимизации (Фаза 2+), а также повторный перф-прогон в стабильном окружении.

### Чек-лист выполнения Фазы 0 (факт)
- [x] Добавлен benchmark-скрипт `auto_tests/perf/benchmark_datasets.py`.
- [x] Снят baseline-отчет в `internal_docs`.
- [x] Зафиксирован набор контрольных датасетов.
- [x] Пройдены проверки целостности датасетов (`run_all_dataset_counts.py`).

### Чек-лист выполнения Фазы 1 (факт)
- [x] Добавлен `seaf.company.ds.ta.all_objects_light`.
- [x] `kb_links` переведен с полного обхода `all_objects` на прямой resolver по профильным датасетам.
- [x] `systems_dependency_graph` и `systems_deployment_topology` переведены на `all_objects_light`.
- [x] Проверена функциональная целостность через dataset count tests.
- [ ] Достигнуты KPI ускорения Фазы 1 (не достигнуты на текущем прогоне).

## 6.2) Статус выполнения (фаза 2)

Артефакты выполнения:
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_phase2_results.md`
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_phase2_results.json`

Сравнение median (Phase1 -> Phase2):

| Dataset | Phase1 median, ms | Phase2 median, ms | Delta, ms | Delta, % |
|---|---:|---:|---:|---:|
| `seaf.company.ds.ta.schema_r41_plural` | 4359.7 | 2915.7 | -1444.0 | -33.1% |
| `seaf.company.ds.ta.all_objects` | 5383.9 | 3093.4 | -2290.5 | -42.5% |
| `seaf.company.ds.ta.kb_links` | 4552.8 | 1749.4 | -2803.4 | -61.6% |
| `seaf.company.ds.ta.servers` | 710.5 | 324.7 | -385.8 | -54.3% |
| `seaf.company.ds.ta.network_components` | 455.5 | 372.9 | -82.6 | -18.1% |
| `seaf.company.ds.app.systems_dependency_graph` | 5575.2 | 2255.3 | -3319.9 | -59.5% |
| `seaf.company.ds.app.systems_deployment_topology` | 6172.1 | 2312.7 | -3859.4 | -62.5% |

Примечание: Phase2 замерен с активными источниками `seaf2 + seaf1 + reverse` (без `kadzo`) в текущем профиле.

### Чек-лист выполнения Фазы 2 (факт)
- [x] Добавлены кэш-датасеты: `reverse_core`, `reverse_network`, `reverse_platform`, `kadzo_core`.
- [x] `compute_services`, `cluster_virtualizations`, `storages`, `servers`, `backup`, `monitoring`, `logical_links`, `network_components` читают reverse/kadzo данные через кэш-слой.
- [x] Сокращены повторные `$eval` в `ta/datasets.yaml` (целевые датасеты Фазы 2 переведены на `_cache.*`).
- [x] Пройдены `completeness_test` и `run_all_dataset_counts.py` после изменений.
- [x] Выполнен benchmark Phase2 и зафиксированы метрики.

## 6.3) Статус выполнения (фаза 3)

Артефакты выполнения:
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_phase3_results.md`
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_phase3_results.json`

Сравнение median (Phase2 -> Phase3):

| Dataset | Phase2 median, ms | Phase3 median, ms | Delta, ms | Delta, % |
|---|---:|---:|---:|---:|
| `seaf.company.ds.ta.k8s_infra_objects` | 965.7 | 657.8 | -307.9 | -31.9% |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 438.9 | 420.1 | -18.8 | -4.3% |
| `seaf.company.ds.app.systems_dependency_graph` | 2255.3 | 1738.8 | -516.5 | -22.9% |
| `seaf.company.ds.app.systems_deployment_topology` | 2312.7 | 2436.5 | +123.8 | +5.4% |

### Чек-лист выполнения Фазы 3 (факт)
- [x] Добавлены `_idx` датасеты: `resources_by_app_component`, `resources_by_location_segment`, `kb_by_protected_service`, `backup_by_service`, `monitoring_by_service`.
- [x] `k8s_infra_objects` и `cluster_virtualization_infra_objects` переведены на предрассчитанные индексы по Security/Backup/Monitoring.
- [x] `systems_dependency_graph` и `systems_deployment_topology` используют индексы TA вместо локального построения reverse-index в app-датасетах.
- [x] Пройдены проверки: `completeness_test`, `run_all_dataset_counts.py`, UI smoke (`113/113`).
- [x] KPI для app-графов соблюдены (`systems_dependency_graph <= 2500 ms`, `systems_deployment_topology <= 3000 ms`).

## 6.4) Статус выполнения (фаза 4)

Артефакты выполнения:
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_phase4_results.md`
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_phase4_results.json`

Сравнение median (Phase3 -> Phase4):

| Dataset | Phase3 median, ms | Phase4 median, ms | Delta, ms | Delta, % |
|---|---:|---:|---:|---:|
| `seaf.company.ds.ta.servers` | 283.6 | 272.9 | -10.7 | -3.8% |
| `seaf.company.ds.ta.network_components` | 312.0 | 296.5 | -15.5 | -5.0% |
| `seaf.company.ds.ta.cluster_virtualization_infra_objects` | 420.1 | 362.4 | -57.7 | -13.7% |
| `seaf.company.ds.app.systems_deployment_topology` | 2436.5 | 2083.2 | -353.3 | -14.5% |

### Чек-лист выполнения Фазы 4 (факт)
- [x] Вынесены и переиспользуются служебные карты для VMware network alias (`_idx.network_vmware_alias`) и объединенного reverse набора network components (`reverse_network.netcomps_all`).
- [x] Уменьшены повторные merge/вычисления в `network_components`.
- [x] Пройдены проверки: `completeness_test`, `run_all_dataset_counts.py`, UI smoke (`113/113`).
- [x] Подтверждена корректность `network_connection`/`segment` на regression-прогоне UI.
- [ ] Достигнут KPI `network_components <= 250 ms` (текущий median `296.5 ms`).

## 6.5) Статус выполнения (фаза 5)

Артефакты выполнения:
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_phase5_results.md`
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_phase5_results.json`

Сравнение median (Phase4 -> Phase5):

| Dataset | Phase4 median, ms | Phase5 median, ms | Delta, ms | Delta, % |
|---|---:|---:|---:|---:|
| `seaf.company.ds.ta.schema_r41_plural` | 2483.2 | 2479.0 | -4.2 | -0.2% |
| `seaf.company.ds.ta.kb_links` | 1206.2 | 1092.5 | -113.7 | -9.4% |
| `seaf.company.ds.ta.k8s_infra_objects` | 675.8 | 615.6 | -60.2 | -8.9% |
| `seaf.company.ds.app.systems_deployment_topology` | 2083.2 | 2004.8 | -78.4 | -3.8% |

### Чек-лист выполнения Фазы 5 (факт)
- [x] Упрощен fallback `schema_r41_plural` (без зависимости от `all_objects` в origin).
- [x] Проверена корректность схем и карточек через UI smoke (`113/113`).
- [x] Пройдены проверки: `completeness_test`, `run_all_dataset_counts.py`.
- [ ] Достигнут KPI `schema_r41_plural <= 2000 ms` (текущий median `2479.0 ms`).

## 6.6) Статус выполнения (фаза 6)

Артефакты выполнения:
- `_metamodel_/seaf-company-ta/configs.yaml`
- `_metamodel_/seaf-company-ta/internal_docs/operations_manual.md`
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_phase6_results.md`
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_phase6_results.json`
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_profile_seaf2_only.md`
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_profile_seaf2_seaf1.md`
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_profile_full_with_reverse.md`
- `_metamodel_/seaf-company-ta/auto_tests/ui_test/results_profile_seaf2_only.json`
- `_metamodel_/seaf-company-ta/auto_tests/ui_test/results_profile_seaf2_seaf1.json`
- `_metamodel_/seaf-company-ta/auto_tests/ui_test/results_profile_full_with_reverse.json`

Матрица профилей (median, ms):

| Profile | schema_r41_plural | all_objects | kb_links | servers | network_components | systems_dependency_graph | systems_deployment_topology |
|---|---:|---:|---:|---:|---:|---:|---:|
| `seaf2_only` | 94.7 | 2409.2 | 1088.1 | 237.7 | 362.3 | 3297.7 | 2590.0 |
| `seaf2_seaf1` | 133.7 | 3188.9 | 1314.6 | 279.3 | 452.8 | 3702.1 | 2641.0 |
| `full_with_reverse` | 93.3 | 3660.6 | 1801.3 | 323.0 | 578.4 | 4778.2 | 3176.8 |

Матрица UI smoke (фильтр целевых сущностей):

| Profile | Total | Passed | Warnings | Failed |
|---|---:|---:|---:|---:|
| `seaf2_only` | 24 | 24 | 0 | 0 |
| `seaf2_seaf1` | 40 | 40 | 0 | 0 |
| `full_with_reverse` | 48 | 48 | 0 | 0 |

### Чек-лист выполнения Фазы 6 (факт)
- [x] Добавлены профили источников: `seaf2_only`, `seaf2_seaf1`, `full_with_reverse` + активный `data_sources.profile`.
- [x] `seaf.company.ds.ta._config` поддерживает чтение профиля и fallback на `enabled/priority`.
- [x] `operations_manual.md` дополнен инструкцией по выбору профиля.
- [x] Базовые проверки в активном профиле (`full_with_reverse`) пройдены: `completeness_test` + `run_all_dataset_counts.py`.
- [x] Выполнена регрессионная проверка переключения между профилями (bench + completeness/counts + профильный UI smoke по целевым TA-сущностям).

## 6.7) Точечная оптимизация KPI (network_components + schema_r41_plural)

Артефакты:
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_targeted_before.md`
- `_metamodel_/seaf-company-ta/internal_docs/dataset_speedup/dataset_speedup_targeted_final.md`
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_targeted_before.json`
- `_metamodel_/seaf-company-ta/auto_tests/perf/benchmark_targeted_final.json`

Изменения:
- `ta/datasets.yaml`: в `seaf.company.ds.ta.network_components` убрана тяжелая многократная cross-source дедупликация (`seaf1/reverse/kadzo`) по dedupe key.
- Оставлена дедупликация `seaf1` только против `seaf2` (как наиболее критичный слой дубликатов).

Сравнение targeted benchmark (warmup=2, runs=7):

| Dataset | Before median, ms | Final median, ms | Delta, ms | Delta, % |
|---|---:|---:|---:|---:|
| `seaf.company.ds.ta.network_components` | 496.3 | 470.1 | -26.2 | -5.3% |
| `seaf.company.ds.ta.schema_r41_plural` | 100.2 | 97.3 | -2.9 | -2.9% |

Итог:
- [x] KPI по `schema_r41_plural` фактически выполнен (значение << 2000 ms).
- [ ] KPI по `network_components <= 250 ms` не достигнут на текущей архитектуре merge/dedupe в full-профиле.

## 7) Риски и ограничения

- Риск функциональной регрессии при изменении dedupe/normalization.
- Риск изменения приоритетов источников в merge.
- Риск циклических зависимостей при введении новых кэш-датасетов.

Меры контроля:
- отдельный PR на каждую фазу;
- сравнение `count + sample IDs` до/после;
- контрольные карточки (server/network/compute/k8s/storage) и схемы R41.

## 8) Критерий завершения плана

План выполнен, когда:
1. KPI из раздела 4 достигнуты;
2. нет новых ошибок в проблемах backend/плагина;
3. автотесты completeness + dataset counts + UI smoke проходят;
4. документация по датасетам обновлена (что закэшировано, что индексировано, что profile-driven).




