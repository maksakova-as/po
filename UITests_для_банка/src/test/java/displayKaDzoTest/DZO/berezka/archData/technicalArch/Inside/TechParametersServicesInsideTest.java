package displayKaDzoTest.DZO.berezka.archData.technicalArch.Inside;

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

public class TechParametersServicesInsideTest extends BerezkaTest {

    @BeforeEach
    public void menuSetup() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickTechnicalArchListButton();
    }

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры / Техническая архитектура / Программное обеспечение + Тех.сервисы и системы/ Внутренние переходы")
    @TmsLink("")
    @Tag(SMOKE)
    @MethodSource("helpers.BusinessData#getParametrsInsideObject")
    @ParameterizedTest
    public void elementOnPageIsDisplayedId(String linkButton, String linkLocator, String currentSummary, String currentLifeStage, String description, String message) {

        systemAppArchPage.clickLocatorLink(linkButton);
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertAll(
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentSummary), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentLifeStage), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(description), message)
        );
    }
}
