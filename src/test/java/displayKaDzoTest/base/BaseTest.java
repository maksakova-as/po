package displayKaDzoTest.base;
import helpers.PropertiesReading;
import helpers.SingletonBrowserClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import pages.tables.EditTablePage;
import pages.tables.ExcelPage;
import pages.MainPage;
import pages.tables.MainPageTable;
import pages.AnyPage;
import pages.dzo.berezka.documentation.SubstantiveChecksPage;
import pages.handbook.DomainsPage;
import pages.menu.MenuPage;
import pages.reports.ClassificationSystemPage;
import pages.reports.ComponentsAndTechnologiesPage;
import pages.reports.GeneralStatisticsPage;
import pages.reports.risk.AbsenceKbSystemPage;
import pages.reports.risk.ProprietaryTechnologiesPage;
import pages.reports.risk.ReliabilityCriteriaPage;

import java.time.Duration;

import static helpers.Actions.getTextMessage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {

    protected static WebDriver driver = SingletonBrowserClass.getInstance();
    protected MainPage mainPage = new MainPage(driver);
    protected MenuPage menuPage = new MenuPage(driver);
    protected GeneralStatisticsPage generalStatisticsPage = new GeneralStatisticsPage(driver);
    protected ClassificationSystemPage classificationSystemPage = new ClassificationSystemPage(driver);
    protected ComponentsAndTechnologiesPage componentsAndTechnologiesPage = new ComponentsAndTechnologiesPage(driver);
    protected AbsenceKbSystemPage absenceKbSystemPage = new AbsenceKbSystemPage(driver);
    protected ProprietaryTechnologiesPage proprietaryTechnologiesPage = new ProprietaryTechnologiesPage(driver);
    protected ReliabilityCriteriaPage reliabilityCriteriaPage = new ReliabilityCriteriaPage(driver);
    protected DomainsPage domainsPage = new DomainsPage(driver);
    protected SubstantiveChecksPage substantiveChecksPage = new SubstantiveChecksPage(driver);
    protected EditTablePage editTablePage = new EditTablePage(driver);
    protected ExcelPage excelPage = new ExcelPage(driver);
    protected MainPageTable mainPageTable = new MainPageTable(driver);
    protected AnyPage anyPage = new AnyPage(driver);

    @BeforeEach
    public void start() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PropertiesReading.getProperty("url"));
        mainPage.mainPageButton();
    }

    @AfterEach
    @DisplayName("ERA-T722")
    public void checkUnknownFile(){
        assertTrue(anyPage.unknownMessageIsHide(),
                getTextMessage("unknown element", getClass().getName()).replace("не", ""));
    }
}
