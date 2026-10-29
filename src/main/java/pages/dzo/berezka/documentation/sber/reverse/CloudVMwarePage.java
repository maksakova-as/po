package pages.dzo.berezka.documentation.sber.reverse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import static helpers.Actions.elementIsDisplayed;


public class CloudVMwarePage {

    private WebDriver driver;

    public CloudVMwarePage(WebDriver driver){
        this.driver = driver;
    }

    private final String CLOUD_VMVARE_PAGE = "Облако VMware";
    private final By LOCATOR_1 = By.xpath("//*[text()[normalize-space(.)='Berezka']]");
    private final By LOCATOR_2 = By.xpath("//*[text()[normalize-space(.)='Облако VMware']]");
    private final By LOCATOR_3 = By.xpath("//*[text()[normalize-space(.)='SNAT']]");

    public String getPageName() {
        return CLOUD_VMVARE_PAGE;
    }
    public boolean firstVMElementIsDisplayed() {
        return elementIsDisplayed(driver, LOCATOR_1);
    }

    public boolean secondVMElementIsDisplayed() {
        return elementIsDisplayed(driver, LOCATOR_2);
    }

    public boolean lastVMElementIsDisplayed() {
        return elementIsDisplayed(driver, LOCATOR_3);
    }
}
