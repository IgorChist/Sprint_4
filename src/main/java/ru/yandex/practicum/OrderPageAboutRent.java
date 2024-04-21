package ru.yandex.practicum;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class OrderPageAboutRent {

    private WebDriver driver;

    // локатор поля ввода Когда привезти самокат
    private By deliveryDateLocator= By.xpath("//div/input[@placeholder='* Когда привезти самокат']");
    // локатор поля ввода Срок аренды
    private By rentalPeriodLocator= By.xpath("//div[text()='* Срок аренды']");
    // локатор срока аренды Сутки
    private By oneDayLocator= By.xpath("//div[text()='сутки']");
    // локатор кнопки Заказать
    private By orderButtonLocator= By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Локатор кнопки Да
    private By confirmOrderButtonLocator= By.xpath("//button[text()='Да']");
    // Локатор всплывающего окна Заказ оформлен
    private By orderIsProcessedLocator= By.xpath("//button[text()='Посмотреть статус']");

    public OrderPageAboutRent (WebDriver driver) {
        this.driver = driver;
    }
    public void enterDeliveryDate(String deliveryDate) {
        WebElement inputDate = driver.findElement(deliveryDateLocator);
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(inputDate));
        inputDate.sendKeys(deliveryDate, Keys.ENTER);
    }
    public void enterRentalPeriod() {
        driver.findElement(rentalPeriodLocator).click();
        driver.findElement(oneDayLocator).click();
    }
    public void enterRentInfo(String deliveryDate) {
        enterDeliveryDate(deliveryDate);
        enterRentalPeriod();
    }
    public void clickOrderButton() {
        driver.findElement(orderButtonLocator).click();
    }
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButtonLocator).click();
    }

    public void checkOrderIsProcessed() {
        WebElement checkStatus = driver.findElement(orderIsProcessedLocator);
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(checkStatus));
    }
}
