package displayKaDzoTest.DZO.Ilsanta;

import displayKaDzoTest.base.RegressTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContextDataRegressTest extends RegressTest {

    @DisplayName("Проверка соотвествия схем во вкладках ДЗО/МинскинтеркапсБелоруссияЗдоровье/Схемы /Контекстные /Данные")
    @MethodSource("pages.dzo.regress.ilsanta.testData.ContextDataIlsantaArgsPage#getPageSchemasData")
    @TmsLink("ERA-T454")
    @Tag(REGRESS)
    @ParameterizedTest()
    public void elementOnPageIsDisplayed(String parentLocator, String locatorContext, String message) {
        menuDzoPage.setDzo("МинскинтеркапсБелоруссияЗдоровье");
        menuDzoPage.transferToData();
        menuDzoPage.clickElement(parentLocator);

        assertAll(
                () -> assertTrue(schemaDataIlsantaPage.elementOnPageIsDisplayed(locatorContext),
                        message + " в текущем контексте данных"),
                () -> assertTrue(schemaDataIlsantaPage.checkCurrentDataContextExtended(locatorContext),
                        message + "  в текущем контексте данных (расширенном)"),
                () -> assertTrue(schemaDataIlsantaPage.checkTargetDataContext(locatorContext),
                        message + " в целевом контексте данных"),
                () -> assertTrue(schemaDataIlsantaPage.checkTargetDataContextExtended(locatorContext),
                        message + " в целевом контексте данных (расширенном)")
        );
    }
}
