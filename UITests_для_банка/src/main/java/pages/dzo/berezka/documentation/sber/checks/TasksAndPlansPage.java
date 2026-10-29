package pages.dzo.berezka.documentation.sber.checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Actions.elementIsDisplayed;

public class TasksAndPlansPage {

    private WebDriver driver;

    public TasksAndPlansPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ELEMENT_ON_PAGE_TEXT = By.xpath("//*[text()[contains(normalize-space(.),'Задачи и планы есть!')]]");

    public boolean elementOnPageIsDisplayed() {
        return elementIsDisplayed(driver, ELEMENT_ON_PAGE_TEXT);
    }
}

