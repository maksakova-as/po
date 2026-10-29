package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static helpers.Actions.getTextMessage;

public class BusinessData {

    private static final String BEREZKA_STRATEGY_ID_1 = "//*[text()[normalize-space(.)='ecogroup.berezka.strategy.id1']]";
    private static final String SUMMARY_BY_TASK = "//*[text()[normalize-space(.)='Сводка по стратегической задаче']]";
    private static final String BEREZKA_STRATEGY_ID_2 = "//*[text()[normalize-space(.)='ecogroup.berezka.strategy.id2']]";

    private static final String BEREZKA_GOAL_ID_1 = "//*[text()[normalize-space(.)='ecogroup.berezka.goals.id1']]";
    private static final String BEREZKA_GOAL_ID_2 = "//*[text()[normalize-space(.)='ecogroup.berezka.goals.id2']]";
    private static final String BEREZKA_GOAL_ID_3 = "//*[text()[normalize-space(.)='ecogroup.berezka.goals.id3']]";
    private static final String SUMMARY_BY_GOAL = "//*[text()[normalize-space(.)='Сводка по бизнес-цели']]";

    private static final String PROCESS_CHOOSE_EXECUTOR = "//*[text()[normalize-space(.)='ecogroup.berezka.processes.choose_executor']]";
    private static final String PROCESS_ONE = "//*[text()[normalize-space(.)='ecogroup.berezka.processes.one']]";
    private static final String PROCESS_TWO = "//*[text()[normalize-space(.)='ecogroup.berezka.processes.two']]";
    private static final String SUMMARY_BY_PROCESS = "//*[text()[normalize-space(.)='Сводка по бизнес-процессу']]";

    private static final String CHANNEL_WEB = "//*[text()[normalize-space(.)='ecogroup.berezka.channels.web']]";
    private static final String CHANNEL_APP = "//*[text()[normalize-space(.)='ecogroup.berezka.channels.client_app']]";
    private static final String CHANNEL_EXECUTOR_APP = "//*[text()[normalize-space(.)='ecogroup.berezka.channels.executor_app']]";
    private static final String CHANNEL_PROFIRU = "//*[text()[normalize-space(.)='ecogroup.berezka.channels.profiru']]";
    private static final String SUMMARY_BY_CHANNEL = "//*[text()[normalize-space(.)='Сводка по каналу']]";
    private static final String LIFESTAGE_BY_CHANNEL = "//*[text()[normalize-space(.)='Жизненный цикл']]";
    private static final String OWNER_BY_CHANNEL = "//*[text()[normalize-space(.)='Модель владения']]";
    private static final String LIFESTAGE_AND_OWNER_BY_CHANNEL = "//*[text()[normalize-space(.)='Жизненный цикл, модель владения']]";
    private static final String IN_USE_LOCATOR = "//code[text()[contains(normalize-space(.),'Используется')]]";
    private static final String OUTSIDE_LOCATOR = "//code[text()[contains(normalize-space(.),'Внешняя')]]";

    private static final String CLIENTS_USERS = "//*[text()[normalize-space(.)='Заказчики услуг']]";
    private static final String CLIENTS_BUSINESS = "//*[text()[normalize-space(.)='Исполнители услуг (ИП)']]";
    private static final String CLIENTS_EMPLOYEES = "//*[text()[normalize-space(.)='Внутренние сотрудники']]";
    private static final String SUMMARY_BY_EMPLOYEES = "//*[text()[normalize-space(.)='Сводка по клиенту']]";

    private static final String LINK_WEB = "//*[text()[normalize-space(.)='Web-приложение']]";
    private static final String LINK_АРМ = "//*[text()[normalize-space(.)='АРМ']]";
    private static final String LINK_CALL_CENTER = "//*[text()[normalize-space(.)='Колл-центр']]";
    private static final String LINK_MARKETPLACE_SERVICES = "//*[text()[normalize-space(.)='Маркетплейс бытовых услуг']]";
    private static final String LINK_MARKETPLACE = "//*[text()[normalize-space(.)='Маркетплейс']]";
    private static final String LINK_1C = "//*[text()[normalize-space(.)='1C_Бухгалтерия']]";
    private static final String GOAL_LINK = "//*[text()[normalize-space(.)='«Целевая внедрена полностью»']]";
    private static final String STATE_LINK = "//*[text()[normalize-space(.)='Государство']]";
    private static final String LINK_MARKETPLACE_CLEAN_SERVICES = "//*[text()[normalize-space(.)='Маркетплейс клининговых услуг']]";
    private static final String LINK_MARKETPLACE_SUPPORT = "//*[text()[normalize-space(.)='Поддержка клиентов Маркетплейс']]";
    private static final String LINK_MARKETPLACE_SYSTEM = "//*[text()[normalize-space(.)='Системы Маркетплейс']]";
    private static final String LINK_MARKETPLACE_SYSTEM_CLOUD = "//*[text()[normalize-space(.)='Системы Маркетплейс в SberCloud']]";
    private static final String LINK_MARKETPLACE_SYSTEM_OFFICE = "//*[text()[normalize-space(.)='Системы Маркетплейс в офисе']]";
    private static final String LINK_NAME = "//*[text()[normalize-space(.)='ФИО исполнителя']]";
    private static final String LINK_ANALYTIC = "//*[text()[normalize-space(.)='Аналитика']]";
    private static final String LINK_SERVICE = "//*[text()[normalize-space(.)='Заявки на услугу']]";
    private static final String LINK_CRM = "//*[text()[normalize-space(.)='CRM']]";
    private static final String LINK_CREATED_PHONE = "//*[text()[normalize-space(.)='Создание мобильного приложения Исполнителя услуги']]";
    private static final String LINK_INFORMATION = "//*[text()[normalize-space(.)='Сводная информация']]";
    private static final String LINK_SYSTEM_ANALYTIC = "//*[text()[normalize-space(.)='Разработка/приобретение системы аналитики']]";
    private static final String LINK_APM = "//*[text()[normalize-space(.)='АРМ']]";

