package pages.dzo.regress.ilsanta.testData;

import static pages.dzo.regress.ilsanta.SchemaSystemsInternalPage.SCHEMA_ABSENT;

public enum InternalSystemIlsanta {

    C1("1C", "sys_id_11", "sys_id_11"),
    ACTIVE_DIRECTORY("ActiveDirectory", "ad", "ad"),
    ALLURE_OPS("AllureOps", "allureops", "allureops"),
    ALTCRAFT("Altcraft", SCHEMA_ABSENT, "altcraft"),
    APPIUM("Appium", "appium", "appium"),
    CRM("CRM", SCHEMA_ABSENT, "crm"),
    DOCHUB("DocHub", "dochub", "dochub"),
    GITLAB("Gitlab", "gitlab", "gitlab"),
    HR("HR ЛайфСкен", SCHEMA_ABSENT, "hrplatform"),
    HARBOR("Harbor", "harbor", "harbor"),
    NEXUS("Nexus", "nexus", "nexus"),
    IAM("IAM", SCHEMA_ABSENT, "iam"),
    PERFORATOR("PerforatorUI", "perforatorweb", "perforatorweb"),
    SEAFILE("Seafile", "seafile", "seafile"),
    VAULT("Vault", "vault", "vault"),
    WELLNESS("Wellness", "wellness", "wellness"),
    AUDIT("Аудит", SCHEMA_ABSENT, "audit"),
    BOOKING("Букинг", "booking", "booking"),
    DMP("ДМП", "rpm", "rpm"),
    DMP_SKOLK("ДМП (Сколково)", "rpmgis", "rpmgis"),
    DMP_MOBILE("ДМП Мобильное приложение", "rpmapp", "rpmapp"),
    DMP_DOCTOR("ДМП кабинет врача", "rpmdoctor", "rpmdoctor"),
    OFFERS_ORDERS("Заказы и предложения", SCHEMA_ABSENT, "offersorders"),
    DOC("Запись к врачу", "docdoc", "docdoc"),
    ZIOPLACE("ЗиОплейс", "marketplace", "marketplace"),
    CUL("Кабинет юридического лица", "cul", "cul"),
    CORPPORTAL("Копроративный портал", "corpportal", "corpportal"),
    LIFE_SKEN_DATA("ЛайфСкен данных", "dataplatform", "dataplatform"),
    LIFE_SKEN_NETWORK("ЛайфСкен обратной связи", "pos", "pos"),
    LIFE_SKEN("Логирование", "logging", "logging"),
    MED_CARD("Медкарта", "medcard", "medcard"),
    MY_HEALTH("МоеЗдоровье", "moezdo", "moezdo"),
    MOBILE_APPLICATION("Мобильное приложение пациента", "mobileapp", "mobileapp"),
    MONITORING("Мониторинг", "monitoring", "monitoring"),
    NSI("НСИ", "nsi", "nsi"),
    NOTIFY("Остров уведомлений", "notify", "notify"),
    OSTROVDESK("Островдеск ПартнерМосква", "usedesk", "usedesk"),
    PUL("ПЮЛ", SCHEMA_ABSENT, "pul"),
    PFL("Профиль физ.лица", "pfl", "pfl"),
    TELEMED("ТелеИзварино", "telemed", "telemed"),
    TELEFONIA("Телефония", "telephony", "telephony"),
    DIGIGTAL_CLIINIC("Цифровая клиника", SCHEMA_ABSENT, "digitalclinic");

    private String currentSystem;
    private String targetSystem;
    private String menuName;

    InternalSystemIlsanta(String menuName, String currentSystem, String targetSystem) {
        this.currentSystem = currentSystem;
        this.targetSystem = targetSystem;
        this.menuName = menuName;
    }

    public String getCurrentSystem() {
        return currentSystem;
    }

    public String getTargetSystem() {
        return targetSystem;
    }

    public String getMenuName() {
        return menuName;
    }
}
