package com.shag.vitebsk.tests;

import com.shag.vitebsk.driver.TestCaseID;
import com.shag.vitebsk.pages.AuthPage;
import com.shag.vitebsk.pages.CheckPage;
import com.shag.vitebsk.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckTest {
    AuthPage authPage;
    MainPage mainPage;
    CheckPage checkPage;

    @BeforeEach
    public void setup() {
        checkPage = new CheckPage();
        authPage = new AuthPage();
        authPage.openAuthPage();
        mainPage = authPage.fullAuth("", "", "");
    }

    @TestCaseID(id = "11")
    @Test
    public void openNewChekTest () {
        mainPage = checkPage.openNewCheck();

        String confirmatoryText = mainPage.getOpenCheckPage();
        Assertions.assertEquals("Счета", confirmatoryText);

    }
}
