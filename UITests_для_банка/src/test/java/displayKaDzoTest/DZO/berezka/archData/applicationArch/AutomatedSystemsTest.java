package displayKaDzoTest.DZO.berezka.archData.applicationArch;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutomatedSystemsTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Прикладная архитектура/ Системы/ Автоматизированные системы  у ООО Berezka")
    @TmsLink("ERA-T77")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToSystemsPage();
        menuDzoPage.clickAutomatedSystemsButton();

        assertAll(
                () -> assertTrue(automatedSystemsPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Седьмая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.seventhElementInTableIsDisplayed(),
                        getTextMessage("Восьмая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.eighthElementInTableIsDisplayed(),
                        getTextMessage("Девятая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.tenthElementInTableIsDisplayed(),
                        getTextMessage("Десятая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.eleventhElementInTableIsDisplayed(),
                        getTextMessage("Одинадцатая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.twelfthElementInTableIsDisplayed(),
                        getTextMessage("Двенадцата колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.thirteenthElementInTableIsDisplayed(),
                        getTextMessage("Тринадцатая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.fourteenthElementInTableIsDisplayed(),
                        getTextMessage("Четырнадцатая колонкА", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.fifteenthElementInTableIsDisplayed(),
                        getTextMessage("Пятнадцатая колонка", "Автоматизированные системы")),
                () -> assertTrue(automatedSystemsPage.sixteenthElementInTableIsDisplayed(),
                        getTextMessage("Шестнадцатая колонка", "Автоматизированные системы"))
        );
    }
}
