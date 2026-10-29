package displayKaDzoTest.reports;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassificationSystemTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Отчеты/Классификация систем")
    @TmsLink("ERA-T113")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuPage.transferToClassificationSystem();
        classificationSystemPage.searchCompany();

        assertAll(
                () -> assertTrue(classificationSystemPage.getItSYSTEM(), "Название IT системы отображается неверно"),
                () -> assertTrue(classificationSystemPage.getClassifierText(), "Классификация системы отображается неверно"),
                () -> assertTrue(classificationSystemPage.getCountText(), "Количество систем исспользующиъ отображается неверно")
        );
    }
}
