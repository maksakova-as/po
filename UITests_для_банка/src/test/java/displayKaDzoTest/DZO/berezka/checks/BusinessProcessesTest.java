package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessProcessesTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО-> Бизнес-процессы у ООО Berezka")
    @TmsLink("ERA-T90")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickBusinessProcesses();

        assertTrue(businessProcessesPageChecks.elementOnPageIsDisplayed(),
                getTextMessage("таблицы Консистентность интеграционных потоков и систем в бизнес-процессе" +
                        "ID Бизнес процесса", "Проверки КА ДЗО->Бизнес объекты "));
    }
}
