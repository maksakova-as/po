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

    private java.util.List<org.openqa.selenium.WebElement> waitElements(By locator, int count) {
        return new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(30))
                .until(d -> {
                    java.util.List<org.openqa.selenium.WebElement> list = d.findElements(locator);
                    return list.size() >= count ? list : null;
                });
    }

    public boolean elementSystemInformationTextIsDisplayed(int i) {
        return waitElements(SYSTEM_INFORMATION_CODE_TEXT, i + 1).get(i).isDisplayed();
    }

    public boolean elementLinkIsDisplayedAndClickable() {
        return elementToBeClickableAndDisplayed(driver, STRATEGY_LINK);
    }

    public boolean elementCriticalTextIsDisplayed(int i) {
        return waitElements(CRITICAL_TEXT, i + 1).get(i).isDisplayed();
    }

    public boolean elementOperationalTextIsDisplayed() {
        return elementIsDisplayed(driver, OPERATIONAL_TEXT);
    }

    public boolean elementProductivityTextIsDisplayed() {
        return elementIsDisplayed(driver, PRODUCTIVITY_TEXT);
    }
}
