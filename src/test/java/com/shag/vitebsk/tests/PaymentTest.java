package com.shag.vitebsk.tests;

import com.shag.vitebsk.driver.TestCaseID;
import com.shag.vitebsk.pages.AuthPage;
import com.shag.vitebsk.pages.MainPage;
import com.shag.vitebsk.pages.PaymentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest extends BaseTest {
    AuthPage authPage;
    MainPage mainPage;
    PaymentPage paymentPage;

    @BeforeEach
    public void setup() {
        paymentPage = new PaymentPage();
        authPage = new AuthPage();
        authPage.openAuthPage();
        mainPage = authPage.fullAuth("", "", "");
    }
    @TestCaseID(id = "6")
    @DisplayName("История операций в системе")
    @Test
    public void paymentsTest () {
        mainPage = paymentPage.paymentHistory();

       String confirmatoryText = mainPage.getPaymentPage();
        Assertions.assertEquals("ПЛАТЕЖИ И ПЕРЕВОДЫ", confirmatoryText);

    }
    @TestCaseID(id = "10")
    @DisplayName("Возврат на страницу Платежи и переводы")
    @Test
    public void viewBalanceTest () {
        paymentPage.viewBalance();

        String confirmatoryText = mainPage.getPaymentPage();
        Assertions.assertEquals("ПЛАТЕЖИ И ПЕРЕВОДЫ", confirmatoryText);


    }
}
