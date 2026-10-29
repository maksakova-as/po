package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.WaitUtils.waitUntilVisibilityOfElement;

public class MenuDzoPage {

    private WebDriver driver;
    private By dzoList;
    private By dzo;

    private static final String MENU_ITEM = "//*[contains(concat(' ', normalize-space(@class), ' '), ' dh-nav__item ')]"
            + "[.//*[contains(@class,'dh-nav__title')][normalize-space(.)='%s']]";
    private static final String MENU_TOGGLE = MENU_ITEM + "//span[contains(@class,'dh-nav__toggle')]";
    private static final String MENU_TITLE = "//*[contains(@class,'dh-nav__title')][normalize-space(.)='%s']";

    public void setDzo(String dzo) {
        this.dzo = By.xpath(String.format(MENU_TITLE, dzo));
        this.dzoList = By.xpath(String.format(MENU_TOGGLE, dzo));
    }

    public MenuDzoPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By MENU_INPUT = By.xpath("//div[contains(@class,'dh-nav__filter')]//input");

    private final By DOC_ARCH_DATA_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Данные архитектуры"));
    private final By BUSINESS_ARCH_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Бизнес-архитектура"));
    private final By BUSINESS_STRATEGY_BUTTON = By.xpath(String.format(MENU_TITLE, "Бизнес стратегия"));
    private final By BUSINESS_GOALS_BUTTON = By.xpath(String.format(MENU_TITLE, "Бизнес цели"));
    private final By BUSINESS_PROCESS_BUTTON = By.xpath(String.format(MENU_TITLE, "Бизнес-процессы"));
    private final By INTERACTION_CHANNEL_BUTTON = By.xpath(String.format(MENU_TITLE, "Каналы взаимодействия с клиентами"));
    private final By CLIENTS_BUTTON = By.xpath(String.format(MENU_TITLE, "Клиенты"));
    private final By PRODUCTS_BUTTON = By.xpath(String.format(MENU_TITLE, "Продукты"));
    private final By BUSINESS_OBJECT_BUTTON = By.xpath(String.format(MENU_TITLE, "Бизнес-объекты"));
    private final By INFORMATION_ARCH_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Информационная архитектура"));
    private final By DATA_OBJECTS_BUTTON = By.xpath(String.format(MENU_TITLE, "Объекты данных"));
    private final By APPLICATION_ARCHITECTURE_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Прикладная архитектура"));
    private final By GROUPS_BUTTON = By.xpath(String.format(MENU_TITLE, "Группы"));
    private final By PLANNING_TASKS_BUTTON = By.xpath(String.format(MENU_TITLE, "Задачи горизонта планирования"));
    private final By INTEGRATIONS_FLOWS_BUTTON = By.xpath(String.format(MENU_TITLE, "Интеграционные потоки"));
    private final By SYSTEM_APP_ARCH_LIST = By.xpath(String.format(MENU_TOGGLE, "Системы"));
    private final By SYSTEM_APP_ARCH_BUTTON = By.xpath(String.format(MENU_TITLE, "Системы"));
    private final By AUTOMATED_SYSTEMS_BUTTON = By.xpath(String.format(MENU_TITLE, "Автоматизированные системы"));
    private final By KB_SYSTEM_BUTTON = By.xpath(String.format(MENU_TITLE, "Системы КБ"));
    private final By FUNCTION_BUTTON = By.xpath(String.format(MENU_TITLE, "Функциональность"));
    private final By TA_PARAMETRS_BUTTON = By.xpath(String.format(MENU_TITLE, "Параметры ТА"));
    private final By TECHNICAL_ARCH_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Техническая архитектура"));
    private final By TECHNOLOGY_SERVICE_BUTTON = By.xpath(String.format(MENU_TITLE, "Технологические сервисы и системы"));
    private final By CONTEXTUAL_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Контекстные"));
    private final By DATA_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Данные"));
    private final By SCHEMES_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Схемы"));
    private final By SCHEMAS_SYSTEM_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Системы"));
    private final By SUMMARY_BUTTON = By.xpath("//*[contains(@class,'dh-nav__title')][starts-with(normalize-space(.),'Сводный') and not(contains(.,'Паспорта'))]");
    private final By ARCHITECTURAL_SCHEME_LIST = By.xpath(String.format(MENU_TITLE, "Архитектурная схема"));
    private final By CHECKS_BUTTON = By.xpath(String.format(MENU_TITLE, "Проверки КА ДЗО"));
    private final By CHECKS_LIST_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Проверки КА ДЗО"));
    private final By EXTERNAL_SYSTEMS_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Внешняя"));
    private final By SUBSTANTIVE_CHECKS_BUTTON = By.xpath(String.format(MENU_TITLE, "Сутевые проверки"));
    private final By INTERNAL_SYSTEM_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Внутренняя"));
    private final By EMPTY_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Нет размещения"));
    private final By ANALYTICS_BUTTON = By.xpath(String.format(MENU_TITLE, "Аналитика"));
    private final By GENERAL_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Общие"));
    private final By CRITICAL_SYSTEM_CARD_BUTTON = By.xpath(String.format(MENU_TITLE, "Карта систем по критичности"));
    private final By EXTERNAL_A_S_BUTTON = By.xpath(String.format(MENU_TITLE, "Внешние АС"));
    private final By FUNCTIONAL_SUB_SYSTEMS_BUTTON = By.xpath(String.format(MENU_TITLE, "Функциональные подсистемы"));
    private final By SUMMARY_CRITICAL_DATA_SHEETS_BUTTON = By.xpath(String.format(MENU_TITLE, "Сводный - Паспорта критичности"));
    private final By DZO_BUTTON = By.xpath(String.format(MENU_TOGGLE, "ДЗО"));
    private final By SINGLE_SET_BUTTON = By.xpath(String.format(MENU_TITLE, "Единый свод"));
    private final By INTERACTION_BUTTON = By.xpath(String.format(MENU_TITLE, "Точки взаимодействия"));
    private final By REVERSE_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Реверс"));
    private final By CLOUD_BUTTON = By.xpath(String.format(MENU_TOGGLE, "Cloud.ru"));
    private final By ADVANCED_BUTTON = By.xpath(String.format(MENU_TITLE, "Advanced"));
    private final By SCHEMA_CLOUD_BUTTON = By.xpath(String.format(MENU_TITLE, "Схемы"));
    private final By CLOUD_VMVARE_BUTTON = By.xpath(String.format(MENU_TITLE, "Облако VMware"));

