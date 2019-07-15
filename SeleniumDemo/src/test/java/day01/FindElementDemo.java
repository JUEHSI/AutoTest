package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementDemo {
    WebDriver driver;
    /**
     *  打开bilibili
     *  定位搜索框
     */
    @BeforeMethod
    public void beforeMethodTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.bilibili.com/");
        Thread.sleep(3000);
    }

    @Test
    public void testTest1(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"哔哩哔哩 (゜-゜)つロ 干杯~-bilibili");
        System.out.println(title);
    }

    @Test
    public void testTest2() throws InterruptedException {
        WebElement video = driver.findElement(By.className("mask-video"));
        WebElement linktest = driver.findElement(By.linkText("你是创作专业玩家吗？"));
        System.out.println(video);
        System.out.println(linktest);

//        video.click();
//        System.out.println("寻找元素成功");
//        Thread.sleep(7000);
//        String title = driver.getTitle();
//        System.out.println(title);
//        String url = driver.getCurrentUrl();
//        System.out.println("url为："+url);
    }

    @Test
    public void partialLinkTest(){
        driver.findElement(By.partialLinkText("创作"));
        System.out.println(driver.findElement(By.partialLinkText("创作")));
    }

    @Test
    public void tagNameTest(){
        List<WebElement> list = driver.findElements(By.tagName("i"));
        System.out.println(list.size());
    }

    @Test
    public void cssTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#chief_recommend > div.recommend-module.clearfix > div:nth-child(1) > a > img")).click();
        Thread.sleep(5000);
    }

    @Test
    public void xPathTest01(){
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"app\"]/div[4]/div[2]/div"));
        String text = list.get(0).getText();
        System.out.println(list.size());
        System.out.println(text);
    }

    @Test
    public void xPathTest02(){
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"app\"]/div[4]/div[2]/div"));
        for(int i = 0;i < list.size();i++){
            String text = list.get(i).getText();
            System.out.println(text);
        }
    }



    @AfterMethod
    public void afterMethodTest(){

        driver.quit();
    }

}
