package day03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void AlertTest() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
    }

    @Test
    public void AlertTest1() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/index.html");
        Thread.sleep(3000);
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    @AfterMethod
    public void afyerMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
