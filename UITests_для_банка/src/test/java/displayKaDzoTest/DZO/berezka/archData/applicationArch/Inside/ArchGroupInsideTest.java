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

public class ArchGroupInsideTest extends BerezkaTest {

    @BeforeEach
    public void menuSetup() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
    }

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры / Прикладная архитектура " +
            "/ Группы / Задачи горизонта планирования / Точки взаимодействия / Функциональность")
    @TmsLink("")
    @Tag(SMOKE)
    @MethodSource("helpers.BusinessData#getGroupObject")
    @ParameterizedTest
    public void elementOnPageIsDisplayedId(String linkButton, String linkLocator, String locator1, String locator2, String message) {
        systemAppArchPage.clickLocatorLink(linkButton);
        systemAppArchPage.clickLocatorLink(linkLocator);

        assertAll(
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locator1), message),
                () -> assertTrue(businessInsidePage.summaryByTaskIsDisplayed(locator2), message)
        );
    }
}
