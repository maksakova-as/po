package pages.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ClassificationSystemPage {

    private WebDriver driver;

    public ClassificationSystemPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By CLASSIFIER_TEXT = By.xpath("//*[text()[contains(normalize-space(.),'05.10')]]");
    private final By COUNT_TEXT = By.xpath("//*[text()[contains(normalize-space(.),'05.10')]]/following-sibling::td[1]");
    private final By SEARCH_INPUT = By.xpath("//*[text()[contains(normalize-space(.),'Поиск')]]/following-sibling::input");
    private final By IT_SYSTEM_LINK = By.xpath("//a[text()[contains(normalize-space(.),'Корпоративная база знаний')]]");

    public boolean getClassifierText() {
        return elementIsDisplayed(driver, CLASSIFIER_TEXT);
    }

    public boolean getCountText() {
        return driver.findElement(COUNT_TEXT).getText().matches("^(?:[5-9]|[1-2][0-9]|3[0-8])$");
    }

    public boolean getItSYSTEM() {
        return elementToBeClickableAndDisplayed(driver, IT_SYSTEM_LINK);
    }

    public void searchCompany() {
        driver.findElement(SEARCH_INPUT).sendKeys("Корпоративная база знаний");
    }
}
