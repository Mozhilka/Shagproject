package com.shag.vitebsk.tests;

import com.shag.vitebsk.pages.AuthPage;
import com.shag.vitebsk.pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthorizationTest {
    WebDriver driver;
    AuthPage authPage;
    MainPage mainPage;

    By username = By.name("username");
    By password = By.name("password");
    By signInButton = By.id("login-button");

    @BeforeEach
    public  void start () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        authPage = new AuthPage(driver);
        mainPage = new MainPage(driver);
        driver.get("https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005");
    }

    @Test
    public  void validAuthTest () {
       mainPage = authPage.fullAuth("", "", "");

        String userName = mainPage.getUserName();
       Assertions.assertEquals("Hello World!", userName);

        driver.quit();
    }

    @Test
    public void invalidAuthTest () {
        mainPage = authPage.notFullAuth("", "1");

        String warningText = authPage.getErrorMessage();
        Assertions.assertEquals("Неверные данные пользователя (осталось 2 попытки)", warningText);
    }

    @Test
    public void emptyPassword () {
        authPage.insertLogin("");
        authPage.clickSignInButton();

        String warningText = authPage.getErrorMessage();
        Assertions.assertEquals("", warningText);
    }

    @Test
    public void paymentsTest () {
        mainPage = authPage.fullAuth("", "", "");
        mainPage = authPage.paymentHistory();

        String confirmatoryText = mainPage.getPaymentPage();
        Assertions.assertEquals("ПЛАТЕЖИ И ПЕРЕВОДЫ", confirmatoryText);

    }

    @AfterEach
    public void completed () {
        driver.quit();
    }

}
