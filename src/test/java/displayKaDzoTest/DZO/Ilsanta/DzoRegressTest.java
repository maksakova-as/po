package displayKaDzoTest.DZO.Ilsanta;

import displayKaDzoTest.base.RegressTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DzoRegressTest extends RegressTest {

    @DisplayName("Проверка отображения элементов вкладки ДЗО/МинскинтеркапсБелоруссияЗдоровье")
    @TmsLink("ERA-T614")
    @Tag(REGRESS)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuDzoPage.setDzo("МинскинтеркапсБелоруссияЗдоровье");
        menuDzoPage.clickDZOButton();

        assertAll(
                () -> assertTrue(dzoIlsantaCardPage.descriptionIsDisplayed(), "Общая информация на карточке ДЗО Ilsanta е отображается"),
                () -> assertTrue(dzoIlsantaCardPage.categoriesIsDisplayed(), "Категория на карточке ДЗО Ilsanta е отображается"),
                () -> assertTrue(dzoIlsantaCardPage.calculationCompletenessIsDisplayed(), "Расчет полноты на карточке ДЗО Ilsanta е отображается"),
                () -> assertTrue(dzoIlsantaCardPage.informationSystemsIsDisplayed(), "Системы на карточке ДЗО Ilsanta е отображается"),
                () -> assertTrue(dzoIlsantaCardPage.versionArchIsDisplayed(), "Версия архитектуры на карточке ДЗО Ilsanta е отображается")
        );
    }
}
