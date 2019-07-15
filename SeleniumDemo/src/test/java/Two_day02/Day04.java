package Two_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day04 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试页面
     * 点击open the windows
     *
     */
    @Test
    public void testWindow(){
        driver.get("https://www.bilibili.com/");
        driver.findElement(By.xpath("//*[@id=\"chief_recommend\"]/div[2]/div[1]/a/img")).click();
        String handle = driver.getWindowHandle();
//        for循环判断获取到的handles是否等于handle
        for(String handles : driver.getWindowHandles()){
            if(handles.equals(handle)){
                continue;
            }else {
                driver.switchTo().window(handles);
            }
        }
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println(title);
        System.out.println(url);
        driver.switchTo().window(handle);
        String url01 = driver.getCurrentUrl();
        String title01 = driver.getTitle();
        System.out.println(url01);
        System.out.println(title01);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
