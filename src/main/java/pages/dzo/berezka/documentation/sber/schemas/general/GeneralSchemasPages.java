package pages.dzo.berezka.documentation.sber.schemas.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import java.io.IOException;

import static helpers.Actions.imageDiffPlantUML;
import static helpers.WaitUtils.threadSleepWait;
import static helpers.Actions.schemaISDisplayed;


public class GeneralSchemasPages {
    private WebDriver driver;

    public GeneralSchemasPages(WebDriver driver) {
        this.driver = driver;
    }

    private final By DROPDOWN_LIST_BUTTON = By.xpath("//div[contains(@class,'v-select')][not(ancestor::div[contains(@class,'v-data-table-footer')])]//div[contains(@class,'v-field')][@role='combobox']");
    private final By TARGET_SCHEMA = By.xpath("//*[contains(translate(text(),'АБВГДЕЖЗИКЛМНОПРСТУФЦШЩЬЪЭЮЯ','абвгдежзиклмнопрстуфцшщьъэюя'),'целевая')]");

    public ImageDiff elementOnPageIsDisplayed(String locator, String image) throws IOException {
        schemaISDisplayed(driver, By.xpath(locator));
        return imageDiffPlantUML(image,driver);
    }

    public ImageDiff checkTargetSchema(String locator, String image) throws IOException {
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        threadSleepWait(1);
        driver.findElement(TARGET_SCHEMA).click();
        schemaISDisplayed(driver, By.xpath(locator));
        return imageDiffPlantUML(image,driver);
    }
}
