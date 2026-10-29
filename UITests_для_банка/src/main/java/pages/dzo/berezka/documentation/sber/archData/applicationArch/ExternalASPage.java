package pages.dzo.berezka.documentation.sber.archData.applicationArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ExternalASPage {

    private WebDriver driver;

    public ExternalASPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By COLUMN_ONE_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.ecosystem.partners.2gis']]");
    private final By COLUMN_TWO_TEXT = By.xpath("//*[text()[normalize-space(.)='2GIS']]");
    private final By COLUMN_THREE_TEXT = By.xpath("//*[text()[normalize-space(.)='Карты в приложениях']]");
    private final By COLUMN_FOUR_TEXT = By.xpath("//*[text()[normalize-space(.)='Гео-информационные системы']]");
    private final By COLUMN_FIVE_TEXT = By.xpath("//*[text()[normalize-space(.)='Внешняя']]");
    private final By COLUMN_SIX_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.groups.ecosystem_partners']]");
    private final By COLUMN_SEVEN_TEXT = By.xpath("//*[text()[normalize-space(.)='Промышленная эксплуатация']]");
    private final By COLUMN_EIGHT_TEXT = By.xpath("//*[text()[normalize-space(.)='Используется']]");

    public boolean firstElementInTableIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, COLUMN_ONE_TEXT);
    }

    public boolean secondElementInTableIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, COLUMN_TWO_TEXT);
    }

    public boolean thirdElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_THREE_TEXT);
    }

    public boolean fourthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_FOUR_TEXT);
    }

    public boolean fifthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_FIVE_TEXT);
    }

    public boolean sixthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_SIX_TEXT);
    }

    public boolean seventhElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_SEVEN_TEXT);
    }

    public boolean eighthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_EIGHT_TEXT);
    }
}
