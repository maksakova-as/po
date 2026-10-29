package displayKaDzoTest.DZO.berezka;

import displayKaDzoTest.base.BerezkaTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.Tags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubstantiveChecksTest extends BerezkaTest {

    @DisplayName("Проверка отображения данных вкладки Проверки КА ДЗО/Сутевые проверки")
    @TmsLink("")
    @Tag(SMOKE)
    @Test
    public void elementsOnPageIsDisplayed() {
        menuDzoPage.setDzo("Березка");
        menuDzoPage.transferToSubstantiveChecks();

        assertAll(
                () -> assertTrue(substantiveChecksPage.systemClassChartIsDisplayed(),
                        "Диаграмма на странице не отображается"),
//                () -> assertTrue(substantiveChecksPage.safetyParametersChartIsDisplayed(),
//                        "Диаграмма на странице не отображается"),
//                () -> assertTrue(substantiveChecksPage.backupChartIsDisplayed(),
//                        "Диаграмма на странице не отображается"),
                () -> assertTrue(substantiveChecksPage.asOnBusinessSystemIsDisplayed(),
                        "Столбец Класс АС в таблице Бизнес-системы не отображается"),
                () -> assertTrue(substantiveChecksPage.asNameBusinessSystemIsDisplayed(),
                        "Столбец Наименование АС в таблице Бизнес-системы не отображается"),
                () -> assertTrue(substantiveChecksPage.asOnKbSystemIsDisplayed(),
                        "Столбец Класс АС в таблице системы КБ не отображается"),
                () -> assertTrue(substantiveChecksPage.asNameKbSystemIsDisplayed(),
                        "Столбец Наименование АС в таблице системы КБ не отображается"),
                () -> assertTrue(substantiveChecksPage.asTechServicesIsDisplayed(),
                        "Столбец Класс АС в таблице Технологиечские сервисы не отображается"));
//                () -> assertTrue(substantiveChecksPage.asNameTechServicesIsDisplayed(),
//                        "Столбец Наименование АС в таблице Технологиечские сервисы не отображается"));
//                () -> assertTrue(substantiveChecksPage.asNameSafetyParametersIsDisplayed(),
//                        "Столбец наименование АС не отображается в таблице параметры надежности"),
//                () -> assertTrue(substantiveChecksPage.complianceRequirementsIsDisplayed(),
//                        "Столбец соответствие требованиям не отображается в таблице параметры надежности"),
//                () -> assertTrue(substantiveChecksPage.asNameChecksIsDisplayed(),
//                        "Наименование АС в таблице Проверка Прикладного ПО компонентов АС по справочнику технологий не отображается"),
//                () -> assertTrue(substantiveChecksPage.idComponentsIsDisplayed(),
//                        "id компонента в таблице Проверка Прикладного ПО компонентов АС по справочнику технологий не отображается"),
//                () -> assertTrue(substantiveChecksPage.componentsTypeIsDisplayed(),
//                        "Тип компонента в таблице Проверка Прикладного ПО компонентов АС по справочнику технологий не отображается"),
//                () -> assertTrue(substantiveChecksPage.applicationPOIsDisplayed(),
//                        "Прикладное ПО в таблице Проверка Прикладного ПО компонентов АС по справочнику технологий не отображается")
    }
}
