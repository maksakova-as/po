package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static helpers.ContextExtendedAndViewLocators.*;
import static helpers.ContextLocators.*;
import static helpers.ContextLocators.CURRENT_SYSTEM_CONTEXT;
import static helpers.DataPageLocators.CLIENTS_ADRESS_LINK_TAB;
import static helpers.DataPageLocators.CLIENT_PHONE_NUMBER_LINK_TAB;
import static helpers.DataPageLocators.EXECUTOR_FULL_NAME_LINK_TAB;
import static helpers.DataPageLocators.EXECUTOR_PHONE_NUMBER_LINK_TAB;
import static helpers.DataPageLocators.SERVICE_STATISTICS_LINK_TAB;

public class TestData {

    private static final String SCHEMA = "Схема";
    private static final String FUNCTION_LINK = "Функция системы";
    private static final String LINK = "Cсылка";
    private static final String TABLE = "Ссылка в таблице";

    public static Stream<Arguments> getCriticalSystemTest() {
        return Stream.of(
                Arguments.of(ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()));
    }

    public static Stream<Arguments> getSystemArchitecturialTest() {
        return Stream.of(
                Arguments.of(CURRENT_SCHEME.getLocator()
                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),

//                Arguments.of(CURRENT_SCHEME_ONLY.getLocator()
//                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
//                        , ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),

                Arguments.of(CURRENT_SCHEME_WITHOUT.getLocator()
                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),

//                Arguments.of(CURRENT_SCHEME_WITHOUT_PERIMETR.getLocator()
//                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
//                        , ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),

                Arguments.of(GOAL_SCHEME.getLocator()
                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),

//                Arguments.of(GOAL_SCHEME_ONLY.getLocator()
//                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
//                        , ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
//                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator())

                Arguments.of(GOAL_WITHOUT_FP.getLocator()
                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator())
        );
    }

    public static Stream<Arguments> getSystemAnalyticTest() {
        return Stream.of(
                Arguments.of(CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.CURRENT_SYSTEM_CONTEXT.getLocator(),
                        ContextExtendedAndViewLocators.CURRENT_SYSTEM_CONTEXT.getLocator(),
                        ContextExtendedAndViewLocators.CURRENT_SYSTEM_CONTEXT.getLocator(),
                        ContextExtendedAndViewLocators.CURRENT_SYSTEM_CONTEXT.getLocator()),

                Arguments.of(CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.CONTEXT_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CONTEXT_SYSTEM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_SYSTEM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_SYSTEM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_SYSTEM_LINK.getLocator()),

                Arguments.of(GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ANALITIKA_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ANALITIKA_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator())
        );
    }

