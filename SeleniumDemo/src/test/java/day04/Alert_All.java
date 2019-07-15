package day04;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alert_All {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void AlertTest() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[2]"));
        String a = element.getText();
        System.out.println(a);
        Boolean C = element.isDisplayed();
        Assert.assertTrue(C);
        
    }

    @Test
    public void alertTest01() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Thread.sleep(1000);
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();
        Thread.sleep(1000);
        alert1.accept();
//        alert.dismiss();
        /**
         * String a = driver.getWindowHandle();
         * System.out.println(a);
         */

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
