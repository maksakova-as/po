package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class IntegrationsPage {

    private WebDriver driver;

    public IntegrationsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ID_INTEGRATION = By.xpath("//*[@id=\"ошибки-интеграций\"]");

    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, ELEMENT_ID_INTEGRATION);
    }
}
