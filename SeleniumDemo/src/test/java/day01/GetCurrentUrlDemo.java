package day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GetCurrentUrlDemo {
    WebDriver driver;
    /**
     * 打开chrome浏览器
     * 设置浏览器大小为1000*1000
     * 等待3s
     * 打开bilibili网页
     * 等待5s
     * 刷新
     * 获取url
     * 获取title
     * 打印url
     * 退出浏览器
     */

    @BeforeMethod
    public void beforeMethodBilibili() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(1000, 1000);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.get("https://www.bilibili.com/");
        Thread.sleep(3000);
    }

    @Test
    public void getCurrentUrlDemoTest() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.bilibili.com/");

        System.out.println(url);
        Thread.sleep(3000);
    }

    @Test
    public void getTitleTest() throws InterruptedException {

        String title = driver.getTitle();
        Assert.assertEquals(title,"哔哩哔哩 (゜-゜)つロ 干杯~-bilibili");
        System.out.println(title);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterMethodTest(){
        driver.quit();
    }

}
//      //*[@id="chief_recommend"]/div[1]/div/div/ul[1]/li[3]/a[1]/img
//      //*[@id="bili_live"]/div/div[2]/div[2]/div[3]/a/div/div[3]
