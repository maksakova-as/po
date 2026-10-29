package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequiredEnablersChecksPage {

    private WebDriver driver;

    public RequiredEnablersChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_NAME_ENABLERS = By.xpath("//*[text()[contains(normalize-space(.),'sber.ecosystem.enablers.jivo')]]");

    public boolean elementOnPageIsDisplayed() {
        return driver.findElement(ELEMENT_NAME_ENABLERS).isDisplayed();
    }
}
