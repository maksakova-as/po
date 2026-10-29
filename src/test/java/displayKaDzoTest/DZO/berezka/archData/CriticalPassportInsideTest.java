package displayKaDzoTest.DZO.berezka.archData;

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

public class CriticalPassportInsideTest extends BerezkaTest {

    @BeforeEach
    public void menuSetup() {
        menuDzoPage.transferToBusinessArch();
    }

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры / Сводный - Паспорт критичности")
    @TmsLink("")
    @Tag(SMOKE)
    @MethodSource("helpers.BusinessData#getCriticalPassportObject")
    @ParameterizedTest
    public void elementOnPageIsDisplayedId(String button, String linkLocator, String locator1, String locator2, String locator3, String locatorImg, String message) {

        systemAppArchPage.clickLocatorLink(button);
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertAll(
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locator1), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locator2), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locator3), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locatorImg), message)
        );
    }
}
