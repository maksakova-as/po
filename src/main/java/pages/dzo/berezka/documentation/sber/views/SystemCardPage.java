package pages.dzo.berezka.documentation.sber.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class SystemCardPage {

    private WebDriver driver;

    public SystemCardPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By ELEMENT_GIT_HUB_BUTTON = By.xpath("//*[contains(@href, 'id=berezka.tech_services.github')]");

    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, ELEMENT_GIT_HUB_BUTTON);
    }
}
