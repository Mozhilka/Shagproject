package com.shag.vitebsk.pages;

import org.openqa.selenium.By;

public class AuthPage extends BasePage{

      String pageURL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";

    private static final By USERNAME_LOCATOR = By.name("username");
    private static final By PASSWORD_LOCATOR = By.name("password");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.id("login-button");
    private static final By CODE_CONFIRMATION = By.id("otp-code");
    private static final By CONFIRMATION_BUTTON = By.id("login-otp-button");
    private static final By ERROR_MESSAGE = By.id("alerts-container");
    private static final By EXIT_BUTTON = By.id("logout-button");


    public AuthPage insertLogin(String login) {
        type(USERNAME_LOCATOR,login);
        return this;
    }

    public AuthPage insertPassword(String password) {
        type(PASSWORD_LOCATOR, password);
        return this;
    }

    public void clickSignInButton() {
        click(SIGN_IN_BUTTON_LOCATOR);
    }

    public AuthPage insertCode(String code) {
        type(CODE_CONFIRMATION, code);
        return this;
    }

    public void clickConfirmationButton() {
        click(CONFIRMATION_BUTTON);
    }

    public String getErrorMessage() {
        return getElementText(ERROR_MESSAGE);
    }

    public void clickExitButton() {
        click(EXIT_BUTTON);
    }


    public MainPage fullAuth(String login, String password, String code) {
        insertLogin(login);
        insertPassword(password);
        clickSignInButton();
        insertCode("1111");
        clickConfirmationButton();

        return new MainPage();
    }

    public MainPage notFullAuth(String login, String password) {
        insertLogin(login);
        insertPassword(password);
        clickSignInButton();

        return new MainPage();
    }

    public MainPage signOut() {
        clickExitButton();

        return new MainPage();
    }

    public void openAuthPage() {
        openUrl(pageURL);
    }
}
