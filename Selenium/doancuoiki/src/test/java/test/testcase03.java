package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class testcase03 {
    public static void testtạodiachimacdinh() {
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
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#form_submit-login")).click();
            Thread.sleep(2000);

            // Step4. click �Danh sách địa chỉ�
            driver.findElement(By.linkText("Danh sách địa chỉ")).click();
            Thread.sleep(2000);

            // Step5 .click Nhập địa chỉ mới
            driver.findElement(By.cssSelector(".add-new-address")).click();
            Thread.sleep(2000);

            // Step6. điền thông tin địa chỉ mới
            driver.findElement(By.cssSelector("#address_last_name_new")).sendKeys("minh");
            driver.findElement(By.cssSelector("#address_first_name_new")).sendKeys("huy");
            driver.findElement(By.cssSelector("input[placeholder='Công ty'][name='address[company]'][for='address_company_new']")).sendKeys("gamelol");
            driver.findElement(By.cssSelector("#address_address1_new")).sendKeys("176 Vành đai Trong");
            driver.findElement(By.cssSelector("#address_address2_new")).sendKeys("175 Vành đai Trong");
            new Select(driver.findElement(By.cssSelector("#address_country_new"))).selectByVisibleText("Vietnam");
            new Select(driver.findElement(By.cssSelector("#address_province_new"))).selectByVisibleText("Hà Nội");
            driver.findElement(By.cssSelector("#address_phone_new")).sendKeys("0123456789");
            driver.findElement(By.cssSelector("#address_default_address_new")).click();
            driver.findElement(By.cssSelector("input[value='Thêm mới']")).click();
            Thread.sleep(2000);


//          Step7: So sánh kiểm tra đã tạo địa chỉ mặc định chưa
            String dcmacdinh = driver.findElement(By.cssSelector
                    (".default_address.note")).getText();
            AssertJUnit.assertEquals(dcmacdinh,"(Địa chỉ mặc định)");
            System.out.println(dcmacdinh);
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}