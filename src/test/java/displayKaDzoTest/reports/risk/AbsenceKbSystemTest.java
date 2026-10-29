package displayKaDzoTest.reports.risk;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbsenceKbSystemTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Отчеты/Риски/Отсутствие КБ-систем")
    @TmsLink("ERA-T117")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuPage.transferToAbsenceKbSystems();

        assertAll(
                () -> assertTrue(absenceKbSystemPage.chartIsDisplayed(), "Диаграмма не отображается"),
                () -> assertTrue(absenceKbSystemPage.getClassSystem(), "Столбец Классы систем в таблице не отображается"),
                () -> assertTrue(absenceKbSystemPage.getDzoName(), "Столбец ДЗО в таблице не отображается")
        );
    }
}
