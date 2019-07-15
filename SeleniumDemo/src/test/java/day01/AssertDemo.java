package day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemo {
    @Test
    public void assertEqualTest(){
        String a = "ssss";
        String b = "sssss";

        Assert.assertEquals(a,b,"a不等于b");
//        Assert.assertEquals(a,b);
    }
    @Test
    public void assertNotEqualTest01(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);
    }
    @Test
    public void assertNotEqualTest02(){
        int a = 1;
        int b = 1;
        Assert.assertNotEquals(a, b);
    }
    @Test
    public void assertNullTest01(){
        String a = null;
        Assert.assertNull(a,"为空正确");
    }
    @Test
    public void assertNullTest02(){
        String a = "";
        Assert.assertNull(a,"为空错误");
    }
    @Test
    public void assertNotNullTest01(){
        String a = "aaaa";
        Assert.assertNotNull(a,"不为空是真的");
    }
    @Test
    public void assertNotNullTest02(){
        String a = null;
        Assert.assertNotNull(a,"不为空是假的");
    }
}
