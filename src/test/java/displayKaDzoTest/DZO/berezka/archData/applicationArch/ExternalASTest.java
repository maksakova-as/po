package displayKaDzoTest.DZO.berezka.archData.applicationArch;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExternalASTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Прикладная архитектура/ Системы/ Внешние АС  у ООО Berezka")
    @TmsLink("ERA-T78")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToSystemsPage();
        menuDzoPage.clickExternalASButton();

        assertAll(
                () -> assertTrue(externalASPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Внешние АС")),
                () -> assertTrue(externalASPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Внешние АС")),
                () -> assertTrue(externalASPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Внешние АС")),
                () -> assertTrue(externalASPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Внешние АС")),
                () -> assertTrue(externalASPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Внешние АС")),
                () -> assertTrue(externalASPage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Внешние АС")),
                () -> assertTrue(externalASPage.seventhElementInTableIsDisplayed(),
                        getTextMessage("Седьмая колонка", "Внешние АС")),
                () -> assertTrue(externalASPage.eighthElementInTableIsDisplayed(),
                        getTextMessage("Восьмая колонка", "Внешние АС"))
        );
    }
}
