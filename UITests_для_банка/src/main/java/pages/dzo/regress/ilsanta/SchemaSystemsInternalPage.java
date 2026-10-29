package pages.dzo.regress.ilsanta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class SchemaSystemsInternalPage {
    private WebDriver driver;
    public static String SCHEMA_ABSENT = "";
    public static String ZIO_PLACE = "marketplace";

    public SchemaSystemsInternalPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')]//div[@role='combobox']");
    private final By CURRENT_SYSTEMS_CONTEXT_VIEW = By.xpath("//*[text()[normalize-space(.)='Контекст системы текущий (view данные)']]");
    private final By TARGET_SYSTEMS_CONTEXT = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы']]");
    private final By TARGET_SYSTEMS_CONTEXT_VIEW = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы (view данные)']]");

    public boolean elementOnPageIsDisplayed(String locator) {
        return elementIsDisplayed(driver, By.xpath(String.format("//*[contains(@id, '%s')]", locator)));
    }

    public boolean checkCurrentDataContextExtended(String locator) {
        helpers.Actions.selectOption(driver, CURRENT_SYSTEMS_CONTEXT_VIEW);
        return elementIsDisplayed(driver, By.xpath(String.format("//*[contains(@id, '%s')]", locator)));
    }

    public boolean checkTargetDataContext(String locator) {
        helpers.Actions.selectOption(driver, TARGET_SYSTEMS_CONTEXT);
        return elementIsDisplayed(driver, By.xpath(String.format("//*[contains(@id, '%s')]", locator)));
    }

    public boolean checkTargetDataContextExtended(String locator) {
        helpers.Actions.selectOption(driver, TARGET_SYSTEMS_CONTEXT_VIEW);
        return elementIsDisplayed(driver, By.xpath(String.format("//*[contains(@id, '%s')]", locator)));
    }
}
