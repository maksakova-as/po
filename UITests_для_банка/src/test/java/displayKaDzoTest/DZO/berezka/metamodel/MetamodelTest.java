package displayKaDzoTest.DZO.berezka.metamodel;

import displayKaDzoTest.base.BerezkaTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MetamodelTest extends BerezkaTest {

    @Test
    @DisplayName("testcase_41")
    @Description("Проверка отображения элементов  вкладки Документы/Метамодель")
    public void elementGeneralMapDisplayedTest() {
        menuDzoPage.typeText(menuMetamodelPage.getMETAMODELLocator());
        menuMetamodelPage.clickMetamodelListButton();

        assertAll(
                () -> assertTrue(metamodelPage.elementGeneralMapClickableAndDisplayed(),
                        getTextMessage("Общая карта", "Метамодель")),
                () -> assertTrue(metamodelPage.elementTableObjectStatistics(),
                        getTextMessage("Таблица ", " Метамодель"))
        );
    }
}
