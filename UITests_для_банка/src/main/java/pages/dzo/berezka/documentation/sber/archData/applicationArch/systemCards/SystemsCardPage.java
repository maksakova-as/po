package pages.dzo.berezka.documentation.sber.archData.applicationArch.systemCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Actions.*;
import static helpers.Actions.elementIsDisplayed;


public class SystemsCardPage {

    private final WebDriver driver;

    public SystemsCardPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By SYSTEM_CONTEXT_DROPDOWN = By.xpath("//div[contains(@class,'v-select__selection')]/*[text()[normalize-space(.)='Текущий контекст системы']]");
    private final By ALL_INTEGRATIONS_FLOWS_DROPDOWN = By.xpath("//*[text()[contains(normalize-space(.),'Все интеграционные потоки')]]");
    private final By INCOMING_INTEGRATIONS_FLOW_BUTTON = By.xpath("//*[text()[normalize-space(.)='Входящие интеграционные потоки']]");
    private final By OUT_INCOMING_INTEGRATIONS_FLOW_BUTTON = By.xpath("//*[text()[normalize-space(.)='Исходящие интеграционные потоки']]");
    private final By DROPDOWN_LIST = By.xpath("//div[contains(@class,'v-select__selection')]");
    private final By DROPDOWN_INTEGRATION = By.xpath("(//div[@class='v-field__append-inner'])[3]");
    private final By BUSINESS_LANDSCAPE_BUTTON = By.xpath("//*[text()[contains(normalize-space(.),'Бизнес ландшафт')]]");
    private final By TECHNIC_LANDSCAPE_BUTTON = By.xpath("//*[text()[contains(normalize-space(.),'Технический ландшафт')]]");
    private final By SOFTWARE_LANDSCAPE_BUTTON = By.xpath("//*[text()[contains(normalize-space(.),'Программное обеспечение')]]");
    private final By EXTRA_LANDSCAPE_BUTTON = By.xpath("//*[text()[contains(normalize-space(.),'Дополнительные характеристики')]]");
    private final By CURRENT_SYSTEM_CONTEXT_WITHOUT_FP_BUTTON = By.xpath("//*[text()[normalize-space(.)='Текущий контекст системы (без ФП)']]");
    private final By CURRENT_SYSTEM_CONTEXT_VIEW_DATA_BUTTON = By.xpath("//*[text()[normalize-space(.)='Текущий контекст системы (view данные)']]");
    private final By TARGET_SYSTEM_CONTEXT_WITHOUT_FP_BUTTON = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы (без ФП)']]");
    private final By TARGET_SYSTEM_CONTEXT_VIEW_DATA_BUTTON = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы (view данные)']]");
    private final By TARGET_SYSTEM_CONTEXT_BUTTON = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы']]");
    private final By NEXT_TAB_BUTTON = By.xpath("//div[@class='v-slide-group__next']");
    private final By NEXT_TAB = By.xpath("(//div[@class='v-slide-group__next'])[2]");

//    private WebElement getWebElements(int index) {
//        List<WebElement> webElements = driver.findElements(DROPDOWN_LIST);
//        return webElements.get(index);
//    }


    public boolean elementOnPageIsDisplayed(String locatorFunctionSystems) {
        return elementIsDisplayed(driver, By.xpath(locatorFunctionSystems));
    }

//    public boolean systemDropdownOnPageIsDisplayed() {
//        return elementIsDisplayed(driver, SYSTEM_CONTEXT_DROPDOWN);
//    }

    public boolean ownModelOnPageIsDisplayed(String locator) {
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean techLandscapeOnPageIsDisplayed(String locator) {
        helpers.Actions.selectOption(driver, TECHNIC_LANDSCAPE_BUTTON);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean lifeCycleOnPageIsDisplayed(String locator) {
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean integrationsDropdownOnPageIsDisplayed() {
        return driver.findElement(ALL_INTEGRATIONS_FLOWS_DROPDOWN).isDisplayed();
    }

    public boolean checkWebApplicationInBusinessLandscape(String locator) {
//        getWebElements(0).click();
        helpers.Actions.selectOption(driver, BUSINESS_LANDSCAPE_BUTTON);
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkPerformerSelectionInBusinessLandscape(String locator) {
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkServiceManagementData(String locator){
        helpers.Actions.selectOption(driver, EXTRA_LANDSCAPE_BUTTON);
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkDeviationTitle(String locator){
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkSystemContextData(String locator){
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkTechnicLandscape(String locator) {
//        getWebElements(0).click();
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkSoftwareLandscape(String locator) {
        helpers.Actions.selectOption(driver, SOFTWARE_LANDSCAPE_BUTTON);
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean checkExtraLandscape(String locator) {
        return elementIsDisplayed(driver, By.xpath(locator));
    }

    public boolean schemaLinkInCurrentContextIsDisplayed(String locator) {
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean schemaLinkInCurrentContextWithoutFPIsDisplayed(String locator) {
//        getWebElements(1).click();
        helpers.Actions.selectOption(driver, CURRENT_SYSTEM_CONTEXT_WITHOUT_FP_BUTTON);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean schemaLinkInCurrentContextViewDataIsDisplayed(String locator) {
//        getWebElements(1).click();
        helpers.Actions.selectOption(driver, CURRENT_SYSTEM_CONTEXT_VIEW_DATA_BUTTON);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean schemaLinkInTargetContextIsDisplayed(String locator) {
//        getWebElements(1).click();
        helpers.Actions.selectOption(driver, TARGET_SYSTEM_CONTEXT_BUTTON);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean schemaLinkInTargetContextWithoutFPIsDisplayed(String locator) {
//        getWebElements(1).click();
        helpers.Actions.selectOption(driver, TARGET_SYSTEM_CONTEXT_VIEW_DATA_BUTTON);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean schemaLinkInTargetViewDataIsDisplayed(String locator) {
//        getWebElements(1).click();
        helpers.Actions.selectOption(driver, TARGET_SYSTEM_CONTEXT_WITHOUT_FP_BUTTON);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean elementInIncomingIntegrationsFlowIsDisplayed(String locator) {
        WebElement OBJECT_DATE = driver.findElement(By.xpath("//*[text()[normalize-space(.)='Объекты данных в системе']]"));
        moveToElement(driver, OBJECT_DATE);
//        driver.findElement(DROPDOWN_INTEGRATION).click();
        helpers.Actions.selectOption(driver, INCOMING_INTEGRATIONS_FLOW_BUTTON);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean elementInOutIncomingIntegrationsFlowIsDisplayed(String locator) {
        WebElement OBJECT_DATE = driver.findElement(By.xpath("//*[text()[normalize-space(.)='Объекты данных в системе']]"));
        moveToElement(driver, OBJECT_DATE);
//        driver.findElement(DROPDOWN_INTEGRATION).click();
        helpers.Actions.selectOption(driver, OUT_INCOMING_INTEGRATIONS_FLOW_BUTTON);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public boolean elementAllOutgoingIntegrationsFlowIsDisplayed(String locator) {
        return anyElementOnPageIsDisplayed(driver, locator);
    }
}