    public static Stream<Arguments> getInternalSystemTest() {
        return Stream.of(
                Arguments.of(ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.TEXT_SYSTEMS_MARKETPLASE_IN_OFICE.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.APM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.TEXT_SYSTEMS_MARKETPLASE_IN_OFICE.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator()),

                Arguments.of(ParentPageLocators.CRM_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.CRM_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.CRM_LINK_TAB.getLocator(), GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.CRM_LINK_TAB.getLocator(), GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator()),

                Arguments.of(ParentPageLocators.MARKET_SERVICE_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.MARKET_SERVICE_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.MARKET_SERVICE_LINK_TAB.getLocator(), GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.MARKET_SERVICE_LINK_TAB.getLocator(), GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),

                Arguments.of(ParentPageLocators.CATALOG_SERVICE_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.ECO_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.CATALOG_SERVICE_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.ECO_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.CATALOG_SERVICE_LINK_TAB.getLocator(), GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.ECO_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.CATALOG_SERVICE_LINK_TAB.getLocator(), GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.ECO_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(ParentPageLocators.MARKETPLACE_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.ECO_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.MARKETPLACE_LINK_TAB.getLocator(), CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.ECO_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.MARKETPLACE_LINK_TAB.getLocator(), GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.ECO_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.MARKETPLACE_LINK_TAB.getLocator(), GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.ECO_SYSTEM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TEXT_SYSTEMS_MARKETPLASE_IN_OFICE.getLocator())
        );
    }

    public static Stream<Arguments> getExternalSystemTest() {
        return Stream.of(
                Arguments.of(ParentPageLocators.GIS_2_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GIS_2_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GIS_2_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GIS_2_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()),

                Arguments.of(ParentPageLocators.EMAIL_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.APM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EMAIL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()),
                Arguments.of(ParentPageLocators.EMAIL_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.APM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EMAIL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()),
                Arguments.of(ParentPageLocators.EMAIL_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.APM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EMAIL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()),
                Arguments.of(ParentPageLocators.EMAIL_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.APM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EMAIL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()),

                Arguments.of(ParentPageLocators.SMSC_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.SMSC_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.SMSC_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.SMSC_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),

                Arguments.of(ParentPageLocators.TELEGRAM_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.TELEGRAM_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()),
                Arguments.of(ParentPageLocators.TELEGRAM_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()),
                Arguments.of(ParentPageLocators.TELEGRAM_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()),

                Arguments.of(ParentPageLocators.ATC_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.ElEM_INTERNAL_EMPLOYEES_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ATC_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator()),
                Arguments.of(ParentPageLocators.ATC_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.ElEM_INTERNAL_EMPLOYEES_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ATC_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator()),
                Arguments.of(ParentPageLocators.ATC_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.ElEM_INTERNAL_EMPLOYEES_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ATC_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CALL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.ATC_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.ElEM_INTERNAL_EMPLOYEES_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ATC_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CALL_LINK.getLocator()),

                Arguments.of(ParentPageLocators.GOVERNMENT_SERVICE_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GOVERNMENT_SERVICE_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GOVERNMENT_SERVICE_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOV_SERVICES_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GOVERNMENT_SERVICE_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOV_SERVICES_LINK.getLocator()),

                Arguments.of(ParentPageLocators.NEWSLETTERS_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETING_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETING_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.NEWSLETTERS_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.MARKETING_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETING_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETING_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.NEWSLETTERS_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETING_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETING_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETING_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.NEWSLETTERS_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.MARKETING_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETING_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETING_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),

                Arguments.of(ParentPageLocators.OFFICE_365_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.OFFICE_365_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.OFFICE_365_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(ParentPageLocators.OFFICE_365_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ITERNAL_EMPLOYEES_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),

                Arguments.of(ParentPageLocators.SMAV_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.STATE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.BUCHUCHET_LINK.getLocator()),
                Arguments.of(ParentPageLocators.SMAV_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.STATE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.SMAV_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.STATE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.SMAV_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.STATE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.FIAS_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_OFFICE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.FIAS_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_OFFICE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.FIAS_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_OFFICE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.FIAS_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_OFFICE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GATEWAY_FIAS_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_OFFICE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GATEWAY_FIAS_LINK_TAB.getLocator(),CURRENT_SYSTEM_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_OFFICE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GATEWAY_FIAS_LINK_TAB.getLocator(),GOAL_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_OFFICE_LINK.getLocator()),
                Arguments.of(ParentPageLocators.GATEWAY_FIAS_LINK_TAB.getLocator(),GOAL_CONTEXT_VIEW.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_OFFICE_LINK.getLocator())
                );
    }

    public static Stream<Arguments> getPageSchemasDataTest() {
        return Stream.of(
                Arguments.of(DataPageLocators.ID_TOKEN_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.ID_TOKEN_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_ID_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.ID_TOKEN_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_ID_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.ID_TOKEN_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.ACCESS_TOKEN_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_ID_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.ID_TOKEN_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_LINK.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_ID_LINK.getLocator(),
                        ContextExtendedAndViewLocators.APM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(CLIENTS_ADRESS_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator()),
                Arguments.of(CLIENTS_ADRESS_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator()),
                Arguments.of(CLIENTS_ADRESS_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator()),
                Arguments.of(CLIENTS_ADRESS_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator()),

                Arguments.of(DataPageLocators.GEODATA_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GIS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.GEODATA_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GIS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.GEODATA_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GIS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.GEODATA_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GIS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(DataPageLocators.PAYMENT_DATA_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.PAY_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.PAYMENT_DATA_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.PAY_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.PAYMENT_DATA_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.PAY_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.PAYMENT_DATA_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.PAY_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(DataPageLocators.PAYMENTS_DETAILS_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.DATE_PAY_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.PAYMENTS_DETAILS_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.DATE_PAY_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.APM_LINK.getLocator()),
                Arguments.of(DataPageLocators.PAYMENTS_DETAILS_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.DATE_PAY_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.PAYMENTS_DETAILS_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.DATE_PAY_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(DataPageLocators.SERVICE_DATA_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_ADS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.COMMON_ECO_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_DATA_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_ADS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CALL_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_DATA_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_ADS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_DATA_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_ADS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(DataPageLocators.USER_DATA_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_ID_LINK.getLocator(),
                        ContextExtendedAndViewLocators.USER_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.USER_DATA_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_ID_LINK.getLocator(),
                        ContextExtendedAndViewLocators.USER_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator()),
                Arguments.of(DataPageLocators.USER_DATA_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_ID_LINK.getLocator(),
                        ContextExtendedAndViewLocators.USER_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.USER_DATA_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_ID_LINK.getLocator(),
                        ContextExtendedAndViewLocators.USER_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(DataPageLocators.SERVICE_REQUEST_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SERVICE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_REQUEST_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SERVICE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_REQUEST_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SERVICE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_REQUEST_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SERVICE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(SERVICE_STATISTICS_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator()),
                Arguments.of(SERVICE_STATISTICS_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CONTEXT_LINK.getLocator()),
                Arguments.of(SERVICE_STATISTICS_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.ANALITIKA_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_CHOOSE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),
                Arguments.of(SERVICE_STATISTICS_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.ANALITIKA_LINK.getLocator(),
                        ContextExtendedAndViewLocators.APM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_CHOOSE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),

                Arguments.of(DataPageLocators.MANDATORY_REPORTING_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.ACCOUNTING_1C_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),
                Arguments.of(DataPageLocators.MANDATORY_REPORTING_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.ACCOUNTING_1C_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),
                Arguments.of(DataPageLocators.MANDATORY_REPORTING_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.ACCOUNTING_1C_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),
                Arguments.of(DataPageLocators.MANDATORY_REPORTING_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.ACCOUNTING_1C_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CMEB_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.STATE_LINK.getLocator()),

                Arguments.of(DataPageLocators.TRANSACTION_PARAMETR_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MINSK_SYSTEMS_LOCATOR.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.TRANSACTION_PARAMETR_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MINSK_SYSTEMS_LOCATOR.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.TRANSACTION_PARAMETR_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MINSK_SYSTEMS_LOCATOR.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.TRANSACTION_PARAMETR_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MINSK_SYSTEMS_LOCATOR.getLocator()
                        , ContextExtendedAndViewLocators.SHLUS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(DataPageLocators.CONTRACTOR_EMAIL_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator()),
                Arguments.of(DataPageLocators.CONTRACTOR_EMAIL_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator()),
                Arguments.of(DataPageLocators.CONTRACTOR_EMAIL_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator()),
                Arguments.of(DataPageLocators.CONTRACTOR_EMAIL_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator()),

                Arguments.of(DataPageLocators.SERVICE_TRANSACTION_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_TRANSACTION_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_TRANSACTION_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),
                Arguments.of(DataPageLocators.SERVICE_TRANSACTION_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_MODIFIED_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()),

                Arguments.of(EXECUTOR_PHONE_NUMBER_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(EXECUTOR_PHONE_NUMBER_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(EXECUTOR_PHONE_NUMBER_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(EXECUTOR_PHONE_NUMBER_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),

                Arguments.of(CLIENT_PHONE_NUMBER_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(CLIENT_PHONE_NUMBER_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(CLIENT_PHONE_NUMBER_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),
                Arguments.of(CLIENT_PHONE_NUMBER_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator()),

                Arguments.of(DataPageLocators.CLIENT_FULL_NAME_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator()),
                Arguments.of(DataPageLocators.CLIENT_FULL_NAME_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator()),
                Arguments.of(DataPageLocators.CLIENT_FULL_NAME_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator()),
                Arguments.of(DataPageLocators.CLIENT_FULL_NAME_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_LINK.getLocator()),

                Arguments.of(EXECUTOR_FULL_NAME_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.BUSINESS_LINK.getLocator()),
                Arguments.of(EXECUTOR_FULL_NAME_LINK_TAB.getLocator(), CURRENT_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.BUSINESS_LINK.getLocator()),
                Arguments.of(EXECUTOR_FULL_NAME_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.BUSINESS_LINK.getLocator()),
                Arguments.of(EXECUTOR_FULL_NAME_LINK_TAB.getLocator(), TARGET_DATA_CONTEXT_EXTENDED.getLocator()
                        , ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.GOAL_PART_LINK.getLocator(),
                        ContextExtendedAndViewLocators.BUSINESS_LINK.getLocator())
                );
    }

    public static Stream<Arguments> getGeneralSchemasTest() {

        return Stream.of(
                Arguments.of(GeneralPageLocators.ARCH_SCHEMA_SMART_ANTS.getLocator()
                        , CURRENT_SCHEME.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(GeneralPageLocators.ARCH_SCHEMA_SMART_ANTS.getLocator()
                        , GOAL_SCHEME.getLocator()
                        , ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(GeneralPageLocators.DATA_CARD_LiST.getLocator()
                        , CURRENT_CARD.getLocator(),
                        SBER_PROFILE_LINK.getLocator(),
                        CLIENT_LINK.getLocator(),
                        DATE_CARD_LINK.getLocator(),
                        OTHER_LINK.getLocator(),
                        PARAMETERS_LINK.getLocator()),
                Arguments.of(GeneralPageLocators.DATA_CARD_LiST.getLocator()
                        , GOAL_CARD.getLocator(),
                        SBER_PROFILE_LINK.getLocator(),
                        CLIENT_LINK.getLocator(),
                        DATE_CARD_LINK.getLocator(),
                        OTHER_LINK.getLocator(),
                        PARAMETERS_LINK.getLocator()),

                Arguments.of(GeneralPageLocators.SYSTEMS_CARD_LIST.getLocator()
                        , SYSTEM_CARD.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(GeneralPageLocators.SYSTEMS_CARD_LIST.getLocator()
                        , GOAL_SYSTEM_CARD.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SBER_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.TELEGRAM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(GeneralPageLocators.BUSINESS_LAYER_DIAGRAM_LIST.getLocator()
                        , SCHEME_BUSINESS.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ElEM_INTERNAL_EMPLOYEES_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(GeneralPageLocators.BUSINESS_LAYER_DIAGRAM_LIST.getLocator()
                        , GOAL_BUSINESS_SCHEME.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.ElEM_INTERNAL_EMPLOYEES_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),

                Arguments.of(GeneralPageLocators.FUNCTIONAL_CARD_LIST.getLocator()
                        , FUNCTION_CARD.getLocator(),
                        ContextExtendedAndViewLocators.PAY_SERVICE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.BUCHUCHET_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()),
                Arguments.of(GeneralPageLocators.FUNCTIONAL_CARD_LIST.getLocator()
                        , GOAL_FUNCTION_CARD.getLocator(),
                        ContextExtendedAndViewLocators.PAY_SERVICE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.BUCHUCHET_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CATALOG_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CRM_LINK.getLocator(),
                        ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator())
        );
    }

    public static Stream<Arguments> getSystemCardTest() {
        return Stream.of(
                Arguments.of(ParentPageLocators.MARKETPLACE_LINK_TAB.getLocator(), FunctionsSystemsLocators.AUTH_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, " Карточка системы Маркетплейс ")),
                Arguments.of(ParentPageLocators.CRM_LINK_TAB.getLocator(), FunctionsSystemsLocators.CONDUCTING_TRANSACTIONS_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы CRM")),
                Arguments.of(ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), FunctionsSystemsLocators.BUCH_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы 1C_Бухгалтерия")),
                Arguments.of(ParentPageLocators.GIS_2_LINK_TAB.getLocator(),
                        FunctionsSystemsLocators.GIS_FUNCTION_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы 2GIS")),
                Arguments.of(ParentPageLocators.NEWSLETTERS_LINK_TAB.getLocator(),
                        FunctionsSystemsLocators.MARKET_FUNCTION_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы Маркетинговые рассылки")),
                Arguments.of(ParentPageLocators.SMSC_LINK_TAB.getLocator(), FunctionsSystemsLocators.SEND_SMS_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы SMSC")),
                Arguments.of(ParentPageLocators.EMAIL_LINK_TAB.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_FUNCTION_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы EMAIL")),
                Arguments.of(ParentPageLocators.ATC_LINK_TAB.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_FUNCTION_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы ATC")),
                Arguments.of(ParentPageLocators.OFFICE_365_LINK_TAB.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_FUNCTION_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы Office 365")),
                Arguments.of(ParentPageLocators.TELEGRAM_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_DATA_FUNCTION_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы Telegram")),
                Arguments.of(ParentPageLocators.GOVERNMENT_SERVICE_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_DATA_FUNCTION_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы Госуслуги ")),
                Arguments.of(ParentPageLocators.SMAV_LINK_TAB.getLocator(), FunctionsSystemsLocators.CMEW_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы СМЭВ")),
                Arguments.of(ParentPageLocators.MARKET_SERVICE_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_DATA_FUNCTION_LINK.getLocator(),
                        Actions.getTextMessage(FUNCTION_LINK, "Карточка системы Сервис услуг"))
        );
    }

    public static Stream<Arguments> getDataCheckLandscapeDropdownTest() {
        return Stream.of(
                Arguments.of(ParentPageLocators.MARKETPLACE_LINK_TAB.getLocator(), FunctionsSystemsLocators.TICKET_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.OWN_CODE_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.PERFORMER_SELECTION_LINK.getLocator(), FunctionsSystemsLocators.WEB_APPLICATION_LINK.getLocator(),
                        FunctionsSystemsLocators.PERFORMANCE_DATA_LINK.getLocator(), FunctionsSystemsLocators.SCALABILITY_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.CATALOG_SERVICE_LINK_TAB.getLocator(), FunctionsSystemsLocators.BUSINESS_SECRET_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.OWN_CODE_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(),FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.RTO_DATA_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.CRM_LINK_TAB.getLocator(), FunctionsSystemsLocators.IN_USE_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.OWN_EXAMPLE_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.EXPERIENCE_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.COLL_CENTER_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PROMETHEUS_LINK.getLocator(), FunctionsSystemsLocators.SCALABILITY_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), FunctionsSystemsLocators.BUSINESS_SECRET_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.OWN_EXAMPLE_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.ARM_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.ACCESSIBILITY_LINK.getLocator(),FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.ANALYTICA_LINK_TAB.getLocator(), FunctionsSystemsLocators.STATISTICS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.MARKETPLACE_LOCATOR.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.RESERVATION_TYPE_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.GIS_2_LINK_TAB.getLocator(), FunctionsSystemsLocators.DATA_PERSONAL_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.EXTERNAL_LINK.getLocator(),FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.WEB_APPLICATION_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.RPO_LINK.getLocator(),FunctionsSystemsLocators.RESERVATION_FULL_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.NEWSLETTERS_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.EXTERNAL_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.RTO_LINK.getLocator(),FunctionsSystemsLocators.RESERVATION_DR_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.SMSC_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.EXTERNAL_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.ACCESS_LEVEL_LINK.getLocator(), FunctionsSystemsLocators.RESERVATION_TYPE_ZONE_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.EMAIL_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.EXTERNAL_CLOUD_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.ARM_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.MONITORING_LINK.getLocator(), FunctionsSystemsLocators.RESERVATION_FULL_ZONE_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.ATC_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.EXTERNAL_CLOUD_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.COLL_CENTER_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.RESERVATION_BACKUP_ZONE_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.OFFICE_365_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.EXTERNAL_CLOUD_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.ARM_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PERFORMANCE_LINK.getLocator(), FunctionsSystemsLocators.RESERVATION_BACKUP_COPY_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.TELEGRAM_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.PARTNERS_SYSTEM_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.SOCIAL_NETWORK_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.GOVERNMENT_SERVICE_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.PARTNERS_SYSTEM_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.SMAV_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.PARTNERS_SYSTEM_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.MARKET_SERVICE_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.OWN_CODE_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.OLD_OFFICE_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_LOCATOR.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.SOSINKA_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.OWN_CODE_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.ARCHIVE_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.PERFORMER_SELECTION_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.DUBOK_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.OWN_CODE_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.NOT_GOAL_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.FIAS_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.PARTNERS_SYSTEM_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator()),

                Arguments.of(ParentPageLocators.GATEWAY_FIAS_LINK_TAB.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(), FunctionsSystemsLocators.OWN_LINK.getLocator(),
                        FunctionsSystemsLocators.PARTNERS_SYSTEM_LINK.getLocator(), FunctionsSystemsLocators.STEP_OF_LIFE_CYCLE_LINK.getLocator(), FunctionsSystemsLocators.COMMERCIAL_OPERATION_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_DATA_CHANNELS_LINK.getLocator(), FunctionsSystemsLocators.NOT_BUSINESS_PROCESSES_LINK.getLocator(),
                        FunctionsSystemsLocators.PARAMETERS_LINK.getLocator(), FunctionsSystemsLocators.HIGH_ACCESS_LINK.getLocator(), FunctionsSystemsLocators.NOT_SYSTEM_OBJECTS_LINK.getLocator(),
                        FunctionsSystemsLocators.NOT_SYSTEM_COMPONENTS_LINK.getLocator(), FunctionsSystemsLocators.SYSTEM_CONTEXT_LINK.getLocator(), FunctionsSystemsLocators.NOT_SOFTWARE_LINK.getLocator(),
                        FunctionsSystemsLocators.SERVICE_MANAGEMENT_LINK.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA.getLocator(), FunctionsSystemsLocators.ASSESSMENT_DATA_NOT_EXIST.getLocator())
        );
    }

    public static Stream<Arguments> getDataCheckSystemContextDropdownTest() {
        return Stream.of(
                Arguments.of(ParentPageLocators.MARKETPLACE_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(), ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(), ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        Actions.getTextMessage(SCHEMA, " Карточка системы Маркетплейс ")),
                Arguments.of(ParentPageLocators.CRM_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(), ContextExtendedAndViewLocators.GOAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(), ContextExtendedAndViewLocators.MARKETPLACE_LINK.getLocator()
                        , ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        Actions.getTextMessage(SCHEMA, "Карточка системы CRM")),
                Arguments.of(ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator()
                        , ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(),
                        Actions.getTextMessage(SCHEMA, "Карточка системы 1C_Бухгалтерия")),
                Arguments.of(ParentPageLocators.GIS_2_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(), ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(), ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SYSTEM_MARKETPLACE_LINK.getLocator(),
                        Actions.getTextMessage(SCHEMA, "Карточка системы 2GIS")),
                Arguments.of(ParentPageLocators.EMAIL_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(), ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(), ContextExtendedAndViewLocators.ElEM_INTERNAL_EMPLOYEES_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(),
                        Actions.getTextMessage(SCHEMA, "Карточка системы  EMAIL")),
                Arguments.of(ParentPageLocators.ATC_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.CALL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(), ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        CUSTOMERS_LINK.getLocator(), ContextExtendedAndViewLocators.ATC_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CUSTOMERS_LINK.getLocator(),
                        Actions.getTextMessage(SCHEMA, "Карточка системы ATC")),
                Arguments.of(ParentPageLocators.OFFICE_365_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(), ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(),
                        ContextExtendedAndViewLocators.EXTERNAL_CLOUD_LINK.getLocator(), ContextExtendedAndViewLocators.EXTERNAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(),
                        Actions.getTextMessage(SCHEMA, "Карточка системы Офис365")),
                Arguments.of(ParentPageLocators.TELEGRAM_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_CLIENT_LINK.getLocator(), ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(), ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        ContextExtendedAndViewLocators.SOCIAL_LINK.getLocator(),
                        Actions.getTextMessage(SCHEMA, "Карточка системы Telegram")),
                Arguments.of(ParentPageLocators.MARKET_SERVICE_LINK_TAB.getLocator(), ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        CUSTOMERS_LINK.getLocator(), ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(), ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        ContextExtendedAndViewLocators.CHANNELS_LINK.getLocator(),
                        Actions.getTextMessage(SCHEMA, "Карточка системы Сервис услуг"))
        );
    }

    public static Stream<Arguments> getDataCheckIntegrationsFlowsTest() {
        return Stream.of(
                Arguments.of(ParentPageLocators.MARKETPLACE_LINK_TAB.getLocator(), IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator(),
                        IntegrationsFlowsLocators.FALSE_LINK.getLocator(), IntegrationsFlowsLocators.FALSE_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, " Карточка системы Маркетплейс ")),
                Arguments.of(ParentPageLocators.CRM_LINK_TAB.getLocator(), IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator(), IntegrationsFlowsLocators.CRM_LINK.getLocator(), IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы CRM")),
                Arguments.of(ParentPageLocators.ACCOUNTING_1C_LINK_TAB.getLocator(), IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator()
                        , IntegrationsFlowsLocators.TRUE_LINK.getLocator(), IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы 1C_Бухгалтерия")),
                Arguments.of(ParentPageLocators.GIS_2_LINK_TAB.getLocator(), IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator(),
                        IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator(), IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы 2GIS")),
                Arguments.of(ParentPageLocators.NEWSLETTERS_LINK_TAB.getLocator(), IntegrationsFlowsLocators.FALSE_LINK.getLocator(),
                        IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(), IntegrationsFlowsLocators.FALSE_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы  Маркетинговые рассылки")),
                Arguments.of(ParentPageLocators.SMSC_LINK_TAB.getLocator(), IntegrationsFlowsLocators.FALSE_LINK.getLocator(),
                        IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(), IntegrationsFlowsLocators.FALSE_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы  SMSC")),
                Arguments.of(ParentPageLocators.ATC_LINK_TAB.getLocator(), IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(),
                        IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(), IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы ATC")),
                Arguments.of(ParentPageLocators.TELEGRAM_LINK_TAB.getLocator(), IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(),
                        IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(), IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы Telegram")),
                Arguments.of(ParentPageLocators.GOVERNMENT_SERVICE_LINK_TAB.getLocator(), IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(),
                        IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(), IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы Госуслуги")),
                Arguments.of(ParentPageLocators.SMAV_LINK_TAB.getLocator(), IntegrationsFlowsLocators.SMEV_LINK.getLocator(),
                        IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(), IntegrationsFlowsLocators.SMEV_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы СМЭВ")),
                Arguments.of(ParentPageLocators.MARKET_SERVICE_LINK_TAB.getLocator(), IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(),
                        IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(), IntegrationsFlowsLocators.NOT_DATA_FLOWS_LINK.getLocator(),
                        Actions.getTextMessage(TABLE, "Карточка системы Сервис услуг"))
        );
    }

    public static Stream<Arguments> getDataCheckInteractionPointTest() {
        return Stream.of(
                Arguments.of(InteractionPointPage.BEREZKA_ENDPOINT.getLocator(),InteractionPointPage.FIAS.getLocator(),
                        InteractionPointPage.PULL.getLocator(), IntegrationsFlowsLocators.FALSE_LINK.getLocator()),
                Arguments.of(InteractionPointPage.BEREZKA_POINT.getLocator(), IntegrationsFlowsLocators.MARKETPLACE_LINK.getLocator(),
                        InteractionPointPage.PULL.getLocator(),IntegrationsFlowsLocators.FALSE_LINK.getLocator())
        );
    }

    public static Stream<Arguments> getDataCheckRegistersTest() {
        return Stream.of(
                Arguments.of(RegistersPages.BACKUP_FIND_PAGE.getLocator(), RegistersPages.BACKUP_PAGE.getLocator(), RegistersPages.POLICY_NAME.getLocator(),RegistersPages.POLICY_GOAL.getLocator(),
                        RegistersPages.POLICY_STATUS.getLocator()),
                Arguments.of(RegistersPages.CLOUD_FIND_PAGE.getLocator(), RegistersPages.CLOUD_PAGE.getLocator(), RegistersPages.CLOUD_CLUSTER_NAME.getLocator(),RegistersPages.CLOUD_FLAVOR.getLocator(),
                        RegistersPages.CLOUD_AUTH.getLocator()),
                Arguments.of(RegistersPages.DISTRIBUTED_FIND_PAGE.getLocator(), RegistersPages.DISTRIBUTED_PAGE.getLocator(), RegistersPages.DISTRIBUTED_CLUSTER_NAME.getLocator(),RegistersPages.DISTRIBUTED_SPECIFICATION.getLocator(),
                        RegistersPages.DISTRIBUTED_VPC.getLocator()),
                Arguments.of(RegistersPages.ELASTIC_CLOUD_FIND_PAGE.getLocator(), RegistersPages.ELASTIC_CLOUD_PAGE.getLocator(), RegistersPages.ELASTIC_SERVER_NAME.getLocator(),RegistersPages.ELASTIC_OS.getLocator(),
                        RegistersPages.ELASTIC_SUBNET.getLocator()),
                Arguments.of(RegistersPages.ELASTIC_IPs_FIND_PAGE.getLocator(), RegistersPages.ELASTIC_IPs_PAGE.getLocator(), RegistersPages.ELASTIC_PERFOMANCE.getLocator(),RegistersPages.ELASTIC_PORT_ID.getLocator(),
                        RegistersPages.ELASTIC_TENANT_ID.getLocator()),
                Arguments.of(RegistersPages.ELASTIC_LOAD_FIND_PAGE.getLocator(), RegistersPages.ELASTIC_LOAD_PAGE.getLocator(), RegistersPages.ELASTIC_NAME.getLocator(),RegistersPages.ELASTIC_LISTENERS.getLocator(),
                        RegistersPages.ELASTIC_POOL.getLocator()),
                Arguments.of(RegistersPages.NAT_GATEWAYS_FIND_PAGE.getLocator(), RegistersPages.NAT_GATEWAYS_PAGE.getLocator(), RegistersPages.NAT_NAME.getLocator(),RegistersPages.NAT_SUBNET.getLocator(),
                        RegistersPages.NAT_VPC.getLocator()),
                Arguments.of(RegistersPages.PEERING_FIND_PAGE.getLocator(), RegistersPages.PEERING_PAGE.getLocator(), RegistersPages.PEERING_NAME.getLocator(),RegistersPages.PEERING_VPC_ID.getLocator(),
                        RegistersPages.PEERING_STATUS.getLocator()),
                Arguments.of(RegistersPages.RELATIONAL_DB_FIND_PAGE.getLocator(), RegistersPages.RELATIONAL_DB_PAGE.getLocator(), RegistersPages.RELATIONAL_DB_NAME.getLocator(),RegistersPages.RELATIONAL_STATUS.getLocator(),
                        RegistersPages.REGISTERS_TYPE.getLocator()),
                Arguments.of(RegistersPages.SECURITY_GROUPS_FIND_PAGE.getLocator(), RegistersPages.SECURITY_GROUPS_PAGE.getLocator(), RegistersPages.SECURITY_GROUP_NAME.getLocator(),RegistersPages.SECURITY_GROUP_DESCRIPTION.getLocator(),
                        RegistersPages.SECURITY_GROUP_ID.getLocator()),
                Arguments.of(RegistersPages.VPC_FIND_PAGE.getLocator(), RegistersPages.VPC_PAGE.getLocator(), RegistersPages.VPC_ID.getLocator(),RegistersPages.VPC_NAME.getLocator(),
                        RegistersPages.VPC_SUBNET.getLocator()),
                Arguments.of(RegistersPages.VPN_FIND_PAGE.getLocator(), RegistersPages.VPN_PAGE.getLocator(), RegistersPages.VPN_NAME.getLocator(),RegistersPages.VPN_SUBNET.getLocator(),
                        RegistersPages.VPN_VPC.getLocator())
        );
    }

    public static Stream<Arguments> getDataCheckSchemaCloudTest() {
        return Stream.of(
                Arguments.of(CloudSchemaPage.NETWORK_SCHEMA_PAGE.getLocator(), CloudSchemaPage.INTERNAL.getLocator(),
                        CloudSchemaPage.EXTERNAL.getLocator()),
                Arguments.of(CloudSchemaPage.SERVERS_PAGE.getLocator(), CloudSchemaPage.INTERNAL.getLocator(),
                        CloudSchemaPage.EXTERNAL.getLocator()),
                Arguments.of(CloudSchemaPage.VIRTUAL_PAGE.getLocator(), CloudSchemaPage.INTERNAL.getLocator(),
                        CloudSchemaPage.EXTERNAL.getLocator())
        );
    }

    public static Stream<Arguments> getDataCheckSystemsTest() {
        return Stream.of(
                Arguments.of(RegistersSystemsPage.BAZAR_PAGE.getLocator(), RegistersSystemsPage.BAZAR_DESCRIPTION.getLocator(),
                        RegistersSystemsPage.BAZAR_COMPONENT.getLocator(),RegistersSystemsPage.BAZAR_TECHCOMPONENT.getLocator()),
                Arguments.of(RegistersSystemsPage.MARKETPLACE_PAGE.getLocator(), RegistersSystemsPage.MARKETPLACE_DESCRIPTION.getLocator(),
                        RegistersSystemsPage.MARKETPLACE_COMPONENT.getLocator(),RegistersSystemsPage.MARKETPLACE_TECHCOMPONENT.getLocator())
        );
    }

    public static Stream<Arguments> getDataCheckRegistersCloudTest() {
        return Stream.of(
                Arguments.of(RegistersCloudPages.VDC_PAGE.getLocator(), RegistersCloudPages.VDC_PAGE_LOCATOR.getLocator(), RegistersCloudPages.VDC_NAME.getLocator(),
                        RegistersCloudPages.VDC_APPS.getLocator(),RegistersCloudPages.VDC_ORGANIZATION.getLocator()),
                Arguments.of(RegistersCloudPages.SERVERS_PAGE.getLocator(), RegistersCloudPages.SERVERS_PAGE_LOCATOR.getLocator(), RegistersCloudPages.SERVER_NAME.getLocator(),
                        RegistersCloudPages.SERVER_OS.getLocator(),RegistersCloudPages.SERVER_DISK.getLocator()),
                Arguments.of(RegistersCloudPages.GATEWAYS_PAGE.getLocator(), RegistersCloudPages.GATEWAYS_PAGE_LOCATOR.getLocator(), RegistersCloudPages.GATEWAY_NAME.getLocator(),
                        RegistersCloudPages.GATEWAY_TYPE.getLocator(),RegistersCloudPages.GATEWAY_INTERFACE.getLocator())
        );
    }

    public static Stream<Arguments> getDataCheckRegistersOrganizationsTest() {
        return Stream.of(
                Arguments.of(OrganizationsReversPages.DOCHUB_TEST_D5A_FIND_PAGE.getLocator(), OrganizationsReversPages.TEST_D5A_LOCATOR1.getLocator(),
                        OrganizationsReversPages.TEST_D5A_LOCATOR2.getLocator(),OrganizationsReversPages.TEST_D5A_LOCATOR3.getLocator(),
                        OrganizationsReversPages.TEST_D5A_LOCATOR4.getLocator(), OrganizationsReversPages.TEST_D5A_LOCATOR5.getLocator(),
                         OrganizationsReversPages.DOCHUB_TEST_D5A_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.DOCHUB_DCG_FIND_PAGE.getLocator(), OrganizationsReversPages.TEST_DCG_NAME.getLocator(),
                        OrganizationsReversPages.TEST_DCG_WEB.getLocator(),OrganizationsReversPages.TEST_DCG_VDC.getLocator(),
                        OrganizationsReversPages.TEST_DCG_NETWORK.getLocator(), OrganizationsReversPages.TEST_DCG_DESCRIPTION.getLocator(),
                        OrganizationsReversPages.DOCHUB_DCG_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.DOCHUB_TEST_VDC01_FIND_PAGE.getLocator(), OrganizationsReversPages.TEST_VDC01_VDC.getLocator(),
                        OrganizationsReversPages.TEST_VDC01_VDC_GROUP.getLocator(),OrganizationsReversPages.TEST_VDC01_NETWORK_NAME.getLocator(),
                        OrganizationsReversPages.TEST_VDC01_APPS.getLocator(), OrganizationsReversPages.TEST_VDC01_SCHEMA_LOC.getLocator(),
                        OrganizationsReversPages.DOCHUB_TEST_VDC01_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.DOCHUB_TEST_VDC02_FIND_PAGE.getLocator(), OrganizationsReversPages.TEST_VDC02_VDC.getLocator(),
                        OrganizationsReversPages.TEST_VDC01_VDC_GROUP.getLocator(),OrganizationsReversPages.TEST_VDC02_NETWORK_NAME.getLocator(),
                        OrganizationsReversPages.TEST_VDC02_APPS.getLocator(), OrganizationsReversPages.TEST_VDC02_SCHEMA_LOC.getLocator(),
                        OrganizationsReversPages.DOCHUB_TEST_VDC02_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.INTERNAL_FIND_PAGE.getLocator(), OrganizationsReversPages.INTERNAL_WEB.getLocator(),
                        OrganizationsReversPages.INTERNAL_VDC.getLocator(),OrganizationsReversPages.INTERNAL_NETWORK.getLocator(),
                        OrganizationsReversPages.INTERNAL_SCHEMA_LOC1.getLocator(), OrganizationsReversPages.INTERNAL_SCHEMA_LOC2.getLocator(),
                        OrganizationsReversPages.INTERNAL_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.EDGE_FIND_PAGE.getLocator(), OrganizationsReversPages.EDGE_NAME.getLocator(),
                        OrganizationsReversPages.EDGE_TYPE.getLocator(),OrganizationsReversPages.EDGE_INTERFACE.getLocator(),
                        OrganizationsReversPages.EDGE_NAME.getLocator(), OrganizationsReversPages.EDGE_INTERFACE.getLocator(),
                        OrganizationsReversPages.EDGE_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.VAPPS_FIND_PAGE.getLocator(), OrganizationsReversPages.VAPPS_VDC_ORG.getLocator(),
                        OrganizationsReversPages.VAPPS_NAME1.getLocator(),OrganizationsReversPages.VAPPS_NAME2.getLocator(),
                        OrganizationsReversPages.VAPPS_DESCRIPTION.getLocator(), OrganizationsReversPages.VAPPS_VDC.getLocator(),
                        OrganizationsReversPages.VAPPS_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.VAPPS_FIND_PAGE.getLocator(), OrganizationsReversPages.VAPPS_VDC_ORG.getLocator(),
                        OrganizationsReversPages.VAPPS_NAME1.getLocator(),OrganizationsReversPages.VAPPS_NAME2.getLocator(),
                        OrganizationsReversPages.VAPPS_DESCRIPTION.getLocator(), OrganizationsReversPages.VAPPS_VDC.getLocator(),
                        OrganizationsReversPages.VAPPS_PAGE2.getLocator()),
                Arguments.of(OrganizationsReversPages.APP_TEST_1_FIND_PAGE.getLocator(), OrganizationsReversPages.APP_TEST1_NETWORK.getLocator(),
                        OrganizationsReversPages.APP_TEST1_DNS.getLocator(),OrganizationsReversPages.APP_TEST1_MODE.getLocator(),
                        OrganizationsReversPages.APP_TEST1_SCHEMA_LOC.getLocator(), OrganizationsReversPages.TEST_VDC01_SCHEMA_LOC.getLocator(),
                        OrganizationsReversPages.APP_TEST_1_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.APP_TEST_2_FIND_PAGE.getLocator(), OrganizationsReversPages.TEST_VDC01_VDC.getLocator(),
                        OrganizationsReversPages.APP_TEST2_WEBAPPVM02.getLocator(),OrganizationsReversPages.APP_TEST1_MODE.getLocator(),
                        OrganizationsReversPages.INTERNAL_SCHEMA_LOC1.getLocator(), OrganizationsReversPages.APP_TEST2_SCHEMA_LOC.getLocator(),
                        OrganizationsReversPages.APP_TEST_2_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.SEGMENT_50_FIND_PAGE.getLocator(), OrganizationsReversPages.TEST_VDC01_VDC.getLocator(),
                        OrganizationsReversPages.SEGMENT_50_NETWORK_NAME.getLocator(),OrganizationsReversPages.INTERNAL_VDC.getLocator(),
                        OrganizationsReversPages.INTERNAL_SCHEMA_LOC1.getLocator(), OrganizationsReversPages.TEST_VDC01_SCHEMA_LOC.getLocator(),
                        OrganizationsReversPages.SEGMENT_50_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.SEGMENT_60_FIND_PAGE.getLocator(), OrganizationsReversPages.TEST_VDC01_VDC.getLocator(),
                        OrganizationsReversPages.SEGMENT_60_NETWORK_NAME.getLocator(),OrganizationsReversPages.INTERNAL_VDC.getLocator(),
                        OrganizationsReversPages.INTERNAL_SCHEMA_LOC1.getLocator(), OrganizationsReversPages.SEGMENT_60_SCHEMA_LOC.getLocator(),
                        OrganizationsReversPages.SEGMENT_60_PAGE.getLocator()),
                Arguments.of(OrganizationsReversPages.DOCHUB_TEST_VDC01_EDGE_FIND_PAGE.getLocator(), OrganizationsReversPages.INTERNAL_SCHEMA_LOC1.getLocator(),
                        OrganizationsReversPages.VDC01_EDGE_VDC_GROUP.getLocator(),OrganizationsReversPages.VDC01_EDGE_VDC_GROUP.getLocator(),
                        OrganizationsReversPages.INTERNAL_SCHEMA_LOC1.getLocator(), OrganizationsReversPages.VDC01_EDGE_VDC_GROUP.getLocator(),
                        OrganizationsReversPages.DOCHUB_TEST_VDC01_EDGE_PAGE.getLocator())
        );
    }
}
