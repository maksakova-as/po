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

public class DataObjectsTest extends BerezkaTest {

    @DisplayName("Проверка отображения  данных вкладки Данные архитектуры /Информационная архитектура  / Объекты данных  у ООО Berezka")
    @TmsLink("ERA-T68")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayedTest() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickInformationArchListButton();
        menuDzoPage.clickDataObjectsButton();

        assertAll(
                () -> assertTrue(dataObjectsPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Объекты данных")),
                () -> assertTrue(dataObjectsPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Объекты данных")),
                () -> assertTrue(dataObjectsPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Объекты данных")),
                () -> assertTrue(dataObjectsPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колокна", "Объекты данных")),
                () -> assertTrue(dataObjectsPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Объекты данных"))
        );
    }
}
