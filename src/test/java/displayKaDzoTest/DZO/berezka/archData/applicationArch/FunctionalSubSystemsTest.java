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

public class FunctionalSubSystemsTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Прикладная архитектура/ Системы/ Функциональные подсистемы  у ООО Berezka")
    @TmsLink("ERA-T79")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToSystemsPage();
        menuDzoPage.clickFunctionalSubSystems();

        assertAll(
                () -> assertTrue(functionalSubsystemsPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.seventhElementInTableIsDisplayed(),
                        getTextMessage("Седьмая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.eighthElementInTableIsDisplayed(),
                        getTextMessage("Восьмая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.ninthElementInTableIsDisplayed(),
                        getTextMessage("Девятая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.eleventhElementInTableIsDisplayed(),
                        getTextMessage("Десятая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.twelfthElementInTableIsDisplayed(),
                        getTextMessage("Одинадцатая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.thirteenthElementInTableIsDisplayed(),
                        getTextMessage("Двенадцатая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.fourteenthElementInTableIsDisplayed(),
                        getTextMessage("Тринадцатая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.fifteenthElementInTableIsDisplayed(),
                        getTextMessage("Четырнадцатая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.sixteenthElementInTableIsDisplayed(),
                        getTextMessage("Пятнадцатая колонка", "Функциональные подсистемы")),
                () -> assertTrue(functionalSubsystemsPage.seventeenthElementInTableIsDisplayed(),
                        getTextMessage("Шестнадцатая колонка", "Функциональные подсистемы"))
        );
    }
}
