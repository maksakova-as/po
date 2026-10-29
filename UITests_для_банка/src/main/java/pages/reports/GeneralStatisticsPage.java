package pages.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class GeneralStatisticsPage {

    private WebDriver driver;

    public GeneralStatisticsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By SYSTEM_AND_FP_COUNT = By.xpath("//*[text()[contains(normalize-space(.),'Количество систем и ФП')]]");
    private final By DZO_COUNT = By.xpath("//*[text()[contains(normalize-space(.),'Общее количество ДЗО')]]");
    private final By SYSTEM_COUNT = By.xpath("//code[text()[contains(normalize-space(.),'Количество систем и ФП / в фокусе')]]");
    private final By INNER_SYSTEM_COUNT = By.xpath("//*[text()[contains(normalize-space(.),'Количество систем внутренних')]]");
    private final By INTEGRATION_COUNT = By.xpath("//*[text()[contains(normalize-space(.),'Количество интеграций')]]");
    private final By PIE_CHART = By.cssSelector("#pie-chart");
    private final By SEARCH_INPUT = By.xpath("//*[text()[contains(normalize-space(.),'Поиск')]]/following-sibling::input");

    public boolean getSystemAndFpCount() {
        return elementIsDisplayed(driver, SYSTEM_AND_FP_COUNT);
    }

    public boolean getDZOCount() {
        return elementIsDisplayed(driver, DZO_COUNT);
    }

    public boolean getSystemCount() {
        return elementIsDisplayed(driver, SYSTEM_COUNT);
    }

    public boolean getInnerSystemCount() {
        return elementIsDisplayed(driver, INNER_SYSTEM_COUNT);
    }

    public boolean getIntegrationCount() {
        return elementIsDisplayed(driver, INTEGRATION_COUNT);
    }

    public boolean getPieChart() {
        return elementIsDisplayed(driver, PIE_CHART);
    }

    public void searchCompany() {
        driver.findElement(SEARCH_INPUT).sendKeys("АВВА");
    }
}
