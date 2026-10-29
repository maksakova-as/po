package pages.dzo.regress.ilsanta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.WaitUtils.threadSleepWait;

public class SchemaDataIlsantaPage {

    private WebDriver driver;

    public SchemaDataIlsantaPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')][not(ancestor::div[contains(@class,'v-data-table-footer')])]//div[contains(@class,'v-field')][@role='combobox']");
    private final By CURRENT_DATA_CONTEXT_EXTENDED = By.xpath("//*[text()[normalize-space(.)='Текущий контекст данных (расширенный)']]");
    private final By TARGET_DATA_CONTEXT = By.xpath("//*[text()[normalize-space(.)='Целевой контекст данных']]");
    private final By TARGET_DATA_CONTEXT_EXTENDED = By.xpath("//*[text()[normalize-space(.)='Целевой контекст данных (расширенный)']]");

    public boolean elementOnPageIsDisplayed(String locator) {
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkCurrentDataContextExtended(String locator) {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(CURRENT_DATA_CONTEXT_EXTENDED).click();
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkTargetDataContext(String locator) {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_DATA_CONTEXT).click();
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkTargetDataContextExtended(String locator) {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_DATA_CONTEXT_EXTENDED).click();
        return elementIsDisplayed(driver, By.xpath(locator));
    }
}
