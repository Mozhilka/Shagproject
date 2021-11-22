package com.shag.vitebsk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private static final By USER_NAME_LOCATOR = By.id("user-greeting");
    private static final By PAYMENT_PAGE = By.id("payments-form");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return driver.findElement(USER_NAME_LOCATOR).getText();
    }

    public String getPaymentPage() {
        return driver.findElement(PAYMENT_PAGE).getText();
    }

}
