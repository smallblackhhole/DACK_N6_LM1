package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class testcase05 {
    public static void testgiaspsale() {
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

            // Step4. quay lại trang chủ
            driver.findElement(By.cssSelector("div[class='title-menu menu-clicked'] span")).click();
            driver.findElement(By.cssSelector("img[alt='TTGShop']")).click();
            Thread.sleep(2000);

            // Step5. Chọn sản phẩm đã sale
            driver.findElement(By.cssSelector("div[id='section_2_loop_3'] a[class='quickview-product']")).click();
            Thread.sleep(2000);

            // Step6. so sánh khuyến mãi
            String sale = driver.findElement(By.cssSelector(".pro-percent")).getText();
            AssertJUnit.assertEquals(sale,"-30%");
            System.out.println(sale);
            Thread.sleep(2000);

            // Step7: click muangay
            driver.findElement(By.cssSelector("#buy-now")).click();
            Thread.sleep(8000);

            // Step8: so sánh giá đã được giảm chưa
            String total = driver.findElement(By.cssSelector("div[class='summary-total'] p span")).getText();
            AssertJUnit.assertEquals(total,"690,000₫");
            System.out.println(total);
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}