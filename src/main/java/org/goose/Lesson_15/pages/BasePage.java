package org.goose.Lesson_15.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.goose.Lesson_15.common.Config.EXPLICIT_WAIT;

public abstract class BasePage {
    public final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitElementIsVisible(WebElement element) {
        Wait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void assertPageLoaded(String url) {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("return document.readyState")
                .toString().equals("complete");
        String s = driver.getCurrentUrl();
        if (s.equals(url)) {
            System.out.println("Страница прогрузилась");
            System.out.println("Активный Url: " + s);
        } else {
            fail("Страница не прогрузилась");
        }
    }

    public void open(String url) {
        driver.navigate().to(url);
    }

    public void verifyTitle(String pageTitle) {
        assertEquals(pageTitle, driver.getTitle(), "Title cтраницы не соответствует ожидаемому");
    }

    public void verifyElementTextContent(WebElement labelElement, String containedText) {
        String actualElementTextContent = labelElement.getAttribute("textContent");
        assertTrue(actualElementTextContent.contains(containedText), "Ожидаемый текст '" + containedText + "' не найден");
    }

    public void assertElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed(), "Элемент не найден");
    }
}