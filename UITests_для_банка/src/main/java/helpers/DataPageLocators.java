package helpers;

public enum DataPageLocators {

    ID_TOKEN_LINK_TAB("//*[text()[contains(normalize-space(.),'id_token')]]"),
    CLIENTS_ADRESS_LINK_TAB("//*[text()[contains(normalize-space(.),'Адрес клиента')]]"),
    GEODATA_LINK_TAB("//*[text()[contains(normalize-space(.),'Геоданные')]]"),
    PAYMENT_DATA_LINK_TAB("//*[text()[contains(normalize-space(.),'Данные о платежах')]]"),
    PAYMENTS_DETAILS_LINK_TAB("//*[text()[contains(normalize-space(.),'Данные о платеже')]]"),
    SERVICE_DATA_LINK_TAB("//*[text()[contains(normalize-space(.),'Данные об услуге')]]"),
    USER_DATA_LINK_TAB("//*[text()[contains(normalize-space(.),'Данные пользователя')]]"),
    SERVICE_REQUEST_LINK_TAB("//*[text()[contains(normalize-space(.),'Заявки на услугу')]]"),
    MANDATORY_REPORTING_LINK_TAB("//*[text()[contains(normalize-space(.),'Обязательная отчетность')]]"),
    TRANSACTION_PARAMETR_LINK_TAB("//*[text()[contains(normalize-space(.),'Параметры сделки')]]"),
    CONTRACTOR_EMAIL_LINK_TAB("//*[text()[contains(normalize-space(.),'Почта исполнителя')]]"),
    SERVICE_TRANSACTION_LINK_TAB("//*[text()[contains(normalize-space(.),'Сделка по услуге')]]"),
    SERVICE_STATISTICS_LINK_TAB("//*[text()[contains(normalize-space(.),'Статистика по услугам')]]"),
    EXECUTOR_PHONE_NUMBER_LINK_TAB("//*[text()[contains(normalize-space(.),'Телефон исполнителя')]]"),
    CLIENT_PHONE_NUMBER_LINK_TAB("//*[text()[contains(normalize-space(.),'Телефон клиента')]]"),
    CLIENT_FULL_NAME_LINK_TAB("//*[text()[contains(normalize-space(.),'ФИО Клиента')]]"),
    EXECUTOR_FULL_NAME_LINK_TAB("//*[text()[contains(normalize-space(.),'ФИО исполнителя')]]");

    private String locator;

    DataPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
