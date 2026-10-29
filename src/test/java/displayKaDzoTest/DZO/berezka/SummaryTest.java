package displayKaDzoTest.DZO.berezka;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SummaryTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Сводный КА ДЗО  у ООО Berezka")
    @TmsLink("ERA-T104")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuDzoPage.transferToDzoArch();
        menuDzoPage.clickSummaryButton();

        assertAll(
                () -> assertTrue(summaryPage.contentLinkIsdisplayed(), getTextMessage("Содержание", "Сводный")),
                () -> assertTrue(summaryPage.shemaLinkIsDisplayed(), getTextMessage("Схема", "Сводный")),
                () -> assertTrue(summaryPage.tableLinkIsDisplayed(), getTextMessage("Таблица", "Сводный")),
                () -> assertTrue(summaryPage.smartantsSchemaLinkIsDisplayed(), getTextMessage("Схема смартантс", " Сводный"))
        );
    }
}