    private static final String SUMMARY_BY_PRODUCT = "//*[text()[normalize-space(.)='Сводка по продукту']]";
    private static final String SUMMARY_BY_OBJECT = "//*[text()[normalize-space(.)='Сводка по объекту данных']]";
    private static final String CHANNELS_BY_PRODUCT = "//*[text()[normalize-space(.)='Каналы, через которые поставляется продукт']]";

    private static final String BUSINESS_STRATEGY_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Бизнес стратегия']]";
    private static final String CLIENTS_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Клиенты']]";
    private static final String BUSINESS_GOALS_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Бизнес цели']]";
    private static final String BUSINESS_PROCESS_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Бизнес-процессы']]";
    private static final String INTERACTION_CHANNEL_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Каналы взаимодействия с клиентами']]";
    private static final String INTERACTION_POINT_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Точки взаимодействия']]";
    private static final String PRODUCTS_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Продукты']]";
    private static final String BUSINESS_OBJECT_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Бизнес-объекты']]";
    private static final String BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Объекты данных']]";
    private static final String GROUPS_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Группы']]";
    private static final String PLANNING_TASKS_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Задачи горизонта планирования']]";
    private static final String INTEGRATIONS_FLOWS_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Интеграционные потоки']]";
    private static final String FUNCTION_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Функциональность']]";
    private static final String SOFTWARE_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Программное обеспечение']]";
    private static final String SERVICES_SYSTEM_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Технологические сервисы и системы']]";
    private static final String CRITICAL_PASSPORT_BUTTON = "//nav//*[contains(@class,'dh-nav__title')]//*[text()[normalize-space(.)='Сводный - Паспорта критичности']]";

    private static final String BUSINESS_OBJECT_CLIENT = "//*[text()[normalize-space(.)='Клиент']]";
    private static final String BUSINESS_OBJECT_EXECUTOR = "//*[text()[normalize-space(.)='Исполнитель']]";
    private static final String BUSINESS_OBJECT_SERVICE = "//*[text()[normalize-space(.)='Услуга']]";
    private static final String SUMMARY_BUSINESS_OBJECT = "//*[text()[normalize-space(.)='Сводка по бизнес-объекту']]";

    private static final String BUSINESS_OBJECT_DATE_CLIENT_NAME = "//*[text()[normalize-space(.)='ФИО Клиента']]";
    private static final String BUSINESS_OBJECT_DATE_CLIENT_PHONE = "//*[text()[normalize-space(.)='Телефон клиента']]";
    private static final String BUSINESS_OBJECT_DATE_CLIENT_ADDRESS = "//*[text()[normalize-space(.)='Адрес клиента']]";
    private static final String SUMMARY_DATE_OBJECT = "//*[text()[normalize-space(.)='Сводка по объекту данных']]";
    private static final String SUMMARY_DATE_OBJECT_SYSTEM = "//*[text()[normalize-space(.)='Сводка по системе']]";
    private static final String FUNCTION_DATE_OBJECT_SYSTEM = "//*[text()[normalize-space(.)='Функции системы']]";
    private static final String DESCRIPTION_GROUP = "//*[text()[contains(normalize-space(.),'Описание')]]";
    private static final String STREAMS = "//*[text()[contains(normalize-space(.),'Потоки')]]";

    private static final String DROPDOWN_CONTEXT = "//*[text()[contains(normalize-space(.),'Целевой контекст объекта данных (расширение до бизнес-слоя)')]]";
    private static final String DROPDOWN_CONTEXT_ADD = "//*[text()[contains(normalize-space(.),'Текущий контекст объекта данных (расширение до бизнес-слоя)')]]";
    private static final String DROPDOWN_CONTEXT_GOAL = "//*[text()[contains(normalize-space(.),'Целевой контекст объекта данных')]]";
    private static final String DROPDOWN_CONTEXT_GROUP_WITHOUT = "//*[text()[normalize-space(.)='Текущий контекст группы (без ФП)']]";
    private static final String DROPDOWN_CONTEXT_GROUP_GOAL = "//*[text()[normalize-space(.)='Целевой контекст группы']]";
    private static final String DROPDOWN_CONTEXT_GROUP_GOAL_WITHOUT = "//*[text()[normalize-space(.)='Целевой контекст группы (без ФП)']]";

