package com.shag.vitebsk.pages;

import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private static final By PAYMENT_PAGE = By.id("payments-form");
    private static final By PAYMENTS_AND_TRANSFERS = By.id("payments-form");
    private static final By PAYMENT_HISTORY_BUTTON = By.xpath("//*[@class='payment-menu-icon history']");
    private static final By DOWNLOAD_HISTORY_BUTTON = By.id("apply-payments-filter");
    private static final By PAYMENT_BACH_BUTTON = By.id("payment-back-action-url");
    private static final By BALANCE_BUTTON = By.id("krawlly");


    public String getPaymentPage() {
        return getElementText(PAYMENT_PAGE);
    }

    public void clickPaymentsAndTransfers() {
        click(PAYMENTS_AND_TRANSFERS);
    }
    public void clickPaymentHistoryButton() {
        click(PAYMENT_HISTORY_BUTTON);
    }
    public void clickPaymentBachButton() {
        click(PAYMENT_BACH_BUTTON);
    }
    public void clickDownloadHistoryButton() {
        click(DOWNLOAD_HISTORY_BUTTON);
    }
    public void clickBalanceButton() {
        click(BALANCE_BUTTON);
    }

    public MainPage paymentHistory() {
        clickPaymentsAndTransfers();
        clickPaymentHistoryButton();
        clickDownloadHistoryButton();
        clickPaymentBachButton();

        return new MainPage();
    }
    public MainPage viewBalance() {
        clickPaymentsAndTransfers();
        clickBalanceButton();
        clickPaymentBachButton();

        return new MainPage();
    }


}
