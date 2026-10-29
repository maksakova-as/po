package displayKaDzoTest.singleSet;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemTest extends BerezkaTest {

    @Test
    @Tag(SMOKE)
    @TmsLink("ERA-T269")
    @DisplayName("Проверка поиска элементов во вкладке Единый свод/Прикладная архитектура/ Системы/ Автоматизированные системмы")
    public void elementOnPageIsDisplayed() {
        menuDzoPage.transferToAutoSystem();
        systemAppArchPage.searchCompany();

        assertTrue(systemAppArchPage.nameOnTableIsDisplayed(),
                "После поиска системы не отображается столбец наименование в таблице");
    }
}
