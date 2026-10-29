package displayKaDzoTest.DZO.berezka.archData.informationArch;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessObjectTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки Данные архитектуры /Информационная архитектура / Бизнес-объекты у ООО Berezka")
    @TmsLink("ERA-T67")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickInformationArchListButton();
        menuDzoPage.clickBusinessObjectButton();

        assertAll(
                () -> assertTrue(businessObjectPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Бизнес объекты")),
                () -> assertTrue(businessObjectPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Бизнес объекты")),
                () -> assertTrue(businessObjectPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Бизнес объекты")),
                () -> assertTrue(businessObjectPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Бизнес объекты"))
        );
    }
}
