package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class testcase02 {
    public static void testdangnhap() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");

            // Step2. Click on �Đăng nhập / Đăng ký�
            driver.findElement(By.cssSelector("button[id='site-account-handle'] span[class='box-text']")).click();
            Thread.sleep(2000);

            // Step3. �nhập thông tin đăng nhập�
            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > header:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(3) > input:nth-child(1)")).sendKeys("minhhuy@gmail.com");
            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > header:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(4) > input:nth-child(1)")).sendKeys("minh1234");
            driver.findElement(By.cssSelector("#form_submit-login")).click();
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}