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

public class IntegrationFlows extends BerezkaTest {

    @DisplayName("Проверка отображения  данных вкладки Данные архитектуры /Прикладная архитектура/ Интеграционные потоки  у ООО Berezka")
    @TmsLink("ERA-T71")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayedTest() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
        menuDzoPage.clickIntegrationFlowsButton();

        assertAll(
                () -> assertTrue(integrationFlowsPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.thirdElementInTableIsDisplayed(),
                        getTextMessage("Третья колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.fourthElementInTableIsDisplayed(),
                        getTextMessage("Четвертая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.fifthElementInTableIsDisplayed(),
                        getTextMessage("Пятая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.sixthElementInTableIsDisplayed(),
                        getTextMessage("Шестая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.seventhElementInTableIsDisplayed(),
                        getTextMessage("Седьмая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.eighthElementInTableIsDisplayed(),
                        getTextMessage("Восьмая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.ninthElementInTableIsDisplayed(),
                        getTextMessage("Девятая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.tenthElementInTableIsDisplayed(),
                        getTextMessage("Десятая колонка", "Интеграционные потоки")),
                () -> assertTrue(integrationFlowsPage.eleventhElementInTableIsDisplayed(),
                        getTextMessage("Одинадцатая колонка", "Интеграционные потоки"))
        );
    }
}
