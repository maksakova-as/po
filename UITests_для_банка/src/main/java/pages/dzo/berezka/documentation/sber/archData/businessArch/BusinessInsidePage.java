package pages.dzo.berezka.documentation.sber.archData.businessArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static helpers.Actions.anyElementOnPageIsDisplayed;
import static helpers.Actions.elementIsDisplayed;


public class BusinessInsidePage {

    private WebDriver driver;

    public BusinessInsidePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean summaryByTaskIsDisplayed(String locator) {
        if (!elementIsDisplayed(driver, By.xpath(locator))) {
            return false;
        }
        new Actions(driver).moveToElement(driver.findElement(By.xpath(locator))).perform();
        return true;
    }

    public boolean clickDropDownAndFindElement(String locator, String element) {
        helpers.Actions.selectOption(driver, locator);
        return anyElementOnPageIsDisplayed(driver, element);
    }

    public boolean clickDropDownAndFindLastElement(String locator, String element) {
        return clickDropDownAndFindElement(locator, element);
    }
}


