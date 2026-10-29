package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class BusinessProcessesPage {

    private WebDriver driver;

    public BusinessProcessesPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ID_BUSINESS_PROCESSES = By.xpath("//h1[@id='ошибки-бизнес-процессов']");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_ID_BUSINESS_PROCESSES);
    }
}
