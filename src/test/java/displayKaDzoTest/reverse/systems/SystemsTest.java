package displayKaDzoTest.reverse.systems;

import displayKaDzoTest.base.BerezkaTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemsTest extends BerezkaTest {

    @Disabled
    @DisplayName("Проверка отображения элементов вкладки Реверс\\Системы")
    @Tag(REGRESS)
    @ParameterizedTest
    @MethodSource("helpers.TestData#getDataCheckSystemsTest")
    public void checkBackupPolicyTest(String anotherPage, String descriptionLocator, String componentLocator, String techcomponentLocator) {
        menuDzoPage.transferToDzoArch();
        menuDzoPage.transferToReverse();
        menuDzoPage.clickSystemButton();
        systemAppArchPage.clickLocatorLink(anotherPage);

        assertAll(
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(descriptionLocator),
                        ("На странице: " + anotherPage + " не отображается элемент: " + descriptionLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(componentLocator),
                        ("На странице: " + anotherPage + " не отображается элемент: " + componentLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(techcomponentLocator),
                        ("На странице: " + anotherPage + " не отображается элемент: " + techcomponentLocator))
        );
    }
}
