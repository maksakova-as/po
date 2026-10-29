package pages.tables;

import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

public class EditTablePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EditTablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By TABLE_CELL_1 = By.xpath("(//textarea[@class='text-area focus-element'])[1]");
    private final By TABLE_CELL_2 = By.xpath("(//textarea[@class='text-area focus-element'])[2]");
    private final By TABLE_CONTAINER_1 = By.xpath("(//div[@class='content-container'])[1]");
    private final By TABLE_CONTAINER_2 = By.xpath("(//div[@class='content-container'])[2]");
    private final By TABLE_CONTAINER_3 = By.xpath("(//div[@class='content-container'])[3]");

    public boolean enterTextCell_2_1(String text1, String text2, String text3) {
        clearContentCell(TABLE_CELL_1);
        clearContentCell(TABLE_CELL_2);
        driver.findElement(TABLE_CELL_1).sendKeys(text1);
        driver.findElement(TABLE_CELL_2).sendKeys(text2);
        return wait.until(ExpectedConditions.textToBe(TABLE_CONTAINER_1, text3));
    }

    public void clearContentCell(By locator){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
    }

    public String getTextContainer_2_1() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(TABLE_CONTAINER_1));
        return element.getText();
    }

    public String getTextContainer_2_2() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(TABLE_CONTAINER_2));
        return element.getText();
    }

    public String getTextContainer_2_3() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(TABLE_CONTAINER_3));
        return element.getText();
    }

    public static Stream<Arguments> calculationTestData() {
        return Stream.of(
                Arguments.of("6","5", "33"),
                Arguments.of("10","20", "90"),
                Arguments.of("0","1", "3"),
                Arguments.of("-1","1", "0"),
                Arguments.of("10000","1", "30003"),
                Arguments.of("-10000","1", "-29997"),
                Arguments.of("abc","1", "Ошибка")
        );
    }
}