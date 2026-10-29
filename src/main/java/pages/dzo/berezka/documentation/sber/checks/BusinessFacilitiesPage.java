package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class BusinessFacilitiesPage {

    private WebDriver driver;

    public BusinessFacilitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ERROR = By.xpath("//*[text()[contains(normalize-space(.),'ecogroup.berezka.business_objects.test')]]");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_ERROR);
    }
}
