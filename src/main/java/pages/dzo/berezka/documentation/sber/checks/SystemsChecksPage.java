package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementToBeClickableAndDisplayed;

public class SystemsChecksPage {

    private WebDriver driver;

    public SystemsChecksPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_LINK_LIVE_CYCLE_BUTTON = By.xpath("//*[text()[contains(normalize-space(.),'АС')]]");
    private final By ELEMENT_LINK_ID_CYCLE_BUTTON = By.xpath("//h1[@id='ошибки-автоматизированных-систем-и-функциональных-подсистем']");
    private final By PERFORMANCE_ID_SYSTEM_BUTTON = By.xpath("//*[text()[contains(normalize-space(.),': ecogroup.berezka')]]");

    public void clickLinkLifeCycle() {
        driver.findElement(ELEMENT_LINK_LIVE_CYCLE_BUTTON).click();
    }

    public boolean elementOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, ELEMENT_LINK_ID_CYCLE_BUTTON);
    }

    public Boolean elementDubokOnPageIsDisplayed() {
        return elementToBeClickableAndDisplayed(driver, PERFORMANCE_ID_SYSTEM_BUTTON);
    }
}
