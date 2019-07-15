package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest {

    /**
     * 我要点击bilibili网站
     * 选定搜索框
     * 点击确定
     * 检查跳转后的页面url是否一致
     */
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();


    }

    @Test
    public void clickTest01() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().refresh();
        WebElement search = driver.findElement(By.linkText("新闻"));
        search.click();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url,"http://news.baidu.com/");
        WebElement click01 = driver.findElement(By.linkText("国内"));
        click01.click();
        String url01 = driver.getCurrentUrl();
        System.out.println(url01);
    }

    @Test
    public void clickTest02() throws InterruptedException {
        driver.get("https://www.bilibili.com");
        Thread.sleep(3000);
        driver.navigate().refresh();
        WebElement click01 = driver.findElement(By.cssSelector("#home_popularize > div.l-con > div.storey-box.clearfix > div:nth-child(2) > a > div > div.mask-video"));
        click01.click();
        driver.close();
        Thread.sleep(15000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
//        Assert.assertEquals(url,"https://www.bilibili.com/video/av57489846/?spm_id_from=333.334.b_63686965665f7265636f6d6d656e64.16");
    }
/**
    @Test
    public void clearTest01() throws InterruptedException{
        driver.get("https://www.bilibili.com");
        WebElement imput = driver.findElement(By.className("search-keyword"));
        imput.sendKeys("java");
        WebElement button = driver.findElement(By.className("search-submit"));
        button.click();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        WebElement imputTest = driver.findElement(By.id("search-keyword"));
        Thread.sleep(5000);
        imputTest.clear();
    }
*/
    @Test
    public void clearTest02() throws InterruptedException{
        driver.get("https://www.bilibili.com");
        driver.navigate().refresh();
        WebElement imput01 = driver.findElement(By.className("search-keyword"));
        imput01.sendKeys("java");
        Thread.sleep(5000);
        imput01.clear();
        Thread.sleep(3000);
    }

    /**
     * 打开哔哩哔哩首页
     * 输入关键 java
     * 获取搜索框的文本
     * 校验是否为 java
     * 清除搜索框文本
     * 校验是否为空
     */

    @Test
    public void clearTest03() throws InterruptedException{
        driver.get("https://www.bilibili.com");
        driver.navigate().refresh();
        WebElement imput = driver.findElement(By.className("search-keyword"));
        imput.sendKeys("java");
        Thread.sleep(3000);
        WebElement keys = driver.findElement(By.partialLinkText("//*[@id=\"banner_link\"]/div/div/ul[1]/li[1]/a"));
        Assert.assertSame(keys,"java");
//        imput.clear();
//        String keys02 = imput.getText();
//        Assert.assertEquals(keys02,null);
    }

    @Test
    public void tagNameTest(){
        driver.get("https://www.bilibili.com");
        driver.navigate().refresh();
        WebElement imput = driver.findElement(By.className("search-keyword"));
        String word01 = imput.getTagName();
        Assert.assertEquals(word01,"input");
    }

    @Test
    public void getAttributeTest() throws InterruptedException {
        driver.get("https://www.bilibili.com");
        driver.navigate().refresh();
//        Thread.sleep(15000);
        String a = driver.findElement(By.className("search-keyword")).getAttribute("placeholder");
        Assert.assertEquals(a,"朋友圈拍照姿势超全攻略");
    }

    /**
     * 打开bilibili首页
     * 判断是否显示 排行榜
     */
    @Test
    public void isDisPlayerTest(){
        driver.get("https://www.bilibili.com");
        Boolean zhengque = driver.findElement(By.xpath("//*[@id=\"banner_link\"]/div/div/a/span")).isDisplayed();
        Assert.assertTrue(zhengque);

    }

    @AfterMethod
    public void afterMethod(){

        driver.quit();
    }

}
