package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageProfile {

    private WebDriver driver;

    // локатор поля ввода Имя
    private By inputNameLocator= By.xpath("//div/input[@placeholder='* Имя']");
    // локатор поля ввода Фамилия
    private By inputSurnameLocator= By.xpath("//div/input[@placeholder='* Фамилия']");
    // локатор поля ввода Адрес: куда привезти самокат
    private By inputAddressLocator= By.xpath("//div/input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор поля ввода Станция метро
    private By inputSubwayStationLocator= By.xpath("//div/input[@placeholder='* Станция метро']");
    // локатор поля ввода Телефон
    private By inputPhoneNumberLocator= By.xpath("//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    // локатор кнопки Далее
    private By onwardsButtonLocator= By.xpath("//button[text()='Далее']");
    // локатор танции метро из списка
    private final String subwayStationLocator = "//div[text()='%s']";

    public OrderPageProfile(WebDriver driver) {
        this.driver = driver;
    }
    public void enterName(String name) {
        driver.findElement(inputNameLocator).sendKeys(name);
    }
    public void enterSurname(String surname) {
        driver.findElement(inputSurnameLocator).sendKeys(surname);
    }
    public void enterAddress(String address) {
        driver.findElement(inputAddressLocator).sendKeys(address);
    }
    public void enterSubwayStation(String subwayTitle) {
        driver.findElement(inputSubwayStationLocator).click();
        WebElement stationMenu = driver.findElement(By.xpath(String.format(subwayStationLocator, subwayTitle)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", stationMenu);
        stationMenu.click();
    }
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumberLocator).sendKeys(phoneNumber);
    }
    public void clickOnwardsButton() {
        driver.findElement(onwardsButtonLocator).click();
    }

    public void enterFullProfile(String name, String surName, String address, String subwayTitle, String phoneNumber) {
        enterName(name);
        enterSurname(surName);
        enterAddress(address);
        enterSubwayStation(subwayTitle);
        enterPhoneNumber(phoneNumber);
    }
}
