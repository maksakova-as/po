package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By MENU_BUTTON = By.xpath("//button[contains(@class, 'v-app-bar-nav-icon')]");
    private final By KADZO_DESCRIPTION_TEXT = By.xpath("//*[text()[normalize-space(.)='Инструкция по описанию КА ДЗО в DocHub (yaml)']]");
    private final By SBERCHAT_TEXT = By.xpath("//*[text()[normalize-space(.)='https://sberchat.sberbank.ru/@seaf']]");
    private final By JIRA_TEXT = By.xpath("//*[text()[normalize-space(.)='http://jira.sberbank.ru/browse/ERA']]");

    public void mainPageButton() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(MENU_BUTTON)).click();
    }

    public String getKaDzoDescriptionLink() {
        return driver.findElement(KADZO_DESCRIPTION_TEXT).getAttribute("href");
    }

    public String getSberChatLink() {
        return driver.findElement(SBERCHAT_TEXT).getAttribute("href");
    }

    public String getJiraLink() {
        return driver.findElement(JIRA_TEXT).getAttribute("href");
    }
}
