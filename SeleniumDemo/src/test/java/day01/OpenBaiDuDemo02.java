package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenBaiDuDemo02 {
    /**
     * 打开chrome浏览器
     * 打开百度网页
     * 等待3s
     * 后退
     * 等待3s
     * 退出浏览器
     */


    @Test
    public void backTest02() throws InterruptedException{   //这是返回case
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        System.out.println("开始后退");
        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println("程序结束，退出浏览器");
        driver.quit();
    }

    @Test
    public void forWardTest() throws InterruptedException{  //这是前进case
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        System.out.println("开始后退");
        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println("开始前进");
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("程序结束，退出浏览器");
        driver.quit();
    }
}
