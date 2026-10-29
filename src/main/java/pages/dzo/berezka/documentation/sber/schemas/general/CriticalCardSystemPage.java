package pages.dzo.berezka.documentation.sber.schemas.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import java.io.IOException;

import static helpers.Actions.elementIsDisplayed;
import static helpers.Actions.imageDiffPlantUML;
import static helpers.Actions.schemaISDisplayed;

public class CriticalCardSystemPage {

    private WebDriver driver;

    public CriticalCardSystemPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By MARKETPLACE_LINK = By.xpath("//*[text()[normalize-space(.)='Маркетплейс']]");


    public ImageDiff elementOnPageIsDisplayed() throws IOException {
        schemaISDisplayed(driver, MARKETPLACE_LINK);
        elementIsDisplayed(driver, MARKETPLACE_LINK);
        return imageDiffPlantUML("CriticalCard.png", driver);
    }
}
