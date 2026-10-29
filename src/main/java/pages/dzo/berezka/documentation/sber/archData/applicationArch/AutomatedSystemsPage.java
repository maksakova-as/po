package pages.dzo.berezka.documentation.sber.archData.applicationArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class AutomatedSystemsPage {

    private WebDriver driver;

    public AutomatedSystemsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By COLUMN_ONE_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.systems.berezka']]");
    private final By COLUMN_TWO_TEXT = By.xpath("//*[text()[normalize-space(.)='Маркетплейс']]");
    private final By COLUMN_THREE_TEXT = By.xpath("//*[text()[normalize-space(.)='Система на микросервисной архитектуре, реализующая прикладной функционал маркетплейса']]");
    private final By COLUMN_FOUR_TEXT = By.xpath("//*[text()[normalize-space(.)='Продуктовая фабрика (основная деятельность)']]");
    private final By COLUMN_FIVE_TEXT = By.xpath("//*[text()[normalize-space(.)='Внутренняя']]");
    private final By COLUMN_SIX_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.groups.systems_sbercloud']]");
    private final By COLUMN_SEVEN_TEXT = By.xpath("//*[text()[normalize-space(.)='Владеем исходным кодом']]");
    private final By COLUMN_EIGHT_TEXT = By.xpath("//*[text()[normalize-space(.)='Опытная эксплуатация']]");
    private final By COLUMN_TEN_TEXT = By.xpath("//*[text()[normalize-space(.)='Целевая']]");
    private final By COLUMN_ELEVEN_TEXT = By.xpath("//*[text()[normalize-space(.)='Модифицируется']]");
    private final By COLUMN_TWELVE_TEXT = By.xpath("//*[text()[normalize-space(.)='Business Critical']]");
    private final By COLUMN_THIRTEEN_TEXT = By.xpath("//*[text()[normalize-space(.)='Обработка не менее 150 запросов в секунду со средним временем отклика 1 секунда и максимальным временем отклика 15 секунд']]");
    private final By COLUMN_FOURTEEN_TEXT = By.xpath("//*[text()[normalize-space(.)='24']]");
    private final By COLUMN_FIFTEEN_TEXT = By.xpath("//*[text()[normalize-space(.)='95']]");
    private final By COLUMN_SIXTEEN_TEXT = By.xpath("//*[text()[normalize-space(.)='Prometheus']]");

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

    public boolean eleventhElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_ELEVEN_TEXT);
    }

    public boolean twelfthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_TWELVE_TEXT);
    }

    public boolean thirteenthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_THIRTEEN_TEXT);
    }

    public boolean fourteenthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_FOURTEEN_TEXT);
    }

    public boolean fifteenthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_FIFTEEN_TEXT);
    }

    public boolean sixteenthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_SIXTEEN_TEXT);
    }
}
