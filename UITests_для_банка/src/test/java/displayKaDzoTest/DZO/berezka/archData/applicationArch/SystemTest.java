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

public class SystemTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Прикладная архитектура/ Системы у ООО Berezka")
    @TmsLink("ERA-T76")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
        menuDzoPage.clickSystemButton();

        assertAll(
                () -> assertTrue(systemAppArchPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Седьмая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.seventhElementInTableIsDisplayed(),
                        getTextMessage("Восьмая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.eighthElementInTableIsDisplayed(),
                        getTextMessage("Девятая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.tenthElementInTableIsDisplayed(),
                        getTextMessage("Десятая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.eleventhElementInTableIsDisplayed(),
                        getTextMessage("Одинадцатая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.twelfthElementInTableIsDisplayed(),
                        getTextMessage("Двенадцата колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.thirteenthElementInTableIsDisplayed(),
                        getTextMessage("Тринадцатая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.fourteenthElementInTableIsDisplayed(),
                        getTextMessage("Четырнадцатая колонкА", "Системы")),
                () -> assertTrue(systemAppArchPage.fifteenthElementInTableIsDisplayed(),
                        getTextMessage("Пятнадцатая колонка", "Системы")),
                () -> assertTrue(systemAppArchPage.sixteenthElementInTableIsDisplayed(),
                        getTextMessage("Шестнадцатая колонка", "Системы"))
        );
    }
}
