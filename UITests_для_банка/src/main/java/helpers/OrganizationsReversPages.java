package helpers;

public enum OrganizationsReversPages {
    DOCHUB_TEST_D5A_FIND_PAGE("DocHub_SEAF_test-D5aEk1nqZ"),
    DOCHUB_DCG_FIND_PAGE("DocHub_SEAF_DCG"),
    INTERNAL_FIND_PAGE("Internal_net"),
    DOCHUB_TEST_VDC01_FIND_PAGE("DocHub_SEAF_test-VDC01"),
    DOCHUB_TEST_VDC02_FIND_PAGE("DocHub_SEAF_test-VDC02"),
    EDGE_FIND_PAGE("Edge Gateways"),
    VAPPS_FIND_PAGE("vApps"),
    APP_TEST_1_FIND_PAGE("App_Test_1"),
    APP_TEST_2_FIND_PAGE("App_Test_2"),
    SEGMENT_50_FIND_PAGE("Segment-50-VM-e8f7f110-5f37-4541-a46f-0b1f08d2b86f"),
    SEGMENT_60_FIND_PAGE("Segment-60-VM-ba23b045-0df1-4fec-9808-66152e655b28"),
    DOCHUB_TEST_VDC01_EDGE_FIND_PAGE("DocHub_SEAF_test-VDC01-EDGE01"),

    DOCHUB_TEST_D5A_PAGE("//*[text()[normalize-space(.)='DocHub_SEAF_test-D5aEk1nqZ']]"),
    DOCHUB_DCG_PAGE("//*[text()[normalize-space(.)='DocHub_SEAF_DCG']]"),
    INTERNAL_PAGE("//*[text()[normalize-space(.)='Internal_net']]"),
    DOCHUB_TEST_VDC01_PAGE("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC01']]"),
    DOCHUB_TEST_VDC02_PAGE("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC02']]"),
    EDGE_PAGE("//*[text()[normalize-space(.)='Edge Gateways']]"),
    VAPPS_PAGE("//*[text()[normalize-space(.)='vApps']]"),
    VAPPS_PAGE2("(//*[text()[normalize-space(.)='vApps']])[2]"),
    APP_TEST_1_PAGE("//*[text()[normalize-space(.)='App_Test_1']]"),
    APP_TEST_2_PAGE("//*[text()[normalize-space(.)='App_Test_2']]"),
    SEGMENT_50_PAGE("//*[text()[normalize-space(.)='Segment-50-VM-e8f7f110-5f37-4541-a46f-0b1f08d2b86f']]"),
    SEGMENT_60_PAGE("//*[text()[normalize-space(.)='Segment-60-VM-ba23b045-0df1-4fec-9808-66152e655b28']]"),
    DOCHUB_TEST_VDC01_EDGE_PAGE("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC01-EDGE01']]"),

    TEST_D5A_LOCATOR1("//*[text()[normalize-space(.)='DocHub_SEAF_test-D5aEk1nqZ']]"),
    TEST_D5A_LOCATOR2("//*[text()[normalize-space(.)='DocHub_SEAF_DCG']]"),
    TEST_D5A_LOCATOR3("//*[text()[normalize-space(.)='Internal_net']]"),
    TEST_D5A_LOCATOR4("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC01']]"),
    TEST_D5A_LOCATOR5("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC02']]"),

    TEST_DCG_NAME("//*[text()[normalize-space(.)='DocHub_SEAF_DCG']]"),
    TEST_DCG_WEB("//*[text()[normalize-space(.)='Segment_01']]"),
    TEST_DCG_VDC("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC01']]"),
    TEST_DCG_NETWORK("//*[text()[normalize-space(.)='Parent network']]"),
    TEST_DCG_DESCRIPTION("//*[text()[normalize-space(.)='Внешняя сеть в интернет']]"),

