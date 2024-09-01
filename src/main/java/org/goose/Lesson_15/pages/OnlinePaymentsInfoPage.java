package org.goose.Lesson_15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlinePaymentsInfoPage extends BasePage {

    public OnlinePaymentsInfoPage(WebDriver driver) {
        super(driver);
    }

    public static final String onlinePaymentsInfoPageUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    public static final String onlinePaymentsInfoPageTitle = "Порядок оплаты и безопасность интернет платежей";

    public WebElement breadcrumbsList() {
        return driver.findElement(By.xpath("//*[@id='breadcrumbs']"));
    }
}