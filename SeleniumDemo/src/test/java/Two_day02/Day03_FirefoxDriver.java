package Two_day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Day03_FirefoxDriver {
    /**
     * 1.打开"ui自动化测试"主页
     * 2.点击Prompt按钮
     * 3.在Prompt弹窗中，输入"这个是Prompt"
     * 4.点击确定/取消按钮
     */
    @Test
    public void firefoxText_PromptTest() throws InterruptedException {
        System.setProperty("webdriver.firefox.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        driver.navigate().refresh();
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是Prompt");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        driver.quit();
    }
}
