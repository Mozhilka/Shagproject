package com.shag.vitebsk.pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final By AUTH_PAGE = By.id("login-button");
    private static final By USER_NAME_LOCATOR = By.id("user-greeting");
    private static final By PAYMENT_PAGE = By.id("payments-form");
    private static final By OPEN_CHECK_PAGE = By.xpath("//*[@class='page-header']");
    private static final By OPEN_CREDIT_CARD_PAGE = By.xpath("//*[@class='alert alert-info']");
    private static final By TRANSLATION_REQUEST_PAGE = By.xpath("//*[@class='alert alert-error hidden']");
    private static final By OVERVIEW_CARDS_PAGE = By.xpath("//*[@class='alert alert-info']");


    public String getUserName() {
        return getElementText(USER_NAME_LOCATOR);
    }

    public String getPaymentPage() {
        return getElementText(PAYMENT_PAGE);
    }

    public String getOpenCheckPage() {
        return getElementText(OPEN_CHECK_PAGE);
    }

    public String getOpenCreditCardPage() {
        return getElementText(OPEN_CREDIT_CARD_PAGE);
    }

    public String getTranslationRequestPage() {
        return getElementText(TRANSLATION_REQUEST_PAGE);
    }

    public String getOverviewCardsPage() {
        return getElementText(OVERVIEW_CARDS_PAGE);
    }

    public String getAuthPage() {
        return getElementText(AUTH_PAGE);
    }

}