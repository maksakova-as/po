package pages.dzo.berezka.documentation.sber.schemas.context.systems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import java.io.IOException;

import static helpers.Actions.imageDiffPlantUML;
import static helpers.WaitUtils.threadSleepWait;
import static helpers.Actions.moveToElement;
import static helpers.Actions.schemaISDisplayed;

public class SchemasSystemsPage {
    private WebDriver driver;

    public SchemasSystemsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')][not(ancestor::div[contains(@class,'v-data-table-footer')])]//div[contains(@class,'v-field')][@role='combobox']");
    private final By CURRENT_SYSTEMS_CONTEXT_VIEW = By.xpath("//*[text()[normalize-space(.)='Контекст системы текущий (view данные)']]");
    private final By TARGET_SYSTEMS_CONTEXT = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы']]");
    private final By TARGET_SYSTEMS_CONTEXT_VIEW = By.xpath("//*[text()[normalize-space(.)='Целевой контекст системы (view данные)']]");

    public ImageDiff elementOnPageIsDisplayed(String locator, String image) throws IOException {
        schemaISDisplayed(driver,By.xpath(locator));
        return imageDiffPlantUML(image, driver);
    }

    public ImageDiff checkCurrentSystemContextView(String locator, String image) throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(CURRENT_SYSTEMS_CONTEXT_VIEW).click();
        schemaISDisplayed(driver,By.xpath(locator));
        return imageDiffPlantUML(image,driver);
    }

    public ImageDiff checkTargetSystemsContext(String locator, String image) throws IOException {
        moveToElement(driver, driver.findElement(DROPDOWN_LIST_BUTTON));
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SYSTEMS_CONTEXT).click();
        schemaISDisplayed(driver,By.xpath(locator));
        return imageDiffPlantUML(image, driver);
    }

    public ImageDiff checkTargetSystemsContextView(String locator, String image) throws IOException {
        moveToElement(driver, driver.findElement(DROPDOWN_LIST_BUTTON));
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SYSTEMS_CONTEXT_VIEW).click();
        schemaISDisplayed(driver,By.xpath(locator));
        return imageDiffPlantUML(image,driver);
    }
}
