package pages.tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageTable {

    private WebDriver driver;

    public MainPageTable(WebDriver driver) {
        this.driver = driver;
    }

    private final By ENTER = By.xpath("//div[contains(@class,'dh-nav__filter')]//input");
    private final By CLICK_EDIT_TABLE_MENU = By.xpath("//*[text()[normalize-space(.)='2. Вычисляемые ячейки']]");

    public void clickMainPageButton() {
        driver.findElement(ENTER).click();
    }

    public void enterText(String text) {
        driver.findElement(ENTER).click();
        driver.findElement(ENTER).sendKeys(text);
    }

    public void clickEditTableMenu() {
        driver.findElement(CLICK_EDIT_TABLE_MENU).click();
    }
}