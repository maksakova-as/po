package pages.dzo.berezka.documentation.sber.schemas.context.systems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import java.io.IOException;

import static helpers.Actions.imageDiffPlantUML;
import static helpers.WaitUtils.threadSleepWait;
import static helpers.Actions.schemaISDisplayed;

public class SchemasSystemsAnalyticPage {
    private WebDriver driver;

    public SchemasSystemsAnalyticPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')][not(ancestor::div[contains(@class,'v-data-table-footer')])]//div[contains(@class,'v-field')][@role='combobox']");
    private final By CURRENT_SYSTEMS_CONTEXT_VIEW = By.xpath("//*[text()[normalize-space(.)='Контекст системы текущий (view данные)']]");
    private final By TARGET_SYSTEMS_CONTEXT = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы']]");
    private final By TARGET_SYSTEMS_CONTEXT_VIEW = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы (view данные)']]");
    private final By ElEM_MARKETPLASE_LINK = By.xpath("//*[@id='elem_ecogroup.berezka.systems.berezka']");
    private final By ElEM_CATALOG = By.xpath("//*[@id='elem_ecogroup.berezka.systems.berezka.catalog']");

    public ImageDiff elementOnPageIsDisplayed(String image) throws IOException {
        schemaISDisplayed(driver, ElEM_MARKETPLASE_LINK);
        return imageDiffPlantUML(image, driver);
    }

    public ImageDiff checkCurrentSystemContextView(String image) throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(CURRENT_SYSTEMS_CONTEXT_VIEW).click();
        schemaISDisplayed(driver, ElEM_CATALOG);
        return imageDiffPlantUML(image, driver);
    }

    public ImageDiff checkTargetSystemsContext(String image) throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SYSTEMS_CONTEXT).click();
        schemaISDisplayed(driver, ElEM_MARKETPLASE_LINK);
        return imageDiffPlantUML(image, driver);
    }

    public ImageDiff checkTargetSystemsContextView(String image) throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SYSTEMS_CONTEXT_VIEW).click();
        schemaISDisplayed(driver, ElEM_CATALOG);
        return imageDiffPlantUML(image, driver);
    }
}
