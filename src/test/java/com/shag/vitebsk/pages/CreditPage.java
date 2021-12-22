package com.shag.vitebsk.pages;

import org.openqa.selenium.By;

public class CreditPage extends BasePage {

    private static final By CREDITS_BUTTON = By.id("loans-index");
    private static final By READ_OFFERS_BUTTON = By.id("loan-application-btn");
    private static final By REGISTRATION_APPLICATION_BUTTON = By.id("credit-card-loan-apply");
    private static final By PAYMENTS_AND_TRANSFERS = By.id("payments-form");
    private static final By TRANSLATION_REQUEST_BUTTON = By.xpath("//*[@class='payment-menu-icon request-money']");
    private static final By FORM_REQUEST_BUTTON = By.id("forward");

    public void clickCreditsButton() {
        click(CREDITS_BUTTON);
    }
    public void clickReadTheOffersButton() {
        click(READ_OFFERS_BUTTON);
    }
    public void clickRegistrationApplicationButton() {
        click(REGISTRATION_APPLICATION_BUTTON);
    }
    public void clickPaymentsAndTransfers() {
        click(PAYMENTS_AND_TRANSFERS);
    }

    public void clickTranslationRequestButton() {
        click(TRANSLATION_REQUEST_BUTTON);
    }
    public void clickFormRequestButton() {
        click(FORM_REQUEST_BUTTON);
    }

    public MainPage openCreditCard() {
        clickCreditsButton();
        clickReadTheOffersButton();
        clickRegistrationApplicationButton();

        return new MainPage();
    }
    public MainPage translationRequest() {
        clickPaymentsAndTransfers();
        clickTranslationRequestButton();
        clickFormRequestButton();

        return new MainPage();
    }
}
