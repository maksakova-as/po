package displayKaDzoTest.DZO.berezka.archData.businessArch.Inside;

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

public class BusinessClientProductInsideInTest extends BerezkaTest {

    @BeforeEach
    public void menuSetup() {
        menuDzoPage.transferToSystemsPage();
        menuDzoPage.clickBusinessArchListButton();
    }

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Бизнес архитектура/ Клиенты/ Продукты / Переход по ссылкам/ Идентификатор  у ООО Berezka/ ecogroup.berezka.channels")
    @TmsLink("")
    @Tag(SMOKE)
    @MethodSource("helpers.BusinessData#getBusinessClientsInsideObject")
    @ParameterizedTest
    public void elementOnPageIsDisplayedId(String linkButton, String linkLocator, String linkLocatorInside
            , String currentSummary, String currentLifeStage, String currentOwner, String locator, String message) {

        systemAppArchPage.clickLocatorLink(linkButton);
        systemAppArchPage.clickLocatorLink(linkLocator);
        systemAppArchPage.clickLocatorLink(linkLocatorInside);

        assertAll(
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentSummary), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentLifeStage), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentOwner), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locator), message));
    }
}
