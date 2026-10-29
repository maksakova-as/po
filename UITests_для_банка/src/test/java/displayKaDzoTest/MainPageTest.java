package displayKaDzoTest;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest extends BerezkaTest {

    @DisplayName("Проверка отображения Стартовой страницы")
    @TmsLink("ERA-T1")
    @Tag(SMOKE)
    @Test
    public void mainPageTest() {
        assertAll(
                () -> assertEquals(mainPage.getKaDzoDescriptionLink(), "https://sberworks.ru/wiki/x/Nz9hDQ"),
                () -> assertEquals(mainPage.getSberChatLink(), "https://sberchat.sberbank.ru/@seaf"),
                () -> assertEquals(mainPage.getJiraLink(), "http://jira.sberbank.ru/browse/ERA")
        );
    }
}
