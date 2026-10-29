package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {

    private static final String username = PropertiesReading.getProperty("sudir.username");
    private static final String password = PropertiesReading.getProperty("sudir.password");
    private static final String url = PropertiesReading.getProperty("url");

    private static final By USERNAME = By.xpath("//input[@id='username']");
    private static final By PASSWORD = By.xpath("//input[@id='password']");
    private static final By BUTTON_LOGIN = By.xpath("//input[@id='login']");

    public static void login(WebDriver driver) {
        driver.get(url);
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).click();
    }
}