    private void clickListButton(By listButton) {
        WebElement button = waitUntilVisibilityOfElement(driver, listButton, 35);
        WebElement item = button.findElement(By.xpath("./ancestor::*[contains(concat(' ', normalize-space(@class), ' '), ' dh-nav__item ')][1]"));
        if (!"true".equals(item.getAttribute("aria-expanded"))) {
            button.click();
        }
    }

    public void typeText(String s) {
        driver.findElement(MENU_INPUT).sendKeys(s);
    }

    public void transferToSubstantiveChecks() {
        transferToDzoArch();
        clickListButton(CHECKS_LIST_BUTTON);
        driver.findElement(SUBSTANTIVE_CHECKS_BUTTON).click();
    }

    public void transferToSingleSet() {
        driver.findElement(SINGLE_SET_BUTTON).click();
    }

    public void transferToAutoSystem() {
        transferToSingleSet();
        clickListButton(APPLICATION_ARCHITECTURE_LIST_BUTTON);
        driver.findElement(SYSTEM_APP_ARCH_BUTTON).click();
        driver.findElement(AUTOMATED_SYSTEMS_BUTTON).click();
    }

    public void transferToTechServices() {
        transferToSingleSet();
        clickListButton(TECHNICAL_ARCH_LIST_BUTTON);
        driver.findElement(TECHNOLOGY_SERVICE_BUTTON).click();
    }

    public void transferToDzoArch() {
        clickListButton(DZO_BUTTON);
        clickListButton(dzoList);
    }

    public void transferToBusinessArch() {
        transferToDzoArch();
        clickListButton(DOC_ARCH_DATA_LIST_BUTTON);
    }

    public void transferToAdvanced(){
        transferToReverse();
        clickListButton(CLOUD_BUTTON);
        driver.findElement(ADVANCED_BUTTON).click();
    }

    public void transferToData() {
        transferToDzoArch();
        clickListButton(SCHEMES_LIST_BUTTON);
        clickListButton(CONTEXTUAL_BUTTON);
        clickListButton(DATA_LIST_BUTTON);
    }

    public void transferToExternalSystems() {
        transferToDzoArch();
        clickListButton(SCHEMES_LIST_BUTTON);
        clickListButton(CONTEXTUAL_BUTTON);
        clickListButton(SCHEMAS_SYSTEM_LIST_BUTTON);
        clickListButton(EXTERNAL_SYSTEMS_BUTTON);
    }

    public void transferToInternalSystems() {
        transferToDzoArch();
        clickListButton(SCHEMES_LIST_BUTTON);
        clickListButton(CONTEXTUAL_BUTTON);
        clickListButton(SCHEMAS_SYSTEM_LIST_BUTTON);
        clickListButton(INTERNAL_SYSTEM_BUTTON);
    }

