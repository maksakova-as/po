# План работ: модернизация и ускорение TA-датасетов

Этот файл дополняет идеи из `Docs/ta_datasets_performance_ideas.md` и содержит чек-лист по изменениям и проверкам.

## Общий порядок работ для каждого изменения
1) До изменения: замерить производительность будущего запроса (3 раза через `$eval`).
1a) Перед изменением выполнить 3 прогона для «будущего» JSONata-выражения (через прямой запрос в backend), чтобы понять, есть ли смысл в оптимизации.
2) Внести изменение в датасет.
3) Перезапустить контейнер и подождать 40-60 секунд.
4) После изменения: повторить замер (3 раза через `$eval`).
5) Прогнать скриптовую проверку (см. строку в таблице).
6) Проверить зависимую страницу UI (list/card), чтобы данные отображались и UI не ломался.

## Как измерять скорость датасетов
Замеры делаем через прямой вызов `source` через `$eval`, чтобы измерять именно построение датасета,
а не отдачу возможного кэша.
Пример (PowerShell):
```powershell
$id = "seaf.company.ds.ta.network_segments"
$expr = "($eval(datasets.`"$id`".source; $))"
$encoded = [System.Uri]::EscapeDataString($expr)
curl.exe -s -o NUL -w "time_total=%{time_total}`nhttp_code=%{http_code}`n" "http://127.0.0.1:8080/core/storage/jsonata/$encoded"
```
Важно: в этом API аргументы функций JSONata разделяются `;` (например, `$eval(...; $)`).
Результат фиксируем в таблице: `pre x3` и `post x3` (секунды).
Примечание: для уже выполненных датасетов до введения правила `pre x3` можно переснять замеры.

## Глобальные проверки после набора изменений
- Completeness: `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py`
- UI smoke: `node _metamodel_/seaf-company-ta/auto_tests/ui_test/run_ui_smoke_test.js`

Примечание: `test_dataset_count.py` ищет `get_jsonata.py` в текущей папке.
Сейчас рабочий вариант лежит в `junk/get_jsonata.py`, поэтому запускать тест нужно из `junk/`
или скопировать скрипт в корень репозитория (если это допустимо по правилам проекта).

---

## Чек-лист: TA-датасеты (seaf.company.ds.ta.*)

| Готово | Датасет | Изменение | Backend pre/post (eval x3) | Прирост, % | Скриптовая проверка | UI проверка |
| --- | --- | --- | --- | --- | --- | --- |
| [x] | `seaf.company.ds.ta._config` | Новый общий конфиг (enabled/priority) | pre: 0.009249 (500) / post: 0.007274 (200) | ___ | `python _metamodel_/seaf-company-ta/auto_tests/test_dataset_count.py seaf.company.ds.ta._config` | N/A (служебный) |
| [x] | `seaf.company.ds.ta.dc_regions` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre: 0.286325 (cache) / post: 0.208212 (cache) / eval: 0.016405 (200) / post x3: 0.004194, 0.025726, 0.005100 | ___ | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "dc_regions"` | `/entities/seaf.company.ta.services.dc_regions/list` + card id |
| [x] | `seaf.company.ds.ta.dc_azs` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre eval: 0.008208 (200) / post eval: 0.012907 (200) / post x3: 0.005846, 0.003600, 0.003530 | ___ | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "dc_azs"` | `/entities/seaf.company.ta.services.dc_azs/list` + card id |
| [x] | `seaf.company.ds.ta.dcs` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.004433, 0.003578, 0.003479 / post x3: 0.004399, 0.003908, 0.003509 | +9.22% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "dcs"` | `/entities/seaf.company.ta.services.dcs/list` + card id |
| [x] | `seaf.company.ds.ta.dc_offices` | Оптимизация merge/источников (cfg + ленивый seaf1) | pre x3: 0.004591, 0.003635, 0.003883 / post x3: 0.005140, 0.003864, 0.003759 | -0.49% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "dc_offices"` | `/entities/seaf.company.ta.services.dc_offices/list` + card id |
| [x] | `seaf.company.ds.ta.networks` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.025326, 0.004270, 0.003732 / post x3: 0.005075, 0.003374, 0.003668 | -14.10% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "networks"` | `/entities/seaf.company.ta.services.networks/list` + card id |
| [x] | `seaf.company.ds.ta.network_segments` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.023278, 0.004074, 0.003525 / post x3: 0.005164, 0.003818, 0.003568 | -6.28% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "network_segments"` | `/entities/seaf.company.ta.services.network_segments/list` + card id |
| [x] | `seaf.company.ds.ta.network_links` | Оптимизация merge/источников (cfg + ленивый seaf1) | pre x3: 0.021378, 0.003782, 0.003635 / post x3: 0.004846, 0.014163, 0.003848 | +28.13% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "network_links"` | `/entities/seaf.company.ta.services.network_links/list` + card id |
| [x] | `seaf.company.ds.ta.logical_links` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.004774, 0.003839, 0.020458 / post x3: 0.005488, 0.004205, 0.023899 | +14.96% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "logical_links"` | `/entities/seaf.company.ta.services.logical_links/list` + card id |
| [x] | `seaf.company.ds.ta.software` | Оптимизация merge/источников (cfg + ленивый seaf1) | pre x3: 0.005008, 0.004177, 0.016420 / post x3: 0.027553, 0.019830, 0.003761 | +295.97% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "software"` | `/entities/seaf.company.ta.services.softwares/list` + card id |
| [x] | `seaf.company.ds.ta.compute_services` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.003837, 0.002955, 0.015806 / post x3: 0.004999, 0.013421, 0.003560 | +30.28% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "compute_services"` | `/entities/seaf.company.ta.services.compute_services/list` + card id |
| [x] | `seaf.company.ds.ta.clusters` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.004181, 0.003675, 0.003070 / post x3: 0.024962, 0.003554, 0.023143 | +529.74% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "clusters"` | `/entities/seaf.company.ta.services.clusters/list` + card id |
| [x] | `seaf.company.ds.ta.cluster_virtualizations` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.003661, 0.003152, 0.004115 / post x3: 0.016880, 0.020805, 0.020109 | +449.28% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "cluster_virtualizations"` | `/entities/seaf.company.ta.services.cluster_virtualizations/list` + card id |
| [x] | `seaf.company.ds.ta.storages` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.005802, 0.005963, 0.005483 / post x3: 0.009431, 0.005539, 0.004280 | -4.53% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "storages"` | `/entities/seaf.company.ta.services.storages/list` + card id |
| [x] | `seaf.company.ds.ta.hw_storages` | централизация config (cfg) и включение/выключение seaf2-источника | pre x3: 0.043337, 0.028206, 0.035931 / post x3: 0.041974, 0.025128, 0.047773 | +16.82% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "hw_storages"` | `/entities/seaf.company.ta.components.hw_storages/list` + card id |
| [x] | `seaf.company.ds.ta.servers` | Оптимизация merge/источников (cfg + ленивый seaf1/reverse) | pre x3: 0.007234, 0.005488, 0.005627 / post x3: 0.020065, 0.008831, 0.009447 | +67.89% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "servers"` | `/entities/seaf.company.ta.components.servers/list` + card id |
| [x] | `seaf.company.ds.ta.k8s` | централизация config (cfg) + ленивые seaf1/reverse | pre x3: 0.047640, 0.044464, 0.053421 / post x3: 0.043909, 0.047405, 0.048683 | -0.49% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "k8s"` | `/entities/seaf.company.ta.services.k8s/list` + card id |
| [x] | `seaf.company.ds.ta.backup` | централизация config (cfg) + ленивые seaf1/reverse | pre x3: 0.054150, 0.032247, 0.047974 / post x3: 0.035041, 0.055185, 0.027932 | -26.96% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "backup"` | `/entities/seaf.company.ta.services.backups/list` + card id |
| [x] | `seaf.company.ds.ta.monitoring` | централизация config (cfg) + ленивые seaf1/reverse | pre x3: 0.044665, 0.040499, 0.061815 / post x3: 0.036981, 0.058699, 0.034581 | -17.20% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "monitoring"` | `/entities/seaf.company.ta.services.monitorings/list` + card id |
| [x] | `seaf.company.ds.ta.kb` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.034265, 0.029550, 0.033096 / post x3: 0.042389, 0.030287, 0.031753 | -4.06% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "kb"` | `/entities/seaf.company.ta.services.kbs/list` + card id |
| [x] | `seaf.company.ds.ta.network_components` | централизация config (cfg) + ленивые seaf1/reverse | pre x3: 0.060664, 0.043343, 0.035776 / post x3: 0.038927, 0.046057, 0.033158 | -10.19% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "network_components"` | `/entities/seaf.company.ta.components.networks/list` + card id |
| [x] | `seaf.company.ds.ta.user_devices` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.072240, 0.072886, 0.071406 / post x3: 0.095707, 0.094832, 0.094587 | +31.27% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "user_devices"` | `/entities/seaf.company.ta.components.user_devices/list` + card id |
| [x] | `seaf.company.ds.ta.environments` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.102384, 0.060865, 0.090280 / post x3: 0.072175, 0.055676, 0.056248 | -37.70% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "environments"` | `/entities/seaf.company.ta.services.environments/list` + card id |
| [x] | `seaf.company.ds.ta.stands` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.035033, 0.051875, 0.050130 / post x3: 0.032919, 0.038678, 0.030236 | -34.33% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "stands"` | `/entities/seaf.company.ta.services.stands/list` + card id |
| [x] | `seaf.company.ds.ta.k8s_namespaces` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.068101, 0.072389, 0.085405 / post x3: 0.040187, 0.035901, 0.034643 | -50.41% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "k8s_namespaces"` | `/entities/seaf.company.ta.components.k8s_namespaces/list` + card id |
| [x] | `seaf.company.ds.ta.k8s_deployments` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.047352, 0.051191, 0.039532 / post x3: 0.046327, 0.033493, 0.036118 | -23.72% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "k8s_deployments"` | `/entities/seaf.company.ta.services.k8s_deployments/list` + card id |
| [x] | `seaf.company.ds.ta.k8s_hpas` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.055284, 0.063713, 0.062666 / post x3: 0.030084, 0.033662, 0.030227 | -51.76% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "k8s_hpas"` | `/entities/seaf.company.ta.components.k8s_hpa/list` + card id |
| [x] | `seaf.company.ds.ta.k8s_nodes` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.033101, 0.039390, 0.048534 / post x3: 0.034768, 0.045975, 0.032706 | -11.73% | `python _metamodel_/seaf-company-ta/auto_tests/completeness_test/check_data_flow.py "k8s_nodes"` | `/entities/seaf.company.ta.components.k8s_nodes/list` + card id |
| [x] | `seaf.company.ds.ta.k8s_cluster_objects` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.031572, 0.036067, 0.041559 / post x3: 0.040244, 0.036478, 0.044151 | +11.58% | `python _metamodel_/seaf-company-ta/auto_tests/test_dataset_count.py seaf.company.ds.ta.k8s_cluster_objects` | Проверка карточки кластера `/entities/seaf.company.ta.services.k8s/card?id=<id>` |
| [x] | `seaf.company.ds.ta.k8s_infra_objects` | централизация config (cfg) + включение/выключение seaf2-источника | pre x3: 0.058752, 0.027134, 0.051081 / post x3: 0.045378, 0.036167, 0.034839 | -29.20% | `python _metamodel_/seaf-company-ta/auto_tests/test_dataset_count.py seaf.company.ds.ta.k8s_infra_objects` | Проверка карточки кластера `/entities/seaf.company.ta.services.k8s/card?id=<id>` |
| [x] | `seaf.company.ds.ta.kb_links` | Оптимизация связей KB | pre x3: 0.028288, 0.033286, 0.027170 / post x3: 0.040371, 0.043031, 0.040377 | +42.74% | `python ..\_metamodel_\seaf-company-ta\auto_tests\test_dataset_count.py seaf.company.ds.ta.kb_links` (cwd: `junk`) | Проверка карточки KB `/entities/seaf.company.ta.services.kbs/card?id=<id>` |
| [x] | `seaf.company.ds.ta.all_objects` | Оптимизация общего merge/fallback | pre x3: 0.031101, 0.039930, 0.026644 / post x3: 0.032526, 0.055256, 0.034055 | +9.50% | `python ..\_metamodel_\seaf-company-ta\auto_tests\test_dataset_count.py seaf.company.ds.ta.all_objects` (cwd: `junk`) | Проверка карточки KB `/entities/seaf.company.ta.services.kbs/card?id=<id>` |

---

## Чек-лист: Reverse-датасеты (reverse2seaf2.ds.ta.reverse.*)

Для reverse-части предполагается скриптовая проверка через JSONata-скрипт. В репозитории есть `junk/get_jsonata.py`.
Если потребуется, можно перенести/скопировать его в рабочую папку reverse.

| Готово | Датасет | Изменение | Backend pre/post (eval x3) | Прирост, % | Скриптовая проверка | UI проверка |
| --- | --- | --- | --- | --- | --- | --- |
| [x] | `reverse2seaf2.ds.ta.reverse.dc_regions` | Оптимизация вычисления регионов | pre x3: 0.041258, 0.056578, 0.044074 / post x3: 0.054141, 0.053554, 0.043718 | +21.52% | `python ..\_metamodel_\seaf-company-ta\auto_tests\test_dataset_count.py reverse2seaf2.ds.ta.reverse.dc_regions` (cwd: `junk`) | `/entities/seaf.company.ta.services.dc_regions/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.dc_az` | Оптимизация вычисления AZ | pre x3: 0.039660, 0.035808, 0.030957 / post x3: 0.056332, 0.039157, 0.035221 | +9.35% | `python ..\_metamodel_\seaf-company-ta\auto_tests\test_dataset_count.py reverse2seaf2.ds.ta.reverse.dc_az` (cwd: `junk`) | `/entities/seaf.company.ta.services.dc_azs/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.dcs` | Оптимизация вычисления DC | pre x3: 0.040286, 0.061153, 0.031337 / post x3: 0.033443, 0.027052, 0.037503 | -16.99% | `python ..\_metamodel_\seaf-company-ta\auto_tests\test_dataset_count.py reverse2seaf2.ds.ta.reverse.dcs` (cwd: `junk`) | `/entities/seaf.company.ta.services.dcs/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.network_segments` | Оптимизация сегментов | pre x3: 0.026462, 0.036900, 0.026683 / post x3: 0.048882, 0.041814, 0.036398 | +56.69% | `python ..\_metamodel_\seaf-company-ta\auto_tests\test_dataset_count.py reverse2seaf2.ds.ta.reverse.network_segments` (cwd: `junk`) | `/entities/seaf.company.ta.services.network_segments/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.networks` | Оптимизация сетей | pre x3: 0.036068, 0.030270, 0.032792 / post x3: 0.038773, 0.034303, 0.037887 | +15.54% | `python ..\_metamodel_\seaf-company-ta\auto_tests\test_dataset_count.py reverse2seaf2.ds.ta.reverse.networks` (cwd: `junk`) | `/entities/seaf.company.ta.services.networks/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.elbs` | Оптимизация ELB | pre: 0.047567 (eval) / post: 0.032051 (eval) | +32.62% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/elb_full.jsonata` | `/entities/seaf.company.ta.services.compute_services/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.dmss_clusters` | Оптимизация DMSS | pre: 0.037007 (eval) / post: 0.036424 (eval) | +1.57% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/dmss_clusters_full.jsonata` | `/entities/seaf.company.ta.services.clusters/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.rdss_clusters` | Оптимизация RDSS | pre: 0.043093 (eval) / post: 0.034896 (eval) | +19.02% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/rdss_clusters_full.jsonata` | `/entities/seaf.company.ta.services.clusters/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.cluster_virtualizations` | Оптимизация виртуализации | pre: 0.033994 (eval) / post: 0.038485 (eval) | -13.21% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/cluster_virtualizations_full.jsonata` | `/entities/seaf.company.ta.services.cluster_virtualizations/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.storages` | Оптимизация storage | pre: 0.039509 (eval) / post: 0.030051 (eval) | +23.93% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/storages_full.jsonata` | `/entities/seaf.company.ta.services.storages/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.backups` | Оптимизация backup | pre: 0.035220 (eval) / post: 0.028825 (eval) | +18.15% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/backups_full.jsonata` | `/entities/seaf.company.ta.services.backups/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.servers` | Оптимизация servers | pre: 0.029538 (eval) / post: 0.033747 (eval) | -14.25% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/servers_full.jsonata` | `/entities/seaf.company.ta.components.servers/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.k8s` | Оптимизация k8s | pre: 0.030384 (eval) / post: 0.032900 (eval) | -8.28% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/k8s_full.jsonata` | `/entities/seaf.company.ta.services.k8s/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.monitoring` | Оптимизация monitoring | pre: ERROR (eval) / post: 0.033629 (eval) | FIXED | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/monitoring_full.jsonata` | `/entities/seaf.company.ta.services.monitorings/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.logical_links` | Оптимизация logical_links | pre: 0.094186 (eval) / post: 0.028550 (eval) | +69.68% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/logical_links_full.jsonata` | `/entities/seaf.company.ta.services.logical_links/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.network_components` | Оптимизация network_components | pre: 0.254257 (eval) / post: 0.048337 (eval) | +80.98% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/network_components_full.jsonata` | `/entities/seaf.company.ta.components.networks/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.nat_gateways` | Оптимизация NAT | pre: 0.175684 (eval) / post: 0.018212 (eval) | +89.63% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/nat_gateways_full.jsonata` | `/entities/seaf.company.ta.components.networks/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.vpn_gateways` | Оптимизация VPN | pre: 0.134900 (eval) / post: 0.035128 (eval) | +73.95% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/vpn_gateways_full.jsonata` | `/entities/seaf.company.ta.components.networks/list` + card id (reverse.*) |
| [x] | `reverse2seaf2.ds.ta.reverse.elb_network_components` | Оптимизация ELB как netcomp | pre: 0.143652 (eval) / post: 0.019189 (eval) | +86.64% | `python junk/get_jsonata.py reverse2seaf2/ta/jsonata_tests/elb_net_full.jsonata` | `/entities/seaf.company.ta.components.networks/list` + card id (reverse.*) |

Примечание: если нужного `*_full.jsonata` нет, его нужно создать в `reverse2seaf2/ta/jsonata_tests/` перед запуском скрипта.

## Чек-лист: App Integration (seaf.company.ds.app.*)

Эти датасеты связывают прикладной слой с техническим.

| Готово | Датасет | Изменение | Backend pre/post (eval x3) | Прирост, % | Скриптовая проверка | UI проверка |
| --- | --- | --- | --- | --- | --- | --- |
| [x] | `seaf.company.ds.app.systems_dependency_graph` | Оптимизация (инвертированный индекс) | pre: 0.049958 (eval) / post: 0.032468 (eval) | +35.01% | `curl ...` | Карточка системы (граф) |
| [x] | `seaf.company.ds.app.systems_deployment_topology` | Оптимизация (инвертированный индекс) | pre: 0.030670 (eval) / post: 0.029198 (eval) | +4.80% | `curl ...` | Карточка системы (топология) |
