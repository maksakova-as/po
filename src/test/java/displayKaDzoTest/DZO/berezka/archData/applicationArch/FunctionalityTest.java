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

public class FunctionalityTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Прикладная архитектура/ Функциональность у ООО Berezka")
    @TmsLink("ERA-T81")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
        menuDzoPage.clickFunctionButton();

        assertAll(
                () -> assertTrue(functionalityPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Функциональность")),
                () -> assertTrue(functionalityPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Функциональность")),
                () -> assertTrue(functionalityPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Функциональность")),
                () -> assertTrue(functionalityPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Функциональность")),
                () -> assertTrue(functionalityPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Функциональность")),
                () -> assertTrue(functionalityPage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Функциональность"))
        );
    }
}
