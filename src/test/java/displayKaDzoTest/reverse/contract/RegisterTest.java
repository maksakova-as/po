package displayKaDzoTest.reverse.contract;

import displayKaDzoTest.base.BerezkaTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BerezkaTest {

    @Disabled
    @DisplayName("Проверка отображения элементов вкладки Реверс\\Договор_Cloud.ru\\Облако_VMware\\Реестры")
    @Tag(REGRESS)
    @ParameterizedTest
    @MethodSource("helpers.TestData#getDataCheckRegistersCloudTest")
    public void checkRegistersTest(String anotherPage, String pageLocator, String firstLocator, String secondLocator, String lastLocator) {
        menuDzoPage.typeText(anotherPage);
        systemAppArchPage.clickLocatorLink(pageLocator);

        assertAll(
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(firstLocator),
                        ("На странице: " + anotherPage + " не отображается элемент: " + firstLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(secondLocator),
                        ("На странице: " + anotherPage + " не отображается элемент: " + secondLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(lastLocator),
                        ("На странице: " + anotherPage + " не отображается элемент: " + lastLocator))
        );
    }
}
