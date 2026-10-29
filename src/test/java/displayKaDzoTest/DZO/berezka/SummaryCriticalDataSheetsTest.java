package displayKaDzoTest.DZO.berezka;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SummaryCriticalDataSheetsTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Сводный - Паспорта критичности у ООО Berezka")
    @TmsLink("ERA-T82")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickSummaryCriticalDataSheets();

        assertTrue(summaryCriticalDataSheetsPage.elementIsDisplayedAndClickable(),
                getTextMessage("Идентификатор паспорта ecogroup.berezka.criticality_passport.1c", " Сводный - Паспорта критичности "));
    }
}
