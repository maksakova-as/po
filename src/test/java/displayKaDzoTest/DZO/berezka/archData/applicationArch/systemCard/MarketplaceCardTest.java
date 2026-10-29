package displayKaDzoTest.DZO.berezka.archData.applicationArch.systemCard;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketplaceCardTest extends BerezkaTest {

    @BeforeEach
    public void transferToSystemCardPage() {
        menuDzoPage.transferToSystemPage();
        systemAppArchPage.clickAllSystemList();
    }

    @DisplayName("Проверка отображения функций системы вкладок Данные архитектуры /Прикладная архитектура/ Системы у ООО Berezka")
    @TmsLink("ERA-T72")
    @Tag(SMOKE)
    @MethodSource("helpers.TestData#getSystemCardTest")
    @ParameterizedTest
    public void elementOnPageIsDisplayedTest(String linkLocator, String functionsSystemLocator, String message) {
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertTrue(systemsCardPage.elementOnPageIsDisplayed(functionsSystemLocator), functionsSystemLocator + " " + message);
    }

    @DisplayName("Проверка дропдауна  \"Характеристики системы в IT-ландшафте \"  в карточке Данные архитектуры /Прикладная архитектура/ Системы у ООО Berezka")
    @Tag(SMOKE)
    @TmsLink("ERA-T73")
    @MethodSource("helpers.TestData#getDataCheckLandscapeDropdownTest")
    @ParameterizedTest
    public void checkLandscapeDropdownTest(String linkLocator, String systemObjectsLocator, String ownModelLocator, String lvlOfOwnLocator,
                                           String lifeCycleLocator, String CommercialOpLocator, String channelsLocator, String businessProcessesLocator,
                                           String parametersTALocator, String parametersHALocator, String techServicesLocator, String systemComponentsLocator,
                                           String systemContextLocator, String softwareLocator, String serviceManagementDataLocator,
                                           String deviationTitleLocator, String assessmentDataLocator) {
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertAll(
                () -> assertTrue(systemsCardPage.ownModelOnPageIsDisplayed(systemObjectsLocator),
                        getTextMessage(systemObjectsLocator, "Объекты данных в системе в прикладном ландшафте " + linkLocator)),
                () -> assertTrue(systemsCardPage.ownModelOnPageIsDisplayed(ownModelLocator),
                        getTextMessage("Модель владения", "Заголовок в модели владения в прикладном ландшафте "+ linkLocator)),
                () -> assertTrue(systemsCardPage.ownModelOnPageIsDisplayed(lvlOfOwnLocator),
                        getTextMessage(lvlOfOwnLocator + "Данные из вкладки Модель владения", "В прикладном ландшафте "+ linkLocator)),
                () -> assertTrue(systemsCardPage.lifeCycleOnPageIsDisplayed(lifeCycleLocator),
                        getTextMessage("Жизненный цикл", "В прикладном ландшафте "+ linkLocator)),
                () -> assertTrue(systemsCardPage.lifeCycleOnPageIsDisplayed(CommercialOpLocator),
                        getTextMessage(CommercialOpLocator + "Данные из вкладки Жизненный цикл", "В прикладном ландшафте "+ linkLocator)),
                () -> assertTrue(systemsCardPage.integrationsDropdownOnPageIsDisplayed(),
                        getTextMessage("Интеграционные потоки дропдаун", "В прикладном ландшафте "+ linkLocator)),

                () -> assertTrue(systemsCardPage.checkWebApplicationInBusinessLandscape(channelsLocator),
                        getTextMessage(channelsLocator, "Бизнес-процессы В бизнес ландшафте "+ linkLocator)),
                () -> assertTrue(systemsCardPage.checkPerformerSelectionInBusinessLandscape(businessProcessesLocator),
                        getTextMessage( businessProcessesLocator,"В бизнес ландшафте "+ linkLocator)),

                () -> assertTrue(systemsCardPage.techLandscapeOnPageIsDisplayed(techServicesLocator),
                        getTextMessage(techServicesLocator, "В техническом ландшафте"+ linkLocator)),
                () -> assertTrue(systemsCardPage.checkTechnicLandscape(parametersTALocator),
                        getTextMessage(parametersTALocator, "В техническом ландшафте"+ linkLocator)),
                () -> assertTrue(systemsCardPage.checkTechnicLandscape(parametersHALocator),
                        getTextMessage(parametersHALocator, "В техническом ландшафте"+ linkLocator)),
                () -> assertTrue(systemsCardPage.techLandscapeOnPageIsDisplayed(systemComponentsLocator),
                        getTextMessage(systemComponentsLocator, "В техническом ландшафте"+ linkLocator)),
                () -> assertTrue(systemsCardPage.checkSystemContextData(systemContextLocator),
                        getTextMessage(systemContextLocator, "В техническом ландшафте"+ linkLocator)),

                () -> assertTrue(systemsCardPage.checkSoftwareLandscape(softwareLocator),
                        getTextMessage(softwareLocator,"В Программном обеспечение"+ linkLocator)),
                () -> assertTrue(systemsCardPage.checkServiceManagementData(deviationTitleLocator),
                        getTextMessage(deviationTitleLocator, "В Программном обеспечение"+ linkLocator)),
                () -> assertTrue(systemsCardPage.checkExtraLandscape(assessmentDataLocator),
                getTextMessage(assessmentDataLocator, "В Программном обеспечение"+ linkLocator)),


                () -> assertTrue(systemsCardPage.checkServiceManagementData(serviceManagementDataLocator),
                        getTextMessage(serviceManagementDataLocator, "В Дополнительных характеристиках"+ linkLocator)),
                () -> assertTrue(systemsCardPage.checkDeviationTitle(deviationTitleLocator),
                        getTextMessage(deviationTitleLocator,"В Дополнительных характеристиках"+ linkLocator)),
                () -> assertTrue(systemsCardPage.checkExtraLandscape(assessmentDataLocator),
                        getTextMessage(assessmentDataLocator, "В Дополнительных характеристиках"+ linkLocator))
        );
    }

    @DisplayName("Проверка дропдауна \"Контекст системы\" в карточке Данные архитектуры /Прикладная архитектура/ Системы у ООО Berezka")
    @TmsLink("ERA-T74")
    @Tag(SMOKE)
    @MethodSource("helpers.TestData#getDataCheckSystemContextDropdownTest")
    @ParameterizedTest
    public void checkSystemContextDropdownTest(String linkLocator, String contextCurrentLocator, String currentContextWithoutFPILocator, String currentContextViewLocator,
                                               String targetContextLocator, String targetContextWithoutFPILocator, String targetViewDataLocator, String message) {
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertAll(
                () -> assertTrue(systemsCardPage.schemaLinkInCurrentContextIsDisplayed(contextCurrentLocator),
                        message + "в текущий контекст системы, в системной карточке упал " + contextCurrentLocator),
                () -> assertTrue(systemsCardPage.schemaLinkInCurrentContextWithoutFPIsDisplayed(currentContextWithoutFPILocator),
                        message + "в текущий контекст системы(без ФП), в системной карточке упал " + currentContextWithoutFPILocator),
                () -> assertTrue(systemsCardPage.schemaLinkInCurrentContextViewDataIsDisplayed(currentContextViewLocator),
                        message + "в текущий контекст системы(view данные), в системной карточке упал " + currentContextViewLocator),
                () -> assertTrue(systemsCardPage.schemaLinkInTargetContextIsDisplayed(targetContextLocator),
                        message + "в целевой контекст системы, в системной карточке упал " + targetContextLocator),
                () -> assertTrue(systemsCardPage.schemaLinkInTargetContextWithoutFPIsDisplayed(targetContextWithoutFPILocator),
                        message + "в целевой контекст системы(без ФП), в системной карточке упал " + targetContextWithoutFPILocator),
                () -> assertTrue(systemsCardPage.schemaLinkInTargetViewDataIsDisplayed(targetViewDataLocator),
                        message + "в целевой контекст системы(view данные), в системной карточке упал " + targetViewDataLocator)
        );
    }

    @DisplayName("Проверка дропдауна  \"Интеграционные потоки \"  в карточке Данные архитектуры /Прикладная архитектура/ Системы у ООО Berezka")
    @Tag(SMOKE)
    @TmsLink("ERA-T75")
    @MethodSource("helpers.TestData#getDataCheckIntegrationsFlowsTest")
    @ParameterizedTest
    public void checkIntegrationsFlows(String linkLocator, String allIntegrationsFlowLocator, String inOutgoingIntegrationsFlowLocator
            , String inIncomingIntegrationsFlowLocator, String message) {
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertAll(
                () -> assertTrue(systemsCardPage.elementAllOutgoingIntegrationsFlowIsDisplayed(allIntegrationsFlowLocator),
                        message + "в интеграционных потоках, в системной карточке системы упал " + allIntegrationsFlowLocator),
                () -> assertTrue(systemsCardPage.elementInOutIncomingIntegrationsFlowIsDisplayed(inOutgoingIntegrationsFlowLocator),
                        message + "в исходящих интеграционных потоках, в системной карточке системы упал " + inOutgoingIntegrationsFlowLocator),
                () -> assertTrue(systemsCardPage.elementInIncomingIntegrationsFlowIsDisplayed(inIncomingIntegrationsFlowLocator),
                        message + "во входящих интеграционных потоках, в системной карточке системы упал " + inIncomingIntegrationsFlowLocator)
        );
    }
}