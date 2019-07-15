package Two_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day04_SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    /**
     * 1.打开测试页面
     * 2.定位下拉框
     * 3.将定位好的元素实例化为Select
     * 4.根据索引来选取第0个值
     * 5.根据属性value来选取huawei
     * 6.根据标签之间的Text值来选取
     */
    @Test
    public void selectByIndexTest() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        WebElement element =  driver.findElement(By.id("moreSelect"));
//      实例化Select类
        Select select = new Select(element);
//      通过索引选取下拉框
        select.selectByIndex(1);
        Thread.sleep(5000);
//      通过value值选取下拉框
        select.selectByValue("huawei");
        Thread.sleep(5000);
//      通过Text文本获取下拉框
        select.selectByVisibleText("xiaomi");
        Thread.sleep(5000);
//      获取当前定位的元素的元素以及元素值
        List a = select.getAllSelectedOptions();
        System.out.println(a);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
