package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;


@Test
public class testcase07 {
    @Test
    public static void kiemtradathang() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");
            //Step 2. Click PC
            driver.findElement(By.cssSelector("a[title='PC - Máy tính chơi game , Làm việc']")).click();
            //Step 3. Click product between 5.000.000đ and 10.000.000đ
            driver.findElement(By.cssSelector("#p2")).click();
            Thread.sleep(2000);
            //Step 4. Click Quick view
            driver.findElement(By.cssSelector("div[id='search_loop_1'] i[class='fa fa-eye']")).click();
            Thread.sleep(2000);
            //Step 5. Add product into your Cart
            driver.findElement(By.cssSelector("#add-to-cartQuickview")).click();
            Thread.sleep(2000);
            //Step 6. Click Cart
            driver.findElement(By.cssSelector("#site-cart-handle > span.box-icon > svg")).click();
            driver.findElement(By.cssSelector("#site-header > div.mainHeader-middle > div > div > div:nth-child(4) > div > div.header-action-item.header-action_cart.js-action-show > div.header-action_dropdown > div > div > div > div.cart-view-total > table > tbody > tr.mini-cart__button > td > a")).click();
            Thread.sleep(2000);
            //Step 9. Fill all required field in bill
            driver.findElement(By.cssSelector("#note")).sendKeys("Chao");
            driver.findElement(By.cssSelector("label[class='title']")).click();
            driver.findElement(By.cssSelector("input[placeholder='Tên công ty...']")).sendKeys("ITC");
            driver.findElement(By.cssSelector("input[placeholder='Mã số thuế...']")).sendKeys("2222222222");
            driver.findElement(By.cssSelector("input[placeholder='Email...']")).sendKeys("tttt12@gmail.com");
            driver.findElement(By.cssSelector("input[placeholder='Địa chỉ công ty...']")).sendKeys("gaaaaaaaaaaa");
            driver.findElement(By.cssSelector(".button.btn-save")).click();
            Thread.sleep(2000);
            //Step 10. Enter Thanh Toán
            driver.findElement(By.cssSelector("#btnCart-checkout")).click();
            Thread.sleep(2000);
            //Step 11.
            driver.findElement(By.cssSelector(".swal-button.swal-button--confirm")).click();
            Thread.sleep(2000);
            //Step 12. Fill all required field in oder
            driver.findElement(By.cssSelector("#billing_address_full_name")).clear();
            driver.findElement(By.cssSelector("#billing_address_full_name")).sendKeys("dung");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#checkout_user_email")).clear();
            driver.findElement(By.cssSelector("#checkout_user_email")).sendKeys("tttt12@gmail.com");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#billing_address_phone")).clear();
            driver.findElement(By.cssSelector("#billing_address_phone")).sendKeys("09999999999");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#billing_address_address1")).clear();
            driver.findElement(By.cssSelector("#billing_address_address1")).sendKeys("gaaaaaaaaaaa");
            Thread.sleep(2000);
            Select selectCity = new Select(driver.findElement(By.cssSelector("#customer_shipping_province")));
            selectCity.selectByVisibleText("Hồ Chí Minh");
            Thread.sleep(2000);
            Select selectDistrict = new Select(driver.findElement(By.cssSelector("#customer_shipping_district")));
            selectDistrict.selectByVisibleText("Quận 7");
            Thread.sleep(2000);
            Select selectWard = new Select(driver.findElement(By.cssSelector("#customer_shipping_ward")));
            selectWard.selectByVisibleText("Phường Bình Thuận");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("button[class='step-footer-continue-btn btn'] i[class='btn-spinner icon icon-button-spinner']")).click();
            Thread.sleep(2000);
            // Step 13. Verify Oder is generated. Note the order number
            String ordersuccess = driver.findElement(By.cssSelector
                    ("body > div:nth-child(7) > div > div.main > div.main-content > div > div:nth-child(1) > div > div > h2")).getText();
            AssertJUnit.assertEquals(ordersuccess, "Đặt hàng thành công");
            String ordercode = driver.findElement(By.cssSelector
                    ("body > div:nth-child(7) > div > div.main > div.main-content > div > div:nth-child(1) > div > div > span.os-order-number")).getText();
            if (ordersuccess.equals("Đặt hàng thành công")) {
                System.out.println("Order success! Order code is:" + ordercode);
                File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String png1 = ("D:\\HK5\\CNKT\\tieuluan\\Selenium\\hinh\\testCase_6_2.png");
                FileUtils.copyFile(scrFile1, new File(png1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //10. Quit browser session
        driver.quit();
    }
}
