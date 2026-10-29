package displayKaDzoTest.DZO.berezka.archData.businessArch;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InteractionChannelTest extends BerezkaTest {

    @DisplayName("Проверка отображения  данных вкладки Данные архитектуры /Бизнес-архитектура / Каналы взаимодействия с клиентами  у ООО Berezka")
    @TmsLink("ERA-T64")
    @Tag(SMOKE)
    @Test
    public void elementIsDisplayedOnPageInteractionChannelTest() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickBusinessArchListButton();
        menuDzoPage.clickInteractionChannelButton();

        assertAll(
                () -> assertTrue(interactionChannelPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Каналы взаимодействия с клиентами")),
                () -> assertTrue(interactionChannelPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Каналы взаимодействия с клиентами")),
                () -> assertTrue(interactionChannelPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Каналы взаимодействия с клиентами")),
                () -> assertTrue(interactionChannelPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Каналы взаимодействия с клиентами")),
                () -> assertTrue(interactionChannelPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Каналы взаимодействия с клиентами")),
                () -> assertTrue(interactionChannelPage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Каналы взаимодействия с клиентами")),
                () -> assertTrue(interactionChannelPage.seventhElementInTableIsDisplayed(),
                        getTextMessage("Седьмая колонка", "Каналы взаимодействия с клиентами")),
                () -> assertTrue(interactionChannelPage.eighthElementInTableIsDisplayed(),
                        getTextMessage("Восьмая колонка", "Каналы взаимодействия с клиентами")),
                () -> assertTrue(interactionChannelPage.tenthElementInTableIsDisplayed(),
                        getTextMessage("Десятая колонка", "Каналы взаимодействия с клиентами"))
        );
    }
}
