package displayKaDzoTest.DZO.berezka.checks;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessFacilitiesTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Berezka/Проверки КА ДЗО-> Бизнес-сущности у ООО Berezka")
    @TmsLink("ERA-T91")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToChecks();
        checksKADZOPage.clickBusinessFacilities();

        assertTrue(businessFacilitiesPage.elementOnPageIsDisplayed(),
                getTextMessage("  в таблице Бизнес-объекты без объектов данных  элемент ecogroup.berezka.business_objects.test", "Проверки КА ДЗО-> Бизнес объекты"));
    }
}
