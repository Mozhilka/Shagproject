package com.shag.vitebsk.pages;

import org.openqa.selenium.By;

public class DepositPage extends BasePage {

    private static final By CARDS_BUTTON = By.id("cards-overview-index");
    private static final By CARDS_GOLD_BUTTON = By.xpath("//*[@class='card-type alias' and text()='Золотая']");

    public void clickCardsButton() {
        click(CARDS_BUTTON);
    }
    public void clickCardsGoldButton() {
        click(CARDS_GOLD_BUTTON);
    }

    public MainPage viewCards() {
        clickCardsButton();
        clickCardsGoldButton();

        return new MainPage();
    }
}
