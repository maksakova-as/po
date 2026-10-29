package displayKaDzoTest.DZO.berezka.schemas.context.data;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchemaContextDataTest extends BerezkaTest {

    @DisplayName("Проверка соотвествия схем во вкладках ДЗО/Berezka/Схемы /Контекстные /Данные")
    @MethodSource("helpers.TestData#getPageSchemasDataTest")
    @TmsLink("ERA-T108")
    @Tag(SMOKE)
    @ParameterizedTest()
    public void elementOnPageIsDisplayed(String parentLocator, String locatorDropDown, String locatorInner1, String locatorInner2
            , String locatorInner3, String locatorInner4, String locatorInner5) throws IOException {
        menuDzoPage.transferToData();
        menuDzoPage.clickElement(parentLocator);
        dataPage.checkCurrentDataContextExtended(locatorDropDown);

        assertAll(
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner1),
                        parentLocator + " в " + locatorDropDown + " упал " + locatorInner1),
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner2),
                        parentLocator + " в " + locatorDropDown + " упал " + locatorInner2),
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner3),
                        parentLocator + " в " + locatorDropDown + " упал " + locatorInner3),
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner4),
                        parentLocator + " в " + locatorDropDown + " упал " + locatorInner4),
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner5),
                        parentLocator + " в " + locatorDropDown + " упал " + locatorInner5)
        );
    }
}
