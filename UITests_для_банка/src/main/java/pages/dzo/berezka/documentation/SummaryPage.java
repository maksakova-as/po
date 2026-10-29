package pages.dzo.berezka.documentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class SummaryPage {

    private WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By CONTENT_LINK = By.xpath("//*[text()[normalize-space(.)='Цели']]");
    private final By TABLE_LINK = By.xpath("//*[text()[contains(normalize-space(.),'объема сделок')]]");
    private final By SCHEMA_LINK = By.xpath("//*[contains(@href,'reporting')]");
    private final By SMARTANTS_SCHEMA_LINK = By.xpath("//*[text()[contains(normalize-space(.),'Целевая архитектурная схема')]]");

    public boolean contentLinkIsdisplayed() {
        return elementToBeClickableAndDisplayed(driver, CONTENT_LINK);
    }

    public boolean tableLinkIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, TABLE_LINK);
    }

    public boolean shemaLinkIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, SCHEMA_LINK);
    }

    public boolean smartantsSchemaLinkIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, SMARTANTS_SCHEMA_LINK);
    }
}