    private static final String INTEGRATION_SBERID_BEREZKA = "//*[text()[normalize-space(.)='ecogroup.berezka.integrations.sberid-berezka']]";
    private static final String INTEGRATION_SBERID_BEREZKA2 = "//*[text()[normalize-space(.)='ecogroup.berezka.integrations.sberid-berezka2']]";
    private static final String INTEGRATION_SBERBUSINESSID_BEREZKA = "//*[text()[normalize-space(.)='ecogroup.berezka.integrations.sberbusinessid-berezka']]";
    private static final String INTEGRATION_USER_INFO = "//*[text()[normalize-space(.)='ecogroup.berezka.data_objects.user_info']]";
    private static final String INTEGRATION_TOKEN_INFO = "//*[text()[normalize-space(.)='ecogroup.berezka.data_objects.token_info']]";
    private static final String INTEGRATION_EXECUTOR_NAME = "//*[text()[normalize-space(.)='ecogroup.berezka.data_objects.executor_name']]";

    private static final String SUMMARY_INTEGRATION = "//*[text()[normalize-space(.)='Сводка по интеграционному потоку']]";
    private static final String TECHNOLOGIES_INTEGRATION = "//*[text()[normalize-space(.)='Технологии интеграций']]";
    private static final String LIFECYCLE_INTEGRATION = "//*[text()[normalize-space(.)='Жизненный цикл потока']]";
    private static final String LIFECYCLE = "//*[text()[normalize-space(.)='Жизненный цикл']]";
    private static final String HA_COMPONENT = "//*[self::code or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Высокая доступность объекта управления (HA)') or contains(normalize-space(.),'Высокая доступность компонента (HA)')]]";
    private static final String GITHUB_LINK = "//code[text()[contains(normalize-space(.),'Github')]]";
    private static final String LOADING_INTEGRATION = "//*[text()[normalize-space(.)='Нагрузочные характеристики интеграций']]";
    private static final String BEREZKA_FIAS_ENDPOINT = "//*[text()[normalize-space(.)='ecogroup.berezka.fias_endpoint']]";
    private static final String BEREZKA_MESSAGE_POINT = "//*[text()[normalize-space(.)='ecogroup.berezka.message_point']]";
    private static final String CATALOG_SERVICE = "//*[text()[normalize-space(.)='Ведение каталога услуг']]";
    private static final String AUTHENTICATION = "//*[text()[normalize-space(.)='Аутентификация пользователей']]";
    private static final String PAYMENT_SERVICE = "//*[text()[normalize-space(.)='Оплата услуг']]";
    private static final String NO_DATA_LOCATOR = "//*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]";
    private static final String NO_SOFTWARE_LOCATOR = "//*[@colspan = '3']/descendant-or-self::*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]";

    private static final String BEREZKA_SOFTWARE_BITRIX = "//*[text()[normalize-space(.)='ecogroup.berezka.bitrix']]";
    private static final String BEREZKA_SOFTWARE_GITHUB = "//*[text()[normalize-space(.)='ecogroup.berezka.github']]";
    private static final String BEREZKA_SOFTWARE_WAF = "//*[text()[normalize-space(.)='ecogroup.berezka.pt_waf']]";
    private static final String BEREZKA_TECH_SERVICES_GITHUB = "//*[text()[normalize-space(.)='ecogroup.berezka.tech_services.github']]";
    private static final String BEREZKA_TECH_SERVICES_PROMETHEUS = "//*[text()[normalize-space(.)='ecogroup.berezka.tech_services.prometheus']]";
    private static final String BEREZKA_TECH_SERVICES_VMWARE = "//*[text()[normalize-space(.)='ecogroup.berezka.tech_services.vmware']]";
    private static final String BEREZKA_CRITICALITY_PASSPORT_1C = "//*[text()[normalize-space(.)='ecogroup.berezka.criticality_passport.1c']]";
    private static final String BEREZKA_CRITICALITY_PASSPORT = "//*[text()[normalize-space(.)='ecogroup.berezka.criticality_passport.berezka']]";
    private static final String BEREZKA_CRITICALITY_PASSPORT_CATALOG = "//*[text()[normalize-space(.)='ecogroup.berezka.criticality_passport.catalog']]";
    private static final String LOCATOR_IN = "//code[@class='language-markuper-form-field']";

