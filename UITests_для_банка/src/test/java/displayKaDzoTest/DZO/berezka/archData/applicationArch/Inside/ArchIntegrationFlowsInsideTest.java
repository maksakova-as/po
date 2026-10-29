package displayKaDzoTest.DZO.berezka.archData.applicationArch.Inside;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArchIntegrationFlowsInsideTest extends BerezkaTest {

    @BeforeEach
    public void menuSetup() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
    }

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры / Прикладная архитектура / Интеграционные потоки ")
    @TmsLink("")
    @Tag(SMOKE)
    @MethodSource("helpers.BusinessData#getIntegrationObject")
    @ParameterizedTest
    public void elementOnPageIsDisplayedId(String linkButton, String linkLocator, String currentLocator, String technologies
            , String lifeStage, String load, String locator, String message) {

        systemAppArchPage.clickLocatorLink(linkButton);
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertAll(
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentLocator), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(technologies), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(lifeStage), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(load), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locator), message)
        );
    }
}
