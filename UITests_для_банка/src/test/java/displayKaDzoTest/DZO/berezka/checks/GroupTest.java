package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО->Группы у ООО Berezka")
    @TmsLink("ERA-T96")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickGroupButton();

        assertTrue(groupPage.elementOnPageIsDisplayed(),
                getTextMessage("Текст Поздавляю, ты единственный кто не допустил здесь ошибок",
                        "Проверки КА ДЗО->Группы"));
    }
}
