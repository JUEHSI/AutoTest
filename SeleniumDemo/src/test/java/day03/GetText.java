package day03;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;


public class GetText {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void getText(){
        driver.get("https://www.bilibili.com/video/av57660784/?spm_id_from=333.334.b_63686965665f7265636f6d6d656e64.16");
        driver.navigate().refresh();
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void urlTest01() throws InterruptedException {
        driver.get("https://www.bilibili.com/video/av57660784/?spm_id_from=333.334.b_63686965665f7265636f6d6d656e64.16");
        driver.navigate().refresh();
        Thread.sleep(5000);
        WebElement css = driver.findElement(By.cssSelector("#reco_list > div.rec-list > div:nth-child(1) > div > div.pic-box > div.pic > a > img"));
        css.click();
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(title,"【用吉他告白】幻界战线ED sugar song&bitter step 能请你跳支舞吗~ 【弹唱】_哔哩哔哩 (゜-゜)つロ 干杯~-bilibili");
        Assert.assertEquals(url,"https://www.bilibili.com/video/av54828874/?spm_id_from=333.788.videocard.0");
    }

    @Test
    public void urlTest02() throws InterruptedException{
        driver.get("https://www.bilibili.com/");
        driver.navigate().refresh();
        WebElement click01 = driver.findElement(By.cssSelector("#home_popularize > div.l-con > div.storey-box.clearfix > div:nth-child(3) > a > div > div.mask-video"));
        click01.click();
        String handle = driver.getWindowHandle();
        for(String handles : driver.getWindowHandles()){
            if(handles.equals(handle)){
                continue;
            }else {
                driver.switchTo().window(handles);
            }
        }
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);
//        String gettext = driver.findElement(By.xpath("//*[@id=\"bangumi_header\"]/div[1]/h1")).getText();
//        System.out.println(gettext);
//        Assert.assertEquals(url,"https://www.bilibili.com/bangumi/play/ep276263/");
//        Assert.assertEquals(title,"");
    }

    @Test
    public void screenShotFile01(){
        driver.get("https://www.bilibili.com/");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file,new File("/Users/jueshi/Desktop/case/case01/sdsd.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Test
    public void screenShotFile02(){
        driver.get("https://www.bilibili.com/");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("/Users/jueshi/Desktop/case/case01/sdsd01.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void isSelectTest() throws InterruptedException {
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        Thread.sleep(3000);
        WebElement volvo = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        volvo.click();
        Thread.sleep(3000);
        Boolean T = volvo.isSelected();
        Assert.assertTrue(T);
    }

    @Test
    public void isEnabledTest(){
        driver.get("file:///Users/jueshi/Desktop/case/new-html/index.html");
        WebElement element = driver.findElement(By.name("buttonhtml"));
        Boolean b = element.isEnabled();
        Assert.assertFalse(b);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
