package test;
/*
Test Steps:
1. Go to https://ttgshop.vn/
2. Click on PC menu
3. Add product in Cart
4. Read the cost in Cart (which is 33,980,000₫)
5. Click on Cart
6. Read the Cart from detail page
7. Compare prices in the shopping cart (which is 33,980,000₫)
*/

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

public class testcase14 {
    @Test
    public static void testCostEqualCart() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            // Step1. Goto https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");

            // Step2. Click on PC menu
            driver.findElement(By.cssSelector("a[title='PC - Máy tính chơi game , Làm việc']")).click();


            // Step3. Add product in Cart
            driver.findElement(By.cssSelector("div[id='collection_loop_1'] span[class='btnadd']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("div[id='collection_loop_2'] span[class='btnadd']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[contains(@class,'header-action-item header-action_cart')]//span[1]//span[2]")).click();
            Thread.sleep(2000);
            // Step4. Read the cost in Cart (which is 33,980,000₫)
            WebElement Cart = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > header:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
            String CartPrice = Cart.getText();
            System.out.println("Cart price from list page: " + CartPrice);
            // Step5. Click on Cart
            WebElement CartLink = driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div/div/div[4]/div/div[3]/div[2]/div/div/div/div[3]/table/tbody/tr[2]/td/a"));
            CartLink.click();
            //debug purpose only
            Thread.sleep(2000);
            // Step6. Read the Cart from detail page
            WebElement CartDetailPrice = driver.findElement(By.cssSelector("div[class='summary-total'] p span"));
            String CartDetailPriceText = CartDetailPrice.getText();
            System.out.println("Cart price from detail: " + CartPrice);
            // Step7. Compare prices in the shopping cart
            WebElement CartDetails = driver.findElement(By.cssSelector("div[class='summary-total'] p span"));
            String CartDetailsPrice = CartDetails.getText();
            Assert.assertEquals(CartPrice, CartDetailsPrice);
            if (CartPrice.equals(CartDetailPriceText)){
                System.out.println("The cost in cart: " + CartDetailsPrice);
            }
            //debug purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
