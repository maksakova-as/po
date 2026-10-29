package pages.metamodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.anyElementOnPageIsDisplayed;
import static helpers.Actions.elementIsDisplayed;

public class GeneralPage {

    private WebDriver driver;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String KA_DZO_METAMODEL_LOCATOR = "//div[@class='plantuml-schema']//*[text()[contains(normalize-space(.),'Мета-модель КА ДЗО')]]";
    private final String DIGITAL_LOCATOR = "//div[@class='plantuml-schema']//*[text()[contains(normalize-space(.),'Цифровое (web, app) или физическое')]]";
    private final String CHANNEL_LOCATOR = "//div[@class='plantuml-schema']//*[text()[contains(normalize-space(.),'Канал')]]";
    private final String USAGE_LOCATOR = "//div[@class='plantuml-schema']//*[text()[contains(normalize-space(.),'Использует')]]";

    public Boolean elementTitleOfMetamodelIsDisplayed() {
        return anyElementOnPageIsDisplayed(driver, KA_DZO_METAMODEL_LOCATOR);
    }

    public Boolean elementDigitalOfMetamodelIsDisplayed() {
        return anyElementOnPageIsDisplayed(driver, DIGITAL_LOCATOR);
    }

    public Boolean elementChannelOfMetamodelIsDisplayed() {
        return anyElementOnPageIsDisplayed(driver, CHANNEL_LOCATOR);
    }

    public Boolean elementUsageOfMetamodelIsDisplayed() {
        return anyElementOnPageIsDisplayed(driver, USAGE_LOCATOR);
    }
}
