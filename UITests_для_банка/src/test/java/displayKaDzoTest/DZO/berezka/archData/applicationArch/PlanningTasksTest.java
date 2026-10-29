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

public class PlanningTasksTest extends BerezkaTest {

    @DisplayName("Проверка отображения  данных вкладки Данные архитектуры /Прикладная архитектура/ Задачи горизонта планирования  у ООО Berezka")
    @TmsLink("ERA-T70")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
        menuDzoPage.clickPlanningTasksButton();

        assertAll(
                () -> assertTrue(planningTasksPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Задачи горизонта планирования")),
                () -> assertTrue(planningTasksPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Задачи горизонта планирования")),
                () -> assertTrue(planningTasksPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Задачи горизонта планирования")),
                () -> assertTrue(planningTasksPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Задачи горизонта планирования"))
        );
    }
}
