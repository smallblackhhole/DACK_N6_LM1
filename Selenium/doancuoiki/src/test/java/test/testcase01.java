package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.io.StringWriter;

@Test
public class testcase01 {
    public static void testdangki() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");

            // Step2. Click on �Đăng nhập / Đăng ký�
            driver.findElement(By.cssSelector("button[id='site-account-handle'] span[class='box-text']")).click();
            driver.findElement(By.cssSelector("a[class='link']")).click();
            Thread.sleep(2000);

            // Step3. �nhập thông tin đăng kí�
            driver.findElement(By.cssSelector("#last_name")).sendKeys("minh");
            driver.findElement(By.cssSelector("#first_name")).sendKeys("huy");
            driver.findElement(By.cssSelector("#birthday")).sendKeys("08/08/1997");
            driver.findElement(By.cssSelector("label[for='radio2']")).click();
            driver.findElement(By.cssSelector("#email")).sendKeys("minhhuy@gmail.com");
            driver.findElement(By.cssSelector("#password")).sendKeys("minh1234");
            driver.findElement(By.cssSelector("input[value='Đăng ký']")).click();
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
