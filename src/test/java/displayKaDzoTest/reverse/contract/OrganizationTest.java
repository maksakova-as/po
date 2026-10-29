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

public class OrganizationTest extends BerezkaTest {

    @Disabled
    @DisplayName("Проверка отображения элементов вкладок Реверс\\Договор_Cloud.ru\\Облако_VMware\\Организации")
    @Tag(REGRESS)
    @ParameterizedTest
    @MethodSource("helpers.TestData#getDataCheckRegistersOrganizationsTest")
    public void checkOrganizationsTest(String nameOfPage, String firstLocator, String secondLocator, String thirdLocator,
                                        String fourthLocator, String lastLocator, String locatorOfPage) {
        menuDzoPage.typeText(nameOfPage);
        systemAppArchPage.clickLocatorLink(locatorOfPage);

        assertAll(
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(firstLocator),
                        ("На странице: " + nameOfPage + " не отображается элемент: " + firstLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(secondLocator),
                        ("На странице: " + nameOfPage + " не отображается элемент: " + secondLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(thirdLocator),
                        ("На странице: " + nameOfPage + " не отображается элемент: " + thirdLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(fourthLocator),
                        ("На странице: " + nameOfPage + " не отображается элемент: " + fourthLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(lastLocator),
                        ("На странице: " + nameOfPage + " не отображается элемент: " + lastLocator))
        );
    }
}
