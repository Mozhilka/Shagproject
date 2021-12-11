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
import org.testng.Assert;

import java.time.Duration;


public class YandexTest {
    WebDriver driver;


    @Test
    public void authTest1() {

//        driver.get("https://yandex.by");
//        WebElement mailButton = driver.findElement(By.xpath("//*[@class='desk-notif-card__login-new-item-title' and text()='Почта']"));
//        mailButton.click();

        driver.get("https://passport.yandex.by");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@type='text']"));
        emailInputField.sendKeys("mozhilka@tut.by");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='passp:sign-in']")));
        WebElement singInButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        singInButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='passp-field-passwd']")));
        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id='passp-field-passwd']"));
        passwordInputField.sendKeys("jkmrf5151216");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='passp:sign-in']")));
        WebElement enterPasswordButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        enterPasswordButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='user-pic__image']")));
        WebElement mailPage = driver.findElement(By.xpath("//img[@class='user-pic__image']"));
        mailPage.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='menu__text']")));
        WebElement menuText = driver.findElement(By.xpath("//span[@class='menu__text']"));
        menuText.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='mail-Layout-Inner']")));

        WebElement departmentResult = driver.findElement(By.xpath("//*[@class='mail-Layout-Inner']"));
        Assert.assertTrue(departmentResult.getText().contains("Входящие"));


    }
    @AfterEach
    public void completed () {
        driver.quit();
    }

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

}
