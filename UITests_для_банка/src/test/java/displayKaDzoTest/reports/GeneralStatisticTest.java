package displayKaDzoTest.reports;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralStatisticTest extends BerezkaTest {


    @DisplayName("Проверка отображения элементов вкладки Отчеты/Общая статистика")
    @TmsLink("ERA-T112")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuPage.transferToGeneralStatistics();

        assertAll(
                () -> assertTrue(generalStatisticsPage.getDZOCount(), "Количество ДЗО отображается не верно"),
                () -> assertTrue(generalStatisticsPage.getPieChart(), "Диаграмма не отображается"),
                () -> assertTrue(generalStatisticsPage.getIntegrationCount(), "Количество Интеграций отображается не верно"),
                () -> assertTrue(generalStatisticsPage.getInnerSystemCount(), "Количество Внешних систем отображается не верно"),
                () -> assertTrue(generalStatisticsPage.getSystemCount(), "Количество Систем отображается не верно"),
                () -> assertTrue(generalStatisticsPage.getSystemAndFpCount(), "Количество Систем и ФП отображается не верно")
        );
    }
}