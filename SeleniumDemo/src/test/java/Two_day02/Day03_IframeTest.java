package Two_day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day03_IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    /**
     * 1.定位iframe
     * 2.driver控制权交给iframe
     * 3.操作iframe里面的元素
     * 4.driver控制权交回原页面
     */
    @Test
    public void iframeTest01() throws InterruptedException{
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        /**
         * 这是通过id或事name的方式转交控制权
         * driver.switchTo().frame("aa");
         */

        /**
         * 是通过element的方式转交控制权
         * WebElement iframe = driver.findElement(By.tagName("iframe"));
         * driver.switchTo().frame(iframe);
         */
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("wd")).sendKeys("美图");
        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();
        Thread.sleep(10000);
//        driver控制权转交给原来的界面
        driver.switchTo().defaultContent();
//        WebElement switchTO = driver.findElement(By.linkText("登陆界面"));
//        driver.switchTo().frame(switchTO);
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
