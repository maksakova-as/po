package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CriticalPassportTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО->Паспорта критичности  у ООО Berezka")
    @TmsLink("ERA-T102")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickCriticalityPassport();

        assertTrue(criticalityPassportPage.elementIsDisplayedAndClickable(),
                getTextMessage(" в таблице ошибки-паспорта-критичности-ecogroupberezka - ecogroup.berezka.criticality_passport.catalog", "Проверки КА ДЗО->Паспорта критичности "));
    }
}