    private static final String VENDOR_COMPONENT = "//*[(self::code and @class='language-markuper-form-label') or contains(@class,'md-form-empty')][text()[contains(normalize-space(.),'Разработчик программного обеспечения')]]";
    private static final String UNDEFINED_LOCATOR = "//code[text()[contains(normalize-space(.),'Не определено')]]";
    private static final String TECH_SERVICE_COMPONENT = "//*[text()[normalize-space(.)='Техсервис']]";
    private static final String VENDOR_REPLACE_COMPONENT = "//code[text()[contains(normalize-space(.),'Рекомендуется замена вендора')]]";
    private static final String SUMMARY_TECH_METHOD = "//*[text()[normalize-space(.)='Сводка по техническому сервису']]";
    private static final String LOSES_CLIENT = "//*[text()[normalize-space(.)='Клиентские потери (списком)']]";
    private static final String LOSES_FINANCIAL = "//*[text()[normalize-space(.)='Финансовые потери']]";
    private static final String LOSES_REPUTATIONAL = "//*[text()[normalize-space(.)='Репутационные потери']]";
    private static final String PASSPORT_CRYTICAL_INFO = "//*[text()[normalize-space(.)='Паспорт критичности - Общая информация']]";
    private static final String UNVAILABILITY_SCENARIO_LIST = "//*[text()[normalize-space(.)='Сценарии недоступности (списком)']]";
    private static final String UNVAILABILITY_SCENARIO = "//*[text()[normalize-space(.)='Сценарии недоступности']]";

    private static final String CLASS_SPACE = "//div[@class='markdown-document']";
    private static final String CLASS_IMG = "//div[@class='dochub-object']/div[img]";
    private static final String PLANTUML_SCHEMA = "//div[@class='plantuml-schema']";

    public static Stream<Arguments> getCriticalPassportObject() {
        return Stream.of(
                Arguments.of(CRITICAL_PASSPORT_BUTTON, BEREZKA_CRITICALITY_PASSPORT_1C
                        , LOSES_CLIENT, LOSES_FINANCIAL, LOSES_REPUTATIONAL, CLASS_IMG
                        , getTextMessage("Паспорта критичности", "Паспорта критичности переход по " + BEREZKA_CRITICALITY_PASSPORT_1C)),
                Arguments.of(CRITICAL_PASSPORT_BUTTON, BEREZKA_CRITICALITY_PASSPORT, CLASS_IMG
                        , PASSPORT_CRYTICAL_INFO, UNVAILABILITY_SCENARIO, UNVAILABILITY_SCENARIO_LIST
                        , getTextMessage("Паспорта критичности", "Паспорта критичности переход по " + BEREZKA_CRITICALITY_PASSPORT)),
                Arguments.of(CRITICAL_PASSPORT_BUTTON, BEREZKA_CRITICALITY_PASSPORT_CATALOG, CLASS_IMG
                        , PASSPORT_CRYTICAL_INFO, UNVAILABILITY_SCENARIO, UNVAILABILITY_SCENARIO_LIST
                        , getTextMessage("Паспорта критичности", "Паспорта критичности переход по " + BEREZKA_CRITICALITY_PASSPORT_CATALOG))
        );
    }

    public static Stream<Arguments> getParametrsInsideObject() {
        return Stream.of(
                Arguments.of(SOFTWARE_BUTTON, NO_SOFTWARE_LOCATOR
                        , NO_SOFTWARE_LOCATOR, NO_SOFTWARE_LOCATOR, NO_SOFTWARE_LOCATOR
                        , getTextMessage(NO_SOFTWARE_LOCATOR, "Параметры ТА переход по ")),
                Arguments.of(SERVICES_SYSTEM_BUTTON, BEREZKA_TECH_SERVICES_GITHUB
                        , SUMMARY_TECH_METHOD, GITHUB_LINK, LIFESTAGE_AND_OWNER_BY_CHANNEL
                        , getTextMessage("Технологические сервисы и системы"
                                , "Технологические сервисы и системы переход по " + BEREZKA_TECH_SERVICES_GITHUB)),
                Arguments.of(SERVICES_SYSTEM_BUTTON, BEREZKA_TECH_SERVICES_PROMETHEUS
                        , SUMMARY_TECH_METHOD, IN_USE_LOCATOR, LIFESTAGE_AND_OWNER_BY_CHANNEL
                        , getTextMessage("Технологические сервисы и системы"
                                , "Технологические сервисы и системы переход по " + BEREZKA_TECH_SERVICES_PROMETHEUS)),
                Arguments.of(SERVICES_SYSTEM_BUTTON, BEREZKA_TECH_SERVICES_VMWARE
                        , SUMMARY_TECH_METHOD, HA_COMPONENT, OUTSIDE_LOCATOR
                        , getTextMessage("Технологические сервисы и системы"
                                , "Технологические сервисы и системы переход по " + BEREZKA_TECH_SERVICES_VMWARE))
        );
    }

    public static Stream<Arguments> getArchGroupInsideInDropDrownObject() {
        return Stream.of(
                Arguments.of(INTEGRATIONS_FLOWS_BUTTON, INTEGRATION_SBERID_BEREZKA, INTEGRATION_USER_INFO
                        ,DROPDOWN_CONTEXT_ADD, DROPDOWN_CONTEXT_GOAL, DROPDOWN_CONTEXT, LINK_АРМ
                        , getTextMessage("Интеграционные потоки", "Интеграционные потоки dropdrown " + INTEGRATION_USER_INFO)),
                Arguments.of(INTEGRATIONS_FLOWS_BUTTON, INTEGRATION_SBERID_BEREZKA2, INTEGRATION_TOKEN_INFO
                        , DROPDOWN_CONTEXT_ADD, DROPDOWN_CONTEXT_GOAL, DROPDOWN_CONTEXT, GOAL_LINK
                        , getTextMessage("Интеграционные потоки", "Интеграционные потоки dropdrown " + INTEGRATION_TOKEN_INFO))
        );
    }

