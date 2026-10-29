package helpers;

public enum IntegrationsFlowsLocators {

    SMSC_LINK("//*[text()[normalize-space(.)='SMSC']]"),
    FALSE_LINK("//*[text()[normalize-space(.)='Ложно']]"),
    TRUE_LINK("//*[text()[normalize-space(.)='Истинно']]"),
    MARKETPLASE_SYSTEMS_LINK("//a[@href='/entities/kadzo.v2023.systems/card?id=ecogroup.berezka.systems.berezka']"),
    SMEV_LINK("//*[text()[normalize-space(.)='СМЭВ']]"),
    MARKETPLACE_LINK("//*[text()[normalize-space(.)='Маркетплейс']]"),
    CATALOG_OF_SERVICE_LINK("//*[text()[normalize-space(.)='Каталог услуг']]"),
    NOT_DATA_FLOWS_LINK("//*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    ELEM_1C_LINK("//*[text()[normalize-space(.)='1C_Бухгалтерия']]"),
    CRM_LINK("//*[text()[normalize-space(.)='CRM']]");

    private String locator;

    IntegrationsFlowsLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}

