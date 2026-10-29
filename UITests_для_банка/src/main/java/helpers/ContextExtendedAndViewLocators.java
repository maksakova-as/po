package helpers;

public enum ContextExtendedAndViewLocators {

    ElEM_INTERNAL_EMPLOYEES_LINK("//*[text()[normalize-space(.)='Внутренние сотрудники']]"),
    CHANNELS_LINK("//*[text()[normalize-space(.)='Каналы взаимодействия с клиентом']]"),
    BUCHUCHET_LINK("//*[text()[normalize-space(.)='Бухучет']]"),
    ACCOUNTING_LINK("//*[text()[normalize-space(.)='Учетная']]"),
    PAY_SERVICE_LINK("//*[text()[normalize-space(.)='Оплата услуг']]"),
    ID_TOKEN_LINK("(//*[text()[normalize-space(.)='id_token,']])[2]"),
    ACCESS_TOKEN_LINK("//div[@class='plantuml-schema']/following::*[text()[contains(normalize-space(.),'access_token')]]"),
    EXTERNAL_LINK("//*[text()[normalize-space(.)='«Внешняя»']]"),
    ATC_LINK("//*[text()[normalize-space(.)='АТС']]"),
    BUSINESS_LINK("//*[text()[normalize-space(.)='Business']]"),
    GOAL_LINK("//*[text()[normalize-space(.)='«Целевая внедрена полностью»']]"),
    EXTERNAL_CLOUD_LINK("//*[text()[normalize-space(.)='Внешнее облако']]"),
    GOAL_PART_LINK("//*[text()[normalize-space(.)='«Целевая частично внедрена»']]"),
    GOAL_CHOOSE_LINK("//*[text()[normalize-space(.)='«Целевая требуется выбор»']]"),
    MARKETPLACE_LINK("//*[text()[normalize-space(.)='Маркетплейс']]"),
    COMMON_ECO_LINK("//*[text()[normalize-space(.)='Объединяющие элементы Экосистемы']]"),
    SOCIAL_LINK("//*[text()[normalize-space(.)='Социальные']]"),
    ITERNAL_EMPLOYEES_LINK("//*[text()[normalize-space(.)='Внутренние сотрудники']]"),
    SYSTEM_MARKETPLACE_LINK("//*[text()[normalize-space(.)='Системы Маркетплейс']]"),
    GOAL_MODIFIED_LINK("//*[text()[normalize-space(.)='«Целевая внедрена полностью»']]"),
    CATALOG_LINK("//*[text()[normalize-space(.)='Каталог']]"),
    CHANNELS_CLIENT_LINK("//*[text()[normalize-space(.)='Каналы взаимодействия с клиентом']]"),
    STATE_LINK("//*[text()[normalize-space(.)='Государство']]"),
    FIREWORK_LINK("//*[text()[normalize-space(.)='Салют']]"),
    MARKETING_LINK("//*[text()[normalize-space(.)='Маркетинговые']]"),
    PROFILE_LINK("//*[text()[normalize-space(.)='profile']]"),
    GIS_LINK("//*[text()[normalize-space(.)='2GIS']]"),
    APM_LINK("//*[text()[normalize-space(.)='АРМ']]"),
    EMAIL_LINK("//*[text()[normalize-space(.)='Email']]"),
    GOV_SERVICES_LINK("//*[text()[normalize-space(.)='Госуслуги']]"),
    CALL_LINK("//*[text()[normalize-space(.)='Колл-центр']]"),
    TEXT_SYSTEMS_MARKETPLASE_IN_OFICE("//*[text()[normalize-space(.)='Системы Маркетплейс в офисе']]"),
    SHLUS_LINK("//*[text()[normalize-space(.)='Шлюз']]"),
    PAY_LINK("//*[text()[normalize-space(.)='платежных']]"),
    DATE_PAY_LINK("//*[text()[normalize-space(.)='платеже']]"),
    SBER_ADS_LINK("//*[text()[normalize-space(.)='SberADS']]"),
    TELEGRAM_LINK("//*[text()[normalize-space(.)='Telegram']]"),
    CUSTOMERS_LINK("//*[text()[normalize-space(.)='Заказчики услуг']]"),
    SBER_PROFILE_LINK("//*[text()[normalize-space(.)='SberProfile']]"),
    ECO_SYSTEM_LINK("//*[text()[normalize-space(.)='Объединяющие элементы Экосистемы']]"),
    SBER_ID_LINK("//*[text()[normalize-space(.)='SberID']]"),
    USER_LINK("//*[text()[normalize-space(.)='пользователя']]"),
    SERVICE_LINK("//*[text()[normalize-space(.)='услугу']]"),
    SBER_CLOUD_LINK("//*[text()[normalize-space(.)='Системы Маркетплейс в SberCloud']]"),
    CONTEXT_LINK("//*[text()[normalize-space(.)='Контекст данных']]"),
    MINSK_SYSTEMS_LOCATOR("//*[text()[normalize-space(.)='Системы МинскинтеркапсБелоруссияа']]"),
    CONTEXT_SYSTEM_LINK("//*[text()[normalize-space(.)='Контекст системы (view данные)']]"),
    CURRENT_SYSTEM_CONTEXT("//*[text()[normalize-space(.)='Текущий контекст системы']]"),
    ANALITIKA_LINK("//*[text()[normalize-space(.)='Аналитика']]"),
    CMEB_LINK("//*[text()[normalize-space(.)='СМЭВ']]"),
    ACCOUNTING_1C_LINK("//*[text()[normalize-space(.)='1C_Бухгалтерия']]"),
    SYSTEM_OFFICE_LINK("//*[text()[normalize-space(.)='Системы Маркетплейс в офисе']]"),
    CRM_LINK("//*[text()[normalize-space(.)='CRM']]"),
    DEALS_LINK("//*[text()[normalize-space(.)='Проведение']]"),

