{{#show}}

| №  |  Объект | Тип | Вид изменения | Срок | Описание изменения |
|----|---------|-----|---------------|------|--------------------|
{{#changed_objects}}
{{#object_link}}
|{{number}}| [{{object_title}} ({{object_id}})]({{object_link}}) | {{object_type}} | {{change_type}} | {{change_finish_date}} | {{change_description}} |
{{/object_link}}
{{^object_link}}
|{{number}}| {{object_title}} ({{object_id}})| {{object_type}} | {{change_type}} | {{change_finish_date}} | {{change_description}} |
{{/object_link}}
{{/changed_objects}}
{{/show}}
