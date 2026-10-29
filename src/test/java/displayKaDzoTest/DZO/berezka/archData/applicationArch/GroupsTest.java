package displayKaDzoTest.DZO.berezka.archData.applicationArch;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupsTest extends BerezkaTest {

    @DisplayName("Проверка отображения  данных вкладки Данные архитектуры /Прикладная архитектура/ Группы  у ООО Berezka")
    @TmsLink("ERA-T69")
    @Tag(SMOKE)
    @Test
    public void elementOnPageIsDisplayedTest() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
        menuDzoPage.clickGroupsButton();

        assertAll(
                () -> assertTrue(groupsPage.firstElementInTableIsDisplayed(),
                        getTextMessage("Первая колонка", "Группы")),
                () -> assertTrue(groupsPage.secondElementInTableIsDisplayed(),
                        getTextMessage("Вторая колонка", "Группы"))
        );
    }
}
