package pages.dzo.berezka.documentation.sber.archData.businessArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static helpers.Actions.anyElementOnPageIsDisplayed;
import static helpers.WaitUtils.threadSleepWait;
import static helpers.Actions.elementIsDisplayed;


public class BusinessInsidePage {

    private WebDriver driver;

    public BusinessInsidePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')][not(ancestor::div[contains(@class,'v-data-table-footer')])]//div[contains(@class,'v-field')][@role='combobox']");

    public boolean summaryByTaskIsDisplayed(String locator) {
        new Actions(driver).moveToElement(driver.findElement(By.xpath(locator))).perform();
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean clickDropDownAndFindElement(String locator, String element) {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(By.xpath(locator)).click();
        return anyElementOnPageIsDisplayed(driver, element);
    }

    public boolean clickDropDownAndFindLastElement(String locator, String element) {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(By.xpath(locator)).click();
        return anyElementOnPageIsDisplayed(driver, element);
    }
}


