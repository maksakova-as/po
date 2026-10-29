package pages.dzo.berezka.documentation.sber.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class DataCardPage {

    private WebDriver driver;

    public DataCardPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By ELEMENT_CLIENT_NAME_BUTTON = By.xpath("//*[contains(@href, 'id=berezka.data_objects.client_name')]");

    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, ELEMENT_CLIENT_NAME_BUTTON);
    }
}
