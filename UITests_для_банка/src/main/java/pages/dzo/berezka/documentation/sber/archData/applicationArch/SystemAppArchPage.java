package pages.dzo.berezka.documentation.sber.archData.applicationArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;
import static helpers.Actions.moveToElement;

public class SystemAppArchPage {

    private WebDriver driver;

    public SystemAppArchPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ROWS_LIST = By.xpath("//div[contains(@class,'v-data-table-footer__items-per-page')]//div[@role='combobox']");
    private final By ALL_SYSTEM_BUTTON = By.xpath("//div[contains(@class,'v-overlay__content')]//div[@role='option'][normalize-space(.)='Все']");
    private final By COLUMN_ONE_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.systems.berezka']]");
    private final By COLUMN_TWO_TEXT = By.xpath("//*[text()[normalize-space(.)='Маркетплейс']]");
    private final By COLUMN_THREE_TEXT = By.xpath("//*[text()[normalize-space(.)='Система на микросервисной архитектуре, реализующая прикладной функционал маркетплейса']]");
    private final By COLUMN_FOUR_TEXT = By.xpath("//*[text()[normalize-space(.)='Продуктовая фабрика (основная деятельность)']]");
    private final By COLUMN_FIVE_TEXT = By.xpath("//*[text()[normalize-space(.)='Внутренняя']]");
    private final By COLUMN_SIX_TEXT = By.xpath("//*[text()[normalize-space(.)='Системы Маркетплейс в SberCloud']]");
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

    public void clickAllSystemList() {
        org.openqa.selenium.WebElement rows = helpers.WaitUtils.waitUntilElementToBeClickable(driver, ROWS_LIST);
        moveToElement(driver, rows);
        rows.click();
        helpers.WaitUtils.waitUntilElementToBeClickable(driver, ALL_SYSTEM_BUTTON).click();
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(d -> d.findElements(By.xpath("//div[contains(@class,'v-data-table-footer__info')]"))
                        .stream().anyMatch(e -> e.getText().matches("1-(\\d+) из \\1")));
    }

    public void clickLocatorLink(String locator) {
        if (driver.findElements(By.xpath(locator)).isEmpty()
                && !driver.findElements(ROWS_LIST).isEmpty()) {
            clickAllSystemList();
        }
        moveToElement(driver, driver.findElement(By.xpath(locator)));
        elementToBeClickableAndDisplayed(driver, By.xpath(locator));
        driver.findElement((By.xpath(locator))).click();
    }

    //Для проверки единого свода
    private final By SEARCH_INPUT = By.xpath("//input[@aria-labelledby='input-v-22-label']");
    private final By NAME_ON_TABLE = By.xpath("//*[text()[normalize-space(.)='ДЗО']]");

    public void searchCompany() {
        driver.findElement(SEARCH_INPUT).sendKeys("systems.sys_id_25_sberjazz");
    }

    public boolean nameOnTableIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, NAME_ON_TABLE);
    }
}
