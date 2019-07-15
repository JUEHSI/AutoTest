package Two_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day04_WaitTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
//        隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


    @Test
    public void waitTest(){
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        String test = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(test,"wait for display");
    }

    /**
     * 显示等待
     */
    @Test
    public void waitTest1(){
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("red")));
    }
}
