package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ProductsChecksPage {

    private WebDriver driver;

    public ProductsChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ID_PRODUCT = By.xpath("//*[text()[contains(normalize-space(.),'Атрибут description не может быть пустым')]]");

    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, ELEMENT_ID_PRODUCT);
    }
}
