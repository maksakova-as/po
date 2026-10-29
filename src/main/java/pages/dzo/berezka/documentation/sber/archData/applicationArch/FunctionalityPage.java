package pages.dzo.berezka.documentation.sber.archData.applicationArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class FunctionalityPage {

    private WebDriver driver;

    public FunctionalityPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By COLUMN_ONE_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.functions.service_catalog']]");
    private final By COLUMN_TWO_TEXT = By.xpath("//*[text()[normalize-space(.)='Ведение каталога услуг']]");
    private final By COLUMN_THREE_TEXT = By.xpath("//*[text()[normalize-space(.)='Набор услуг, представленный на маркетплейсе']]");
    private final By COLUMN_FOUR_TEXT = By.xpath("//*[text()[normalize-space(.)='Аналитика,Каталог услуг']]");
    private final By COLUMN_FIVE_TEXT = By.xpath("//*[text()[normalize-space(.)='Целевое']]");
    private final By COLUMN_SIX_TEXT = By.xpath("//*[text()[normalize-space(.)='Разрабатывается или модифицируется']]");

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
        return elementToBeClickableAndDisplayed(driver, COLUMN_FIVE_TEXT);
    }

    public boolean sixthElementInTableIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, COLUMN_SIX_TEXT);
    }
}
