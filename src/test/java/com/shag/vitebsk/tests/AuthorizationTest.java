package com.shag.vitebsk.tests;

import com.shag.vitebsk.driver.Slf4j;
import com.shag.vitebsk.driver.TestCaseID;
import com.shag.vitebsk.pages.AuthPage;
import com.shag.vitebsk.pages.MainPage;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class AuthorizationTest extends BaseTest {
    AuthPage authPage;
    MainPage mainPage;

    @BeforeEach
    public  void start () {
        authPage = new AuthPage();
        authPage.openAuthPage();
    }

    @TestCaseID(id = "3")
    @DisplayName("Авторизация валидными данными")
    @Test
    public  void validAuthTest () {
        mainPage = authPage.fullAuth("", "", "");

        String userName = mainPage.getUserName();
        Assertions.assertEquals("Hello World!", userName);
    }

    @TestCaseID(id = "4")
    @DisplayName("Авторизация невалидными данными")
    @Test
    public void invalidAuthTest () {
        mainPage = authPage.notFullAuth("", "1");

        String warningText = authPage.getErrorMessage();
        Assertions.assertEquals("Неверные данные пользователя (осталось 2 попытки)", warningText);
    }

    @TestCaseID(id = "5")
    @DisplayName("Авторизация с пустыми полями")
    @Test
    public void emptyPassword () {
        authPage.insertLogin("");
        authPage.clickSignInButton();

        String warningText = authPage.getErrorMessage();
        Assertions.assertEquals("", warningText);
    }

    @TestCaseID(id = "12")
    @DisplayName("Выход из системы")
    @Test
    public void signOutTest () {
        mainPage = authPage.fullAuth("", "", "");
        authPage.signOut();

        String confirmatoryText = mainPage.getAuthPage();
        Assertions.assertEquals("Войти", confirmatoryText);
    }

    @AfterEach
    public void completed () {
    }

}