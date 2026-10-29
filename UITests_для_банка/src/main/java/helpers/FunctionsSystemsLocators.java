package helpers;

public enum FunctionsSystemsLocators {

    AUTH_LINK("//*[text()[normalize-space(.)='Аутентификация пользователей']]"),
    CONDUCTING_TRANSACTIONS_LINK("//*[text()[normalize-space(.)='Проведение сделок']]"),
    BUCH_LINK("//*[text()[normalize-space(.)='Бухучет']]"),
    PARAMETERS_LINK("//*[text()[normalize-space(.)='Параметры производительности и надежности']]"),
    NOT_DATA_FUNCTION_LINK("//*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    GIS_FUNCTION_LINK("//*[text()[normalize-space(.)='2GIS']]"),
    PERFORMANCE_DATA_LINK("//*[text()[contains(normalize-space(.),'Обработка не менее 150 запросов')]]"),
    MARKET_FUNCTION_LINK("//*[text()[normalize-space(.)='Маркетинговые рассылки']]"),
    NOT_BUSINESS_PROCESSES_LINK("//*[@colspan = '2']/descendant-or-self::*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    NOT_SYSTEM_OBJECTS_LINK("//*[@colspan = '3']/descendant-or-self::*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    NOT_SYSTEM_COMPONENTS_LINK("//*[@colspan = '4']/descendant-or-self::*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    HIGH_ACCESS_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Высокая доступность объекта управления (HA)') or contains(normalize-space(.),'Высокая доступность компонента (HA)')]]"),
    NOT_SOFTWARE_LINK("//*[@colspan = '1']/descendant-or-self::*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    NOT_DATA_CHANNELS_LINK("//*[@colspan = '7']/descendant-or-self::*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    PERFORMANCE_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Производительность')]]"),
    RPO_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'RPO (час)')]]"),
    RTO_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'RTO (час)')]]"),
    ACCESS_LEVEL_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Уровень доступности')]]"),
    MONITORING_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Средства мониторинга')]]"),
    SCALABILITY_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Масштабируемость')]]"),
    RESERVATION_TYPE_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Тип резервирования в пределах одной зоны доступности')]]"),
    RESERVATION_FULL_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Полнота резервирования в пределах одной зоны доступности')]]"),
    RESERVATION_DR_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Катастрофоустойчивость объекта управления (DR)') or contains(normalize-space(.),'Резервирование компонента (DR)')]]"),
    RESERVATION_TYPE_ZONE_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Тип резервирования в резервных зонах доступности')]]"),
    RESERVATION_FULL_ZONE_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Полнота резервирования в резервных зонах доступности')]]"),
    RESERVATION_BACKUP_ZONE_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Резервное копирование (место хранение бекапа)')]]"),
    RESERVATION_BACKUP_COPY_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Резервное копирование дубликата (место хранения дубликата резервной копии)')]]"),
    ASSESSMENT_DATA("//*[text()[contains(normalize-space(.),'Отклонения по итогам последней Оценки')]]"),
    ASSESSMENT_DATA_NOT_EXIST("//*[text()[contains(normalize-space(.),'Данные о проведении Оценки не найдены')]]"),
    SYSTEM_CONTEXT_LINK("//div[@role='tab' and text()[contains(normalize-space(.),'Контекст системы уровня L2')]]"),
    SQL_LINK("//*[text()[normalize-space(.)='MySQL']]"),
    SQL_TECH_LINK("//a[text()[normalize-space(.)='ecogroup.berezka.systems.berezka.catalog']]"),
    STATISTICS_LINK("//a[text()[normalize-space(.)='Статистика по услугам']]"),
    TICKET_LINK("//a[text()[normalize-space(.)='Заявки на услугу']]"),
    DATABASE_LINK("//td[text()[normalize-space(.)='База данных']]"),
    CRM_BITRIX_LINK("//td[text()[normalize-space(.)='CRM Битрикс 24']]"),
    NGINX_LINK("//a[text()[normalize-space(.)='Балансировка нагрузки (NGINX)']]"),
    SEND_SMS_LINK("//*[text()[normalize-space(.)='Отправка СМС']]"),
    COLL_CENTER_LINK("//a[text()[normalize-space(.)='Колл-центр']]"),
    CMEW_LINK("//*[text()[normalize-space(.)='СМЭВ']]"),
    WEB_APPLICATION_LINK("//*[text()[normalize-space(.)='Web-приложение']]"),
    ARM_LINK("//a[text()[normalize-space(.)='АРМ']]"),
    PERFORMER_SELECTION_LINK("//*[text()[contains(normalize-space(.),'Подбор исполнителя')]]"),
    OWN_LINK("//*[text()[contains(normalize-space(.),'Степень владения')]]"),
    DATA_PERSONAL_LINK("//td[text()[normalize-space(.)='Перс данные']]"),
    OWN_CODE_LINK("//*[text()[contains(normalize-space(.),'Владеем исходным кодом')]]"),
    OWN_EXAMPLE_LINK("//*[text()[contains(normalize-space(.),'Владеем экземпляром')]]"),
    STEP_OF_LIFE_CYCLE_LINK("//*[text()[contains(normalize-space(.),'Этап жизненного цикла (текущий)')]]"),
    EXTERNAL_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'Внешняя')]]"),
    OLD_OFFICE_LINK("//*[text()[normalize-space(.)='Старый офис']]"),
    BITRIX_LINK("//*[text()[normalize-space(.)='Битрикс24']]"),
    SOCIAL_NETWORK_LINK("//*[text()[normalize-space(.)='Социальные сети']]"),
    ACCOUNTING_LINK("//*[text()[normalize-space(.)='Учет сделок']]"),
    BUSINESS_SECRET_LINK("//td[text()[normalize-space(.)='Коммерческая тайна']]"),
    IN_USE_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'Используется')]]"),
    COMMERCIAL_OPERATION_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'Промышленная эксплуатация')]]"),
    IN_DEVELOP_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'В разработке / приобретение')]]"),
    ARCHIVE_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'Архив')]]"),
    NOT_GOAL_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'Не целевая')]]"),
    EXPERIENCE_OPERATION_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'Опытная эксплуатация')]]"),
    SERVICE_MANAGEMENT_LINK("//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Идентификатор IHCI в ITSM')]]"),
    EXTERNAL_CLOUD_LINK("//code[text()[normalize-space(.)='Внешнее облако']]"),
    PARTNERS_SYSTEM_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'Система партнера')]]"),
    NOT_LOCATOR("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'Нет')]]"),
    EXTERNAL_PARTNERS_AND_SERVICES_LINK("//code[text()[normalize-space(.)='Внешние партнеры и сервисы']]"),
    ACCESSIBILITY_LINK("//code[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'95')]]"),
    RTO_DATA_LINK("(//*[@class='language-markuper-form-field' and text()[contains(normalize-space(.),'24')]])[1]"),
    MARKETPLACE_LOCATOR("//code[text()[contains(normalize-space(.),'Системы Маркетплейс')]]"),
    PROMETHEUS_LINK("//*[text()[contains(normalize-space(.),'Prometheus')]]");

    private String locator;

    public String getLocator() {
        return locator;
    }

    FunctionsSystemsLocators(String locator) {
        this.locator = locator;
    }
}