    public static Stream<Arguments> getArchGroupInsideDropDrownObject() {
        return Stream.of(
                Arguments.of(GROUPS_BUTTON, LINK_MARKETPLACE_SYSTEM, DROPDOWN_CONTEXT_GROUP_WITHOUT,
                        DROPDOWN_CONTEXT_GROUP_GOAL, DROPDOWN_CONTEXT_GROUP_GOAL_WITHOUT, GOAL_LINK
                        , getTextMessage("Группы", "Группы dropdrown " + LINK_MARKETPLACE_SYSTEM))
        );
    }

    public static Stream<Arguments> getGroupInsideInObject() {
        return Stream.of(
                Arguments.of(GROUPS_BUTTON, LINK_MARKETPLACE_SYSTEM, LINK_ANALYTIC, DESCRIPTION_GROUP
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LOCATOR_IN
                        , getTextMessage("Группы", "Группы переход по " + LINK_ANALYTIC)),
                Arguments.of(GROUPS_BUTTON, LINK_MARKETPLACE_SYSTEM_CLOUD, LINK_MARKETPLACE, DESCRIPTION_GROUP
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LINK_APM
                        , getTextMessage("Группы", "Группы переход по " + LINK_MARKETPLACE)),
                Arguments.of(GROUPS_BUTTON, LINK_MARKETPLACE_SYSTEM_OFFICE, LINK_1C, DESCRIPTION_GROUP
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LINK_APM
                        , getTextMessage("Группы", "Группы переход по " + LINK_MARKETPLACE_SYSTEM_OFFICE)),
                Arguments.of(INTEGRATIONS_FLOWS_BUTTON, INTEGRATION_SBERID_BEREZKA, INTEGRATION_USER_INFO
                        , SUMMARY_BY_OBJECT, LIFECYCLE, STREAMS, LINK_MARKETPLACE
                        , getTextMessage("Интеграционные потоки", "Интеграционные потоки переход по " + INTEGRATION_USER_INFO)),
                Arguments.of(INTEGRATIONS_FLOWS_BUTTON, INTEGRATION_SBERID_BEREZKA2, INTEGRATION_TOKEN_INFO
                        , SUMMARY_BY_OBJECT, LIFECYCLE, STREAMS, LINK_MARKETPLACE
                        , getTextMessage("Интеграционные потоки", "Интеграционные потоки переход по " + INTEGRATION_TOKEN_INFO)),
                Arguments.of(INTEGRATIONS_FLOWS_BUTTON, INTEGRATION_SBERBUSINESSID_BEREZKA, INTEGRATION_EXECUTOR_NAME
                        , SUMMARY_BY_OBJECT, LIFECYCLE, STREAMS, LINK_MARKETPLACE
                        , getTextMessage("Интеграционные потоки", "Интеграционные потоки переход по " + INTEGRATION_EXECUTOR_NAME)),
                Arguments.of(INTERACTION_POINT_BUTTON, BEREZKA_FIAS_ENDPOINT, LINK_1C
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LIFESTAGE_BY_CHANNEL, LINK_APM
                        , getTextMessage("Точки взаимодействия", "Точки взаимодействия переход по " + LINK_1C)),
                Arguments.of(INTERACTION_POINT_BUTTON, BEREZKA_MESSAGE_POINT, LINK_MARKETPLACE
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LIFESTAGE_BY_CHANNEL, LINK_APM
                        , getTextMessage("Точки взаимодействия", "Точки взаимодействия переход по " + LINK_INFORMATION)),
                Arguments.of(FUNCTION_BUTTON, CATALOG_SERVICE, LINK_ANALYTIC
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LIFESTAGE_BY_CHANNEL, LINK_MARKETPLACE
                        , getTextMessage("Функциональность", "Функциональность переход по " + LINK_ANALYTIC)),
                Arguments.of(FUNCTION_BUTTON, AUTHENTICATION, LINK_MARKETPLACE
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LIFESTAGE_BY_CHANNEL, LINK_MARKETPLACE
                        , getTextMessage("Функциональность", "Функциональность переход по " + LINK_MARKETPLACE)),
                Arguments.of(FUNCTION_BUTTON, PAYMENT_SERVICE, LINK_MARKETPLACE
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LIFESTAGE_BY_CHANNEL, LINK_MARKETPLACE
                        , getTextMessage("Функциональность", "Функциональность переход по " + LINK_MARKETPLACE))
        );
    }


