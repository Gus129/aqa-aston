import org.goose.Lesson_15.builders.PaySectionInfo;
import org.goose.Lesson_15.pages.HomePage;
import org.goose.Lesson_15.pages.OnlinePaymentsInfoPage;
import org.junit.jupiter.api.*;
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

    @DisplayName("Загрузка корректной домашней страницы")
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
        homePage.scrollToElement(homePage.onlinePaymentsLabel());
        homePage.verifyElementTextContent(homePage.onlinePaymentsLabel(), "Онлайн пополнение без комиссии");
    }

    @DisplayName("Наличие логотипов платёжных систем в блоке онлайн оплаты")
    @Test
    public void checkPaymentsLogosIsPresent() {
        homePage.open(HOME_PAGE_URL);
        homePage.assertPageLoaded(HOME_PAGE_URL);
        homePage.verifyTitle(HOME_PAGE_TITLE);
        homePage.declineCookies();
        homePage.waitElementIsVisible(homePage.visaLogo());
        homePage.scrollToElement(homePage.visaLogo());
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
        homePage.scrollToElement(homePage.moreDetailsAboutServiceLink());
        homePage.moreDetailsAboutServiceLink().click();
        onlinePaymentsInfoPage.assertPageLoaded(ONLINE_PAYMENTS_INFO_PAGE_URL);
        onlinePaymentsInfoPage.verifyTitle(ONLINE_PAYMENTS_INFO_PAGE_TITLE);
        onlinePaymentsInfoPage.verifyElementTextContent(onlinePaymentsInfoPage.breadCrumbsList(), "Порядок оплаты и безопасность интернет платежей");
    }

    @DisplayName("Кнопка 'Продолжить' при заполненной форме 'Услуги связи' где номер '297777777' открывает мини-форму со следующим шагом оплаты c корректными плейсхордерами и логотипами систем оплаты")
    @Test
    public void checkCommunicationServicesContinueClickIsCorrect() {
        homePage.open(HOME_PAGE_URL);
        homePage.assertPageLoaded(HOME_PAGE_URL);
        homePage.verifyTitle(HOME_PAGE_TITLE);
        homePage.declineCookies();
        homePage.waitElementIsVisible(homePage.phoneNumberConnectionInput());
        homePage.scrollToElement(homePage.phoneNumberConnectionInput());
        PaySectionInfo lesson15Info = PaySectionInfo.builder()
                .paymentType("Услуги связи")
                .numberField("297777777")
                .paymentSum("129")
                .email("email@gmail.com")
                .build();
        homePage.fillPaymentInfo(lesson15Info);
        homePage.continueButton().click();
        driver.switchTo().frame(homePage.bePaidFrame());
        assertAll(
                () -> homePage.verifyElementTextContent(homePage.sumLabelBePaid(), "129.00 BYN"),
                () -> homePage.verifyElementTextContent(homePage.paymentButtonBePaid(), "129.00 BYN"),
                () -> homePage.verifyElementTextContent(homePage.payDescriptionLabelBePaid(), "375297777777"),
                () -> homePage.verifyElementTextContent(homePage.cardNumberLabelBePaid(), "Номер карты"),
                () -> homePage.verifyElementTextContent(homePage.cardExpireDateLabelBePaid(), "Срок действия"),
                () -> homePage.verifyElementTextContent(homePage.cardCvcCodeLabelBePaid(), "CVC"),
                () -> homePage.verifyElementTextContent(homePage.cardHolderNameLabelBePaid(), "Имя держателя (как на карте)")
        );
        homePage.waitElementIsVisible(homePage.mirSmallLogoBePaid());
        assertAll(
                () -> homePage.assertElementIsDisplayed(homePage.visaSmallLogoBePaid()),
                () -> homePage.assertElementIsDisplayed(homePage.belkartSmallLogoBePaid()),
                () -> homePage.assertElementIsDisplayed(homePage.maestroSmallLogoBePaid()),
                () -> homePage.assertElementIsDisplayed(homePage.masterCardSmallLogoBePaid()),
                () -> homePage.assertElementIsDisplayed(homePage.mirSmallLogoBePaid()),
                () -> homePage.assertElementIsDisplayed(homePage.googlePayButton()),
                () -> homePage.assertElementIsDisplayed(homePage.yandexPayButton())
        );
    }

    @DisplayName("Проверка плейсхолдеров в каждом поле каждого варианта оплаты услуг")
    @Test
    public void checkOnlinePaymentsPlaceholdersTextIsCorrect() {
        homePage.open(HOME_PAGE_URL);
        homePage.assertPageLoaded(HOME_PAGE_URL);
        homePage.verifyTitle(HOME_PAGE_TITLE);
        homePage.declineCookies();
        homePage.waitElementIsVisible(homePage.phoneNumberConnectionInput());
        homePage.scrollToElement(homePage.onlinePaymentsLabel());
        homePage.paymentSelect("Услуги связи");
        assertAll(
                () -> homePage.assertElementIsDisplayed(homePage.phoneNumberConnectionInput()),
                () -> homePage.assertElementIsDisplayed(homePage.moneyConnectionInput()),
                () -> homePage.assertElementIsDisplayed(homePage.emailConnectionInput())
        );
        assertAll(
                () -> homePage.verifyElementPlaceholderTextContent(homePage.phoneNumberConnectionInput(), "Номер телефона"),
                () -> homePage.verifyElementPlaceholderTextContent(homePage.moneyConnectionInput(), "Сумма"),
                () -> homePage.verifyElementPlaceholderTextContent(homePage.emailConnectionInput(), "E-mail для отправки чека")
        );
        homePage.paymentSelect("Домашний интернет");
        homePage.waitElementIsVisible(homePage.phoneNumberInternetInput());
        assertAll(
                () -> homePage.assertElementIsDisplayed(homePage.phoneNumberInternetInput()),
                () -> homePage.assertElementIsDisplayed(homePage.moneyInternetInput()),
                () -> homePage.assertElementIsDisplayed(homePage.emailInternetInput())
        );
        assertAll(
                () -> homePage.verifyElementPlaceholderTextContent(homePage.phoneNumberInternetInput(), "Номер абонента"),
                () -> homePage.verifyElementPlaceholderTextContent(homePage.moneyInternetInput(), "Сумма"),
                () -> homePage.verifyElementPlaceholderTextContent(homePage.emailInternetInput(), "E-mail для отправки чека")
        );
        homePage.paymentSelect("Рассрочка");
        homePage.waitElementIsVisible(homePage.accountNumberInstalmentInput());
        assertAll(
                () -> homePage.assertElementIsDisplayed(homePage.accountNumberInstalmentInput()),
                () -> homePage.assertElementIsDisplayed(homePage.moneyInstalmentInput()),
                () -> homePage.assertElementIsDisplayed(homePage.emailInstalmentInput())
        );
        assertAll(
                () -> homePage.verifyElementPlaceholderTextContent(homePage.accountNumberInstalmentInput(), "Номер счета на 44"),
                () -> homePage.verifyElementPlaceholderTextContent(homePage.moneyInstalmentInput(), "Сумма"),
                () -> homePage.verifyElementPlaceholderTextContent(homePage.emailInstalmentInput(), "E-mail для отправки чека")
        );
        homePage.paymentSelect("Задолженность");
        homePage.waitElementIsVisible(homePage.accountNumberArrearsInput());
        assertAll(
                () -> homePage.assertElementIsDisplayed(homePage.accountNumberArrearsInput()),
                () -> homePage.assertElementIsDisplayed(homePage.moneyArrearsInput()),
                () -> homePage.assertElementIsDisplayed(homePage.emailArrearsInput())
        );
        assertAll(
                () -> homePage.verifyElementPlaceholderTextContent(homePage.accountNumberArrearsInput(), "Номер счета на 2073"),
                () -> homePage.verifyElementPlaceholderTextContent(homePage.moneyArrearsInput(), "Сумма"),
                () -> homePage.verifyElementPlaceholderTextContent(homePage.emailArrearsInput(), "E-mail для отправки чека")
        );
    }
}
