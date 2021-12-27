package com.shag.vitebsk.tests;

import com.shag.vitebsk.driver.TestCaseID;
import com.shag.vitebsk.pages.AuthPage;
import com.shag.vitebsk.pages.CheckPage;
import com.shag.vitebsk.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckTest {
    AuthPage authPage;
    MainPage mainPage;
    CheckPage checkPage;

    private static final Logger logger = LoggerFactory.getLogger(CheckTest.class);

    @BeforeEach
    public void setup() {
        checkPage = new CheckPage();
        authPage = new AuthPage();
        authPage.openAuthPage();
        mainPage = authPage.fullAuth("", "", "");
    }

    @TestCaseID(id = "11")
    @DisplayName("Открытие нового счета")
    @Test
    public void openNewChekTest () {
        logger.info("!!!CheckTest");
        mainPage = checkPage.openNewCheck();

        String confirmatoryText = mainPage.getOpenCheckPage();
        Assertions.assertEquals("Счета", confirmatoryText);

    }
}
