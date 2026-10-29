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

public class KBSystemTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Прикладная архитектура/ Системы КБ у ООО \"Berezka\"")
    @TmsLink("ERA-T80")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
        menuDzoPage.clickKBSystemButton();

        assertAll(
                () -> assertTrue(kbSystemPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Системы КБ")),
                () -> assertTrue(kbSystemPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Системы КБ")),
                () -> assertTrue(kbSystemPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Системы КБ")),
                () -> assertTrue(kbSystemPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Системы КБ")),
                () -> assertTrue(kbSystemPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Системы КБ")),
                () -> assertTrue(kbSystemPage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Системы КБ"))
        );
    }
}
