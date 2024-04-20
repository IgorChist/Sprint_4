package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class MainPage {

    private WebDriver driver;
    // локатор кнопки Заказать вверху страницы
    private By orderButtonHeaderLocator= By.xpath("//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // локатор кнопки заказать внизу страницы
    private By orderButtonFooterLocator= By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    // локатор кнопки принятия куки
    private By confirmCookiesLocator= By.id("rcc-confirm-button");
    // локатор вопроса
    private final String questionLocator = "accordion__heading-%s";
    // локатор ответа
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";
    public MainPage(WebDriver driver) {
                this.driver = driver;
    }
    public void clickOrderButtonHeader() {
                driver.findElement(orderButtonHeaderLocator).click();
    }
    public void clickOrderButtonFooter() {
        driver.findElement(orderButtonFooterLocator).click();
        }

    public void confirmCookies() {
        driver.findElement(confirmCookiesLocator).click();
    }

    public void openQuestion(int index) {
        WebElement element = driver.findElement(By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = driver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }
}
