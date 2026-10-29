package pages.menu;

import helpers.PropertiesReading;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuDzoPage {

    private final WebDriver driver;
    private final MenuNavigator menu;
    private String dzoPath;

    public MenuDzoPage(WebDriver driver) {
        this.driver = driver;
        this.menu = new MenuNavigator(driver);
    }

    public void setDzo(String dzo) {
        this.dzoPath = PropertiesReading.getProperty("menu.dzo." + dzo, "ДЗО/" + dzo);
    }

    private String dzoName() {
        String[] parts = dzoPath.split("/");
        return parts[parts.length - 1].trim();
    }

    public void typeText(String s) {
        menu.typeInFilter(s);
    }


    public void transferToDzoArch() {
        menu.expandPath(dzoPath);
    }

    public void clickDZOButton() {
        String parent = dzoPath.contains("/") ? dzoPath.substring(0, dzoPath.lastIndexOf('/')) : "";
        menu.expandPath(parent);
        menu.open(dzoName());
    }


    public void transferToBusinessArch() {
        transferToDzoArch();
        menu.expand("Данные архитектуры");
    }

    public void clickBusinessArchListButton() {
        menu.expand("Бизнес-архитектура");
    }

    public void clickBusinessStrategyButton() {
        menu.open("Бизнес стратегия");
    }

    public void clickBusinessTargetButton() {
        menu.open("Бизнес цели");
    }

    public void clickBusinessProcessButton() {
        menu.open("Бизнес-процессы");
    }

    public void clickInteractionChannelButton() {
        menu.open("Каналы взаимодействия с клиентами");
    }

    public void clickClientsButton() {
        menu.open("Клиенты");
    }

    public void clickProductsButton() {
        menu.open("Продукты");
    }

    public void clickInformationArchListButton() {
        menu.expand("Информационная архитектура");
    }

    public void clickBusinessObjectButton() {
        menu.open("Бизнес-объекты");
    }

    public void clickDataObjectsButton() {
        menu.open("Объекты данных");
    }

    public void clickApplicationArchListButton() {
        menu.expand("Прикладная архитектура");
    }

    public void clickGroupsButton() {
        menu.open("Группы");
    }

    public void clickPlanningTasksButton() {
        menu.open("Задачи горизонта планирования");
    }

    public void clickIntegrationFlowsButton() {
        menu.open("Интеграционные потоки");
    }

    public void clickSystemButton() {
        menu.open("Системы");
    }

    public void transferToSystemPage() {
        transferToBusinessArch();
        clickApplicationArchListButton();
        clickSystemButton();
    }

    public void transferToSystemsPage() {
        transferToBusinessArch();
        clickApplicationArchListButton();
        menu.expand("Системы");
    }

    public void clickAutomatedSystemsButton() {
        menu.open("Автоматизированные системы");
    }

    public void clickExternalASButton() {
        menu.open("Внешние АС");
    }

    public void clickFunctionalSubSystems() {
        menu.open("Функциональные подсистемы");
    }

    public void clickKBSystemButton() {
        menu.open("Системы КБ");
    }

    public void clickFunctionButton() {
        menu.open("Функциональность");
    }

    public void clickInteractionButton() {
        menu.open("Точки взаимодействия");
    }

    public void clickTechnicalArchListButton() {
        menu.expand("Техническая архитектура");
    }

    public void clickTechnologyServiceButton() {
        menu.open("Технологические сервисы и системы");
    }

    public void clickSummaryCriticalDataSheets() {
        menu.open("Сводный - Паспорта критичности");
    }


    public void transferToChecks() {
        transferToDzoArch();
        menu.open("Проверки КА ДЗО");
    }

    public void transferToSubstantiveChecks() {
        transferToDzoArch();
        menu.expand("Проверки КА ДЗО");
        menu.open("Сутевые проверки");
    }

    public void clickSummaryButton() {
        menu.openAny("Сводный КА ДЗО", "Сводный");
    }


    private void transferToContextSchemas() {
        transferToDzoArch();
        menu.expand("Схемы");
        menu.expand("Контекстные");
    }

    public void transferToData() {
        transferToContextSchemas();
        menu.expand("Данные");
    }

    public void transferToExternalSystems() {
        transferToContextSchemas();
        menu.expand("Системы");
        menu.expand("Внешняя");
    }

    public void transferToInternalSystems() {
        transferToContextSchemas();
        menu.expand("Системы");
        menu.expand("Внутренняя");
    }

    public void transferToAnalyticSystem() {
        transferToContextSchemas();
        menu.expand("Системы");
        menu.expand("Нет размещения");
        menu.open("Аналитика");
    }

    public void transferToGeneralSystemPage() {
        transferToDzoArch();
        menu.expand("Схемы");
        menu.expand("Общие");
    }

    public void clickArchitectureSchema() {
        menu.open("Архитектурная схема");
    }

    public void clickCriticalSystemCard() {
        menu.open("Карта систем по критичности");
    }


    public void transferToSingleSet() {
        menu.open("Единый свод");
    }

    public void transferToAutoSystem() {
        menu.expand("Единый свод");
        menu.expand("Прикладная архитектура");
        menu.expand("Системы");
        menu.open("Автоматизированные системы");
    }

    public void transferToTechServices() {
        menu.expand("Единый свод");
        menu.expand("Техническая архитектура");
        menu.openAny("Технологические сервисы и системы", "Технологические сервисы");
    }

    public void transferToReverse() {
        menu.expand("Реверс");
    }

    public void transferToAdvanced() {
        transferToReverse();
        menu.expand("Cloud.ru");
        menu.open("Advanced");
    }

    public void clickCloudButton() {
        menu.open("Облако VMware");
    }

    public void clickSchemaCloudButton() {
        menu.open("Схемы");
    }


    public void clickElement(String page) {
        driver.findElement(By.xpath(page)).click();
    }
}
