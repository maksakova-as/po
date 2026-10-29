package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class ChannelsPage {

    private WebDriver driver;

    public ChannelsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ID_CHANNELS = By.xpath("//*[@id=\"ошибки-каналов-взаимодействия-с-клиентом\"]");

    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, ELEMENT_ID_CHANNELS);
    }
}
