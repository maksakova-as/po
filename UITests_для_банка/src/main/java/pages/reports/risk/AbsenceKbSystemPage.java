package pages.reports.risk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class AbsenceKbSystemPage {

    private WebDriver driver;

    public AbsenceKbSystemPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By BAR_CHART = By.cssSelector("#bar-chart");
    private final By DZO_NAME_TEXT = By.xpath("//*[@id='bar-chart']");
    private final By CLASS_SYSTEM_TEXT = By.xpath("//*[text()[contains(normalize-space(.),'ИБ-Защита от утечек информации')]]");

    public boolean chartIsDisplayed() {
        return elementIsDisplayed(driver, BAR_CHART);
    }

    public boolean getDzoName() {
        return elementIsDisplayed(driver, DZO_NAME_TEXT);
    }

    public boolean getClassSystem() {
        return elementIsDisplayed(driver, CLASS_SYSTEM_TEXT);
    }
}
