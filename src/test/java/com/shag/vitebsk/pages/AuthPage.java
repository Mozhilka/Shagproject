package com.shag.vitebsk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {
    private WebDriver driver;

    private static final By USERNAME_LOCATOR = By.name("username");
    private static final By PASSWORD_LOCATOR = By.name("password");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.id("login-button");
    private static final By CODE_CONFIRMATION = By.id("otp-code");
    private static final By CONFIRMATION_BUTTON = By.id("login-otp-button");
    private static final By ERROR_MESSAGE = By.id("alerts-container");
    private static final By PAYMENTS_AND_TRANSFERS = By.id("payments-form");
    private static final By PAYMENT_HISTORY_BUTTON = By.xpath("//*[@class='payment-menu-icon history']");
    private static final By PAYMENT_BACH_BUTTON = By.id("payment-back-action-url");

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertLogin(String login) {
        driver.findElement(USERNAME_LOCATOR).sendKeys(login);
    }

    public void insertPassword(String password) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON_LOCATOR).click();
    }

    public void insertCode(String code) {
        driver.findElement(CODE_CONFIRMATION).sendKeys(code);
    }

    public void clickConfirmationButton() {
        driver.findElement(CONFIRMATION_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void clickPaymentsAndTransfers() {
        driver.findElement(PAYMENTS_AND_TRANSFERS).click();
    }

    public void clickPaymentHistoryButton() {
        driver.findElement(PAYMENT_HISTORY_BUTTON).click();
    }

    public void clickPaymentBachButton() {
        driver.findElement(PAYMENT_BACH_BUTTON).click();
    }


    public MainPage fullAuth(String login, String password, String code) {
        insertLogin(login);
        insertPassword(password);
        clickSignInButton();
        insertCode("1111");
        clickConfirmationButton();

        return new MainPage(driver);
    }

    public MainPage notFullAuth(String login, String password) {
        insertLogin(login);
        insertPassword(password);
        clickSignInButton();

        return new MainPage(driver);
    }

    public MainPage paymentHistory() {
        clickPaymentsAndTransfers();
        clickPaymentHistoryButton();
        clickPaymentBachButton();

        return new MainPage(driver);
    }
}
