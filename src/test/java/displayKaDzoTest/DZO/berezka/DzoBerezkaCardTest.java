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

public class DzoBerezkaCardTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки ДЗО/Berezka")
    @TmsLink("ERA-T60")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuDzoPage.clickDZOButton();

        assertAll(
                () -> assertTrue(dzoCardPage.elementSystemInformationTextIsDisplayed(0), getTextMessage("0/0 ", "Карточка березки")),
                () -> assertTrue(dzoCardPage.elementSystemInformationTextIsDisplayed(1), getTextMessage("0/0 ", "Карточка березки")),
                () -> assertTrue(dzoCardPage.elementSystemInformationTextIsDisplayed(2), getTextMessage("4/0 ", "Карточка березки")),
                () -> assertTrue(dzoCardPage.elementSystemInformationTextIsDisplayed(3), getTextMessage("1/0 ", "Карточка березки")),
                () -> assertTrue(dzoCardPage.elementCriticalTextIsDisplayed(0), getTextMessage("Mission Critical ", "Карточка березки")),
                () -> assertTrue(dzoCardPage.elementCriticalTextIsDisplayed(1), getTextMessage("Business Critical", "Карточка березки")),
                () -> assertTrue(dzoCardPage.elementProductivityTextIsDisplayed(), getTextMessage("Office Productivity", "Карточка березки")),
                () -> assertTrue(dzoCardPage.elementOperationalTextIsDisplayed(), getTextMessage("Business Operational", "Карточка березки")),
                () -> assertTrue(dzoCardPage.elementLinkIsDisplayedAndClickable(), getTextMessage("Стратегия", "Карточка березки"))
        );
    }
}