    public static Stream<Arguments> getIntegrationObject() {
        return Stream.of(
                Arguments.of(INTEGRATIONS_FLOWS_BUTTON, INTEGRATION_SBERID_BEREZKA, SUMMARY_INTEGRATION, TECHNOLOGIES_INTEGRATION
                        , LIFECYCLE_INTEGRATION, LOCATOR_IN, LINK_MARKETPLACE, INTEGRATION_USER_INFO, NO_DATA_LOCATOR
                        , getTextMessage("Интеграционные потоки", "Интеграционные потоки переход по " + INTEGRATION_SBERID_BEREZKA)),
                Arguments.of(INTEGRATIONS_FLOWS_BUTTON, INTEGRATION_SBERID_BEREZKA2, SUMMARY_INTEGRATION, TECHNOLOGIES_INTEGRATION
                        , LIFECYCLE_INTEGRATION, LOCATOR_IN, LINK_MARKETPLACE, INTEGRATION_TOKEN_INFO, NO_DATA_LOCATOR
                        , getTextMessage("Интеграционные потоки", "Интеграционные потоки переход по " + INTEGRATION_SBERID_BEREZKA2)),
                Arguments.of(INTEGRATIONS_FLOWS_BUTTON, INTEGRATION_SBERBUSINESSID_BEREZKA, SUMMARY_INTEGRATION, TECHNOLOGIES_INTEGRATION
                        , LIFECYCLE_INTEGRATION,  LOCATOR_IN,LINK_MARKETPLACE, INTEGRATION_EXECUTOR_NAME, NO_DATA_LOCATOR
                        , getTextMessage("Интеграционные потоки", "Интеграционные потоки переход по " + INTEGRATION_SBERBUSINESSID_BEREZKA))
        );
    }

    public static Stream<Arguments> getGroupObject() {
        return Stream.of(
                Arguments.of(GROUPS_BUTTON, LINK_MARKETPLACE_SYSTEM, DESCRIPTION_GROUP, CLASS_SPACE
                        , getTextMessage("Группы", "Группы переход по " + LINK_MARKETPLACE_SYSTEM)),
                Arguments.of(GROUPS_BUTTON, LINK_MARKETPLACE_SYSTEM_OFFICE, DESCRIPTION_GROUP, CLASS_SPACE
                        , getTextMessage("Группы", "Группы переход по " + LINK_MARKETPLACE_SYSTEM_OFFICE)),
                Arguments.of(PLANNING_TASKS_BUTTON, LINK_CREATED_PHONE, DESCRIPTION_GROUP, CLASS_SPACE
                        , getTextMessage("Задачи горизонта планирования", "Задачи горизонта планирования переход по " + LINK_CREATED_PHONE)),
                Arguments.of(PLANNING_TASKS_BUTTON, LINK_SYSTEM_ANALYTIC, DESCRIPTION_GROUP, CLASS_SPACE
                        , getTextMessage("Задачи горизонта планирования", "Задачи горизонта планирования переход по " + LINK_SYSTEM_ANALYTIC)),
                Arguments.of(INTERACTION_POINT_BUTTON, BEREZKA_FIAS_ENDPOINT, LINK_INFORMATION, CLASS_SPACE
                        , getTextMessage("Точки взаимодействия", "Точки взаимодействия переход по " + BEREZKA_FIAS_ENDPOINT)),
                Arguments.of(INTERACTION_POINT_BUTTON, BEREZKA_MESSAGE_POINT, LINK_INFORMATION, CLASS_SPACE
                        , getTextMessage("Точки взаимодействия", "Точки взаимодействия переход по " + BEREZKA_MESSAGE_POINT)),
                Arguments.of(FUNCTION_BUTTON, CATALOG_SERVICE, DESCRIPTION_GROUP, CLASS_SPACE
                        , getTextMessage("Функциональность", "Функциональность переход по " + CATALOG_SERVICE)),
                Arguments.of(FUNCTION_BUTTON, AUTHENTICATION, DESCRIPTION_GROUP, CLASS_SPACE
                        , getTextMessage("Функциональность", "Функциональность переход по " + AUTHENTICATION)),
                Arguments.of(FUNCTION_BUTTON, PAYMENT_SERVICE, DESCRIPTION_GROUP, CLASS_SPACE
                        , getTextMessage("Функциональность", "Функциональность переход по " + PAYMENT_SERVICE))
        );
    }

