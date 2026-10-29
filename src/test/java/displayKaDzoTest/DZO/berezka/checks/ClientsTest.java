package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientsTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО->Клиенты у ООО Berezka")
    @TmsLink("ERA-T87")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickClients();

        assertTrue(clientsChecksPage.elementOnPageIsDisplayed(),
                getTextMessage(" в таблице Ошибки “Клиентов строка  berezka.clients.flighter", "Проверки КА ДЗО->Клиенты"));
    }
}
