package pages.dzo.berezka.documentation.sber.archData.applicationArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.*;

public class IntegrationFlowsPage {

    private WebDriver driver;

    public IntegrationFlowsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String COLUMN_TWO_REGEX_PATTERN = "^П\\.(?:[1-9]|[1-9]\\d|[1-9]\\d\\d|1000)$";
    private final By COLUMN_ONE_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.integrations.sberid-berezka']]");
    private final By COLUMN_TWO_TEXT = By.xpath("//td['data-v-188a1911'][2]");
    private final By COLUMN_THREE_TEXT = By.xpath("//*[text()[normalize-space(.)='Получение данных по user_info']]");
    private final By COLUMN_FOUR_TEXT = By.xpath("//*[text()[normalize-space(.)='SberID']]");
    private final By COLUMN_FIVE_TEXT = By.xpath("//*[text()[normalize-space(.)='Маркетплейс']]");
    private final By COLUMN_SIX_TEXT = By.xpath("//*[text()[normalize-space(.)='Данные пользователя из SberProfile']]");
    private final By COLUMN_SEVEN_TEXT = By.xpath("//*[text()[normalize-space(.)='HTTPS,JSON']]");
    private final By COLUMN_EIGHT_TEXT = By.xpath("//*[text()[normalize-space(.)='По запросу']]");
    private final By COLUMN_NINE_TEXT = By.xpath("//*[text()[normalize-space(.)='Ложно']]");
    private final By COLUMN_TEN_TEXT = By.xpath("//*[text()[normalize-space(.)='Используется']]");
    private final By COLUMN_ELEVEN_TEXT = By.xpath("//*[text()[normalize-space(.)='TLS']]");

    public boolean firstElementInTableIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, COLUMN_ONE_TEXT);
    }

    public boolean secondElementInTableIsDisplayed() {
        return elementRegexMatch(driver,COLUMN_TWO_TEXT,COLUMN_TWO_REGEX_PATTERN);
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

    public boolean ninthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_NINE_TEXT);
    }

    public boolean tenthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_TEN_TEXT);
    }

    public boolean eleventhElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_ELEVEN_TEXT);
    }
}
