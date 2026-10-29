package pages.dzo.regress.ilsanta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DzoIlsantaCardPage {

    private WebDriver driver;

    public DzoIlsantaCardPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENTS_ON_PAGE = By.cssSelector(".space");

    public List<WebElement> getListElements() {
        new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.numberOfElementsToBe(ELEMENTS_ON_PAGE, 5));
        return driver.findElements(ELEMENTS_ON_PAGE);
    }

    public boolean descriptionIsDisplayed() {
        return getListElements().get(0).isDisplayed();
    }

    public boolean versionArchIsDisplayed() {
        return getListElements().get(1).isDisplayed();
    }

    public boolean informationSystemsIsDisplayed() {
        return getListElements().get(2).isDisplayed();
    }

    public boolean categoriesIsDisplayed() {
        return getListElements().get(3).isDisplayed();
    }

    public boolean calculationCompletenessIsDisplayed() {
        return getListElements().get(4).isDisplayed();
    }
}
