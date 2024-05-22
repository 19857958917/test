// Generated by Selenium IDE
package com.selenium;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TestopenbaiduTest {
    public static void main(String[] args) throws InterruptedException {
        ToTestopenbaiduTest autoTest = new ToTestopenbaiduTest();
        autoTest.Test();
    }
}
class ToTestopenbaiduTest{
    public void Test() throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        EdgeDriver driver = new EdgeDriver(options);
//        driver.get("https://www.baidu.com/");
//        driver.manage().window().setSize(new Dimension(1083, 667));
//        driver.findElement(By.id("kw")).sendKeys("zhiun");
//        driver.findElement(By.id("kw")).sendKeys(Keys.ENTER);
//        {
//            WebElement element = driver.findElement(By.linkText("zhiun影像仪 - zhiun影像仪批发价格、市场报价、厂家供应 ..."));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(element).perform();
//        }
//        {
//            WebElement element = driver.findElement(By.tagName("body"));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(element, 0, 0).perform();
//        }
//        {
//            WebElement element = driver.findElement(By.id("user"));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(element).perform();
//        }
//        {
//            WebElement element = driver.findElement(By.tagName("body"));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(element, 0, 0).perform();
//        }
//        driver.quit();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Poco F1");
        Thread.sleep(4000);
        driver.findElement(By.className("nav-input")).click();
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.navigate().to("http://itxiaonv.com");
        Thread.sleep(4000);
        driver.navigate().back();
        driver.quit();
    }

}