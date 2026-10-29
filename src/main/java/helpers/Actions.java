package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.Level;

import static io.qameta.allure.Allure.addAttachment;

public class Actions {

    private static final String ACTUAL_IMAGE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\testScreenshots\\actual\\";
    private static final String EXPECTED_IMAGE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\testScreenshots\\expected\\";

    public static boolean elementToBeClickableAndDisplayed(WebDriver driver, By element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(element));
            return driver.findElement(element).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        } catch (StaleElementReferenceException t) {
            return driver.findElement(element).isDisplayed();
        }
    }

    public static boolean elementFromListIsDisplayed(WebDriver driver, List<WebElement> list, int index,
                                                     String dzoName) {
        try {
            return list.get(index).findElement(By.xpath(String.format("//*[contains(@id,'%s')]", dzoName))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean elementRegexMatch(WebDriver driver, By element, String reg) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(element));
            return driver.findElement(element).getText().matches(reg);
        } catch (TimeoutException e) {
            return false;
        } catch (StaleElementReferenceException exception) {
            return driver.findElement(element).isDisplayed();
        }
    }

    public static boolean schemaISDisplayed(WebDriver driver, By element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.javaScriptThrowsNoExceptions("return document.readyState"));
            return elementIsDisplayed(driver, element) && elementToBeClickableAndDisplayed(driver, element);
        } catch (TimeoutException e) {
            return false;
        } catch (StaleElementReferenceException exception) {
            return driver.findElement(element).isDisplayed();
        }
    }

    public static boolean elementIsDisplayed(WebDriver driver, By element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(element));
            return driver.findElement(element).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        } catch (StaleElementReferenceException exception) {
            return driver.findElement(element).isDisplayed();
        }
    }

    public static String getTextMessage(String element, String page) {
        return String.format("Элемент %s на странице %s не отображается", element, page);
    }

    public static ImageDiff imageDiffPlantUML(String image, WebDriver driver) throws IOException {
        Screenshot screenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File(ACTUAL_IMAGE_PATH + image));
        addAttachment("testScreenshots/actual", FileUtils.openInputStream(new File(ACTUAL_IMAGE_PATH + image)));
        return new ImageDiffer().withIgnoredColor(Color.WHITE)
                .withIgnoredColor(Color.getHSBColor(52, 149, 219)).makeDiff(screenshot.getImage(), expectedImage(image));
    }

    public static BufferedImage expectedImage(String image) throws IOException {
        addAttachment("expected", FileUtils.openInputStream(new File(EXPECTED_IMAGE_PATH + image)));
        return ImageIO.read(new File(EXPECTED_IMAGE_PATH + image));
    }

    public static void cleanActualDirectory() throws IOException {
        FileUtils.cleanDirectory(new File(ACTUAL_IMAGE_PATH));
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        new org.openqa.selenium.interactions.Actions(driver)
                .scrollToElement(element)
                .perform();
    }

    //Если в DOM несколько веб-элементов по 1 локатору, но нужно убедиться, что хотя бы один из них отображается
    public static boolean anyElementOnPageIsDisplayed(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class);
        try {
            wait.until(d -> {
                try {
                    List<WebElement> elements = d.findElements(By.xpath(locator));
                    return elements.stream().anyMatch(e -> e.isDisplayed() || isShownBySvgUse(d, e));
                } catch (StaleElementReferenceException | NoSuchElementException e) {
                    return false;
                }
            });
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    private static boolean isShownBySvgUse(WebDriver driver, WebElement element) {
        return Boolean.TRUE.equals(((JavascriptExecutor) driver).executeScript(
                "const defs = arguments[0].closest('defs'); if (!defs) return false;"
                        + "for (let p = arguments[0]; p && p !== defs; p = p.parentElement) {"
                        + "  if (!p.id) continue;"
                        + "  const use = [...document.querySelectorAll('use')].find(u => (u.getAttribute('href') || u.getAttribute('xlink:href')) === '#' + p.id);"
                        + "  if (use && use.getBoundingClientRect().width > 0) return true;"
                        + "}"
                        + "return false;", element));
    }

    public static boolean anyElementOnPageIsDisplayedAndScroll(WebDriver driver, String locator) {
        if(anyElementOnPageIsDisplayed(driver, locator)) {
            return true;
        }
        scrollButtom(driver);
        return anyElementOnPageIsDisplayed(driver, locator);
    }

    public static void scrollButtom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "const container = document.querySelector('.v-main__wrap');" +
                        "if (container) container.scrollTop = container.scrollHeight;"
        );
    }

    public static boolean checkConsoleForErrorsAndTableMessage(WebDriver driver) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        boolean error = true;
        boolean passed = true;

        for (LogEntry entry : logEntries) {
            Level level = entry.getLevel();
            if (level.getName().equals("ERROR")) {
                error = false;
            }
        }
        try {
            driver.findElement(By.xpath("//*[text()[contains(normalize-space(.),'Тружусь')]]"));
        } catch (NoSuchElementException e) {
            passed = false;
        }
        return passed && error;
    }

    public static boolean noElementsFound(WebDriver driver, By element) {
        Duration originalImplicitWait = driver.manage().timeouts().getImplicitWaitTimeout();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            List<WebElement> elements = driver.findElements(element);
            return elements.isEmpty();
        } finally {
            driver.manage().timeouts().implicitlyWait(originalImplicitWait);
        }
    }
}
