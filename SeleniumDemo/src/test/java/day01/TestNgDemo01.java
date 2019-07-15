package day01;

import org.testng.annotations.*;

public class TestNgDemo01 {

    @BeforeTest
    public void beforeTest01(){
        System.out.println("这是BeforeTest注解");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是BeforeMethod注释");
    }
    @Test
    public void testCase01(){
        System.out.println("这是@Test注解，case01");
    }
    @Test
    public void testCase02(){
        System.out.println("这是@Test注解，case02");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是fterMethod");
    }
    @AfterTest
    public void afterTest01(){
        System.out.println("这是AfterTest");
    }
}
//        String title = driver.getTitle();
//        Assert.assertEquals(title,"哔哩哔哩 (゜-゜)つロ 干杯~-bilibili/");

//        System.out.println(title);
