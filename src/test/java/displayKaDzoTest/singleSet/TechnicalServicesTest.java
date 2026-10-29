package displayKaDzoTest.singleSet;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TechnicalServicesTest extends BerezkaTest {

    @Test
    @TmsLink("ERA-T134")
    @Tag(SMOKE)
    @DisplayName("Проверка поиска элементов во вкладке Единый свод/Техническая архитектура/Технологические сервисы и системы")
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToTechServices();
        technologyServicePage.searchCompany();

        assertTrue(technologyServicePage.idOnTableIsDisplayed(), "После поиска в таблице не отображается столбец идентификатор");
    }
}
