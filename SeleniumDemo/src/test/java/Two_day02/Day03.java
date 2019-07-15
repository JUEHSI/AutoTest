package Two_day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day03 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    /**
     * 1.打开"ui自动化测试"主页
     * 2.点击Alert按钮
     * 3.在Alert警告窗点击确认按钮
     */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(1000);
//        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * 1.打开"ui自动化测试"主页
     * 2.点击Confirm按钮
     * 3.在Confirm警告框点击取消按钮
     * 4.再次点击确定按钮
     */
    @Test
    public void conFirmTest() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
//        driver控制权转交给Alert弹窗
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);
        alert.accept();
    }

    /**
     * 1.打开"ui自动化测试"主页
     * 2.点击Prompt按钮
     * 3.在Prompt弹窗中，输入"这个是Prompt"
     * 4.点击确定/取消按钮
     */
    @Test
    public void promptTest01() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是prompt");
        Thread.sleep(5000);
        alert.accept();
        alert.accept();
        Thread.sleep(3000);
    }

    @Test
    public void promptTest02() throws InterruptedException {
//        这个是点击取消按钮
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是prompt");
        Thread.sleep(5000);
        alert.dismiss();
        alert.accept();
    }

    /**
     * 1.打开"ui自动化测试"主页
     * 2.点击Alert按钮
     * 3.在Alert弹窗中，获取警告框的文本值
     * 4.断言文本值是否符合预期
     * 5.点击确定/取消按钮
     */
    @Test
    public void promptTest_GetText() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(1000);
//        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        Assert.assertEquals(text,"请点击确定");
        System.out.println("断言成功，等待1秒");
        Thread.sleep(1000);
        alert.accept();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
