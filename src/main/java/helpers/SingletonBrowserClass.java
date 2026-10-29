package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletonBrowserClass {

    private static WebDriver driver;
    private static ChromeOptions chromeOptions = new ChromeOptions();

    public static WebDriver getInstance() {
      //  chromeOptions.addArguments("headless");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\23456361\\IdeaProjects\\qa-for-seaf.portal\\driver\\chromedriver.exe");
        chromeOptions.addArguments("--window-size=1020,1500");
        if (driver == null) {
            driver = new ChromeDriver(chromeOptions);
            AuthPage.login(driver);
        }
        return driver;
    }
}