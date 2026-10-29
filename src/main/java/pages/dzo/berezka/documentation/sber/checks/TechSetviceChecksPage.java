package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class TechSetviceChecksPage {

    private WebDriver driver;

    public TechSetviceChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_IMG = By.cssSelector(".dochub-object");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_IMG);
    }
}
