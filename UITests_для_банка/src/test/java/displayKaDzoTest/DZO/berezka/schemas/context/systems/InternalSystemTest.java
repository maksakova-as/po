package displayKaDzoTest.DZO.berezka.schemas.context.systems;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InternalSystemTest extends BerezkaTest {

    @DisplayName("Проверка соотвествия схем во вкладках ДЗО/Berezka/Схемы /Контекстные / Системы/Внутренняя")
    @MethodSource("helpers.TestData#getInternalSystemTest")
    @Tag(SMOKE)
    @TmsLink("ERA-T111")
    @ParameterizedTest()
    public void elementOnPageIsPresent(String parentLocator, String locatorDropDown, String locatorInner1, String locatorInner2
            , String locatorInner3, String locatorInner4, String locatorInner5) {
        menuDzoPage.transferToInternalSystems();
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
