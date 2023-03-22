package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/*
Test Steps:
1. Go to https://ttgshop.vn/
2. Click on Đăng nhập / Đăng ký -> Click on Đăng Nhập -> go back home
3. Click on Products onSale -> Click on product onSale
4. Choose size and add to Cart
*/
    public class testcase10 {
        @Test
        public static void testne2() {
            WebDriver driver = driverFactory.getChromeDriver();
            try {

                // Step1. Go to https://ttgshop.vn/
                driver.get("https://ttgshop.vn/");

                //debug purpose only
                Thread.sleep(5000);

                // Step2. Click on Đăng nhập / Đăng ký -> Click on Đăng Nhập -> go back home
                driver.findElement(By.cssSelector("#site-account-handle > span.box-text")).click();
                driver.findElement(By.xpath("//input[@id='login-customer[email]']")).sendKeys("minh1@gmail.com");
                driver.findElement(By.xpath("//input[@id='login-customer[password]']")).sendKeys("minh1234");

                //debug purpose only
                Thread.sleep(5000);

                driver.findElement(By.cssSelector("button[class=\"form__submit button dark\"]")).click();

                driver.findElement(By.cssSelector("#site-header > div.mainHeader-middle > div > div > div.header-wrap-logo > div > a")).click();


                //debug purpose only
                Thread.sleep(5000);

                // Step3. Click on Products onSale -> Click on product onSale
                driver.findElement(By.cssSelector("a[class='button']")).click();

                //debug purpose only
                Thread.sleep(5000);

                driver.findElement(By.cssSelector("#collection_loop_2 > div.proloop-detail > h3 > a")).click();

                // Step4. Choose size and add to Cart
                driver.findElement(By.cssSelector("#variant-swatch-0 > div.select-swap > div.n-sd.swatch-element.xxl > label")).click();
                //debug purpose only
                Thread.sleep(5000);
                driver.findElement(By.cssSelector("#add-to-cart")).click();

                // Step5. Click Watch Cart and go to Cart
                driver.findElement(By.cssSelector("#site-cart-handle")).click();
                //debug purpose only
                Thread.sleep(5000);

                driver.findElement(By.cssSelector("#site-header > div.mainHeader-middle > div > div > div:nth-child(4) > div > div.header-action-item.header-action_cart.js-action-show > div.header-action_dropdown > div > div > div > div.cart-view-total > table > tbody > tr.mini-cart__button > td > a\n")).click();

                // Step6. Verify payment terms
                    String pending = driver.findElement(By.cssSelector
                                    ("#layout-cart > div.wrapper-mainCart > div > div > div > div.col-lg-4.col-md-12.col-12.sidebarCart-sticky > div > div:nth-child(1) > div.summary-action > div"))
                            .getText();
                    AssertJUnit.assertEquals(pending,"Giỏ hàng của bạn hiện chưa đạt mức tối thiểu để thanh toán.");
                    if (pending.equals("Giỏ hàng của bạn hiện chưa đạt mức tối thiểu để thanh toán.")) {
                        System.out.println("Verify Successful payment terms : " + pending);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            //5. Quit browser session
            driver.quit();
        }
}
