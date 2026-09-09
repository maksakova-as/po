# {{title}}

-------------------
- ID в арх. репозитории: **{{__id__}}**
- Тип документа: **{{type}}**
- Дата создания: **{{date_created}}**, версия: **{{version}}**
- Статус: **{{status}}**

**Авторы:**

| №  | ФИО | Комментарий             |
|----|-----|-------------------------|
{{#authors}}
|{{number}} |{{name}} |{{comment}}|
{{/authors}}


{{#show_stakeholders}}
_

**Стейкхолдеры:**

| №  | ФИО | Роль | Позиция | Комментарий |
|----|-----|------|---------|-------------|
{{#stakeholders}}
|{{number}} |{{name}} | {{role}} | {{position}} ({{department}}) | {{description}}|
{{/stakeholders}}

{{/show_stakeholders}}