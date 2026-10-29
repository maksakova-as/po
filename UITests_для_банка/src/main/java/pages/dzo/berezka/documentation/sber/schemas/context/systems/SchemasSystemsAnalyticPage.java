package pages.dzo.berezka.documentation.sber.schemas.context.systems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import java.io.IOException;

import static helpers.Actions.imageDiffPlantUML;
import static helpers.Actions.schemaISDisplayed;

public class SchemasSystemsAnalyticPage {
    private WebDriver driver;

    public SchemasSystemsAnalyticPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')]//div[@role='combobox']");
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
        helpers.Actions.selectOption(driver, CURRENT_SYSTEMS_CONTEXT_VIEW);
        schemaISDisplayed(driver, ElEM_CATALOG);
        return imageDiffPlantUML(image, driver);
    }

    public ImageDiff checkTargetSystemsContext(String image) throws IOException {
        helpers.Actions.selectOption(driver, TARGET_SYSTEMS_CONTEXT);
        schemaISDisplayed(driver, ElEM_MARKETPLASE_LINK);
        return imageDiffPlantUML(image, driver);
    }

    public ImageDiff checkTargetSystemsContextView(String image) throws IOException {
        helpers.Actions.selectOption(driver, TARGET_SYSTEMS_CONTEXT_VIEW);
        schemaISDisplayed(driver, ElEM_CATALOG);
        return imageDiffPlantUML(image, driver);
    }
}
