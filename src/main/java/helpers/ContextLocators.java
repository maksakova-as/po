package helpers;

public enum ContextLocators {
    CURRENT_DATA_CONTEXT("//*[text()[normalize-space(.)='Текущий контекст данных']]"),
    CURRENT_SYSTEM_CONTEXT("//*[text()[contains(normalize-space(.),'Текущий контекст системы')]]"),
    TARGET_DATA_CONTEXT("//*[text()[normalize-space(.)='Целевой контекст данных']]"),
    CURRENT_DATA_CONTEXT_EXTENDED("//*[text()[normalize-space(.)='Текущий контекст данных (расширенный)']]"),
    TARGET_DATA_CONTEXT_EXTENDED("//*[text()[normalize-space(.)='Целевой контекст данных (расширенный)']]"),
    CURRENT_SYSTEM_CONTEXT_VIEW("//*[text()[contains(normalize-space(.),'Контекст системы текущий (view данные)')]]"),
    GOAL_CONTEXT("//*[text()[contains(normalize-space(.),'Целевой контекст системы')]]"),
    GOAL_CONTEXT_VIEW("//*[text()[contains(normalize-space(.),'Целевой контекст системы (view данные)')]]"),
    CURRENT_SCHEME("(//*[text()[contains(normalize-space(.),'Текущая схема')]])"),
    SCHEME_BUSINESS("//*[text()[normalize-space(.)='Схема бизнес слоя (текущая)']]"),
    CURRENT_CARD("//*[text()[normalize-space(.)='Карта данных (текущая)']]"),
    SYSTEM_CARD("//*[text()[normalize-space(.)='Карта систем (текущая)']]"),
    FUNCTION_CARD("//*[text()[normalize-space(.)='Функциональная карта (текущая)']]"),
    CURRENT_SCHEME_ONLY("//*[text()[normalize-space(.)='Текущая схема (только внешний периметр)']]"),
    CURRENT_SCHEME_WITHOUT("//*[text()[contains(normalize-space(.),'Текущая схема (без ФП)')]]"),
    CURRENT_SCHEME_WITHOUT_PERIMETR("//*[text()[normalize-space(.)='Текущая схема (без ФП, внешний периметр)']]"),
    GOAL_SCHEME("//*[text()[contains(normalize-space(.),'Целевая схема')]]"),
    GOAL_CARD("//*[text()[contains(normalize-space(.),'Карта данных (целевая)')]]"),
    GOAL_SYSTEM_CARD("//*[text()[contains(normalize-space(.),'Карта систем (целевая)')]]"),
    GOAL_SCHEME_ONLY("//*[text()[normalize-space(.)='Целевая схема (только внешний периметр)']]"),
    GOAL_BUSINESS_SCHEME("//*[text()[normalize-space(.)='Схема бизнес слоя (целевая)']]"),
    GOAL_FUNCTION_CARD("//*[text()[contains(normalize-space(.),'Функциональная карта (целевая)')]]"),
    GOAL_WITHOUT_FP("//*[text()[contains(normalize-space(.),'Целевая схема (без ФП)')]]"),

    ElEM_MARKETPLASE_LINK("//*[@id ='elem_ecogroup.berezka.systems.berezka']"),
    ELEM_1C_LINK("//*[@id ='elem_ecogroup.berezka.systems.1c']"),
    ELEM_ARM_LINK("//*[contains(@id,'berezka.channels.arm')]"),
    ELEM_COLL_CENTER_LINK("//*[contains(@id,'berezka.channels.CallCenter')]"),
    ELEM_MARKET_SERVICE_LINK("//*[@id ='elem_ecogroup.berezka.systems.osinka']"),
    ELEM_MARKET_CATALOG_LINK("//*[@id ='elem_ecogroup.berezka.systems.berezka.catalog']"),
    ELEM_2GIS_LINK("//*[@id ='elem_ecogroup.berezka.ecosystem.partners.2gis']"),
    ELEM_MARKETING_SALES_LINK("//*[@id ='elem_ecogroup.berezka.external_systems.marketing']"),
    ELEM_ANALYTIC_LINK("//*[@id ='elem_ecogroup.berezka.systems.analytics']"),
    ElEM_CRM_LINK("//*[@id ='elem_ecogroup.berezka.systems.crm']"),
    SYSTEM_CONTEXT_TEXT("//*[@fill='#000000']");

    private String locator;

    public String getLocator() {
        return locator;
    }

    ContextLocators(String locator) {
        this.locator = locator;
    }
}
