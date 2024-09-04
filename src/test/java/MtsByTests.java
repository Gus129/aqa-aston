import org.goose.Lesson_15.pages.HomePage;
import org.goose.Lesson_15.pages.OnlinePaymentsInfoPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import static org.goose.Lesson_15.common.Config.IMPLICIT_WAIT;
import static org.goose.Lesson_15.pages.HomePage.*;
import static org.goose.Lesson_15.pages.OnlinePaymentsInfoPage.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MtsByTests {

    private WebDriver driver;
    private HomePage homePage;
    private OnlinePaymentsInfoPage onlinePaymentsInfoPage;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        onlinePaymentsInfoPage = new OnlinePaymentsInfoPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @DisplayName("Загрузка домашней страницы")
    @Test
    public void checkHomePageAppearCorrect() {
        homePage.open(HOME_PAGE_URL);
        homePage.assertPageLoaded(HOME_PAGE_URL);
        homePage.verifyTitle(HOME_PAGE_TITLE);
    }

    @DisplayName("Блок оплаты имеет label с текстом 'Онлайн пополнение без комиссии'")
    @Test
    public void checkOnlinePaymentsLabelText() {
        homePage.open(HOME_PAGE_URL);
        homePage.assertPageLoaded(HOME_PAGE_URL);
        homePage.verifyTitle(HOME_PAGE_TITLE);
        homePage.declineCookies();
        homePage.waitElementIsVisible(homePage.onlinePaymentsLabel());
        homePage.verifyElementTextContent(homePage.onlinePaymentsLabel(), "Онлайн пополнение без комиссии");
    }

    @DisplayName("Наличие логотипов платёжных систем")
    @Test
    public void checkPaymentsLogosIsPresent() {
        homePage.open(HOME_PAGE_URL);
        homePage.assertPageLoaded(HOME_PAGE_URL);
        homePage.verifyTitle(HOME_PAGE_TITLE);
        homePage.declineCookies();
        homePage.waitElementIsVisible(homePage.visaLogo());
        assertAll(
                () -> homePage.assertElementIsDisplayed(homePage.visaLogo()),
                () -> homePage.assertElementIsDisplayed(homePage.verifiedByVisaLogo()),
                () -> homePage.assertElementIsDisplayed(homePage.masterCardLogo()),
                () -> homePage.assertElementIsDisplayed(homePage.masterCardSecureCodeLogo()),
                () -> homePage.assertElementIsDisplayed(homePage.belcartLogo())
        );
    }

    @DisplayName("Cсылка «Подробнее о сервисе» открывает ожидаемую страницу")
    @Test
    public void checkMoreDetailsAboutServiceLinkIsCorrect() {
        homePage.open(HOME_PAGE_URL);
        homePage.assertPageLoaded(HOME_PAGE_URL);
        homePage.verifyTitle(HOME_PAGE_TITLE);
        homePage.declineCookies();
        homePage.waitElementIsVisible(homePage.moreDetailsAboutServiceLink());
        homePage.moreDetailsAboutServiceLink().click();
        onlinePaymentsInfoPage.assertPageLoaded(ONLINE_PAYMENTS_INFO_PAGE_URL);
        onlinePaymentsInfoPage.verifyTitle(ONLINE_PAYMENTS_INFO_PAGE_TITLE);
        onlinePaymentsInfoPage.verifyElementTextContent(onlinePaymentsInfoPage.breadCrumbsList(), "Порядок оплаты и безопасность интернет платежей");
    }

    @DisplayName("Кнопка 'Продолжить' при заполненной форме 'Услуги связи' где номер '297777777' открывает мини-форму со следующим шагом оплаты")
    @Test
    public void checkCommunicationServicesContinueClickIsCorrect() {
        homePage.open(HOME_PAGE_URL);
        homePage.assertPageLoaded(HOME_PAGE_URL);
        homePage.verifyTitle(HOME_PAGE_TITLE);
        homePage.declineCookies();
        homePage.waitElementIsVisible(homePage.phoneNumberInput());
        homePage.phoneNumberInput().click();
        homePage.phoneNumberInput().sendKeys("297777777");
        homePage.moneyInput().click();
        homePage.moneyInput().sendKeys("129");
        homePage.continueButton().click();
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));
        homePage.verifyElementTextContent(homePage.paymentButton(), " Оплатить  129.00 BYN ");
    }
}
