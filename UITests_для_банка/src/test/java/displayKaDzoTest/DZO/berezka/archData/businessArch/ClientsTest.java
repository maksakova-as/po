package displayKaDzoTest.DZO.berezka.archData.businessArch;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.Flaky;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientsTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки Данные архитектуры /Бизнес-архитектура / Клиенты у ООО Berezka")
    @TmsLink("ERA-T65")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickBusinessArchListButton();
        menuDzoPage.clickClientsButton();

        assertAll(
                () -> assertTrue(clientsPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Клиенты")),
                () -> assertTrue(clientsPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Клиенты")),
                () -> assertTrue(clientsPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Клиенты")),
                () -> assertTrue(clientsPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Клиенты"))
        );
    }
}
