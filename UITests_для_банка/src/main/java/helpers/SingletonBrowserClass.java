package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletonBrowserClass {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            if (PropertiesReading.getBoolean("browser.headless", false)) {
                options.addArguments("--headless=new");
            }
            options.addArguments("--window-size=" + PropertiesReading.getProperty("browser.window.size", "1020,1500"));

            String driverPath = PropertiesReading.getProperty("browser.driver.path", "");
            if (!driverPath.isBlank()) {
                System.setProperty("webdriver.chrome.driver", driverPath);
            }

            driver = new ChromeDriver(options);

            if (PropertiesReading.getBoolean("auth.enabled", true)) {
                AuthPage.login(driver);
            }
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    driver.quit();
                } catch (Exception ignored) {
                }
            }));
        }
        return driver;
    }
}
