package editTableTest;

import displayKaDzoTest.base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static helpers.Tags.REGRESS;

public class CheckDownloadExcelTest extends BaseTest {

    String fileName = "editable-table.calculating-cells.xls";
    String filePath = Paths.get("C:\\Users\\22631769\\Downloads", fileName).toString();

    @Disabled("Тесты с таблицами будут перенесены до Июня 2026")
    @Description("Проверка правильности выгрузки Excel")
    @Test()
    @Tag(REGRESS)
    public void checkDownloadExcel() throws IOException {
        mainPageTable.clickMainPageButton();
        mainPageTable.enterText("Вычисляемые ячейки");
        mainPageTable.clickEditTableMenu();
        excelPage.clickDownloadExcelButton();

        Assertions.assertTrue(excelPage.downloadExcelHTML(filePath).contains(editTablePage.getTextContainer_2_1()));
        Assertions.assertTrue(excelPage.downloadExcelHTML(filePath).contains(editTablePage.getTextContainer_2_2()));
        Assertions.assertTrue(excelPage.downloadExcelHTML(filePath).contains(editTablePage.getTextContainer_2_3()));
        excelPage.deleteFile(filePath);
    }
}