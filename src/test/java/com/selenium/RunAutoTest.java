package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * @author SunYuHang
 */

public class RunAutoTest {
    public static void main(String[] args) throws InterruptedException {
        AutoTest autoTest = new AutoTest();
        autoTest.Test();
    }
}
class AutoTest {
    //打开我自己发布的博客网站 登录博客网站
    public void Test() throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        EdgeDriver driver = new EdgeDriver(options);

        String st = "";
        int sum = 0;

        driver.get("http://127.0.0.1:5500/%E7%99%BB%E5%BD%95.html");
        for(int i = 0 ; i < 8 ; i++){

            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("password")).clear();
            //driver.manage().window().setSize(new Dimension(968, 796));
            driver.findElement(By.id("username")).click();
            driver.findElement(By.id("username")).sendKeys(st);
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("password")).sendKeys("111111");
            driver.findElement(By.id("submitBtn")).click();
            //获取元素的文本
            WebElement opentab=driver.findElement(By.id("ErrorMsg"));
            //获取元素的文本
            String elementTest=opentab.getText();
            //打印元素的文本

            if (elementTest.equals("")){
                System.out.println("实际结果：登录成功");
            }else {
                System.out.println("实际结果："+elementTest);
            }

            String p1 = "用户名长度不符合要求！";
            String p2 = "账号密码错误";
            String p3 = "";

            if(st.length()>6||st.length()==0){
                System.out.println("预期结果："+p1);
                if(elementTest.equals(p1)){
                    sum++;
                }
            }else {
                System.out.println("预期结果："+p2+" 或 登录成功"+p3);
                if(elementTest.equals(p2)||elementTest.equals(p3)){
                    sum++;
                }
            }
            System.out.println("输入的账号是："+st);
            System.out.println("本次测试通过的案例数量："+sum);
            driver.navigate().refresh();
            st = st + "1";

        }
        driver.close();

//        driver.manage().window().setSize(new Dimension(1083, 667));
//        driver.findElement(By.id("username")).click();
//        driver.findElement(By.id("username")).sendKeys("123456");
//        driver.findElement(By.id("password")).click();
//        driver.findElement(By.id("password")).sendKeys("123456");
//        driver.findElement(By.id("submitBtn")).click();
//        WebElement element = driver.findElement(By.id("ErrorMsg"));
//        String getelement = element.getText();
//        System.out.println(getelement+"-----------------------");
////        String message = "成功";
//        assertEquals("登录成功",getelement);
//        driver.quit();

    }
}




