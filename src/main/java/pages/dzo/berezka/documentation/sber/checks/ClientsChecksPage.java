package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ClientsChecksPage {

    private WebDriver driver;

    public ClientsChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ID_CLIENT = By.xpath("//*[self::h1 or self::h2 or self::h3][contains(translate(normalize-space(.), '\"“”«»', ''), 'Ошибки Клиентов')]");

    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, ELEMENT_ID_CLIENT);
    }
}
