package pages.dzo.regress.ilsanta.testData;

import static pages.dzo.regress.ilsanta.SchemaSystemsInternalPage.SCHEMA_ABSENT;
import static pages.dzo.regress.ilsanta.SchemaSystemsInternalPage.ZIO_PLACE;

public enum ExternalSystemsIlsanta {

    ALBATO("Albato", "albato", "albato"),
    AMOCRM("AmoCRM", "amocrm", "amocrm"),
    APPLE_APP_STORE_CONNECT("Apple AppStore Connect", "appleappstoreconnect", "appleappstoreconnect"),
    APPLE_DEV_PORTAL("Apple Dev Portal", "appledevportal", "appledevportal"),
    BITRIX24("Bitrix24", "bitrix24", "bitrix24"),
    DADATA("DaData", "dadata", "dadata"),
    GOOGLE_PLAY_CONSOLE("Google Play Console", "googleplayconsole", "googleplayconsole"),
    GOOGLE_FORMS("GoogleForms", "googleforms", "googleforms"),
    GOOGLE_SPREADSHEETS("GoogleSpreadsheets", "googletables", "googletables"),
    GREEN_PLUM("GreenPlum", "greenplum", "greenplum"),
    GARGILL("HR ЛайфСкен Gargill", SCHEMA_ABSENT, "hrplatformGargill"),
    HELZY("Helzy", SCHEMA_ABSENT, "helzy"),
    HUAWEI("Huawei App Gallery", "huaweiappgallery", "huaweiappgallery"),
    HUNTFLOW("Huntflow", "huntflow", "huntflow"),
    ISPRING("ISpring", "ispring", "ispring"),
    MAILGUN("MailGun", "mailgun", "mailgun"),
    MAILKING("MailKing", SCHEMA_ABSENT, "mailking"),
    MINDBOX("Mindbox", "mindbox", "mindbox"),
    OMNIDESK("Omnidesk", "omnidesk", "omnidesk"),
    PYRUS("Pyrus", "pyrus", "pyrus"),
    RUSTORE("RuStore", "rustore", "rustore"),
    SMSC("SMSC", "smsc", "smsc"),
    SBER911("Sber911", "sber911", "sber911"),
    SBER_API_REGISTRY("SberApIRegistry", "sberapiregistry", "sberapiregistry"),
    SBER_DATA_EXCHANGE("SberDataExchange", "sberdataexchange", "sberdataexchange"),
    GREESBER_GARGILL_S3("SberGargillS3", "sberGargills3", "sberGargills3"),
    SBER_PRIME("SberPrime", "sberprime", "sberprime"),
    SBER_RADAR("SberRadar", "sberradar", "sberradar"),
    SBER_TEAM_ID("SberTeamId", SCHEMA_ABSENT, "sberteamid"),
    SPLIT_SERVICE("SplitService", "splitservice", "splitservice"),
    TEST_FLIGHT("TestFlight", "testflight", "testflight"),
    YANDEX_360("Yandex 360", "yandex360", "yandex360"),
    YANDEX_FORMS("Yandex Forms", "yandexforms", "yandexforms"),
    YANDEX_TRACKER("Yandex Tracker", "yandextracker", "yandextracker"),
    YANDEX_WIKI("Yandex Wiki", "yandexwiki", "yandexwiki"),
    YOO_KASSA("YooKassa", "yookassa", "yookassa"),
    REMOVE_BG("remove.bg", "removebg", "removebg"),
    BIOTECH("БиокорПенза срБиотэкМосква", "businessenv", ZIO_PLACE),
    BIOSENSOR("БиосенсорМосковская", ZIO_PLACE, ZIO_PLACE),
    DOCTOR("Доктор Рядом", ZIO_PLACE, ZIO_PLACE),
    EGIS3("ЕГИСЗ", "egisz", "egisz"),
    ESIA("ЕСИА", "esia", "esia"),
    MED_COMPANY("Мед. Учреждения", "medcompany", "medcompany"),
    HETERO("МинскинтеркапсБелоруссияАвто", SCHEMA_ABSENT, "Hetero"),
    PROMOMED("МинскинтеркапсБелоруссияАлтайвитаминыАлтайский ПромомедМосква Борисовский", ZIO_PLACE, ZIO_PLACE),
    BUSINESS_ONLINE("МинскинтеркапсБелоруссияБизнесОнлайн", SCHEMA_ABSENT, ZIO_PLACE),
    GEO("МинскинтеркапсБелоруссияГео", SCHEMA_ABSENT, "sbergeo"),
    MEGASIO("МинскинтеркапсБелоруссияМегаЗиО", SCHEMA_ABSENT, "sbermegamarket"),
    MEDII("МинскинтеркапсБелоруссияМедИИ", SCHEMA_ABSENT, "sbermedii"),
    SBE_HELIOMEDS("МинскинтеркапсБелоруссияМедбиофармКалуга", "sbeHeliomeds", "sbeHeliomeds"),
    FNS("Налоговая служба", "fns", "fns"),
    ROBOT_CALL("Островы робообзвона", "robotcall", "robotcall"),
    PFR("ПФР", "pfr", "pfr"),
    PONIMAU("Понимаю", "ponimau", "ponimau"),
    PUSH("Провайдеры Push", "push", "push"),
    PHONE_PROVIDERS("Провайдеры телефонии", "phoneproviders", "phoneproviders"),
    REPOMETR("Репометр", "repometr", "repometr"),
    ROSSTAT("Росстат", "rosstat", "rosstat"),
    TELEGRAM("Телеграм", "telegram", "telegram"),
   // TRANSKRIBATOR("Транскрибатор", SCHEMA_ABSENT, "transkribator"),
    FSS("ФСС", "fss", "fss"),
    PACKAGEFABRIC("Фабрика пакетов", "packagefabric", "packagefabric"),
    YANDEXS3("Яндекс S3", "yandexs3", "yandexs3"),
    YANDEX_SPEECHKIT("Яндекс.SpeechKit", "yandexspeechkit", "yandexspeechkit"),
    YANDEX_METRO("Яндекс.Метро", "yandexmetro", "yandexmetro");

    private String currentSystem;
    private String targetSystem;
    private String menuName;

    ExternalSystemsIlsanta(String menuName, String currentSystem, String targetSystem) {
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
