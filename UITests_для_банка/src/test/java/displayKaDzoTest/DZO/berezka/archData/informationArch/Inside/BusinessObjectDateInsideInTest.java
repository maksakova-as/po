package displayKaDzoTest.DZO.berezka.archData.informationArch.Inside;

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

public class BusinessObjectDateInsideInTest extends BerezkaTest {

    @BeforeEach
    public void menuSetup() {
        menuDzoPage.transferToSystemsPage();
        menuDzoPage.clickInformationArchListButton();
    }

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры / Информационная архитектура / Объекты данных / Внутренние переходы по наименованию")
    @TmsLink("")
    @Tag(SMOKE)
    @MethodSource("helpers.BusinessData#getBusinessObjectInsideInObject")
    @ParameterizedTest
    public void elementOnPageIsDisplayedId(String linkButton, String linkLocator, String linkLocatorInside
            , String currentSummary, String currentLifeStage, String locator, String message) {

        systemAppArchPage.clickLocatorLink(linkButton);
        systemAppArchPage.clickLocatorLink(linkLocator);
        systemAppArchPage.clickLocatorLink(linkLocatorInside);

        assertAll(
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentSummary), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentLifeStage), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locator), message)
        );
    }
}
