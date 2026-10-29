package displayKaDzoTest.reverse.cloud;

import displayKaDzoTest.base.BerezkaTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchemasTest extends BerezkaTest {

    @Disabled
    @DisplayName("Проверка отображения элементов вкладки Реверс\\Cloud.ru\\Advanced\\Схемы")
    @Tag(REGRESS)
    @ParameterizedTest
    @MethodSource("helpers.TestData#getDataCheckSchemaCloudTest")
    public void checkBackupPolicyTest(String anotherPage, String firstLocator, String secondLocator) {
        menuDzoPage.transferToDzoArch();
        menuDzoPage.transferToAdvanced();
        menuDzoPage.clickSchemaCloudButton();
        systemAppArchPage.clickLocatorLink(anotherPage);

        assertAll(
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(firstLocator),
                        ("На странице: " + anotherPage + "не отображается элемент: " + firstLocator)),
                () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(secondLocator),
                        ("На странице: " + anotherPage + "не отображается элемент: " + secondLocator))
        );
    }
}