    public void transferToAnalyticSystem() {
        transferToInternalSystems();
        clickListButton(EMPTY_BUTTON);
        driver.findElement(ANALYTICS_BUTTON).click();
    }

    public void clickBusinessArchListButton() {
        clickListButton(BUSINESS_ARCH_LIST_BUTTON);
    }

    public void clickBusinessStrategyButton() {
        driver.findElement(BUSINESS_STRATEGY_BUTTON).click();
    }

    public void clickBusinessTargetButton() {
        driver.findElement(BUSINESS_GOALS_BUTTON).click();
    }

    public void clickBusinessProcessButton() {
        driver.findElement(BUSINESS_PROCESS_BUTTON).click();
    }

    public void clickInteractionChannelButton() {
        driver.findElement(INTERACTION_CHANNEL_BUTTON).click();
    }

    public void clickClientsButton() {
        driver.findElement(CLIENTS_BUTTON).click();
    }

    public void clickProductsButton() {
        driver.findElement(PRODUCTS_BUTTON).click();
    }

    public void clickBusinessObjectButton() {
        driver.findElement(BUSINESS_OBJECT_BUTTON).click();
    }

    public void clickInformationArchListButton() {
        clickListButton(INFORMATION_ARCH_LIST_BUTTON);
    }

    public void clickDataObjectsButton() {
        driver.findElement(DATA_OBJECTS_BUTTON).click();
    }

    public void clickApplicationArchListButton() {
        clickListButton(APPLICATION_ARCHITECTURE_LIST_BUTTON);
    }

    public void clickGroupsButton() {
        driver.findElement(GROUPS_BUTTON).click();
    }

    public void clickPlanningTasksButton() {
        driver.findElement(PLANNING_TASKS_BUTTON).click();
    }

    public void clickIntegrationFlowsButton() {
        driver.findElement(INTEGRATIONS_FLOWS_BUTTON).click();
    }

    public void clickSystemButton() {
        driver.findElement(SYSTEM_APP_ARCH_BUTTON).click();
    }

    public void clickKBSystemButton() {
        driver.findElement(KB_SYSTEM_BUTTON).click();
    }

    public void clickFunctionButton() {
        driver.findElement(FUNCTION_BUTTON).click();
    }

    public void clickTechnicalArchListButton() {
        clickListButton(TECHNICAL_ARCH_LIST_BUTTON);
    }

    public void clickTechnologyServiceButton() {
        driver.findElement(TECHNOLOGY_SERVICE_BUTTON).click();
    }

    public void clickInteractionButton() {
        driver.findElement(INTERACTION_BUTTON).click();
    }

    public void clickSchemaCloudButton() {
        driver.findElement(SCHEMA_CLOUD_BUTTON).click();
    }

    public void clickElement(String page) {
        driver.findElement(By.xpath(page)).click();
    }

    public void transferToChecks() {
        transferToDzoArch();
        driver.findElement(CHECKS_BUTTON).click();
    }

    public void clickSummaryButton() {
        driver.findElement(SUMMARY_BUTTON).click();
    }

    public void transferToReverse() {
        clickListButton(REVERSE_BUTTON);
    }

    public void clickCloudButton() {
        driver.findElement(CLOUD_VMVARE_BUTTON).click();
    }

    public void transferToSystemPage() {
        transferToBusinessArch();
        clickApplicationArchListButton();
        clickSystemButton();
    }

    public void transferToGeneralSystemPage() {
        transferToDzoArch();
        clickListButton(SCHEMES_LIST_BUTTON);
        clickListButton(GENERAL_BUTTON);
    }

    public void clickArchitectureSchema() {
        driver.findElement(ARCHITECTURAL_SCHEME_LIST).click();
    }

    public void clickCriticalSystemCard() {
        driver.findElement(CRITICAL_SYSTEM_CARD_BUTTON).click();
    }

    public void clickDZOButton() {
        clickListButton(DZO_BUTTON);
        driver.findElement(dzo).click();
    }

    public void clickAutomatedSystemsButton() {
        driver.findElement(AUTOMATED_SYSTEMS_BUTTON).click();
    }

    public void transferToSystemsPage() {
        transferToBusinessArch();
        clickApplicationArchListButton();
        clickListButton(SYSTEM_APP_ARCH_LIST);
    }

    public void clickExternalASButton() {
        driver.findElement(EXTERNAL_A_S_BUTTON).click();
    }

    public void clickFunctionalSubSystems() {
        driver.findElement(FUNCTIONAL_SUB_SYSTEMS_BUTTON).click();
    }

    public void clickSummaryCriticalDataSheets() {
        driver.findElement(SUMMARY_CRITICAL_DATA_SHEETS_BUTTON).click();
    }
}