    public static Stream<Arguments> getBusinessObjectInsideDropDrownObject() {
        return Stream.of(
                Arguments.of(BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT, BUSINESS_OBJECT_DATE_CLIENT_NAME
                        , DROPDOWN_CONTEXT_ADD, DROPDOWN_CONTEXT_GOAL, DROPDOWN_CONTEXT, GOAL_LINK
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект dropdrown " + BUSINESS_OBJECT_DATE_CLIENT_NAME)),
                Arguments.of(BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT, BUSINESS_OBJECT_DATE_CLIENT_PHONE
                        , DROPDOWN_CONTEXT_ADD, DROPDOWN_CONTEXT_GOAL, DROPDOWN_CONTEXT, STATE_LINK
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект dropdrown " + BUSINESS_OBJECT_DATE_CLIENT_PHONE)));
    }

    public static Stream<Arguments> getBusinessObjectInsideInObject() {
        return Stream.of(
                Arguments.of(BUSINESS_OBJECT_BUTTON, BUSINESS_OBJECT_CLIENT, BUSINESS_OBJECT_DATE_CLIENT_PHONE
                        , SUMMARY_DATE_OBJECT, LIFESTAGE_BY_CHANNEL, LINK_MARKETPLACE_SYSTEM
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + BUSINESS_OBJECT_DATE_CLIENT_PHONE)),
                Arguments.of(BUSINESS_OBJECT_BUTTON, BUSINESS_OBJECT_EXECUTOR, LINK_NAME
                        , SUMMARY_DATE_OBJECT, LIFESTAGE_BY_CHANNEL, LINK_MARKETPLACE
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + LINK_NAME)),
                Arguments.of(BUSINESS_OBJECT_BUTTON, BUSINESS_OBJECT_SERVICE, LINK_SERVICE
                        , SUMMARY_DATE_OBJECT, LIFESTAGE_BY_CHANNEL, LINK_MARKETPLACE
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + LINK_SERVICE)),
                Arguments.of(BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT, BUSINESS_OBJECT_DATE_CLIENT_NAME, LINK_CRM
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LINK_CRM
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + LINK_CRM)),
                Arguments.of(BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT, BUSINESS_OBJECT_DATE_CLIENT_PHONE, LINK_CRM
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LINK_CRM
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + LINK_CRM)),
                Arguments.of(BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT, BUSINESS_OBJECT_DATE_CLIENT_ADDRESS, LINK_CRM
                        , SUMMARY_DATE_OBJECT_SYSTEM, FUNCTION_DATE_OBJECT_SYSTEM, LINK_CRM
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + LINK_CRM))
        );
    }

    public static Stream<Arguments> getBusinessObjectInsideObject() {
        return Stream.of(
                Arguments.of(BUSINESS_OBJECT_BUTTON, BUSINESS_OBJECT_CLIENT, SUMMARY_BUSINESS_OBJECT, LIFESTAGE_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + BUSINESS_OBJECT_CLIENT)),
                Arguments.of(BUSINESS_OBJECT_BUTTON, BUSINESS_OBJECT_EXECUTOR, SUMMARY_BUSINESS_OBJECT, LIFESTAGE_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + BUSINESS_OBJECT_EXECUTOR)),
                Arguments.of(BUSINESS_OBJECT_BUTTON, BUSINESS_OBJECT_SERVICE, SUMMARY_BUSINESS_OBJECT, LIFESTAGE_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + BUSINESS_OBJECT_SERVICE)),
                Arguments.of(BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT, BUSINESS_OBJECT_DATE_CLIENT_NAME, SUMMARY_DATE_OBJECT, LIFESTAGE_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + BUSINESS_OBJECT_DATE_CLIENT_NAME)),
                Arguments.of(BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT, BUSINESS_OBJECT_DATE_CLIENT_PHONE, SUMMARY_DATE_OBJECT, LIFESTAGE_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + BUSINESS_OBJECT_DATE_CLIENT_PHONE)),
                Arguments.of(BUSINESS_OBJECT_BUTTON_INSIDE_OBJECT, BUSINESS_OBJECT_DATE_CLIENT_ADDRESS, SUMMARY_DATE_OBJECT, LIFESTAGE_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Бизнесс обьект", "Бизнесс обьект переход по " + BUSINESS_OBJECT_DATE_CLIENT_ADDRESS))
        );
    }

    public static Stream<Arguments> getBusinessStrategyObject() {
        return Stream.of(
                Arguments.of(BUSINESS_STRATEGY_BUTTON, BEREZKA_STRATEGY_ID_1, SUMMARY_BY_TASK, CLASS_SPACE, getTextMessage("Сводка по стратегической задаче", "Бизнес стратегия (переход по id1)")),
                Arguments.of(BUSINESS_STRATEGY_BUTTON, BEREZKA_STRATEGY_ID_2, SUMMARY_BY_TASK, CLASS_SPACE, getTextMessage("Сводка по стратегической задаче", "Бизнес стратегия (переход по id1)")),
                Arguments.of(CLIENTS_BUTTON, CLIENTS_USERS, SUMMARY_BY_EMPLOYEES, CLASS_SPACE, getTextMessage("Клиенты", "Клиенты (переход по ecogroup.berezka.client)")),
                Arguments.of(CLIENTS_BUTTON, CLIENTS_BUSINESS, SUMMARY_BY_EMPLOYEES, CLASS_SPACE, getTextMessage("Клиенты", "Клиенты переход по " + CLIENTS_BUSINESS)),
                Arguments.of(CLIENTS_BUTTON, CLIENTS_EMPLOYEES, SUMMARY_BY_EMPLOYEES, CLASS_SPACE, getTextMessage("Клиенты", "Клиенты переход по " + CLIENTS_EMPLOYEES)),
                Arguments.of(BUSINESS_GOALS_BUTTON, BEREZKA_GOAL_ID_1, SUMMARY_BY_GOAL, CLASS_SPACE, getTextMessage("Сводка по бизнес-цели", "Бизнес цель переход по " + BEREZKA_GOAL_ID_1)),
                Arguments.of(BUSINESS_GOALS_BUTTON, BEREZKA_GOAL_ID_2, SUMMARY_BY_GOAL, CLASS_SPACE, getTextMessage("Сводка по бизнес-цели", "Бизнес цель переход по " + BEREZKA_GOAL_ID_2)),
                Arguments.of(BUSINESS_GOALS_BUTTON, BEREZKA_GOAL_ID_3, SUMMARY_BY_GOAL, CLASS_SPACE, getTextMessage("Сводка по бизнес-цели", "Бизнес цель переход по " + BEREZKA_GOAL_ID_3)),
                Arguments.of(BUSINESS_PROCESS_BUTTON, PROCESS_CHOOSE_EXECUTOR, SUMMARY_BY_PROCESS, CLASS_SPACE, getTextMessage("Сводка по бизнес-процессу", "Бизнес процесс переход по " + PROCESS_CHOOSE_EXECUTOR)),
                Arguments.of(BUSINESS_PROCESS_BUTTON, PROCESS_ONE, SUMMARY_BY_PROCESS, CLASS_SPACE, getTextMessage("Сводка по бизнес-процессу", "Бизнес процесс переход по " + PROCESS_ONE)),
                Arguments.of(BUSINESS_PROCESS_BUTTON, PROCESS_TWO, SUMMARY_BY_PROCESS, CLASS_SPACE, getTextMessage("Сводка по бизнес-процессу", "Бизнес процесс переход по " + PROCESS_TWO))
        );
    }

    public static Stream<Arguments> getBusinessChannelsObject() {
        return Stream.of(
                Arguments.of(INTERACTION_CHANNEL_BUTTON, CHANNEL_WEB, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Сводка по бизнес-каналу", "Бизнес канал переход по )" + CHANNEL_WEB)),
                Arguments.of(INTERACTION_CHANNEL_BUTTON, CHANNEL_APP, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Сводка по бизнес-каналу", "Бизнес канал переход по " + CHANNEL_APP)),
                Arguments.of(INTERACTION_CHANNEL_BUTTON, CHANNEL_EXECUTOR_APP, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Сводка по бизнес-каналу", "Бизнес канал переход по " + CHANNEL_EXECUTOR_APP)),
                Arguments.of(INTERACTION_CHANNEL_BUTTON, CHANNEL_PROFIRU, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Сводка по бизнес-каналу", "Бизнес канал переход по " + CHANNEL_PROFIRU)),
                Arguments.of(PRODUCTS_BUTTON, LINK_MARKETPLACE_SERVICES, SUMMARY_BY_PRODUCT, LIFESTAGE_BY_CHANNEL, CHANNELS_BY_PRODUCT, CLASS_SPACE
                        , getTextMessage("Сводка по бизнес-каналу", "Бизнес канал переход по " + LINK_MARKETPLACE_SERVICES)),
                Arguments.of(PRODUCTS_BUTTON, LINK_MARKETPLACE_CLEAN_SERVICES, SUMMARY_BY_PRODUCT, LIFESTAGE_BY_CHANNEL, CHANNELS_BY_PRODUCT, CLASS_SPACE
                        , getTextMessage("Сводка по бизнес-каналу", "Бизнес канал переход по " + LINK_MARKETPLACE_CLEAN_SERVICES)),
                Arguments.of(PRODUCTS_BUTTON, LINK_MARKETPLACE_SUPPORT, SUMMARY_BY_PRODUCT, LIFESTAGE_BY_CHANNEL, CHANNELS_BY_PRODUCT, CLASS_SPACE
                        , getTextMessage("Сводка по бизнес-каналу", "Бизнес канал переход по " + LINK_MARKETPLACE_SUPPORT))
        );
    }

    public static Stream<Arguments> getBusinessClientsInsideObject() {
        return Stream.of(
                Arguments.of(CLIENTS_BUTTON, CLIENTS_USERS, LINK_WEB, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Клиенты", "Клиенты переход по " + LINK_WEB)),
                Arguments.of(CLIENTS_BUTTON, CLIENTS_BUSINESS, LINK_WEB, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Клиенты", "Клиенты переход по " + LINK_WEB)),
                Arguments.of(CLIENTS_BUTTON, CLIENTS_EMPLOYEES, LINK_АРМ, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Клиенты", "Клиенты переход по " + LINK_АРМ)),
                Arguments.of(PRODUCTS_BUTTON, LINK_MARKETPLACE_SERVICES, LINK_WEB, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Клиенты", "Клиенты переход по " + LINK_MARKETPLACE_SERVICES)),
                Arguments.of(PRODUCTS_BUTTON, LINK_MARKETPLACE_CLEAN_SERVICES, LINK_WEB, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Клиенты", "Клиенты переход по " + LINK_MARKETPLACE_CLEAN_SERVICES)),
                Arguments.of(PRODUCTS_BUTTON, LINK_MARKETPLACE_SUPPORT, LINK_CALL_CENTER, SUMMARY_BY_CHANNEL, LIFESTAGE_BY_CHANNEL, OWNER_BY_CHANNEL, CLASS_SPACE
                        , getTextMessage("Клиенты", "Клиенты переход по " + LINK_MARKETPLACE_SUPPORT))
        );
    }
}
