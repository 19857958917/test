package com.selenium.Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;


public class CountTest {

    //验证超时
    @Test(timeout=100)
    public void testAdd() throws InterruptedException {
        Thread.sleep(10);
        new Count().add(1, 1);
    }

    //验证抛出异常
    @Test(expected=ArithmeticException.class)
    public void testDivision() {
        new Count().division(0, 8);
    }

    // 跳过该条用例
    @Ignore
    @Test
    public void testAdd2() {
        Count count = new Count();
        int result = count.add(2,2);
        assertEquals(result, 5);
    }

}
