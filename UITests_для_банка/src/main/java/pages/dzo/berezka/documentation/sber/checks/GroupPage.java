package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class GroupPage {

    private WebDriver driver;

    public GroupPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By TEXT_ERROR = By.xpath("//*[text()[contains(normalize-space(.),'ошибок!')]]");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, TEXT_ERROR);
    }
}
