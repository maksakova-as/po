package pages.metamodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class MetamodelPage {
    private WebDriver driver;

    public MetamodelPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By GENERAL_MAP = By.cssSelector(".box[y='80']");
    private final By TABLE_OBJECT_STATISTICS = By.xpath("//td[text()[normalize-space(.)='Аспекты']]");

    public Boolean elementGeneralMapClickableAndDisplayed() {
        return elementIsDisplayed(driver, GENERAL_MAP);
    }

    public Boolean elementTableObjectStatistics() {
        return elementIsDisplayed(driver, TABLE_OBJECT_STATISTICS);
    }
}
