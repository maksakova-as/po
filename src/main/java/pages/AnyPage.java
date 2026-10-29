package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.noElementsFound;

public class AnyPage {

    private WebDriver driver;

    public AnyPage(WebDriver driver){
        this.driver = driver;
    }

    private final By UNKNOWN_MESSAGE = By.xpath("//*[text()[contains(normalize-space(.),'Неизвестный тип документа [unknown]')]]");

    public Boolean unknownMessageIsHide(){
        return noElementsFound(driver, UNKNOWN_MESSAGE);
    }
}
