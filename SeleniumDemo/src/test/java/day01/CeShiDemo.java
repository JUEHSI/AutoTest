package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CeShiDemo {
//    @Test
    public  static void de() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.close();
    }


    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","/Users/jueshi/IdeaProjects/SeleniumDemo/drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        Thread.sleep(5000);
//        driver.close();
        de();


    }
    public static void c(){
        CeShiDemo de =new CeShiDemo();
        try {
            de.de();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
