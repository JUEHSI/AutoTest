package day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RefreshDemo {
    @Test
    public void refreshTest() throws InterruptedException{      //页面刷新
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bilibili.com/");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        System.out.println("程序结束，退出浏览器");
        driver.quit();
    }

    @Test
    public void dimensionTest() throws InterruptedException{    //调整窗口大小
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bilibili.com/");
        Thread.sleep(3000);
        Dimension dimension = new Dimension(500,500);   //设置窗口的大小
        driver.manage().window().setSize(dimension);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.manage().window().maximize();    //窗口最大化
        Thread.sleep(3000);
        Dimension dimension1 = new Dimension(600,600);
        driver.manage().window().setSize(dimension1);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        System.out.println("退出浏览器");
        driver.quit();
    }
}
