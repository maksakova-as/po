package displayKaDzoTest.DZO;

import displayKaDzoTest.base.RegressTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.dzo.regress.Dzo;

import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SummaryTest extends RegressTest {

    @DisplayName("Проверка отображения элементов вкладки Сводный КА ДЗО")
    @TmsLink("ERA-T453")
    @Tag(REGRESS)
    @EnumSource(Dzo.class)
    @ParameterizedTest
    public void elementsOnPageIsDisplayed(Dzo dzo) {
        menuDzoPage.setDzo(dzo.getDzoName());
        summaryPage.setDzoName(dzo.toString());
        menuDzoPage.transferToDzoArch();
        menuDzoPage.clickSummaryButton();

        assertAll(
                () -> assertTrue(summaryPage.checkError(), "Не отображается таблица на вкладке Сводный у ДЗО" + dzo.getDzoName()),
                () -> assertTrue(summaryPage.archSchemaIsDisplayed(), "Текущая архитектурная схема не отображается"),
                () -> assertTrue(summaryPage.cardDataIsDisplayed(), "Карта данных  не отображается"),
                () -> assertTrue(summaryPage.targetArchSchemaIsDisplayed(), "Целевая архитектурная схема не отображается")
        );
    }
}