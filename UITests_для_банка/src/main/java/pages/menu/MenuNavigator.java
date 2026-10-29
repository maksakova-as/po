package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MenuNavigator {

    private static final By BURGER = By.cssSelector("button.v-app-bar-nav-icon");
    private static final By MENU_FILTER = By.cssSelector(".dh-nav__filter input");
    private static final By TOGGLE = By.cssSelector("span.dh-nav__toggle");
    private static final By TITLE = By.cssSelector(".dh-nav__title");

    private final WebDriver driver;

    public MenuNavigator(WebDriver driver) {
        this.driver = driver;
    }

    public static By item(String name) {
        return By.xpath("//*[contains(concat(' ', normalize-space(@class), ' '), ' dh-nav__item ')]"
                + "[.//*[contains(@class,'dh-nav__title')][normalize-space(.)=" + xpathLiteral(name) + "]]");
    }

    public void ensureMenuOpen() {
        List<WebElement> filter = driver.findElements(MENU_FILTER);
        if (filter.isEmpty() || !filter.get(0).isDisplayed()) {
            wait(15).until(d -> {
                List<WebElement> b = d.findElements(BURGER);
                return !b.isEmpty() && b.get(0).isDisplayed();
            });
            driver.findElement(BURGER).click();
            wait(10).until(d -> {
                List<WebElement> f = d.findElements(MENU_FILTER);
                return !f.isEmpty() && f.get(0).isDisplayed();
            });
        }
    }

    public WebElement findItem(String name) {
        ensureMenuOpen();
        return wait(15).until(d -> {
            List<WebElement> visible = d.findElements(item(name)).stream()
                    .filter(WebElement::isDisplayed)
                    .collect(Collectors.toList());
            return visible.isEmpty() ? null : visible.get(0);
        });
    }

    private boolean isPresent(String name) {
        ensureMenuOpen();
        return driver.findElements(item(name)).stream().anyMatch(WebElement::isDisplayed);
    }

    public void expand(String name) {
        WebElement element = findItem(name);
        if (!"true".equals(element.getAttribute("aria-expanded"))) {
            element.findElement(TOGGLE).click();
            wait(10).until(d -> "true".equals(findItem(name).getAttribute("aria-expanded")));
        }
    }

    public void expandPath(String path) {
        for (String part : path.split("/")) {
            if (!part.isBlank()) {
                expand(part.trim());
            }
        }
    }

    public void open(String name) {
        findItem(name).findElement(TITLE).click();
    }

    public void openAny(String... names) {
        ensureMenuOpen();
        for (String name : names) {
            if (isPresent(name)) {
                open(name);
                return;
            }
        }
        open(names[0]);
    }

    public void typeInFilter(String text) {
        ensureMenuOpen();
        WebElement input = driver.findElement(MENU_FILTER);
        input.click();
        input.sendKeys(text);
    }

    private WebDriverWait wait(int seconds) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        w.ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        return w;
    }

    private static String xpathLiteral(String s) {
        if (!s.contains("'")) {
            return "'" + s + "'";
        }
        if (!s.contains("\"")) {
            return "\"" + s + "\"";
        }
        return "concat('" + s.replace("'", "', \"'\", '") + "')";
    }
}
