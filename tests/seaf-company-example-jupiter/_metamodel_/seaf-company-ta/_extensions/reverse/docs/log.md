## 2025-12-09
- Собрал и проверил JSONata-выгрузки для ELB: `_extensions/reverse/dev/jsonata_tests/elb_step1.jsonata`/`elb_step2.jsonata`/`elb_full.jsonata`, убедился, что сборка запускаемого датасета (`reverse2seaf2.ds.ta.reverse.elb_network_components`) лежит в `_metamodel_/seaf-company-ta/ta/datasets.yaml` и доступна по `curl /core/storage/jsonata/reverse2seaf2.ds.ta.reverse.elb_network_components`.
- Отметил в `plan.md`, что задача №5 ("network_components + NAT/VPN/ELB") в процессе, и зафиксировал в `Docs/get_jsonata.md` инструкции по повторному запуску `get_jsonata.py` для туда/обратно проверки.
- Подготовил предварительные фиксы: добавил новые поля `location`/`availabilityzone` для сетевых объектов в `ta/dataset_parts`, проверил мержи в `seaf.company.ds.ta.network_components`, убедился, что данные подтягиваются в UI `entities/seaf.company.ta.components.networks/list`.

## 2025-12-11
- Переписал PlantUML-виджеты `network_component_location_topology` и `network_component_connections`: убрал ссылки `[[...]]`, отключил `arrowFontColor`, добавил функцию `sanitize` для всех заголовков и продолжил использовать `$replace(...,"[^A-Za-z0-9_]","_")` для идентификаторов, чтобы текст не ломал PlantUML 1.2025.2.
- Перезапустил `archtool_reverse_seaf2`, чтобы пересобрать release-датасет и заново загрузить шаблоны; проверка `/core/storage/jsonata/.../network_components` через `get_jsonata.py` подтверждает, что JSON-данные содержат ожидаемые поля `segment`, `location`, `availabilityzone`.
- На фронте по-прежнему виден компонент `DocPlantUML` с текстом "Syntax Error" и `Plugin.log` фиксирует `Argument 4 of function "replace" does not match function signature`, поэтому виджет `network_component_connections` пока не отрисовывается.

## 2025-12-12
- Повторная загрузка `http://127.0.0.1:8080/entities/seaf.company.ta.components.networks/card?id=reverse.netcomp.elb.6d174721-db0e-4758-9a96-2f626e1a6632` возвращает HTML-ошибку DocHub "Cannot GET …/card", но в `plugin.log` всё ещё появляются ошибки `DocPlantUML` в том же месте (`network_component_connections`).
- `DocPlantUML` возвращает: `Error: Argument 4 of function "replace" does not match function signature`. Значит, JSONata-шаблон передаёт лишний аргумент ` "g"` в `$replace`, и PlantUML-диаграмма не строится, поэтому нынче сетевые связи не визуализируются.
- Необходимо ещё раз пройтись по шаблону `network_component_connections`, убрать лишние аргументы `$replace` и/или экранировать строки так, чтобы JSONata и PlantUML совместно работали на ArchTool, а затем снова перезапустить контейнер.

- Исправил ошибку в виджете `network_component_connections` (seaf-company-ta/widgets/network_component.yaml). Заменил строковый паттерн в `$replace` на regex-литерал `/[^A-Za-z0-9_]/` в функции `$clean_id`, так как backend не поддерживал строки как regex. Проверил через `python get_jsonata.py` и скриншот UI: диаграмма связей для сетевого устройства теперь отображается без ошибок.

- Исправил аналогичную ошибку в виджете `server_network_topology` (seaf-company-ta/widgets/server.yaml). Функция `$sanitize` теперь использует литерал регулярного выражения для очистки идентификаторов. Карточка сервера `reverse.server.flix.ecss...` теперь корректно отображает виджеты локации и сетевых подключений.

- Исправил отображение 'технического мусора' в диаграмме сетевых подключений сервера. Добавил фильтрацию узлов сегментов: теперь узел создаётся только при наличии заголовка и entity_id, что исключает пустые ссылки на несуществующие сегменты.
