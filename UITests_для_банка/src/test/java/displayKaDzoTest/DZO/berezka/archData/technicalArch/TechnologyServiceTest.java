package displayKaDzoTest.DZO.berezka.archData.technicalArch;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TechnologyServiceTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры /Техническая архитектура /  Технологические сервисы и системы  у ООО Berezka")
    @TmsLink("ERA-T84")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickTechnicalArchListButton();
        menuDzoPage.clickTechnologyServiceButton();

        assertAll(
                () -> assertTrue(technologyServicePage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Технологические сервисы и системы")),
                () -> assertTrue(technologyServicePage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Технологические сервисы и системы")),
                () -> assertTrue(technologyServicePage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Технологические сервисы и системы")),
                () -> assertTrue(technologyServicePage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Технологические сервисы и системы")),
                () -> assertTrue(technologyServicePage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Технологические сервисы и системы")),
                () -> assertTrue(technologyServicePage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Технологические сервисы и системы"))
        );
    }
}
