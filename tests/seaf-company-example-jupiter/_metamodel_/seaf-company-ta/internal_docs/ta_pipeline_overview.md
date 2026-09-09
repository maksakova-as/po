# Техническое устройство связки метамодели, представлений и примера

1. **Источник данных** – YAML из `_metamodel_/seaf-company-ta` (метамодель) и `architecture/ta` (пример) попадают в `seaf.ds.objects_by_entities` и становятся входом для JSONata-запросов.
2. **Датасеты Docs** – файл `Docs/ta_dynamic_reports.yaml` объявляет три датасета: `docs.ta.metamodel.entities`, `docs.ta.metamodel.properties`, `docs.ta.example.capability_matrix`. Они динамически собирают информацию по `seaf.ta.*` и доменным данным Jupiter.
3. **Представления** – в том же YAML определены таблицы `docs.ta.metamodel.entities_table`, `docs.ta.metamodel.properties_table`, `docs.ta.example.capability_matrix_table`, которые сразу готовы к подключению в UI/Docs.
4. **Меню и виджеты** – существующие `presentations/*.yaml` и `widgets/*.yaml` продолжают работать; карточки (`type: mkr-grid`) через `$seaf_fn_combine_widgets` смогут включить новые docs-блоки без доработок.
5. **Документация** – все новые артефакты лежат в `Docs/` и теперь разбиты на подпапки меню `Техническая архитектура`: `.../Метамодель/Сущности`, `.../Метамодель/Свойства`, `.../Пример/Матрица покрытий` (см. `Docs/ta_dynamic_reports.yaml`).
6. **Тестирование** – используется чек-лист `Docs/app_systems_ta_services_widget_testing.md`: перезапуск `archtool`, проверка `/core/storage/problems/`, UI-карточки, дополнительные проверки Playwright (и для карточек, и для docs).
