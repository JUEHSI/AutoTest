package Two_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day05_ActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /**
     * 单击
     */
    @Test
    public void actionsTest(){
        driver.get("https://www.bilibili.com/");
//        实例化Actions
        Actions actions = new Actions(driver);
//        在不传入任何参数的情况下单击右键
        actions.contextClick().click().perform();
    }

    /**
     * 单击
     */
    @Test
    public void actionsTest1(){
        driver.get("https://www.bilibili.com/");
        WebElement zhibo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div[2]/div[1]"));
        Actions actions = new Actions(driver);
        actions.contextClick(zhibo).click().perform();
    }

    /**
     * 双击
     */
    @Test
    public void doubleClickTest() throws InterruptedException{
        driver.get("https://www.bilibili.com/");
        WebElement yinping = driver.findElement(By.linkText("音频"));
        yinping.click();
//      获取到当前页面的handle
        String handle = driver.getWindowHandle();
//      获取多个页面的句柄，并做比较，若与前一个页面的句柄一致则跳过，继续比较，
//      若不同，则会跳转到不同页面
        for(String handles : driver.getWindowHandles()){
            if (handles.equals(handle)){
                continue;
            }else {
                driver.switchTo().window(handles);
            }
        }
        driver.findElement(By.xpath("//*[@id=\"home_click_recommend_menu\"]/li[3]/div[1]/div")).click();
//        WebElement bofang = driver.findElement(By.className("list-play"));
//      显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("list-play")));
        WebElement wow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[1]"));
//      将动作实例化
        Actions actions = new Actions(driver);
//      双击操作，双击的是选中的元素
        actions.doubleClick(wow).perform();
        Thread.sleep(5000);
    }

    /**
     * 打开测试页面
     * 将鼠标移动到Action
     * 获取出现的文本Hello World
     * 打印文本
     */
    @Test
    public void moveTest(){
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        WebElement element = driver.findElement(By.className("over"));

    }
}
