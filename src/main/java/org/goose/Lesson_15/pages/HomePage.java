package org.goose.Lesson_15.pages;

import org.goose.Lesson_15.builders.PaySectionInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String HOME_PAGE_URL = "https://www.mts.by/";
    public static final String HOME_PAGE_TITLE = "МТС – мобильный оператор в Беларуси";

    public WebElement onlinePaymentsLabel() {
        return driver.findElement(By.xpath("//*[@id='pay-section']//h2[contains(text(), 'Онлайн пополнение')]"));
    }

    public WebElement phoneNumberConnectionInput() {
        return driver.findElement(By.id("connection-phone"));
    }

    public WebElement moneyConnectionInput() {
        return driver.findElement(By.id("connection-sum"));
    }

    public WebElement emailConnectionInput() {
        return driver.findElement(By.id("connection-email"));
    }

    public WebElement phoneNumberInternetInput() {
        return driver.findElement(By.id("internet-phone"));
    }

    public WebElement moneyInternetInput() {
        return driver.findElement(By.id("internet-sum"));
    }

    public WebElement emailInternetInput() {
        return driver.findElement(By.id("internet-email"));
    }

    public WebElement accountNumberInstalmentInput() {
        return driver.findElement(By.id("score-instalment"));
    }

    public WebElement moneyInstalmentInput() {
        return driver.findElement(By.id("instalment-sum"));
    }

    public WebElement emailInstalmentInput() {
        return driver.findElement(By.id("instalment-email"));
    }

    public WebElement accountNumberArrearsInput() {
        return driver.findElement(By.id("score-arrears"));
    }

    public WebElement moneyArrearsInput() {
        return driver.findElement(By.id("arrears-sum"));
    }

    public WebElement emailArrearsInput() {
        return driver.findElement(By.id("arrears-email"));
    }

    public WebElement continueButton() {
        return driver.findElement(By.xpath("//button[text()='Продолжить']"));
    }

    public WebElement bePaidFrame() {
        return driver.findElement(By.className("bepaid-iframe"));
    }

    public WebElement sumLabelBePaid() {
        return driver.findElement(By.className("pay-description__cost"));
    }

    public WebElement payDescriptionLabelBePaid() {
        return driver.findElement(By.className("pay-description__text"));
    }

    public WebElement cardNumberLabelBePaid() {
        return driver.findElement(By.xpath("//*[@autocomplete='cc-number']/following::label[1]"));
    }

    public WebElement cardExpireDateLabelBePaid() {
        return driver.findElement(By.xpath("//*[@autocomplete='cc-exp']/following::label[1]"));
    }

    public WebElement cardCvcCodeLabelBePaid() {
        return driver.findElement(By.xpath("//*[@autocomplete='cc-csc']/following::label[1]"));
    }

    public WebElement cardHolderNameLabelBePaid() {
        return driver.findElement(By.xpath("//*[@autocomplete='cc-name']/following::label[1]"));
    }

    public WebElement visaSmallLogoBePaid() {
        return driver.findElement(By.xpath("//img[contains(@src,'visa-system')]"));
    }

    public WebElement belkartSmallLogoBePaid() {
        return driver.findElement(By.xpath("//img[contains(@src,'belkart-system')]"));
    }

    public WebElement masterCardSmallLogoBePaid() {
        return driver.findElement(By.xpath("//img[contains(@src,'mastercard-system')]"));
    }

    public WebElement maestroSmallLogoBePaid() {
        return driver.findElement(By.xpath("//img[contains(@src,'maestro-system')]"));
    }

    public WebElement mirSmallLogoBePaid() {
        return driver.findElement(By.xpath("//img[contains(@src,'mir-system-ru')]"));
    }

    public WebElement paymentButtonBePaid() {
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

    public WebElement googlePayButton() {
        return driver.findElement(By.id("google-pay-button"));
    }

    public WebElement yandexPayButton() {
        return driver.findElement(By.id("yandex-button"));
    }

    public void paymentSelect(String selectText) {
        WebElement selectButton = driver.findElement(By.className("select__header"));
        WebElement selectList = driver.findElement(By.className("select__list"));
        selectButton.click();
        List<WebElement> options = selectList.findElements(By.tagName("p"));
        for (WebElement option : options) {
            if (selectText.equals(option.getAttribute("textContent"))) {
                waitElementIsClickable(option);
                option.click();
                break;
            }
        }
    }

    public void fillPaymentInfo(PaySectionInfo builder) {
        String paymentType = builder.getPaymentType();
        paymentSelect(paymentType);
        switch (paymentType) {
            case "Услуги связи":
                phoneNumberConnectionInput().sendKeys(builder.getNumberField());
                moneyConnectionInput().sendKeys(builder.getPaymentSum());
                emailConnectionInput().sendKeys(builder.getEmail());
                break;
            case "Домашний интернет":
                phoneNumberInternetInput().sendKeys(builder.getNumberField());
                moneyInternetInput().sendKeys(builder.getPaymentSum());
                emailInternetInput().sendKeys(builder.getEmail());
                break;
            case "Рассрочка":
                accountNumberInstalmentInput().sendKeys(builder.getNumberField());
                moneyInstalmentInput().sendKeys(builder.getPaymentSum());
                emailInstalmentInput().sendKeys(builder.getEmail());
                break;
            case "Задолженность":
                accountNumberArrearsInput().sendKeys(builder.getNumberField());
                moneyArrearsInput().sendKeys(builder.getPaymentSum());
                emailArrearsInput().sendKeys(builder.getEmail());
                break;
            default:
                System.out.println("Несуществующий тип оплаты");
        }
    }

    public void declineCookies() {
        if (cookiesDeclineButton().isDisplayed()) {
            cookiesDeclineButton().click();
        }
    }
}