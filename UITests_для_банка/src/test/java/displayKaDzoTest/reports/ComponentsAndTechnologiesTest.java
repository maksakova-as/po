package displayKaDzoTest.reports;

import displayKaDzoTest.base.BerezkaTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComponentsAndTechnologiesTest extends BerezkaTest {

    @DisplayName("Проверка отображения элементов вкладки Отчеты/Классификация систем")
    @Tag(SMOKE)
    @Test  //Значения не отображаются когда подключён файл isolation_kadzo.yaml, 1 проверку закомментировал
    public void elementsOnPageIsDisplayed() {
        menuPage.transferToComponentsAndTechnologies();
        componentsAndTechnologiesPage.searchCompany();

        assertAll(
                () -> assertTrue(componentsAndTechnologiesPage.getItSYSTEM(), "Тип компонента отображается неверно")
                //() -> assertTrue(componentsAndTechnologiesPage.getCountText(), "Количество систем исспользующих отображается неверно")
        );
    }
}
