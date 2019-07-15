package day01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ChromeDriver {
    @Test
    public void openChromeTest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
        Thread.sleep(5000);
        System.out.println("进程结束，关闭页面");
        driver.quit();
    }
}


