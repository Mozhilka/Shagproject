package com.shag.vitebsk.pages;

import com.shag.vitebsk.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver = Driver.getDriver();

    protected void openUrl(String URL) {
        driver.get(URL);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    protected void type(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }
}