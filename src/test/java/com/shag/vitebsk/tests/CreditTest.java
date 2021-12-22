package com.shag.vitebsk.tests;

import com.shag.vitebsk.driver.TestCaseID;
import com.shag.vitebsk.pages.AuthPage;
import com.shag.vitebsk.pages.CreditPage;
import com.shag.vitebsk.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditTest extends BaseTest {
    AuthPage authPage;
    MainPage mainPage;
    CreditPage creditPage;

    @BeforeEach
    public void setup() {
        creditPage = new CreditPage();
        authPage = new AuthPage();
        authPage.openAuthPage();
        mainPage = authPage.fullAuth("", "", "");
    }

    @TestCaseID(id = "9")
    @Test
    public void openCreditCardTest () {
        mainPage = creditPage.translationRequest();

        String confirmatoryText = mainPage.getTranslationRequestPage();
        Assertions.assertEquals("Не все поля заполнены корректно!", confirmatoryText);

    }

    @TestCaseID(id = "8")
    @Test
    public void translationRequestTest () {
        mainPage = creditPage.openCreditCard();

        String warningText = mainPage.getOpenCreditCardPage();
        Assertions.assertEquals("В данный момент подача заявки невозможна", warningText);

    }
}
