package pages.dzo.berezka.documentation.sber.archData.businessArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By COLUMN_ONE_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.products.uid1']]");
    private final By COLUMN_TWO_TEXT = By.xpath("//*[text()[normalize-space(.)='Маркетплейс бытовых услуг']]");
    private final By COLUMN_THREE_TEXT = By.xpath("//*[text()[normalize-space(.)='Площадка для взаимодействия клиентов и поставщиков, предоставляющих бытовые услуги (например, услуги по ремонту)']]");
    private final By COLUMN_FOUR_TEXT = By.xpath("//*[text()[normalize-space(.)='Используется']]");

    public boolean firstElementInTableIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, COLUMN_ONE_TEXT);
    }

    public boolean secondElementInTableIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, COLUMN_TWO_TEXT);
    }

    public boolean thirdElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_THREE_TEXT);
    }

    public boolean fourthElementInTableIsDisplayed() {
        return elementIsDisplayed(driver, COLUMN_FOUR_TEXT);
    }
}
