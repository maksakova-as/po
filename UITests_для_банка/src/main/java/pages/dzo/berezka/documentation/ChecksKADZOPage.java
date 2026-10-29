package pages.dzo.berezka.documentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChecksKADZOPage {

    private WebDriver driver;

    public ChecksKADZOPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By BUSINESS_FACILITIES_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Бизнес-сущности')]]");
    private final By BUSINESS_PROCESSES_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Бизнес-процессы')]]");
    private final By GROUP_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Группы')]]");
    private final By INTEGRATIONS_BUTTON = By.xpath("//*[text()[contains(normalize-space(.),'Интеграции')]]");
    private final By CHANNELS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Каналы')]]");
    private final By CLIENTS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Клиенты')]]");
    private final By DATA_OBJECTS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Объекты данных')]]");
    private final By REQUIRED_ENABLERS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Объединяющие элементы')]]");
    private final By PRODUCTS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Продукты')]]");
    private final By SYSTEMS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'АС')]]");
    private final By SYSTEMS_KB_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'КБ')]]");
    private final By STRATEGY_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Стратегия')]]");
    private final By TECH_PARAMS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Параметры ТА')]]");
    private final By TECH_SERVICE_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'сервисы')]]");
    private final By FUNCTIONALITY_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Функциональность')]]");
    private final By CRITICALITY_PASSPORTS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Паспорта критичности')]]");
    private final By GOAL_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Цели')]]");
    private final By TASKS_AND_PLANS_BUTTON = By.xpath("//a[text()[contains(normalize-space(.),'Задачи и планы')]]");

    public void clickBusinessFacilities() {
        driver.findElement(BUSINESS_FACILITIES_BUTTON).click();
    }

    public void clickBusinessProcesses() {
        driver.findElement(BUSINESS_PROCESSES_BUTTON).click();
    }

    public void clickGroupButton() {
        driver.findElement(GROUP_BUTTON).click();
    }

    public void clickIntegrationsButton() {
        driver.findElement(INTEGRATIONS_BUTTON).click();
    }

    public void clickChannels() {
        driver.findElement(CHANNELS_BUTTON).click();
    }

    public void clickClients() {
        driver.findElement(CLIENTS_BUTTON).click();
    }

    public void clickDataObjects() {
        driver.findElement(DATA_OBJECTS_BUTTON).click();
    }

    public void clickRequiredEnablersButton() {
        driver.findElement(REQUIRED_ENABLERS_BUTTON).click();
    }

    public void clickProductsButton() {
        driver.findElement(PRODUCTS_BUTTON).click();
    }

    public void clickSystemsButton() {
        driver.findElement(SYSTEMS_BUTTON).click();
    }

    public void clickSystemKBButton() {
        driver.findElement(SYSTEMS_KB_BUTTON).click();
    }

    public void clickStrategyButton() {
        driver.findElement(STRATEGY_BUTTON).click();
    }

    public void clickTechParamsButton() {
        driver.findElement(TECH_PARAMS_BUTTON).click();
    }

    public void clickTechServiceButton() {
        driver.findElement(TECH_SERVICE_BUTTON).click();
    }

    public void clickFunctionalityButton() {
        driver.findElement(FUNCTIONALITY_BUTTON).click();
    }

    public void clickGoalButton() {
        driver.findElement(GOAL_BUTTON).click();
    }

    public void clickCriticalityPassport() {
        driver.findElement(CRITICALITY_PASSPORTS_BUTTON).click();
    }

    public void clickTasksAndPlans() {
        driver.findElement(TASKS_AND_PLANS_BUTTON).click();
    }
}
