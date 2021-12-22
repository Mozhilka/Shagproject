package com.shag.vitebsk.tests;

import com.shag.vitebsk.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;




public class BaseTest {

    @AfterEach
    public void tearDown() {
        Driver.tearDown();
    }
}