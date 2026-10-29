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
    private static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.ignoring(StaleElementReferenceException.class);
        try {
            return wait.until(d -> d.findElements(element).stream().anyMatch(e -> isVisible(d, e)));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean isVisible(WebDriver driver, WebElement e) {
        if (e.isDisplayed()) {
            return true;
        }
        return Boolean.TRUE.equals(((JavascriptExecutor) driver).executeScript(
                "const e=arguments[0]; const defs=e.closest('defs'); if(!defs) return false;"
                + "const uses=[...document.querySelectorAll('use')];"
                + "for(let p=e; p && p!==defs; p=p.parentElement){ if(!p.id) continue;"
                + "  const u=uses.find(u=>(u.getAttribute('href')||u.getAttribute('xlink:href'))==='#'+p.id);"
                + "  if(u){ const b=u.getBoundingClientRect(); if(b.width>0&&b.height>0) return true; } }"
                + "return false;", e));
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
                    return elements.stream().anyMatch(e -> isVisible(d, e));
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

    public static void selectOption(WebDriver driver, String optionLocator) {
        selectOption(driver, By.xpath(optionLocator));
    }

    public static void selectOption(WebDriver driver, By option) {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        try {
            selectOptionImpl(driver, option);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
        }
    }

    private static void selectOptionImpl(WebDriver driver, By option) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.ignoring(StaleElementReferenceException.class);
        By combo = By.xpath("//div[contains(@class,'v-select')]//div[contains(@class,'v-field')][@role='combobox']");
        wait.until(d -> !d.findElements(option).isEmpty() || !d.findElements(combo).isEmpty());

        for (WebElement e : driver.findElements(option)) {
            if (!e.isDisplayed()) {
                continue;
            }
            Object where = js.executeScript(
                    "const e=arguments[0];"
                    + "if (e.closest('.v-select__selection, .v-field__input')) return 'selected';"
                    + "if (e.closest('.v-select, .v-overlay__content')) return 'list';"
                    + "return 'button';", e);
            if ("selected".equals(where)) {
                return;
            }
            if ("button".equals(where)) {
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", e);
                e.click();
                return;
            }
        }

        for (int attempt = 0; attempt < 2; attempt++) {
            int count = driver.findElements(combo).size();
            for (int i = 0; i < count; i++) {
                List<WebElement> now = driver.findElements(combo);
                if (i >= now.size()) {
                    break;
                }
                WebElement field = now.get(i);
                if (!field.isDisplayed() || Boolean.TRUE.equals(js.executeScript(
                        "return !!arguments[0].closest('.v-data-table-footer');", field))) {
                    continue;
                }
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", field);
                threadSleep(300);
                field.click();
                WebElement item;
                try {
                    item = new WebDriverWait(driver, Duration.ofSeconds(5))
                            .ignoring(StaleElementReferenceException.class)
                            .until(d -> d.findElements(option).stream()
                                    .filter(e -> e.isDisplayed() && Boolean.TRUE.equals(js.executeScript(
                                            "return !!arguments[0].closest('.v-overlay__content');", e)))
                                    .findFirst().orElse(null));
                } catch (TimeoutException notInThisList) {
                    if (Boolean.TRUE.equals(js.executeScript("return !!document.querySelector('.v-overlay--active .v-list');"))) {
                        field.click();
                        threadSleep(300);
                    }
                    continue;
                }
                item.click();
                threadSleep(500);
                try {
                    js.executeScript("arguments[0].scrollIntoView({block:'start'});", field);
                } catch (StaleElementReferenceException ignored) {
                }
                return;
            }
            threadSleep(1500);
        }
        throw new NoSuchElementException("Не найден пункт выпадающего списка: " + option);
    }

    private static void threadSleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
