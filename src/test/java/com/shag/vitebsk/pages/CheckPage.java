package com.shag.vitebsk.pages;

import org.openqa.selenium.By;

public class CheckPage extends BasePage {

    private static final By ACCOUNT_TAB = By.xpath("//*[@class='dropdown-toggle']");
    private static final By OPEN_CHECK_BUTTON = By.xpath("//*[@class='btn btn-primary' and text()='Открыть счёт']");
    private static final By CHEKBOX_INPUT = By.name("condition.newAccountConditions");
    private static final By CONFIRMATION_OPEN_CHECK_BUTTON = By.id("submit");

    public void clickAccountTab() {
        click(ACCOUNT_TAB);
    }
    public void clickOpenCheckButton() {
        click(OPEN_CHECK_BUTTON);
    }
    public void clickChekboxInput() {
        click(CHEKBOX_INPUT);
    }
    public void clickConfirmationOpenCheckButton() {
        click(CONFIRMATION_OPEN_CHECK_BUTTON);
    }

    public MainPage openNewCheck() {
        clickAccountTab();
        clickOpenCheckButton();
        clickChekboxInput();
        clickConfirmationOpenCheckButton();

        return new MainPage();
    }
}
