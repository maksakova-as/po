package pages.dzo.berezka.documentation.sber.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class FunctionalCardPage {

    private WebDriver driver;

    public FunctionalCardPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By ELEMENT_CRM_BUTTON = By.xpath("//*[contains(@id, 'elem_berezka.functions.dealsberezka.systems.crm')]");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_CRM_BUTTON);
    }
}
