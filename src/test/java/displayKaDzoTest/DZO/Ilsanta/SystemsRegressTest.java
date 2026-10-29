//package displayKaDzoTest.DZO.Ilsanta;
//
//import displayKaDzoTest.base.RegressTest;
//import io.qameta.allure.TmsLink;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.EnumSource;
//import pages.dzo.regress.ilsanta.testData.ExternalSystemsIlsanta;
//import pages.dzo.regress.ilsanta.testData.InternalSystemIlsanta;
//
//import static helpers.Tags.REGRESS;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static pages.dzo.regress.Dzo.Ilsanta;
//import static pages.menu.MenuDzoPage.ILSANTA_SCHEMAS;
//
//public class SystemsRegressTest extends RegressTest {
//
//    @DisplayName("Проверка соотвествия схем во вкладках ДЗО/МинскинтеркапсБелоруссияЗдоровье/Схемы/Системы/Внешняя")
//    @TmsLink("ERA-T454")
//    @EnumSource(ExternalSystemsIlsanta.class)
//    @Tag(REGRESS)
//    @ParameterizedTest()
//    public void externalSystemsIsDisplayed(ExternalSystemsIlsanta systems) {
//        menuDzoPage.setDzo(Ilsanta.getDzoName());
//        menuDzoPage.transferToExternalSystems();
//        menuDzoPage.clickElement(String.format(ILSANTA_SCHEMAS, systems.getMenuName()));
//
//        assertAll(
//                () -> assertTrue(schemaSystemsInternalPage.elementOnPageIsDisplayed(systems.getCurrentSystem()),
//                        " в текущем контексте данных"),
//                () -> assertTrue(schemaSystemsInternalPage.checkCurrentDataContextExtended(systems.getCurrentSystem()),
//                        "  в текущем контексте данных (View данные)"),
//                () -> assertTrue(schemaSystemsInternalPage.checkTargetDataContext(systems.getTargetSystem()),
//                        " в целевом контексте данных"),
//                () -> assertTrue(schemaSystemsInternalPage.checkTargetDataContextExtended(systems.getTargetSystem()),
//                        " в целевом контексте данных(View данные)")
//        );
//    }
//
//    @DisplayName("Проверка соотвествия схем во вкладках ДЗО/МинскинтеркапсБелоруссияЗдоровье/Схемы/Системы/Внутренняя")
//    @TmsLink("ERA-T454")
//    @EnumSource(InternalSystemIlsanta.class)
//    @Tag(REGRESS)
//    @ParameterizedTest()
//    public void internalSystemsIsDisplayed(InternalSystemIlsanta systems) {
//        menuDzoPage.setDzo(Ilsanta.getDzoName());
//        menuDzoPage.transferToInternalSystems();
//        menuDzoPage.clickElement(String.format(ILSANTA_SCHEMAS, systems.getMenuName()));
//
//        assertAll(
//                () -> assertTrue(schemaSystemsInternalPage.elementOnPageIsDisplayed(systems.getCurrentSystem()),
//                        " в текущем контексте данных"),
//                () -> assertTrue(schemaSystemsInternalPage.checkCurrentDataContextExtended(systems.getCurrentSystem()),
//                        "  в текущем контексте данных (View данные)"),
//                () -> assertTrue(schemaSystemsInternalPage.checkTargetDataContext(systems.getTargetSystem()),
//                        " в целевом контексте данных"),
//                () -> assertTrue(schemaSystemsInternalPage.checkTargetDataContextExtended(systems.getTargetSystem()),
//                        " в целевом контексте данных(View данные)")
//        );
//    }
//}
