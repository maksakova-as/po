Период планируемых изменений с **{{change_start_date}}** по **{{change_finish_date}}**

{{#show_activities}}
Изменения производятся в рамках инициатив компании:

| №  | Инициатива | Тип | Тек. статус | Комментарий  |
|----|------------|-----|-------------|--------------|
{{#activities}}
{{#activity_link}}
|{{number}} | [{{activity_title}} ({{activity_id}})]({{activity_link}}) | {{activity_type}} | {{activity_status}} | {{comment}}|
{{/activity_link}}
{{^activity_link}}
|{{number}}|{{activity_id}} | {{activity_title}} | {{activity_type}} | {{activity_status}} | {{comment}}|
{{/activity_link}}
{{/activities}}
{{/show_activities}}
