package pages.dzo.berezka.documentation.sber.archData.applicationArch.systemCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class MarketplaceCardPage {

    private WebDriver driver;

    public MarketplaceCardPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By AUTH_LINK = By.xpath("//*[text()[normalize-space(.)='Аутентификация пользователей']]");
    private final By SYSTEM_CONTEXT_DROPDOWN = By.xpath("//div[contains(@class,'v-select__selection')]/*[text()[normalize-space(.)='Текущий контекст системы']]");
    private final By INTEGRATIONS_FLOWS_DROPDOWN = By.xpath("//*[text()[normalize-space(.)='Исходящие интеграционные потоки']]");
    private final By DROPDOWN_LIST = By.xpath("//div[contains(@class,'v-select')]//div[@role='combobox']");
    private final By BUSINESS_LANDSCAPE_BUTTON = By.xpath("//*[text()[normalize-space(.)='Бизнес ландшафт']]");
    private final By WEB_APPLICATION_LINK = By.xpath("//*[text()[normalize-space(.)='Web-приложение']]");
    private final By PERFORMER_SELECTION_LINK = By.xpath("//*[text()[normalize-space(.)='Подбор исполнителя']]");
    private final By BALANCER_TEXT = By.xpath("//*[text()[normalize-space(.)='Балансировщик']]");
    private final By TECHNIC_LANDSCAPE_BUTTON = By.xpath("//*[text()[normalize-space(.)='Технический ландшафт']]");
    private final By OUTSIDE_2_GIS_SCHEMA_LINK = By.xpath("//*[text()[contains(normalize-space(.),'без ФП')]]/..//following-sibling::*[contains(@href, 'ecosystem.partners')]");
    private final By SERVICES_CATALOG_LINK = By.xpath("//*[contains(@href, 'berezka.catalog')]");
    private final By CURRENT_SYSTEM_CONTEXT_WITHOUT_FP_BUTTON = By.xpath("//*[text()[normalize-space(.)='Текущий контекст системы (без ФП)']]");
    private final By CURRENT_SYSTEM_CONTEXT_VIEW_DATA_BUTTON = By.xpath("//*[text()[normalize-space(.)='Текущий контекст системы (view данные)']]");
    private final By TARGET_SYSTEM_CONTEXT_WITHOUT_FP_BUTTON = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы (без ФП)']]");
    private final By TARGET_SYSTEM_CONTEXT_VIEW_DATA_BUTTON = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы (view данные)']]");
    private final By INCOMING_INTEGRATIONS_FLOW_BUTTON = By.xpath("//*[text()[normalize-space(.)='Входящие интеграционные потоки']]");
    private final By CRM_SCHEMA_LINK = By.xpath("//*[text()[normalize-space(.)='«Целевая, частично внедрена»']]/ancestor::*[@href]");
    private final By TARGET_SYSTEM_CONTEXT_BUTTON = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы']]");
    private final By ANALYTICS_LINK = By.xpath("//*[text()[normalize-space(.)='«Целевая, требуется выбор»']]/ancestor::*[contains(@href, 'analytics')]");
    private final By MARKETPLACE_SERVICES_LINK = By.xpath("//*[text()[normalize-space(.)='Базар']]/ancestor::*[contains(@href, 'osinka')]");
    private final By MARKETPLACE_LINK = By.xpath("//*[text()[normalize-space(.)='Маркетплейс']]/ancestor::*[contains(@href, 'berezka')]");
    private final By SBER_BUSINESS_LINK = By.xpath("//*[@data-v-010c8869]//*[contains(@href, 'enablers.sberbusinessid')]");
    private final By SMSC_LINK = By.xpath("//*[@data-v-010c8869]//*[text()[normalize-space(.)='SMSC']]");

    private WebElement getWebElements(int index) {
        List<WebElement> webElements = driver.findElements(DROPDOWN_LIST);
        return webElements.get(index);
    }
    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, AUTH_LINK);
    }

    public boolean SystemDropdownOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, SYSTEM_CONTEXT_DROPDOWN);
    }

    public boolean IntegrationsDropdownOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, INTEGRATIONS_FLOWS_DROPDOWN);
    }

    public boolean checkWebApplicationInBusinessLandscape() {
        helpers.Actions.selectOption(driver, BUSINESS_LANDSCAPE_BUTTON);
        return elementToBeClickableAndDisplayed(driver, WEB_APPLICATION_LINK);
    }

    public boolean checkPerformerSelectionInBusinessLandscape() {
        return elementToBeClickableAndDisplayed(driver, PERFORMER_SELECTION_LINK);
    }
    public boolean checkTechnicLandscape() {
        helpers.Actions.selectOption(driver, TECHNIC_LANDSCAPE_BUTTON);
        return elementToBeClickableAndDisplayed(driver, BALANCER_TEXT);
    }
    public boolean schemaLinkInCurrentContextIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, SERVICES_CATALOG_LINK);
    }

    public boolean schemaLinkInCurrentContextWithoutFPIsDisplayed() {
        helpers.Actions.selectOption(driver, CURRENT_SYSTEM_CONTEXT_WITHOUT_FP_BUTTON);
        return elementToBeClickableAndDisplayed(driver, OUTSIDE_2_GIS_SCHEMA_LINK);
    }

    public boolean schemaLinkInCurrentContextViewDataIsDisplayed() {
        helpers.Actions.selectOption(driver, CURRENT_SYSTEM_CONTEXT_VIEW_DATA_BUTTON);
        return elementToBeClickableAndDisplayed(driver, CRM_SCHEMA_LINK);
    }

    public boolean schemaLinkInTargetContextIsDisplayed() {
        helpers.Actions.selectOption(driver, TARGET_SYSTEM_CONTEXT_BUTTON);
        return elementToBeClickableAndDisplayed(driver, ANALYTICS_LINK);
    }

    public boolean schemaLinkInTargetContextWithoutFPIsDisplayed() {
        helpers.Actions.selectOption(driver, TARGET_SYSTEM_CONTEXT_VIEW_DATA_BUTTON);
            return elementToBeClickableAndDisplayed(driver, MARKETPLACE_LINK);
    }

    public boolean schemaLinkInTargetViewDataIsDisplayed() {
        helpers.Actions.selectOption(driver, TARGET_SYSTEM_CONTEXT_WITHOUT_FP_BUTTON);
        return elementToBeClickableAndDisplayed(driver, MARKETPLACE_SERVICES_LINK);
    }

    public boolean elementInOutgoingIntegrationsFlowIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, SMSC_LINK );
    }

    public boolean elementInIncomingIntegrationsFlowIsDisplayed() {
        helpers.Actions.selectOption(driver, INCOMING_INTEGRATIONS_FLOW_BUTTON);
        return elementToBeClickableAndDisplayed(driver, SBER_BUSINESS_LINK);
    }
}
