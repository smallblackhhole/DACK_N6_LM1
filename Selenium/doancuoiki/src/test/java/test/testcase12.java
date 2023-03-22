package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/*
Test Steps:
1. Go to https://ttgshop.vn/
2. Click on �MOBILE� menu
3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
4. Click on �COMPARE� button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/
public class testcase12 {
    @Test
    public static void testne4() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            // Step1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");

            // Step2. Click on Đăng nhập / Đăng ký -> Click on Đăng Nhập -> go back home
            driver.findElement(By.cssSelector("#site-account-handle > span.box-text")).click();
            driver.findElement(By.xpath("//input[@id='login-customer[email]']")).sendKeys("minh1@gmail.com");
            driver.findElement(By.xpath("//input[@id='login-customer[password]']")).sendKeys("minh1234");

            //debug purpose only
            Thread.sleep(1000);

            driver.findElement(By.cssSelector("#form_submit-login")).click();

            //debug purpose only
            Thread.sleep(5000);

            driver.findElement(By.cssSelector("#site-header > div.mainHeader-middle > div > div > div.header-wrap-logo > div > a")).click();

            //debug purpose only
            Thread.sleep(5000);

            //Step 2. Click on -> PC -> menu
            driver.findElement(By.linkText("PC - Máy tính chơi game , Làm việc")).click();

            // Step3. Click on Products onSale
            driver.findElement(By.cssSelector("#collection_loop_1 > div.proloop-detail > h3 > a")).click();

            // Step4. Add High Quantity product
            //debug purpose only
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#quantity")).clear();
            driver.findElement(By.cssSelector("#quantity")).sendKeys("10000");

            //debug purpose only
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#add-to-cart")).click();

            // Step5. Verify quantity product add to Cart
            try {
                Alert alert = driver.switchTo().alert();
                String message = alert.getText();
                System.out.println(alert.getText());
                AssertJUnit.assertEquals
                        (message,"Sản phẩm bạn vừa mua đã vượt quá tồn kho");
                if (message.equals("Sản phẩm bạn vừa mua đã vượt quá tồn kho")){
                    System.out.println("Verify quantity product add to Cart Successful " + message);
                }
                alert.accept();
            } catch (NoAlertPresentException e) {
                System.out.println("Can't Verify quantity product add to Cart ");
            }

            Thread.sleep(5000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
