package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsChecksTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО-> Продукты у ООО \"Berezka\"")
    @TmsLink("ERA-T88")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickProductsButton();

        assertTrue(productsChecksPage.elementOnPageIsDisplayed(),
                getTextMessage("Строка berezka.products.uid4 в таблице Ошибки “Продуктов или услуг ",
                        "Проверки КА ДЗО->Продукты "));
    }
}
