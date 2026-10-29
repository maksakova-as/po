package pages.dzo.berezka.documentation.sber.schemas.context.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.*;
import static helpers.WaitUtils.waitUntilVisibilityOfElement;

public class DataPage {
    private WebDriver driver;

    public DataPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')]//div[@role='combobox']");

//    public boolean elementOnPageIsDisplayed(String locator) {
//        return schemaISDisplayed(driver, By.xpath(locator));
//    }

    public boolean elementOnPageIsDisplayed(String locator){
        return anyElementOnPageIsDisplayedAndScroll(driver,locator);
    }

    public void checkCurrentDataContextExtended(String locatorDropDown) {
//        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        selectOption(driver, locatorDropDown);
    }
}
