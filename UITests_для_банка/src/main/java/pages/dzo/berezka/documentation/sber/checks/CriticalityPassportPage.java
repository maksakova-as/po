package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class CriticalityPassportPage {

    private WebDriver driver;

    public CriticalityPassportPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ID_LINK = By.xpath("//h1[@id ='ошибки-паспорта-критичности-ecogroupberezka']");

    public boolean elementIsDisplayedAndClickable() {
        return elementToBeClickableAndDisplayed(driver, ID_LINK);
    }
}
