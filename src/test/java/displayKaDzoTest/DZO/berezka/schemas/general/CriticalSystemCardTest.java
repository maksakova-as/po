package displayKaDzoTest.DZO.berezka.schemas.general;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CriticalSystemCardTest extends BerezkaTest {

    @DisplayName("Проверка соотвествия схем во вкладке ДЗО/Berezka/Схемы /Общие/Карта систем по критичности")
    @TmsLink("ERA-T106")
    @MethodSource("helpers.TestData#getCriticalSystemTest")
    @Tag(SMOKE)
    @ParameterizedTest()
    public void elementOnPageIsDisplayed(String locatorInner) throws IOException {
        menuDzoPage.transferToGeneralSystemPage();
        menuDzoPage.clickCriticalSystemCard();

        assertTrue(dataPage.elementOnPageIsDisplayed(locatorInner),
                "Карта систем по критичности в  упал " + locatorInner);
    }
}
