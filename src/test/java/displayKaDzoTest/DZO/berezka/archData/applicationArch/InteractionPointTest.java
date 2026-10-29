package displayKaDzoTest.DZO.berezka.archData.applicationArch;
import displayKaDzoTest.base.BerezkaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Actions.getTextMessage;
import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InteractionPointTest extends BerezkaTest {

    @BeforeEach
    public void transferToSystemCardPage() {
        menuDzoPage.transferToBusinessArch();
        menuDzoPage.clickApplicationArchListButton();
        menuDzoPage.clickInteractionButton();
    }

    @DisplayName("Проверка отображения элементов на странице: ДЗО\\Березка\\Данные архитектуры\\Прикладная архитектура\\Точки взаимодействия")
    @Tag(REGRESS)
    @ParameterizedTest
    @MethodSource("helpers.TestData#getDataCheckInteractionPointTest")
    public void checkInteractionPoint(String linkLocator, String summaryLocator, String technologyLocator, String integrationLocator) {
        systemAppArchPage.clickLocatorLink(linkLocator);
        assertAll(
            () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(summaryLocator),
                    getTextMessage(summaryLocator, "на Сводной информации не отображается")),
            () -> assertTrue(systemsCardPage.elementOnPageIsDisplayed(technologyLocator),
                    getTextMessage(technologyLocator, "на Технологической информации не отображается")));
    }
}
