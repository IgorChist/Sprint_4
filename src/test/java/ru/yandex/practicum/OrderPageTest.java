package ru.yandex.practicum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class OrderPageTest {
    public static final String BROWSER = "chrome";
    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(BROWSER);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void createOrderHeaderButton() { //оформление заказа через кнопку заказать вверху страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonHeader();

        OrderPageProfile orderPageProfile = new OrderPageProfile(driver);
        orderPageProfile.enterFullProfile("Олег", "Олегов", "Усачева, 3", "Коломенская", "899999999999");
        orderPageProfile.clickOnwardsButton();
        OrderPageAboutRent orderPageAboutRent = new OrderPageAboutRent(driver);
        orderPageAboutRent.enterRentInfo("20.05.2024");
        orderPageAboutRent.clickOrderButton();
        orderPageAboutRent.clickConfirmOrderButton();
        orderPageAboutRent.checkOrderIsProcessed();
    }

    @Test
    public void createOrderFooterButton() { //оформление заказа через кнопку заказать внизу страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.confirmCookies();
        mainPage.clickOrderButtonFooter();

        OrderPageProfile orderPageProfile = new OrderPageProfile(driver);
        orderPageProfile.enterFullProfile("Иван", "Иванов", "Пехотинцев, 10", "Автозаводская", "899999999777");
        orderPageProfile.clickOnwardsButton();
        OrderPageAboutRent orderPageAboutRent = new OrderPageAboutRent(driver);
        orderPageAboutRent.enterRentInfo("15.09.2024");
        orderPageAboutRent.clickOrderButton();
        orderPageAboutRent.clickConfirmOrderButton();
        orderPageAboutRent.checkOrderIsProcessed();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}