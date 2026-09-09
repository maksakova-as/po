# Бэклог модуля
## Трансформаторы данных SEAF -> КАДЗО
### kadzo.v2023.goals
-[x] Датасет с трансформацией

### kadzo.v2023.strategy
-[x] Датасет с трансформацией

### kadzo.v2023.clients
-[x] Датасет с трансформацией

### kadzo.v2023.products
-[x] Датасет с трансформацией
-[x] конверсия status

### kadzo.v2023.channels
-[x] Датасет с трансформацией
-[x] АС, обеспечивающие функционирование канала
-[x] Размещение/владение = Внешний, Внутренний (Брать из АС)
-[x] этап ЖЦ - конвертить 
-[ ] Способы защиты канала 

### kadzo.v2023.processes
-[x] Датасет с трансформацией
-[ ] ! Связь с интеграциями

### kadzo.v2023.business_objects
-[x] Датасет с трансформацией

### kadzo.v2023.data_objects
-[x] Датасет с трансформацией

### kadzo.v2023.tasks
-[x] Датасет с трансформацией
-[x] трансформировать енум для статуса

### kadzo.v2023.functions
-[x] Датасет с трансформацией

### kadzo.v2023.groups
-[x] Датасет с трансформацией

### kadzo.softwares
-[x] Датасет с трансформацией

### kadzo.v2023.systems
-[x] Датасет с трансформацией
-[x] привязка к группам\тегам
-[ ] change-type, changes - брать из артефакта
-[x] softwares - используемое ПО привязать к АС

### kadzo.v2023.kb_systems
-[x] Датасет с трансформацией

### kadzo.v2023.tech_services 
[//]: # (TODO: Конвертация тех. систем)
-[!] Датасет с трансформацией. Допущение - тенх. АС ведутся в едином реестре АС вместе с прикладными
-[ ] change-type, changes - брать из артефакта

### kadzo.v2023.endpoints
-[x] Датасет с трансформацией
-[ ] ? Не конвертировать сервисы, по которым не задано uri, gates - не считать это точками взаимодейтсвия 

### kadzo.v2023.integrations
-[x] Датасет с трансформацией
-[ ] "status","changes" - связь с артефактами

### [ОТМЕНЕН] kadzo.v2023.tech_params

### kadzo.v2023.criticality_passport
-[ ] ? Датасет с трансформацией


## Ядро валидации
-[ ] kadzo.v2023.validators.schema - raw валидация по схеме всех объектов

## Валидаторы к реализации
-[ ] goals: kadzo.v2023.validators.goals
-[ ] strategy: kadzo.v2023.validators.strategy
-[ ] clients: kadzo.v2023.validators.clients
-[ ] channels: kadzo.v2023.validators.channels
-[ ] products: kadzo.v2023.validators.products
-[ ] processes: kadzo.v2023.validators.processes
-[ ] business_objects: kadzo.v2023.validators.business_objects
-[ ] data_objects: kadzo.v2023.validators.data_objects
-[ ] systems: kadzo.v2023.validators.systems
-[ ] functions: kadzo.v2023.validators.functions
-[ ] groups: kadzo.v2023.validators.groups
-[ ] integrations: kadzo.v2023.validators.integrations
-[ ] kb_systems: kadzo.v2023.validators.kb_systems
-[ ] tasks: kadzo.v2023.validators.tasks
-[ ] tech_services: kadzo.v2023.validators.tech_services
-[ ] tech_params: kadzo.v2023.validators.tech_params
-[ ] unified_elements: kadzo.v2023.validators.unified_elements
-[ ] criticality_passports: kadzo.v2023.validators.criticality_passports
-[ ] domain: kadzo.v2023.validators.domain
-[ ] enterprice_domain: kadzo.v2023.validators.domain_enterprise
-[ ] endpoints: kadzo.v2023.validators.endpoints
-[ ] softwares: kadzo.v2023.validators.softwares

## Идеи
-[ ] Подключить КА ДЗО напрямую к сеаф2:

```yaml
datasets:
   kadzo.v2023.channels:
      origin: seaf.company.ds.kadzo

   kadzo.v2023.products:
      origin: seaf.company.ds.kadzo
sber:
   domain: jupiter
```

## Открытые вопросы (анализ КАДЗО v2025)
1. Совмещение кода для обычного и enterprise режима в одной базе = усложнение поддержки, потенциальные проблемы с производительностью (например регэсп. matcher
   применяется постоянно и для локального режима и для ент. - а это довольно медленная операция)
2. Валидаторы - глобальный массив. Поиск нужных объектов в нем идет по [] - медленная операция
3. Зачем kadzo.manifestschema.extra_links? (дополняет енумы ссылок систем, функций и т.п.)
4. Валидация текущей и целевой архитектуры КА ДЗО - как делаем?
5. В валидаторах (rules.validators) и в датасетах\ функциях валидации есть дублирование кода (например формулировки ошибок). Идеально правила описать в одном месте, потом их транслировать
6. В каналах размещение - муж. рода, в системах - женского. было бы удобрнее среднего везде едино использовать размещение=внешнее
   $result := $val.type != "Стратегическая инициатива"
7. В тасках отсутствует поле description why?
8. В клиентах отсутствует поле description why?
8. В бизнес-объектах отсутствует поле description why?
8. В data-объектах отсутствует поле description why?
8. В integrations отсутствует поле title why?
9. Сильно разный подход Функции - в КАДЗО каждая функция привязана к неск. системам, но статус и целевость одна на функцию. 
В сеаф - функция это тэг. одную и ту же функцию может реализовать сколько угодно систем и этап жц функции свой в контексте данной системы. понятия "целевость" нету
10. Разобраться с формированием меню. КА ДЗО патчит меню docs и SEAF2 патчит меню docs - итоге эти алгоритмы конфликтуют
11. сущность Системы - имеет много атрибутов с тире в названии (live-stage, target-status и т.п.)
12. ТВ КАДЗО отсутствует description why?
13. В системах КА ДЗО комментарии - это строка а не массив! В системах КБ КА ДЗО комментарии - массив!
13. В системах КБ нет ФП! (поле parent отсутствует)
13. В системах КБ нет ownership!
13. В системах КБ нет group!
13. В системах КБ нет атрибутов: performance, rto, rpo, sla
13. В системах КБ status вместо: live-stage, target-status, change-type, changes
13. В системах КБ стадии ЖЦ уникальны - не совпадают с системами и другими объектами
