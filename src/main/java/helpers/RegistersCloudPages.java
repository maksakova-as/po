package helpers;

public enum RegistersCloudPages {
    VDC_PAGE("VDC"),
    SERVERS_PAGE("Серверы"),
    GATEWAYS_PAGE("Шлюзы"),

    VDC_PAGE_LOCATOR("//*[text()[normalize-space(.)='VDC']]"),
    SERVERS_PAGE_LOCATOR("//*[text()[normalize-space(.)='Серверы']]"),
    GATEWAYS_PAGE_LOCATOR("//*[text()[normalize-space(.)='Шлюзы']]"),

    VDC_NAME("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC01']]"),
    VDC_APPS("//*[text()[contains(normalize-space(.),'Segment-50-VM-e8f7f110-5f37-4541-a46f-0b1f08d2b86f\n" +
            "App_Test_1')]]"),
    VDC_ORGANIZATION("//*[text()[normalize-space(.)='DocHub_SEAF_test-D5aEk1nqZ']]"),

    SERVER_NAME("//*[text()[normalize-space(.)='WebAppVM02']]"),
    SERVER_OS("//*[text()[normalize-space(.)='Ubuntu Linux (64-bit)']]"),
    SERVER_DISK("//*[text()[normalize-space(.)='0/0 - Gold - 16Gb']]"),

    GATEWAY_NAME("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC01-EDGE01']]"),
    GATEWAY_TYPE("//*[text()[normalize-space(.)='NSXT_BACKED']]"),
    GATEWAY_INTERFACE("//*[text()[normalize-space(.)='xxx.xxx.xxx.xxx,xxx.xxx.xxx.xxx']]");

    private String locator;

    RegistersCloudPages(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
