package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class TechParamsChecksPage {

    private WebDriver driver;

    public TechParamsChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ON_PAGE = By.xpath("//h1[@id='ошибки-параметров-та']");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_ON_PAGE);
    }
}
