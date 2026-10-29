package helpers;

public enum GeneralPageLocators {

    DATA_CARD_LiST("//*[text()[contains(normalize-space(.),'Карта данных')]]"),
    SYSTEMS_CARD_LIST("//*[text()[contains(normalize-space(.),'Карта систем')]]"),
    BUSINESS_LAYER_DIAGRAM_LIST("//*[text()[contains(normalize-space(.),'Схема бизнес-слоя')]]"),
    FUNCTIONAL_CARD_LIST("//*[text()[contains(normalize-space(.),'Функциональная карта')]]"),
    ARCH_SCHEMA_SMART_ANTS("//*[text()[contains(normalize-space(.),'Архитектурная схема SmartAnts')]]");
    private String locator;

    public String getLocator() {
        return locator;
    }

    GeneralPageLocators(String locator) {
        this.locator = locator;
    }
}
