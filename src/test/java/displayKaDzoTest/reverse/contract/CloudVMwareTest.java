package displayKaDzoTest.reverse.contract;

import displayKaDzoTest.base.BerezkaTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloudVMwareTest extends BerezkaTest {

    @Disabled
    @DisplayName("Проверка отображения элементов вкладки Реверс\\Договор_Cloud.ru\\Облако_VMware")
    @Tag(REGRESS)
    @Test
    public void checkCloudVMwareTest() {
        menuDzoPage.typeText(cloudVMPage.getPageName());
        menuDzoPage.clickCloudButton();

        assertAll(
                () -> assertTrue(cloudVMPage.firstVMElementIsDisplayed(),
                        getTextMessage("Первый элемент", "Облако VMware")),
                () -> assertTrue(cloudVMPage.secondVMElementIsDisplayed(),
                        getTextMessage("Второй элемент", "Облако VMware")),
                () -> assertTrue(cloudVMPage.lastVMElementIsDisplayed(),
                        getTextMessage("Третий элемент", "Облако VMware"))
        );
    }
}
