package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class testcase04 {
    public static void testchinhsuadiachi() {
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

            //Step5. click nút chinh sữa địa chỉ
            driver.findElement(By.cssSelector("#address_tables > div:nth-child(1) > div > div > p > span.action_link.action_edit > a > i")).click();
            Thread.sleep(2000);

            //Step6. chỉnh sữa thông tin địa chỉ
            driver.findElement(By.cssSelector("#address_last_name_1124879293")).clear();
            driver.findElement(By.cssSelector("#address_last_name_1124879293")).sendKeys("Minh");
            driver.findElement(By.cssSelector("#address_first_name_1124879293")).clear();
            driver.findElement(By.cssSelector("#address_first_name_1124879293")).sendKeys("Huy");
            driver.findElement(By.cssSelector("#address_address1_1124879293")).clear();
            driver.findElement(By.cssSelector("#address_address1_1124879293")).sendKeys("176 Vành đai Trong , phường Bình Trị Đông B , quận Binhf Tân");
            driver.findElement(By.cssSelector("#address_address2_1124879293")).clear();
            driver.findElement(By.cssSelector("#address_address2_1124879293")).sendKeys("175 Vành đai Trong , phường Bình Trị Đông B , quận Binhf Tân");
            new Select(driver.findElement(By.cssSelector("#address_country_1124879293"))).selectByVisibleText("Vietnam");
            new Select(driver.findElement(By.cssSelector("#address_province_1124879293"))).selectByVisibleText("Bình Dương");
            driver.findElement(By.cssSelector("#address_phone_1124879293")).clear();
            driver.findElement(By.cssSelector("#address_phone_1124879293")).sendKeys("0123456777");
            driver.findElement(By.cssSelector("#address_default_address_1124879293")).click();
            driver.findElement(By.cssSelector("form[id='address_form_1124879293'] input[value='Cập nhật']")).click();
            Thread.sleep(2000);

            //Step7. So sánh nội dung địa chỉ đã được chỉnh sữa chưa
            String hoten = driver.findElement(By.cssSelector("div[class='address_title '] h3 strong")).getText();
            AssertJUnit.assertEquals(hoten,"Minh Huy");
            String diachi1 = driver.findElement(By.cssSelector("#view_address_1124879293 > div > div:nth-child(3) > div.lb-right > p:nth-child(1)")).getText();
            AssertJUnit.assertEquals(diachi1,"176 Vành đai Trong , phường Bình Trị Đông B , quận Binhf Tân");
            String diachi2 = driver.findElement(By.cssSelector("#view_address_1124879293 > div > div:nth-child(3) > div.lb-right > p:nth-child(2)")).getText();
            AssertJUnit.assertEquals(diachi2,"175 Vành đai Trong , phường Bình Trị Đông B , quận Binhf Tân");
            String sdt = driver.findElement(By.cssSelector("#view_address_1124879293 > div > div:nth-child(4) > div.lb-right")).getText();
            AssertJUnit.assertEquals(sdt,"0123456777");
            String quocgia = driver.findElement(By.cssSelector("#view_address_1124879293 > div > div:nth-child(3) > div.lb-right > p:nth-child(3)")).getText();
            AssertJUnit.assertEquals(quocgia,"Bình Dương, Vietnam");
            System.out.println(hoten);
            System.out.println(diachi1);
            System.out.println(diachi2);
            System.out.println(quocgia);
            System.out.println(sdt);
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}