package displayKaDzoTest.handbook;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomainTest extends BerezkaTest {

    @Test
    @Tag(SMOKE)
    @TmsLink("ERA-T270")
    @DisplayName("Проверка поиска элементов во вкладке Справочники/Домены участников Группы")
    public void elementOnPageIsDisplayed() {
        menuPage.transferToDomain();
        domainsPage.searchCompany();

        assertTrue(domainsPage.domainOnTableIsDisplayed(),
                "После поиска ДЗО не отображается столбец с доменом в таблице");
    }
}
