package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuMetamodelPage {

    private WebDriver driver;

    public MenuMetamodelPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String METAMODEL_LOCATOR = "Метамодель (Stalker)";
    private final By METAMODEL_LIST_BUTTON = By.xpath("//*[text()[normalize-space(.)='Метамодель (Stalker)']]");

    public String getMETAMODELLocator(){
        return METAMODEL_LOCATOR;
    }

    public void clickMetamodelListButton() {
        driver.findElement(METAMODEL_LIST_BUTTON).click();
    }
}
