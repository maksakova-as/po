package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class GoalChecksPage {

    private WebDriver driver;

    public GoalChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ON_PAGE = By.xpath("//*[text()[contains(normalize-space(.),'Таких')]]");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_ON_PAGE);
    }
}
