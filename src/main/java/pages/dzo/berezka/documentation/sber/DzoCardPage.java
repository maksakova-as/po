package pages.dzo.berezka.documentation.sber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class DzoCardPage {

    private WebDriver driver;

    public DzoCardPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By SYSTEM_INFORMATION_CODE_TEXT = By.xpath("//code[text()[contains(normalize-space(.),'/0')]]");
    private final By STRATEGY_LINK = By.xpath("//a[text()[contains(normalize-space(.),'Стратегия')]]");
    private final By CRITICAL_TEXT = By.xpath("//code[text()[contains(normalize-space(.),'Critical')]]");
    private final By OPERATIONAL_TEXT = By.xpath("//*[text()[contains(normalize-space(.),'Operational')]]");
    private final By PRODUCTIVITY_TEXT = By.xpath("//*[text()[contains(normalize-space(.),'Office Productivity')]]");

    public boolean elementSystemInformationTextIsDisplayed(int i) {
        return driver.findElements(SYSTEM_INFORMATION_CODE_TEXT).get(i).isDisplayed();
    }

    public boolean elementLinkIsDisplayedAndClickable() {
        return elementToBeClickableAndDisplayed(driver, STRATEGY_LINK);
    }

    public boolean elementCriticalTextIsDisplayed(int i) {
        return driver.findElements(CRITICAL_TEXT).get(i).isDisplayed();
    }

    public boolean elementOperationalTextIsDisplayed() {
        return elementIsDisplayed(driver, OPERATIONAL_TEXT);
    }

    public boolean elementProductivityTextIsDisplayed() {
        return elementIsDisplayed(driver, PRODUCTIVITY_TEXT);
    }
}
