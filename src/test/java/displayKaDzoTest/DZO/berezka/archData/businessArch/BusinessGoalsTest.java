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

public class BusinessGoalsTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Данные архитектуры /Бизнес-архитектура /Бизнес цели у ООО Berezka")
    @TmsLink("ERA-T62")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickBusinessArchListButton();
        menuDzoPage.clickBusinessTargetButton();

        assertAll(
                () -> assertTrue(businessGoalsPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Бизнес объекты")),
                () -> assertTrue(businessGoalsPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Бизнес объекты")),
                () -> assertTrue(businessGoalsPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Бизнес объекты"))
        );
    }
}
