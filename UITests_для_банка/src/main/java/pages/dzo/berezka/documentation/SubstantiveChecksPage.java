package pages.dzo.berezka.documentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static helpers.Actions.elementIsDisplayed;

public class SubstantiveChecksPage {

    private WebDriver driver;

    public SubstantiveChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By PIE_CHART = By.xpath("//canvas[contains(@id,'chart')]");
    private final By AC_BUSINESS_SYSTEM_TEXT = By.xpath("//*[text()[normalize-space(.)='Управление персоналом']]");
    private final By AC_NAME_BUSINESS_SYSTEM_TEXT = By.xpath("//*[text()[normalize-space(.)='1C_Бухгалтерия']]");
    private final By AC_KB_SYSTEM_TEXT = By.xpath("//*[text()[normalize-space(.)='ИБ-Аутентификация пользователей']]");
    private final By AC_NAME_KB_SYSTEM_TEXT = By.xpath("//*[text()[normalize-space(.)='Active Directory']]");
    private final By AC_TECH_SERVICES_TEXT = By.xpath("//*[text()[normalize-space(.)='Системы логирования']]");
    private final By AC_NAME_TECH_SERVICES_TEXT = By.xpath("//*[text()[normalize-space(.)='Graylog']]");
    private final By AC_NAME_SAFETY_PARAMETERS_TEXT = By.xpath("//*[text()[normalize-space(.)='Каталог услуг']]");
    private final By COMPLIANCE_REQUIREMENTS_TEXT = By.xpath("//*[text()[normalize-space(.)='Удовлетворяет критериям']]");
    private final By AC_NAME_CHECKS_TEXT = By.xpath("//*[text()[normalize-space(.)='Маркетплейс']]");
    private final By ID_COMPONENTS_TEXT = By.xpath("//*[text()[normalize-space(.)='ecogroup.berezka.tech_params.berezka.application']]");
    private final By COMPONENTS_TYPE_TEXT = By.xpath("//*[text()[normalize-space(.)='Серверное приложение']]");
    private final By APPLICATION_PO_TEXT = By.xpath("//*[text()[normalize-space(.)='Java Server']]");

    public List<WebElement> getListElements() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(PIE_CHART));
        return driver.findElements(PIE_CHART);
    }
    public boolean systemClassChartIsDisplayed() {
        return getListElements().get(0).isDisplayed();
    }

    public boolean safetyParametersChartIsDisplayed() {
        return getListElements().get(1).isDisplayed();
    }

    public boolean backupChartIsDisplayed() {
        return getListElements().get(2).isDisplayed();
    }

    public boolean asOnBusinessSystemIsDisplayed() {
        return elementIsDisplayed(driver, AC_BUSINESS_SYSTEM_TEXT);
    }

    public boolean asNameBusinessSystemIsDisplayed() {
        return elementIsDisplayed(driver, AC_NAME_BUSINESS_SYSTEM_TEXT);
    }

    public boolean asOnKbSystemIsDisplayed() {
        return elementIsDisplayed(driver, AC_KB_SYSTEM_TEXT);
    }

    public boolean asNameKbSystemIsDisplayed() {
        return elementIsDisplayed(driver, AC_NAME_KB_SYSTEM_TEXT);
    }

    public boolean asTechServicesIsDisplayed() {
        return elementIsDisplayed(driver, AC_TECH_SERVICES_TEXT);
    }

    public boolean asNameTechServicesIsDisplayed() {
        return elementIsDisplayed(driver, AC_NAME_TECH_SERVICES_TEXT);
    }

    public boolean asNameSafetyParametersIsDisplayed() {
        return elementIsDisplayed(driver, AC_NAME_SAFETY_PARAMETERS_TEXT);
    }

    public boolean complianceRequirementsIsDisplayed() {
        return elementIsDisplayed(driver, COMPLIANCE_REQUIREMENTS_TEXT);
    }

    public boolean asNameChecksIsDisplayed() {
        return elementIsDisplayed(driver, AC_NAME_CHECKS_TEXT);
    }

    public boolean idComponentsIsDisplayed() {
        return elementIsDisplayed(driver, ID_COMPONENTS_TEXT);
    }

    public boolean componentsTypeIsDisplayed() {
        return elementIsDisplayed(driver, COMPONENTS_TYPE_TEXT);
    }

    public boolean applicationPOIsDisplayed() {
        return elementIsDisplayed(driver, APPLICATION_PO_TEXT);
    }
}
