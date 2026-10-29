package helpers;

public enum GeneralContextSchemaLocators {

    INTERACTION_TEXT("//*[text()[contains(normalize-space(.),'Внутренние')]]"),
    ELEM_BUH_LINK("//*[contains(@id, 'cluster_ecogroup.berezka.functions.buh')]"),
    ELEMENT_CLIENT_NAME_BUTTON("//*[contains(@href, 'berezka.data_objects.client_name')]");

    private String locator;

    public String getLocator() {
        return locator;
    }

    GeneralContextSchemaLocators(String locator) {
        this.locator = locator;
    }
}
