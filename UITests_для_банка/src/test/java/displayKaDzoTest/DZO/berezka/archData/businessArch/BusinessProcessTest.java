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

public class BusinessProcessTest extends BerezkaTest {

    @DisplayName("Проверка отображения  данных вкладки Данные архитектуры /Бизнес-архитектура /Бизнес-процессы   у ООО Berezka")
    @TmsLink("ERA-T63")
    @Tag(SMOKE)
    @Test
    public void businessProcessPage() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickBusinessArchListButton();
        menuDzoPage.clickBusinessProcessButton();

        assertAll(
                () -> assertTrue(businessProcessPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Объекты данных")),
                () -> assertTrue(businessProcessPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Объекты данных")),
                () -> assertTrue(businessProcessPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Объекты данных")),
                () -> assertTrue(businessProcessPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Объекты данных")),
                () -> assertTrue(businessProcessPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Объекты данных"))
        );
    }
}
