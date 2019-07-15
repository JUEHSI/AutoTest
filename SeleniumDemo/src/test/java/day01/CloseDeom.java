package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseDeom {
    @Test
    public void closeDemoTest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.close();
    }


}
