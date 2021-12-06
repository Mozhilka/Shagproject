package test2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddRemoveElements {
    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void addRemoveElementsTest() {
        WebElement button = driver.findElement(By.xpath("//button[text()='Add Element']"));
        button.click();
        button.click();
        driver.findElement(By.className("added-manually")).click();
        int deletedButtonsQuantity = driver.findElements(By.className("added-manually")).size();
        assertEquals(deletedButtonsQuantity, 1, "One button is remaining");
    }

    @AfterEach
    public void completed () {
        driver.quit();
    }
}
