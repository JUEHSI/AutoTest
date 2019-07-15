package day01;

import org.testng.annotations.Test;

public class DiaoYong_demo {
    @Test
    public void demo_01(){
        StaticDemo.a();
    }
    @Test
    public void demo_02(){
        StaticDemo ceshi_b = new StaticDemo();
        ceshi_b.b();
    }
}
