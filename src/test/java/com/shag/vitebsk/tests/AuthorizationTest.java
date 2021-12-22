package com.shag.vitebsk.tests;

import com.shag.vitebsk.driver.TestCaseID;
import com.shag.vitebsk.pages.AuthPage;
import com.shag.vitebsk.pages.MainPage;
import org.junit.jupiter.api.*;

public class AuthorizationTest extends BaseTest {
    AuthPage authPage;
    MainPage mainPage;

    @BeforeEach
    public  void start () {
        authPage = new AuthPage();
        authPage.openAuthPage();
    }

    @TestCaseID(id = "3")
    @Test
    public  void validAuthTest () {
        mainPage = authPage.fullAuth("", "", "");

        String userName = mainPage.getUserName();
        Assertions.assertEquals("Hello World!", userName);
    }

    @TestCaseID(id = "4")
    @Test
    public void invalidAuthTest () {
        mainPage = authPage.notFullAuth("", "1");

        String warningText = authPage.getErrorMessage();
        Assertions.assertEquals("Неверные данные пользователя (осталось 2 попытки)", warningText);
    }

    @TestCaseID(id = "5")
    @Test
    public void emptyPassword () {
        authPage.insertLogin("");
        authPage.clickSignInButton();

        String warningText = authPage.getErrorMessage();
        Assertions.assertEquals("", warningText);
    }

    @TestCaseID(id = "12")
    @Test
    public void signOutTest () {
        authPage.signOut();

        String confirmatoryText = mainPage.getAuthPage();
        Assertions.assertEquals("Войти", confirmatoryText);
    }

    @AfterEach
    public void completed () {
    }

}