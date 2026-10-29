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

public class ProductsTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки Данные архитектуры /Бизнес-архитектура / Продукты у ООО Berezka")
    @TmsLink("ERA-T66")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayedTest() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickBusinessArchListButton();
        menuDzoPage.clickProductsButton();

        assertAll(
                () -> assertTrue(productsPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Продукты")),
                () -> assertTrue(productsPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Продукты")),
                () -> assertTrue(productsPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Продукты")),
                () -> assertTrue(productsPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Продукты"))
        );
    }
}
