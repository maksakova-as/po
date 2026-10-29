package pages.dzo.regress.ilsanta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class SchemaDataIlsantaPage {

    private WebDriver driver;

    public SchemaDataIlsantaPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')]//div[@role='combobox']");
    private final By CURRENT_DATA_CONTEXT_EXTENDED = By.xpath("//*[text()[normalize-space(.)='Текущий контекст данных (расширенный)']]");
    private final By TARGET_DATA_CONTEXT = By.xpath("//*[text()[normalize-space(.)='Целевой контекст данных']]");
    private final By TARGET_DATA_CONTEXT_EXTENDED = By.xpath("//*[text()[normalize-space(.)='Целевой контекст данных (расширенный)']]");

    public boolean elementOnPageIsDisplayed(String locator) {
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkCurrentDataContextExtended(String locator) {
        helpers.Actions.selectOption(driver, CURRENT_DATA_CONTEXT_EXTENDED);
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkTargetDataContext(String locator) {
        helpers.Actions.selectOption(driver, TARGET_DATA_CONTEXT);
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkTargetDataContextExtended(String locator) {
        helpers.Actions.selectOption(driver, TARGET_DATA_CONTEXT_EXTENDED);
        return elementIsDisplayed(driver, By.xpath(locator));
    }
}
