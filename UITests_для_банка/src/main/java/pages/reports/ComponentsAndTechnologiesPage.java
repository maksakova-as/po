package pages.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ComponentsAndTechnologiesPage {

    private WebDriver driver;

    public ComponentsAndTechnologiesPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By COUNT_TEXT = By.xpath("//*[text()[normalize-space(.)='180']]");
    private final By SEARCH_INPUT = By.xpath("//*[text()[contains(normalize-space(.),'Поиск')]]/following-sibling::input");
    private final By IT_SYSTEM_LINK = By.xpath("//*[text()[contains(normalize-space(.),'Балансировщик')]]");


    public boolean getCountText() {
        return elementIsDisplayed(driver, COUNT_TEXT);
    }

    public boolean getItSYSTEM() {
        return elementToBeClickableAndDisplayed(driver, IT_SYSTEM_LINK);
    }

    public void searchCompany() {
        driver.findElement(SEARCH_INPUT).sendKeys("Балансировщик");
    }
}
