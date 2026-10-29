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

public class BusinessStrategyTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Данные архитектуры /Бизнес- архитектура /Бизнес стратегия у Berezka")
    @TmsLink("ERA-T61")
    @Tag(SMOKE)
    @Test
    public void elementOnPageBusinessStrategy() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickBusinessArchListButton();
        menuDzoPage.clickBusinessStrategyButton();

        assertAll(
                () -> assertTrue(businessStrategyPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Бизнес объекты")),
                () -> assertTrue(businessStrategyPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Бизнес объекты")),
                () -> assertTrue(businessStrategyPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Бизнес объекты"))
        );
    }
}
