package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {

    private WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By REPORTS_BUTTON = By.xpath("//*[text()[normalize-space(.)='Отчеты']]");
    private final By MENU_INPUT = By.xpath("//div[contains(@class,'dh-nav__filter')]//input");
    private final By GENERAL_STATISTICS_BUTTON = By.xpath("//*[text()[normalize-space(.)='Общая статистика']]");
    private final By RISK_BUTTON = By.xpath("//*[text()[normalize-space(.)='Риски']]");
    private final By CLASSIFICATION_BUTTON = By.xpath("//*[text()[normalize-space(.)='Классификация систем']]");
    private final By COMPONENTS_AND_TECHNOLOGIES_BUTTON = By.xpath("//*[text()[normalize-space(.)='Типы компонент и технологии']]");
    private final By RELIABILITY_CRITERIA_BUTTON = By.xpath("//*[text()[normalize-space(.)='Критерии надежности']]");
    private final By PROPRIETARY_TECHNOLOGIES_BUTTON = By.xpath("//*[text()[normalize-space(.)='Проприетарные технологии']]");
    private final By DOMAIN_BUTTON = By.xpath("//*[text()[normalize-space(.)='Домены участников Группы']]");
    private final String DOMAIN_PAGE = "Домены участников Группы";
    private final String KB_SYSTEM_PAGE = "Отсутствие КБ-систем";
    private final String METAMODEL_PLANT_PAGE = "Метамодель (PlantUML)";
    private final By KB_SYSTEM_LOCATOR_BUTTON = By.xpath("//*[text()[normalize-space(.)='Отсутствие КБ-систем']]");
    private final By METAMODEL_PLANT_BUTTON = By.xpath("//*[text()[normalize-space(.)='Метамодель (PlantUML)']]");

    public void typeText(String s) {
        driver.findElement(MENU_INPUT).sendKeys(s);
    }

    public void findPage(String s, By locator) {
        typeText(s);
        driver.findElement(locator).click();
    }

    public void transferToDomain() {
        findPage(DOMAIN_PAGE,DOMAIN_BUTTON);
    }

    public void transferToReports() {
        driver.findElement(REPORTS_BUTTON).click();
    }

    public void transferToGeneralStatistics() {
        transferToReports();
        driver.findElement(GENERAL_STATISTICS_BUTTON).click();
    }

    public void transferToClassificationSystem() {
        transferToReports();
        driver.findElement(CLASSIFICATION_BUTTON).click();
    }

    public void transferToComponentsAndTechnologies() {
        transferToReports();
        driver.findElement(COMPONENTS_AND_TECHNOLOGIES_BUTTON).click();
    }

    public void transferToRisks() {
        transferToReports();
        driver.findElement(RISK_BUTTON).click();
    }

    public void transferToReliabilityCriteria() {
        transferToRisks();
        driver.findElement(RELIABILITY_CRITERIA_BUTTON).click();
    }

    public void transferToAbsenceKbSystems() {
        findPage(KB_SYSTEM_PAGE, KB_SYSTEM_LOCATOR_BUTTON);
    }

    public void transferToPlantUmlMetamodel() {
        findPage(METAMODEL_PLANT_PAGE, METAMODEL_PLANT_BUTTON);
    }

    public void transferToProprietaryTechnologies() {
        transferToRisks();
        driver.findElement(PROPRIETARY_TECHNOLOGIES_BUTTON).click();
    }
}
