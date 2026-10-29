package displayKaDzoTest.DZO.berezka.schemas.general;

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

public class ArchitecturalSchemeTest extends BerezkaTest {

    @DisplayName("Проверка соотвествия схем во вкладке ДЗО/Berezka/Схемы /Общие/Архитектурная схема")
    @TmsLink("ERA-T105")
    @MethodSource("helpers.TestData#getSystemArchitecturialTest")
    @Tag(SMOKE)
    @ParameterizedTest()
    public void elementOnPageIsDisplayed(String locatorDropDown, String locatorInner1, String locatorInner2
            , String locatorInner3, String locatorInner4, String locatorInner5) throws IOException {
        menuDzoPage.transferToGeneralSystemPage();
        menuDzoPage.clickArchitectureSchema();
        dataPage.checkCurrentDataContextExtended(locatorDropDown);

        assertAll(
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner1),
                        "Архитектурная схема в " + locatorDropDown + " упал " + locatorInner1),
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner2),
                        "Архитектурная схема в " + locatorDropDown + " упал " + locatorInner2),
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner3),
                        "Архитектурная схема в " + locatorDropDown + " упал " + locatorInner3),
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner4),
                        "Архитектурная схема в " + locatorDropDown + " упал " + locatorInner4),
                () -> assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner5),
                        "Архитектурная схема в " + locatorDropDown + " упал " + locatorInner5)
        );
    }
}
