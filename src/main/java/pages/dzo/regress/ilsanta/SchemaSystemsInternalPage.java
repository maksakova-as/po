package pages.dzo.regress.ilsanta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.WaitUtils.threadSleepWait;

public class SchemaSystemsInternalPage {
    private WebDriver driver;
    public static String SCHEMA_ABSENT = "";
    public static String ZIO_PLACE = "marketplace";

    public SchemaSystemsInternalPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')][not(ancestor::div[contains(@class,'v-data-table-footer')])]//div[contains(@class,'v-field')][@role='combobox']");
    private final By CURRENT_SYSTEMS_CONTEXT_VIEW = By.xpath("//*[text()[normalize-space(.)='Контекст системы текущий (view данные)']]");
    private final By TARGET_SYSTEMS_CONTEXT = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы']]");
    private final By TARGET_SYSTEMS_CONTEXT_VIEW = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы (view данные)']]");

    public boolean elementOnPageIsDisplayed(String locator) {
        return elementIsDisplayed(driver, By.xpath(String.format("//*[contains(@id, '%s')]", locator)));
    }

    public boolean checkCurrentDataContextExtended(String locator) {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(CURRENT_SYSTEMS_CONTEXT_VIEW).click();
        return elementIsDisplayed(driver, By.xpath(String.format("//*[contains(@id, '%s')]", locator)));
    }

    public boolean checkTargetDataContext(String locator) {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SYSTEMS_CONTEXT).click();
        return elementIsDisplayed(driver, By.xpath(String.format("//*[contains(@id, '%s')]", locator)));
    }

    public boolean checkTargetDataContextExtended(String locator) {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SYSTEMS_CONTEXT_VIEW).click();
        return elementIsDisplayed(driver, By.xpath(String.format("//*[contains(@id, '%s')]", locator)));
    }
}
