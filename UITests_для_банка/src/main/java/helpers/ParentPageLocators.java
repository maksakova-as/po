package helpers;

public enum ParentPageLocators {

    GIS_2_LINK_TAB("//*[text()[contains(normalize-space(.),'2GIS')]]"),
    EMAIL_LINK_TAB("//*[text()[contains(normalize-space(.),'Email')]]"),
    SMSC_LINK_TAB("//*[text()[contains(normalize-space(.),'SMSC')]]"),
    TELEGRAM_LINK_TAB("//*[text()[contains(normalize-space(.),'Telegram')]]"),
    ATC_LINK_TAB("//*[text()[contains(normalize-space(.),'АТС')]]"),
    GOVERNMENT_SERVICE_LINK_TAB("//*[text()[contains(normalize-space(.),'Госуслуги')]]"),
    NEWSLETTERS_LINK_TAB("//*[text()[contains(normalize-space(.),'Маркетинговые рассылки')]]"),
    OFFICE_365_LINK_TAB("//*[text()[contains(normalize-space(.),'Офис365')]]"),
    SMAV_LINK_TAB("//*[text()[contains(normalize-space(.),'СМЭВ')]]"),
    ACCOUNTING_1C_LINK_TAB("//*[text()[contains(normalize-space(.),'1C_Бухгалтерия')]]"),
    CRM_LINK_TAB("//*[text()[contains(normalize-space(.),'CRM')]]"),
    MARKET_SERVICE_LINK_TAB("//*[text()[contains(normalize-space(.),'Базар услуг')]]"),
    CATALOG_SERVICE_LINK_TAB("//*[text()[contains(normalize-space(.),'Каталог услуг')]]"),
    MARKETPLACE_LINK_TAB("//*[text()[contains(normalize-space(.),'Маркетплейс')]]"),
    ACCOUNTING_SYSTEM_LINK_TAB("//*[text()[contains(normalize-space(.),'Учетная система')]]"),
    ANALYTICA_LINK_TAB("//a[text()[contains(normalize-space(.),'Аналитика')]]"),
    GATEWAY_FIAS_LINK_TAB("//*[text()[contains(normalize-space(.),'Шлюз ФИАС')]]"),
    SOSINKA_LINK_TAB("//*[text()[contains(normalize-space(.),'Сосинка услуг')]]"),
    DUBOK_LINK_TAB("//*[text()[contains(normalize-space(.),'Дубок услуг')]]"),
    FIAS_LINK_TAB("//*[text()[contains(normalize-space(.),'ФИАС')]]");

    private String locator;

    ParentPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
