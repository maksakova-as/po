package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TechParamsTest extends BerezkaTest {

    @Disabled("Параметры ТА отключены в новых версиях Березки")
    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО->Параметры ТА у ООО Berezka")
    @TmsLink("ERA-T100")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickTechParamsButton();

        assertTrue(techParamsChecksPage.elementOnPageIsDisplayed(),
                getTextMessage(" berezka.tech_params.berezka.database", "Проверки КА ДЗО->Параметры ТА"));
    }
}
