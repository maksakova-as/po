package displayKaDzoTest.DZO.berezka.metamodel;

import displayKaDzoTest.base.BerezkaTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MetamodelPlantUmlTest extends BerezkaTest {

    @Test
    @DisplayName("testcase_42")
    @Description("Проверка отображения элементов вкладки Документы/Контроль Архитектуры/Метамодель (PlantUML) ")
    public void elementGeneralMapDisplayedTest() {
        menuPage.transferToPlantUmlMetamodel();

        assertAll(
                () -> assertTrue(generalPage.elementTitleOfMetamodelIsDisplayed(),
                        getTextMessage("Title", "Метамодель Plant UML")),
                () -> assertTrue(generalPage.elementDigitalOfMetamodelIsDisplayed(),
                        getTextMessage("Описание", "Метамодель Plant UML")),
                () -> assertTrue(generalPage.elementChannelOfMetamodelIsDisplayed(),
                        getTextMessage("Объект", "Метамодель Plant UML")),
                () -> assertTrue(generalPage.elementUsageOfMetamodelIsDisplayed(),
                        getTextMessage("Использование", "Метамодель Plant UML"))
        );
    }
}