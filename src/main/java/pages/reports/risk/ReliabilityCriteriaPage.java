package pages.reports.risk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ReliabilityCriteriaPage {

    private WebDriver driver;

    public ReliabilityCriteriaPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By BAR_CHART = By.cssSelector("#bar-chart");
    private final By PIE_CHART = By.cssSelector("#pie-chart");
    private final By BACKUP_TEXT = By.xpath("//*[text()[normalize-space(.)='Резервная копия присутствует на любой площадке']]");
    private final By AC_NAME_LINK = By.xpath("//*[text()[normalize-space(.)='Для удовлетворения критериям катастрофоустойчивости все компоненты системы (кроме фронтальных):']]");
    private final By COMPLIANCE_TEXT = By.xpath("//div[@class='dochub-object']");
    private final By DZO_TEXT = By.xpath("//*[@id='bar-chart']");
    private final By AC_LINK = By.xpath("//*[text()[normalize-space(.)='Телефония']]");
    private final By COMPLIANCE_REQUIREMENTS_TEXT = By.xpath("//*[text()[normalize-space(.)='Отсутствует бекапирование на резервную площадку']]");
    private final By SEARCH_INPUT = By.xpath("//*[text()[contains(normalize-space(.),'Поиск')]]/following-sibling::input");

    public boolean barChartIsDisplayed() {
        return elementIsDisplayed(driver, BAR_CHART);
    }

    public boolean pieChartIsDisplayed() {
        return elementIsDisplayed(driver, PIE_CHART);
    }

    public boolean getDzoName() {
        return elementIsDisplayed(driver, BACKUP_TEXT);
    }

    public boolean getAbsenceComplianceText() {
        return elementIsDisplayed(driver, COMPLIANCE_REQUIREMENTS_TEXT);
    }

    public boolean getAbsenceAcName() {
        return elementToBeClickableAndDisplayed(driver, AC_LINK);
    }

    public boolean getComplianceText() {
        return elementIsDisplayed(driver, COMPLIANCE_TEXT);
    }

    public boolean getAcName() {
        return elementToBeClickableAndDisplayed(driver, AC_NAME_LINK);
    }

    public boolean getDzoNameText() {
        return elementIsDisplayed(driver, DZO_TEXT);
    }

    public void searchCompany() {
        List<WebElement> searchInput = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.numberOfElementsToBe(SEARCH_INPUT, 2));
        searchInput.get(0).sendKeys("ЗиОинговые кампании мерчантов");
        searchInput.get(1).sendKeys("Телефония");
    }
}
