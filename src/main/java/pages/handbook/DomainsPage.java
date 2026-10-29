package pages.handbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class DomainsPage {

    private WebDriver driver;

    public DomainsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By SEARCH_INPUT = By.xpath("//*[text()[contains(normalize-space(.),'Поиск')]]/following-sibling::input");
    private final By DOMAIN_ON_TABLE = By.xpath("//*[text()[normalize-space(.)='ООО \"АЗТ\"']]");

    public void searchCompany() {
        driver.findElement(SEARCH_INPUT).sendKeys("АЗТ");
    }

    public boolean domainOnTableIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, DOMAIN_ON_TABLE);
    }
}
