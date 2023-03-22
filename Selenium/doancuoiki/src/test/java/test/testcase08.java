package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;


public class testcase08 {
    @Test
    public static void kiemtragiakhitangsoluong() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");
            //Step 2. Click Màn Hình
            driver.findElement(By.cssSelector("a[aria-label='Màng hình máy tính']")).click();
            //Step 3. Click product Màn hình Asus VP249QGR
            driver.findElement(By.cssSelector("div[id='collection_loop_1'] a[class='quickview-product']")).click();
            Thread.sleep(2000);
            //Step 4. Change product quantity to 2
            driver.findElement(By.cssSelector("#quantity")).clear();
            driver.findElement(By.cssSelector("#quantity")).sendKeys("2");
            Thread.sleep(2000);
            //Step 5. Add product into your Cart
            driver.findElement(By.cssSelector("#add-to-cart")).click();
            Thread.sleep(2000);
            //Step 6. Click Cart
            driver.findElement(By.cssSelector("#site-cart-handle > span.box-icon > svg")).click();
            driver.findElement(By.cssSelector("#site-header > div.mainHeader-middle > div > div > div:nth-child(4) > div > div.header-action-item.header-action_cart.js-action-show > div.header-action_dropdown > div > div > div > div.cart-view-total > table > tbody > tr.mini-cart__button > td > a")).click();
            Thread.sleep(2000);
            //Step 7. Equal cost
            String cost = driver.findElement(By.cssSelector
                    ("#cartformpage > div:nth-child(1) > div > div > div.media-total > div.item-total-price > div > span")).getText();
            AssertJUnit.assertEquals(cost, "7,180,000₫");
            if (cost.equals("7,180,000₫")) {
                System.out.println("Đúng giá tiền");
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
