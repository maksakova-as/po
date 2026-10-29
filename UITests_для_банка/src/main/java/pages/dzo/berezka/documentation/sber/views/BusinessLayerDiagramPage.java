package pages.dzo.berezka.documentation.sber.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class BusinessLayerDiagramPage {

    private WebDriver driver;

    public BusinessLayerDiagramPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By ELEMENT_WEB_BUTTON = By.xpath("//*[contains(@id, 'elem_berezka.channels.web')]");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_WEB_BUTTON);
    }
}
