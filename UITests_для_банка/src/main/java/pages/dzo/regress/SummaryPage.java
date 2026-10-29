package pages.dzo.regress;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static helpers.Actions.checkConsoleForErrorsAndTableMessage;
import static helpers.Actions.elementFromListIsDisplayed;

public class SummaryPage {

    private WebDriver driver;
    private String dzoName;

    public void setDzoName(String dzoName) {
        this.dzoName = dzoName;
    }

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getPlantLocator() {
        return By.xpath("//*[@class = 'plantuml-schema']");
    }

    public boolean checkError() {
        return checkConsoleForErrorsAndTableMessage(driver);
    }

    public List<WebElement> getListElements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(d -> {
            try {
                List<WebElement> elements = d.findElements(getPlantLocator());
                return elements.size() == 3 && elements.stream().allMatch(WebElement::isDisplayed);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                return false;
            }
        });
        return driver.findElements(getPlantLocator());
    }

    public boolean cardDataIsDisplayed() {
        return elementFromListIsDisplayed(driver, getListElements(), 0, dzoName);
    }

    public boolean archSchemaIsDisplayed() {
        return elementFromListIsDisplayed(driver, getListElements(), 1, dzoName);
    }

    public boolean targetArchSchemaIsDisplayed() {
        return elementFromListIsDisplayed(driver, getListElements(), 2, dzoName);
    }
}
