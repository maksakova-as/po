package displayKaDzoTest.DZO.berezka.archData.applicationArch.Inside;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArchGroupInsideInDropDrownTest extends BerezkaTest {

    @BeforeEach
    public void menuSetup() {
        menuDzoPage.transferToSystemsPage();
        menuDzoPage.clickInformationArchListButton();
    }

    @DisplayName("Проверка отображения данных вкладки  Данные архитектуры / Прикладная архитектура / Группы / Проверка dropdown")
    @TmsLink("")
    @Tag(SMOKE)
    @MethodSource("helpers.BusinessData#getArchGroupInsideInDropDrownObject")
    @ParameterizedTest

    public void elementOnPageIsDisplayedId(String linkButton, String linkLocator, String linkLocatorInside
            , String currentDropDrown_1, String currentDropDrown_2, String currentDropDrown_3, String element, String message) {

        systemAppArchPage.clickLocatorLink(linkButton);
        systemAppArchPage.clickLocatorLink(linkLocator);
        systemAppArchPage.clickLocatorLink(linkLocatorInside);

        assertAll(
                () -> assertTrue(businessInsidePage.clickDropDownAndFindElement(currentDropDrown_1, element), message),
                () -> assertTrue(businessInsidePage.clickDropDownAndFindElement(currentDropDrown_2, element), message),
                () -> assertTrue(businessInsidePage.clickDropDownAndFindLastElement(currentDropDrown_3, element), message)
        );
    }
}
