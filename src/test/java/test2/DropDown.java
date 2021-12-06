package test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void dropDownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement element1 = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']"));
        element1.click();
        Assert.assertEquals(element1.isSelected(), true, "Option 1 is selected");
        WebElement element2 = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='2']"));
        element2.click();
        Assert.assertEquals(element2.isSelected(), true, "Option 2 is selected");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}