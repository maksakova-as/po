# Задача

Цель — перенести данные из `_metamodel_/SEAF1/iaas/reverse/cloud.ru/advanced` в `seaf-company-example-jupiter/_metamodel_/seaf-company-ta`, сохраняя ссылочную целостность (регион → AZ → DC → сети → сервисы → компоненты).

Основные источники:
- скрипты `_metamodel_/SEAF1/iaas/adv_reverse2seaf/modules/*_converter.py`;
- документация `seaf-dzo-example/_metamodel_/iaas/adv_reverse2seaf` (правила переноса свойств);
- инструкции `seaf-company-example-jupiter/Docs/*.md`.

Рабочие артефакты в `reverse2seaf2`:
- `plan.md` — план и чек-листы по датасетам;
- `log.md` — история валидированных шагов;
- `Docs/get_jsonata.md` и `Docs/operations_manual.md` — порядок проверки JSONata и backend;
- `ta/jsonata_tests` → `ta/dataset_parts` → `_metamodel_/seaf-company-ta/ta/datasets.yaml` — основная цепочка работы с выражениями.

Каждый переносимый ресурс должен пройти цикл: **JSONata тесты → обновление dataset_parts → docker restart → curl проблем и UI**.

