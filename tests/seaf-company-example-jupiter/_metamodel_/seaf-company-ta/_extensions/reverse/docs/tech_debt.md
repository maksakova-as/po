# Tech Debt: Network & Server Cards

1. Network card (`reverse.network.0d9f37b6-0889-4763-8cf3-20d9641af0c1`) still loads endlessly when rendering the PlantUML widgets (`network_platform_connections`, `network_infra_connections`). Even though datasets now provide `location`/`availabilityzone`, the UI keeps requesting PlantUML and never finishes. Needs deeper investigation (likely widget query size or PlantUML service crash).

2. [IN PROGRESS] Server card (`reverse.server.flix.ecss.e5e60a69-0653-4297-8799-ea0df4f0cacc`) issues.
   **Проблема 1 (PlantUML Error):** Виджет `server_network_topology` падал с ошибкой PlantUML Syntax Error из-за некорректной работы `$replace` со строковыми паттернами (в ID оставались точки).
   **Решение 1:** Использование литерала регулярного выражения `/[^A-Za-z0-9_]/` вместо строки в функции `$sanitize`.

   **Проблема 2 (Technical Garbage):** На диаграмме отображались "битые" узлы сегментов (пустые названия, ссылки вида `/entities//card?id=`).
   **Причина:** Если сервер привязан к сети, но объект сегмента отсутствует в датасете (lookup возвращает `null` или пустой объект), код виджета все равно генерировал узел, конкатенируя `undefined` поля.
   **Попытка исправления:** Внедрение строгой фильтрации в JSONata: узел сегмента (`segment_node`) формируется только при наличии всех ключевых полей (`__id__`, `title`, `__entity_id__`).
   **Текущий статус:** Файл виджета `server.yaml` восстановлен к исходному состоянию. Требуется повторное "чистовое" применение обоих исправлений.

3. [FIXED] Виджет `network_component_connections` падал с ошибкой `Argument 4 of function "replace"`.
   **Проблема:** В JSONata-выражении использовалась функция `$replace($id, "[^A-Za-z0-9_]", "_")`. В текущей среде выполнения (DocHub backend) строковый аргумент паттерна интерпретировался буквально, а не как регулярное выражение, что приводило к некорректной замене (или отсутствию замены) символов вроде точек в ID. Это создавало недопустимые идентификаторы для PlantUML (например, `dev_reverse.netcomp...`), вызывая Syntax Error. Ошибка "Argument 4..." возникала из-за особенностей внутренней реализации парсера при передаче флагов.
   **Решение:** Строковый паттерн заменен на литерал регулярного выражения JSONata: `/[^A-Za-z0-9_]/`. Также добавлена явная функция `$clean_id` для нормализации идентификаторов перед вставкой в шаблон диаграммы.