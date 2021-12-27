package com.shag.vitebsk.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("driver", "chrome");
            String drvr = System.getProperty("driver");
            switch (drvr) {
                case "chrome":
                    initChrome();
                    break;
                case "Firefox":
                    break;
            }
        }
        return driver;
    }

    private static void initFF() {
    }

    private static void initChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}