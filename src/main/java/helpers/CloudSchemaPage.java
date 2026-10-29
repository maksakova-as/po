package helpers;

public enum CloudSchemaPage {
    NETWORK_SCHEMA_PAGE("//*[text()[normalize-space(.)='Network Schema']]"),
    SERVERS_PAGE("//*[text()[normalize-space(.)='Servers in VPC']]"),
    VIRTUAL_PAGE("//*[text()[normalize-space(.)='Virtual Private Clouds']]"),

    INTERNAL("//*[text()[contains(normalize-space(.),'vpc-internal')]]"),
    EXTERNAL("//*[text()[contains(normalize-space(.),'vpc-external')]]");

    private String locator;

    CloudSchemaPage(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
