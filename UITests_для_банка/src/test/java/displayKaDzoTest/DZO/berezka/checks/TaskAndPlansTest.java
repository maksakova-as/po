package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskAndPlansTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО->Задачи и планы  у ООО Berezka")
    @TmsLink("ERA-T93")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickTasksAndPlans();

        assertTrue(tasksAndPlansPage.elementOnPageIsDisplayed(),
                getTextMessage(" Задачи и планы есть!", "Проверки КА ДЗО  -> Задачи и планы"));
    }
}
