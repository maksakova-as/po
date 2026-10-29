package pages.dzo.berezka.documentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class SummaryCriticalDataSheetsPage {

    private WebDriver driver;

    public SummaryCriticalDataSheetsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By PASSPORT_ID_LINK = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.criticality_passport.1c']]");

    public boolean elementIsDisplayedAndClickable() {
        return elementToBeClickableAndDisplayed(driver, PASSPORT_ID_LINK);
    }
}
