package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemsChecksTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО->АС у ООО Berezka")
    @TmsLink("ERA-T95")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickSystemsButton();
//        systemsChecksPage.clickLinkLifeCycle();

        assertAll(
                () -> assertTrue(systemsChecksPage.elementOnPageIsDisplayed(),
                        getTextMessage("Строка  berezka.systems.analytics в таблице Атрибуты жизненного цикла  ",
                                "Проверки КА ДЗО->АС")),
                () -> assertTrue(systemsChecksPage.elementDubokOnPageIsDisplayed(),
                        getTextMessage("Строка berezka.systems.dubok в таблице Таблица ошибок",
                                "Проверки КА ДЗО->АС"))
        );
    }
}
