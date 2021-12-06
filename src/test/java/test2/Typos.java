package test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Typos {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void typosTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> text = driver.findElements(By.xpath("//div[@class='example']/p"));
        assertEquals(text.get(0).getText(),"This example demonstrates a typo being introduced. It does it randomly on each page load.");
        assertEquals(text.get(1).getText(),"Sometimes you'll see a typo, other times you won't.");
    }
}
