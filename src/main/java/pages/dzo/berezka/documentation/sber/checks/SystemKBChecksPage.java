package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class SystemKBChecksPage {

    private WebDriver driver;

    public SystemKBChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ID_SYSTEM_KB = By.xpath("//*[@id=\"ошибки-систем-кибербезопасности\"]");

    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, ELEMENT_ID_SYSTEM_KB);
    }
}
