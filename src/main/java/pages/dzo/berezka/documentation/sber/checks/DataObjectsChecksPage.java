package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class DataObjectsChecksPage {
    private WebDriver driver;

    public DataObjectsChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ERROR = By.xpath("//*[self::h1 or self::h2 or self::h3][contains(translate(normalize-space(.), '\"“”«»', ''), 'Ошибки Объектов данных')]");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_ERROR);
    }
}