    INTERNAL_WEB("//td[text()[normalize-space(.)='Internal_net']]"),
    INTERNAL_VDC("//*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    INTERNAL_NETWORK("//a[text()[normalize-space(.)='DBNET']]"),
    INTERNAL_SCHEMA_LOC1("//*[text()[normalize-space(.)='Организация: DocHub_SEAF_test-D5aEk1nqZ']]"),
    INTERNAL_SCHEMA_LOC2("//*[text()[normalize-space(.)='VDC Group:']]"),

    TEST_VDC01_VDC("//td[text()[normalize-space(.)='DocHub_SEAF_test-D5aEk1nqZ']]"),
    TEST_VDC01_VDC_GROUP("//a[text()[normalize-space(.)='DocHub_SEAF_DCG']]"),
    TEST_VDC01_NETWORK_NAME("//a[text()[normalize-space(.)='Segment_50']]"),
    TEST_VDC01_APPS("//td[text()[normalize-space(.)='This vApp is created automatically on behalf of the user.']]"),
    TEST_VDC01_SCHEMA_LOC("//*[text()[normalize-space(.)='VDC: DocHub_SEAF_test-VDC01']]"),

    TEST_VDC02_VDC("//a[text()[normalize-space(.)='DocHub_SEAF_DCG']]"),
    TEST_VDC02_NETWORK_NAME("//*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]"),
    TEST_VDC02_APPS("//td[text()[normalize-space(.)='This vApp is created automatically on behalf of the user.']]"),
    TEST_VDC02_SCHEMA_LOC("//*[text()[normalize-space(.)='VDC: DocHub_SEAF_test-VDC02']]"),

    EDGE_NAME("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC01-EDGE01']]"),
    EDGE_TYPE("//*[text()[normalize-space(.)='NSXT_BACKED']]"),
    EDGE_INTERFACE("//*[text()[normalize-space(.)='xxx.xxx.xxx.xxx,xxx.xxx.xxx.xxx']]"),

    VAPPS_NAME1("//*[text()[normalize-space(.)='Segment-50-VM-e8f7f110-5f37-4541-a46f-0b1f08d2b86f']]"),
    VAPPS_NAME2("//*[text()[normalize-space(.)='App_Test_1']]"),
    VAPPS_DESCRIPTION("//*[text()[normalize-space(.)='This vApp is created automatically on behalf of the user.']]"),
    VAPPS_VDC("//*[text()[normalize-space(.)='DocHub_SEAF_test-VDC01']]"),
    VAPPS_VDC_ORG("//*[text()[normalize-space(.)='DocHub_SEAF_test-D5aEk1nqZ']]"),

    APP_TEST1_NETWORK("//a[text()[normalize-space(.)='WebApp']]"),
    APP_TEST1_DNS("//a[text()[normalize-space(.)='xxx.xxx.xxx.xxx']]"),
    APP_TEST1_MODE("//p[text()[normalize-space(.)=': bridged']]"),
    APP_TEST1_SCHEMA_LOC("//*[text()[normalize-space(.)='vApp: App_Test_1']]"),

    APP_TEST2_WEBAPPVM02("//a[text()[normalize-space(.)='WebAppVM02']]"),
    APP_TEST2_SCHEMA_LOC("//*[text()[normalize-space(.)='vApp: App_Test_2']]"),

    SEGMENT_50_NETWORK_NAME("//a[text()[normalize-space(.)='Segment_50']]"),
    SEGMENT_60_NETWORK_NAME("//a[text()[normalize-space(.)='Segment_60']]"),
    SEGMENT_60_SCHEMA_LOC("//*[text()[normalize-space(.)='vApp: Segment-60-VM-ba23b045-0df1-4fec-9808-66152e655b28']]"),
    VDC01_EDGE_VDC_GROUP("//*[text()[normalize-space(.)='VDC Group: DocHub_SEAF_DCG']]");

    private String locator;

    OrganizationsReversPages(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
