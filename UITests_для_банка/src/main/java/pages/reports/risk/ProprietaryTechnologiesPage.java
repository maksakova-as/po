package pages.reports.risk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ProprietaryTechnologiesPage {

    private WebDriver driver;

    public ProprietaryTechnologiesPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By BAR_CHART = By.cssSelector("#bar-chart");
    private final By VENDOR_TITLE = By.xpath("//*[text()[contains(normalize-space(.),'Использование проприетарных РеплекФарм')]]");
    private final By VENDOR_TEXT = By.xpath("//*[text()[contains(normalize-space(.),'Наличие проприетарных РеплекФарм')]]");
    private final By NOT_PARAMS_TA_LINK = By.xpath("//*[@colspan = '2']/descendant-or-self::*[text()[normalize-space(.)='Данных нет :(' or normalize-space(.)='Нет данных']]");

    public boolean chartIsDisplayed() {
        return elementIsDisplayed(driver, BAR_CHART);
    }

    public boolean getDzoName() {
        return elementIsDisplayed(driver, NOT_PARAMS_TA_LINK);
    }

    public boolean getClassSystem() {
        return elementIsDisplayed(driver, VENDOR_TEXT);
    }

    public boolean getVendorTitle() {
        return elementIsDisplayed(driver, VENDOR_TITLE);
    }
}