    CLIENT_LINK("//*[text()[contains(normalize-space(.),'клиента')]]"),
    DATE_CARD_LINK("//*[text()[contains(normalize-space(.),'Платежные данные (карты)')]]"),
    OTHER_LINK("//*[text()[contains(normalize-space(.),'«Прочее»')]]"),
    PARAMETERS_LINK("//*[text()[contains(normalize-space(.),'Параметры')]]"),

    PAYMENT_LINK("//*[text()[normalize-space(.)='Pay/Wallet']]"),
    ELEM_EMAIL_LINK(" //*[@id = 'elem_ecogroup.berezka.external_systems.email']"),
    ELEM_SMSC_LINK(" //*[@id ='elem_ecogroup.berezka.external_systems.smsc']"),
    ELEM_TELEGRAM_LINK(" //*[@id ='elem_ecogroup.berezka.external_systems.telegram']"),
    ELEM_ATS_LINK(" //*[@id = 'elem_ecogroup.berezka.external_systems.iptelephony']"),
    ELEM_ESIA_LINK(" //*[@id ='elem_ecogroup.berezka.external_systems.esia']"),
    ELEM_MARKETING_LINK(" //*[@id ='elem_ecogroup.berezka.external_systems.marketing']"),
    ELEM_OFFICE_365_LINK(" //*[@id = 'elem_ecogroup.berezka.external_systems.office365']"),
    ELEM_SMEV_LINK(" //*[@id = 'elem_ecogroup.berezka.external_systems.smev']"),
    ELEM_OLD_OFFICE_LINK(" //*[contains(@id ,'berezka.channels.old_office')]"),
    ELEM_CLIENT_APP_LINK(" //*[contains(@id ,'berezka.channels.client_app')]");

    private String locator;

    public String getLocator() {
        return locator;
    }

    ContextExtendedAndViewLocators(String locator) {
        this.locator = locator;
    }
}
