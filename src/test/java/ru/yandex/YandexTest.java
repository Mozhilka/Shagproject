package ru.yandex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.netty.handler.codec.socksx.v5.Socks5AuthMethod.PASSWORD;

public class YandexTest {
    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void authTest1() {

        driver.get("https://yandex.ru/");
        WebElement mailButton = driver.findElement(By.xpath("//*[@class='desk-notif-card__login-new-item-title' and text()='Почта']"));
        mailButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='Textinput-Control'])[20]")));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@class='Textinput-Control']"));
        emailInputField.sendKeys("mozhilka@tut.by");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='passp:sign-in']")));
        WebElement singInButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        singInButton.click();


    }
    @AfterEach
    public void completed () {
        driver.quit();
    }

}
