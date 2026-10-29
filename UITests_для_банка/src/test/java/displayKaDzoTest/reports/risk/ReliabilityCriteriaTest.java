package displayKaDzoTest.reports.risk;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReliabilityCriteriaTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Отчеты/Риски/Критерии надежности")
    @TmsLink("ERA-T116")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuPage.transferToReliabilityCriteria();
        reliabilityCriteriaPage.searchCompany();

        assertAll(
                () -> assertTrue(reliabilityCriteriaPage.barChartIsDisplayed(), "BAR-Диаграмма не отображается"),
                () -> assertTrue(reliabilityCriteriaPage.pieChartIsDisplayed(), "PIE-Диаграмма не отображается"),
                () -> assertTrue(reliabilityCriteriaPage.getDzoName(), "Столбец ДЗО в таблице Отсутствие бекапирования АС не отображается"),
                () -> assertTrue(reliabilityCriteriaPage.getAbsenceComplianceText(), "Столбец соответствие требованиям в таблице Отсутствие бекапирования АС не отображается"),
                () -> assertTrue(reliabilityCriteriaPage.getAbsenceAcName(), "Столбец Наименование АС в таблице Отсутствие бекапирования АС не отображается"),
                () -> assertTrue(reliabilityCriteriaPage.getDzoNameText(), "Столбец ДЗО в таблице Критерии отказоустойчивости и катастрофоустойчивости АС не отображается"),
                () -> assertTrue(reliabilityCriteriaPage.getComplianceText(), "Столбец соответствие требованиям в таблице Критерии отказоустойчивости и катастрофоустойчивости АС не отображается"),
                () -> assertTrue(reliabilityCriteriaPage.getAcName(), "Столбец Наименование АС Критерии отказоустойчивости и катастрофоустойчивости АС в таблице не отображается")
        );
    }
}
