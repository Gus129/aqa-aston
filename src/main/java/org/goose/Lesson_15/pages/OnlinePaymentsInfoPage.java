package org.goose.Lesson_15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlinePaymentsInfoPage extends BasePage {

    public OnlinePaymentsInfoPage(WebDriver driver) {
        super(driver);
    }

    public static final String ONLINE_PAYMENTS_INFO_PAGE_URL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    public static final String ONLINE_PAYMENTS_INFO_PAGE_TITLE = "Порядок оплаты и безопасность интернет платежей";

    public WebElement breadCrumbsList() {
        return driver.findElement(By.xpath("//*[@id='breadcrumbs']"));
    }
}