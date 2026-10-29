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

public class BusinessStrategyGoalProcessClientInsideTest extends BerezkaTest {

    @BeforeEach
    public void menuSetup() {
        menuDzoPage.transferToSystemsPage();
        menuDzoPage.clickBusinessArchListButton();
    }

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Бизнес архитектура" +
            "/ Бизес стратегия/ Бизнес цели / Бизнес процессы / Клиенты" +
            "/ Идентификатор  у ООО Berezka")
    @TmsLink("")
    @Tag(SMOKE)
    @MethodSource("helpers.BusinessData#getBusinessStrategyObject")
    @ParameterizedTest
    public void elementOnPageIsDisplayedId(String linkButton, String linkLocator, String currentLocator, String locatorClass, String message) {

        systemAppArchPage.clickLocatorLink(linkButton);
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertAll(
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(currentLocator), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locatorClass), message)
        );
    }
}
