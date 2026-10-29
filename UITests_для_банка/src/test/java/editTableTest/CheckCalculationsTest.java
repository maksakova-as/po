package editTableTest;

import displayKaDzoTest.base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static helpers.Tags.REGRESS;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckCalculationsTest extends BaseTest {

    @Disabled("Тесты с таблицами будут перенесены до Июня 2026")
    @Tag(REGRESS)
    @Description("Проверка правильности вычислений в редактируемой таблице")
    @ParameterizedTest()
    @MethodSource("pages.tables.EditTablePage#calculationTestData")
    public void checkCalculationsWithDifferentValues(String inputValue1, String inputValue2, String expectedResult) {

        mainPageTable.clickMainPageButton();
        mainPageTable.enterText("Вычисляемые ячейки");
        mainPageTable.clickEditTableMenu();

        assertTrue(editTablePage.enterTextCell_2_1(inputValue1, inputValue2, expectedResult), "Результат вычисления в ячейке (2,3) не совпадает с ожидаемым.");
    }
}