# Скрипт `get_jsonata.py`

Инструмент помогает прогонять JSONata-выражения напрямую через backend (только GET) без ручного URL-энкода.

## Что делает скрипт
- читает файл с выражением (UTF-8);
- убирает завершающие переводы строк, кодирует выражение для URL;
- отправляет `GET http://127.0.0.1:8080/core/storage/jsonata/(expr)` и печатает ответ backend как есть.

## Как пользоваться
1. Создайте тестовое выражение, например `_extensions/reverse/dev/jsonata_tests/vpn_step1.jsonata`.
2. Выполните:
   ```bash
   python get_jsonata.py _extensions/reverse/dev/jsonata_tests/vpn_step1.jsonata
   ```
3. Проанализируйте вывод:
   - HTTP 200 + JSON — выражение валидно;
   - HTTP 500 + `Expected '}' got ';'` — исправляем скобки до переноса в датасет.
4. Сохраните результат проверки в `reverse2seaf2/log.md`.

## Рекомендации
- Двигайтесь по шагам: `*_step1` (count), `*_step2` (проекция), `*_full` (payload).
- Перед копированием выражения в `dataset_parts/*.yaml` всегда прогоняйте `*_full`.
- Скрипт ничего не пишет на диск, так что можно использовать его в пайплайне тестов.

## Проверка серверов
- Для контроля полей `location` и `availabilityzone` в импортированных серверах можно запросить текущий датасет напрямую:
  ```bash
  curl -s http://127.0.0.1:8080/core/storage/jsonata/reverse2seaf2.ds.ta.reverse.servers | jq '.["reverse.server.flix.ecss.e5e60a69-0653-4297-8799-ea0df4f0cacc"] | {location, availabilityzone}'
  ```
- Ответ должен показывать ссылки на `reverse.dc.*` и `reverse.dc_az.*`, что гарантирует кликабельность ЦОД/АЗ на карточке.
- ??? ????? ?????????? ??????? `reverse.network.*`/`reverse.netcomp.*` ??????? ?????????: curl -s http://127.0.0.1:8080/core/storage/jsonata/reverse2seaf2.ds.ta.reverse.networks | jq '."reverse.network.0d9f37b6-0889-4763-8cf3-20d9641af0c1" | {location, availabilityzone}' — ??????? ?????? `reverse.dc.*` + `reverse.dc_az.*`.
- ????? ???????? `reverse.dc.*`/`reverse.dc_az.*` ??????? ??????????/AZ (????? ????????? ?????????? `reverse.dc.ru-moscow-1c`), ?????? ??????? `/entities/seaf.company.ta.services.dcs/card?id=...`  ??? `/entities/seaf.company.ta.services.dc_azs/card?id=...` — ??????? ??? ?????? ??? UI.
- Для vault/storage проверок: curl -s http://127.0.0.1:8080/core/storage/jsonata/reverse2seaf2.ds.ta.reverse.storages | jq '.\"flix.vaults.25bd50a1-20a3-4ca7-b84a-d9f6dda9a65c\" | {location, availabilityzone, network_connection}'` и аналогично для `reverse2seaf2.ds.ta.reverse.backups`.
- Проверка кластеров виртуализации: `curl -s http://127.0.0.1:8080/core/storage/jsonata/reverse2seaf2.ds.ta.reverse.cluster_virtualizations | jq '.["reverse.cluster_virtualization.9f7dcs8823ed23e9cwe223ecwe22236.vm"] | {location, network_connection}'` — убеждаемся, что список `location` содержит `reverse.dc.*`/`reverse.dc_az.*`, а `network_connection` заполнен.
- Проверка Kubernetes: `curl -s http://127.0.0.1:8080/core/storage/jsonata/reverse2seaf2.ds.ta.reverse.k8s | jq '.["reverse.k8s.a8350fe7-cfdd-11ed-9fc0-0255ac100088"] | {location, availabilityzone, network_connection}'` — убеждаемся, что AZ/сети и ссылка на карточку присутствуют.
- Проверка ELB как сетевых устройств: `python get_jsonata.py _extensions/reverse/dev/jsonata_tests/elb_net_full.jsonata` и `curl -s http://127.0.0.1:8080/core/storage/jsonata/reverse2seaf2.ds.ta.reverse.elb_network_components | jq '."reverse.netcomp.elb.<id>" | {segment, location, availabilityzone}'` — убеждаемся, что segment тянется из reverse2seaf2.ds.ta.reverse.networks, а location/availabilityzone совпадают с подсетями.
- ?????? peering/vpn/eip ???????????: `python get_jsonata.py _extensions/reverse/dev/jsonata_tests/logical_links_full.jsonata` (payload ????? reverse-dataset) + `python -c "import json, urllib.request; data = json.load(urllib.request.urlopen('http://127.0.0.1:8080/core/storage/jsonata/seaf.company.ds.ta.logical_links')); print([k for k in data if k.startswith('reverse.link.')])"` — ???????? `reverse.link.peering.*`, `reverse.link.vpn.*`, `reverse.link.eip.*` ?????????? ? `seaf.company.ds.ta.logical_links`.

