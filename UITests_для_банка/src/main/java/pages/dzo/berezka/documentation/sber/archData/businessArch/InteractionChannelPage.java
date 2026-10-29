package pages.dzo.berezka.documentation.sber.archData.businessArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class InteractionChannelPage {

    private WebDriver driver;

    public InteractionChannelPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By COLUMN_ONE_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.channels.web']]");
    private final By COLUMN_TWO_TEXT = By.xpath("//*[text()[normalize-space(.)='Web-приложение']]");
    private final By COLUMN_THREE_TEXT = By.xpath("//*[text()[normalize-space(.)='Канал взаимодействия с клиентами через веб-браузеры']]");
    private final By COLUMN_FOUR_TEXT = By.xpath("//*[text()[normalize-space(.)='Цифровой']]");
    private final By COLUMN_FIVE_TEXT = By.xpath("//*[text()[normalize-space(.)='Внутренний']]");
    private final By COLUMN_SIX_TEXT = By.xpath("//*[text()[normalize-space(.)='Используется']]");
    private final By COLUMN_SEVEN_TEXT = By.xpath("//*[text()[normalize-space(.)='Маркетплейс бытовых услуг,Маркетплейс клининговых услуг']]");
    private final By COLUMN_EIGHT_TEXT = By.xpath("//*[text()[normalize-space(.)='Заказчики услуг,Исполнители услуг (ИП)']]");
    private final By COLUMN_TEN_TEXT = By.xpath("//*[text()[normalize-space(.)='IAM']]");


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

    public boolean tenthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_TEN_TEXT);
    }
}
