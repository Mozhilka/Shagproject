package com.shag.vitebsk.tests;

import com.shag.vitebsk.driver.TestCaseID;
import com.shag.vitebsk.pages.AuthPage;
import com.shag.vitebsk.pages.DepositPage;
import com.shag.vitebsk.pages.MainPage;
import com.shag.vitebsk.pages.PaymentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DepositTest extends BaseTest {

    AuthPage authPage;
    MainPage mainPage;
    DepositPage depositPage;

    @BeforeEach
    public void setup() {
        depositPage = new DepositPage();
        authPage = new AuthPage();
        authPage.openAuthPage();
        mainPage = authPage.fullAuth("", "", "");
    }

    @TestCaseID(id = "7")
    @Test
    public void openDepositTest () {
         depositPage.viewCards();

        String confirmatoryText = mainPage.getOverviewCardsPage();
        Assertions.assertEquals("Вам одобрен кредитный лимит. Получить.", confirmatoryText);


    }
}
