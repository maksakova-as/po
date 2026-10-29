package displayKaDzoTest.reports.risk;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProprieataryTechnologiesTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Отчеты/Риски/ Проприетарные РеамедСамара ")
    @TmsLink("ERA-T115")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuPage.transferToProprietaryTechnologies();

        assertAll(
                () -> assertTrue(proprietaryTechnologiesPage.chartIsDisplayed(), "Диаграмма не отображается"),
                () -> assertTrue(proprietaryTechnologiesPage.getVendorTitle(), "Title Вендор в таблице не отображается"),
                () -> assertTrue(proprietaryTechnologiesPage.getClassSystem(), "Текст Вендор в таблице не отображается"),
                () -> assertTrue(proprietaryTechnologiesPage.getDzoName(), "Столбец ДЗО в таблице не отображается")
        );
    }
}
