package helpers;

public enum TargetGeneralSchemaLocators {

    SCHEMA_LINK("//*[text()[contains(normalize-space(.),'услуг (ИП)')]]"),
    ELEM_DATA_PAYMENT_LINK("//*[contains(@id,'elem_ecogroup.berezka.data_objects.payment_order')]"),
    ELEM_SEND_SMS_LINK("//*[contains(@id,'cluster_ecogroup.berezka.functions.send_sms')]");

    private String locator;

    public String getLocator() {
        return locator;
    }

    TargetGeneralSchemaLocators(String locator) {
        this.locator = locator;
    }
}
