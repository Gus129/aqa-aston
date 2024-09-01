package org.goose.Lesson_15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String homePageUrl = "https://www.mts.by/";
    public static final String homePageTitle = "МТС – мобильный оператор в Беларуси";

    public WebElement homePageLogo() {
        return driver.findElement(By.xpath("//a[contains(@class, 'page-header__logo')]"));
    }

    public WebElement onlinePaymentsLabel() {
        return driver.findElement(By.xpath("//*[@id='pay-section']//h2[contains(text(), 'Онлайн пополнение')]"));
    }

    public WebElement phoneNumberInput() {
        return driver.findElement(By.id("connection-phone"));
    }

    public WebElement moneyInput() {
        return driver.findElement(By.id("connection-sum"));
    }

    public WebElement continueButton() {
        return driver.findElement(By.xpath("//button[text()='Продолжить']"));
    }

    public WebElement paymentButton() {
        return driver.findElement(By.xpath("//button[@class='colored disabled']"));
    }

    public WebElement moreDetailsAboutServiceLink() {
        return driver.findElement(By.linkText("Подробнее о сервисе"));
    }

    public WebElement visaLogo() {
        return driver.findElement(By.xpath("//*[@id='pay-section']//img[@alt='Visa']"));
    }

    public WebElement verifiedByVisaLogo() {
        return driver.findElement(By.xpath("//*[@id='pay-section']//img[@alt='Verified By Visa']"));
    }

    public WebElement masterCardLogo() {
        return driver.findElement(By.xpath("//*[@id='pay-section']//img[@alt='MasterCard']"));
    }

    public WebElement masterCardSecureCodeLogo() {
        return driver.findElement(By.xpath("//*[@id='pay-section']//img[@alt='MasterCard Secure Code']"));
    }

    public WebElement belcartLogo() {
        return driver.findElement(By.xpath("//*[@id='pay-section']//img[@alt='Белкарт']"));
    }

    public WebElement cookiesDeclineButton() {
        return driver.findElement(By.xpath("//button[@class='btn btn_gray cookie__cancel']"));
    }

    public void declineCookies() {
        if (cookiesDeclineButton().isDisplayed()) {
            cookiesDeclineButton().click();
        }
    }
}