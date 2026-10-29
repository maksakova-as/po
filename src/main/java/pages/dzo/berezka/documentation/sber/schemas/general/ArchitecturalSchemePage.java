package pages.dzo.berezka.documentation.sber.schemas.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import java.io.IOException;

import static helpers.Actions.imageDiffPlantUML;
import static helpers.WaitUtils.threadSleepWait;
import static helpers.Actions.schemaISDisplayed;

public class ArchitecturalSchemePage {

    private WebDriver driver;

    public ArchitecturalSchemePage(WebDriver driver) {

        this.driver = driver;
    }

    private final By ELEMENT_2GIS_BUTTON = By.xpath("//*[contains(@id, 'partners.2gis')]");
    private final By ElEM_MARKETPLASE_LINK = By.xpath("//*[@id ='elem_ecogroup.berezka.systems.berezka']");
    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')][not(ancestor::div[contains(@class,'v-data-table-footer')])]//div[contains(@class,'v-field')][@role='combobox']");
    private final By CURRENT_SCHEMA_OUTER_PERIMETER_ONLY = By.xpath("//*[text()[normalize-space(.)='Текущая схема (только внешний периметр)']]");
    private final By CURRENT_SCHEMA_WITHOUT_FP = By.xpath("//*[text()[normalize-space(.)='Текущая схема (без ФП)']]");
    private final By CURRENT_SCHEMA_WITHOUT_FP_OUTER_PERIMETER_ONLY = By.xpath("//*[text()[normalize-space(.)='Текущая схема (без ФП, внешний периметр)']]");
    private final By TARGET_SCHEMA = By.xpath("//*[text()[normalize-space(.)='Целевая схема']]");
    private final By TARGET_SCHEMA_OUTER_PERIMETER_ONLY = By.xpath("//*[text()[normalize-space(.)='Целевая схема (только внешний периметр)']]");
    private final By TARGET_SCHEMA_WITHOUT_FP = By.xpath("//*[text()[normalize-space(.)='Целевая схема (без ФП)']]");
    private final By TARGET_SCHEMA_WITHOUT_FP_OUTER_PERIMETER_ONLY = By.xpath("//*[text()[normalize-space(.)='Целевая схема (без ФП, внешний периметр)']]");

    public ImageDiff currentSchemaIsDisplayed() throws IOException {
        schemaISDisplayed(driver, ELEMENT_2GIS_BUTTON);
        return imageDiffPlantUML("context.png", driver);
    }

    public ImageDiff checkCurrentSchemaOuterPerimeterOnly() throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(CURRENT_SCHEMA_OUTER_PERIMETER_ONLY).click();
        schemaISDisplayed(driver, ElEM_MARKETPLASE_LINK);
        return imageDiffPlantUML("CurrentSchema.png", driver);
    }

    public ImageDiff checkCurrentSchemaWithoutFP() throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(CURRENT_SCHEMA_WITHOUT_FP).click();
        schemaISDisplayed(driver, ELEMENT_2GIS_BUTTON);
        return imageDiffPlantUML("CurrentSchemaWithoutFP.png", driver);
    }

    public ImageDiff checkCurrentSchemaWithoutFPOuterPerimeterOnly() throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(CURRENT_SCHEMA_WITHOUT_FP_OUTER_PERIMETER_ONLY).click();
        schemaISDisplayed(driver, ElEM_MARKETPLASE_LINK);
        return imageDiffPlantUML("CurrentSchemaWithoutFPOuterPerimeterOnly.png", driver);
    }

    public ImageDiff checkTargetSchema() throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SCHEMA).click();
        schemaISDisplayed(driver, ELEMENT_2GIS_BUTTON);
        return imageDiffPlantUML("TargetSchema.png", driver);
    }

    public ImageDiff checkTargetSchemaOuterPerimeterOnly() throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SCHEMA_OUTER_PERIMETER_ONLY).click();
        schemaISDisplayed(driver, ElEM_MARKETPLASE_LINK);
        return imageDiffPlantUML("TargetSchemaOuterPerimeterOnly.png", driver);
    }

    public ImageDiff checkTargetSchemaWithoutFP() throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SCHEMA_WITHOUT_FP).click();
        schemaISDisplayed(driver, (ELEMENT_2GIS_BUTTON));
        return imageDiffPlantUML("TargetSchemaWithoutFP.png", driver);
    }

    public ImageDiff checkTargetSchemaWithoutFPOuterPerimeterOnly() throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SCHEMA_WITHOUT_FP_OUTER_PERIMETER_ONLY).click();
        schemaISDisplayed(driver, ElEM_MARKETPLASE_LINK);
        return imageDiffPlantUML("TargetSchemaWithoutFPOuterPerimeterOnly.png", driver);
    }
}
