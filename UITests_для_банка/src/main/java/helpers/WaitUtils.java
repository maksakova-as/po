package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WaitUtils {

    public static void waitUntilVisibilityOfElements(WebDriver driver, By firstElement, By secondElement) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.and(visibilityOfElementLocated(firstElement), visibilityOfElementLocated(secondElement)));
    }

    public static WebElement waitUntilVisibilityOfElement(WebDriver driver, By element, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static WebElement waitUntilElementToBeClickable(WebDriver driver, By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilTextDisappears(WebDriver driver, By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    public static boolean waitUntilVisibilityOfSpecificText(WebDriver driver, By locator, String expectedText) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public static boolean waitUntilUrlIsLoadedInNewTab(WebDriver driver, String url) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains(url));
    }

    public static void threadSleepWait(int seconds) {
        try {
            java.util.concurrent.TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
