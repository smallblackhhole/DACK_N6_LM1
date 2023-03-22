package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.io.StringWriter;


@Test
public class testcase06 {
    public static void kiemtrathoigiangiaohang() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");
            //Step 2. Click Gaming Gear
            driver.findElement(By.cssSelector("a[aria-label='Bàn phím máy tính']")).click();
            //Step 3. Click product Bàn Phím Cơ Gaming SPARTAN 3218 LED RGP
            driver.findElement(By.cssSelector("div[id='collection_loop_1'] a[class='quickview-product']")).click();
            Thread.sleep(2000);
            //Step 4. Select Spartan Hồng
            driver.findElement(By.cssSelector("label[for='swatch-0-spartan-hong'] span")).click();
            Thread.sleep(2000);
            //Step 5. Add product into your Cart
            driver.findElement(By.cssSelector("#add-to-cart")).click();
            Thread.sleep(2000);
            //Step 6. Click Cart
            driver.findElement(By.cssSelector("#site-cart-handle > span.box-icon > svg")).click();
            driver.findElement(By.cssSelector("#site-header > div.mainHeader-middle > div > div > div:nth-child(4) > div > div.header-action-item.header-action_cart.js-action-show > div.header-action_dropdown > div > div > div > div.cart-view-total > table > tbody > tr.mini-cart__button > td > a")).click();
            Thread.sleep(2000);
            //Step 7. Set up datetime for shipping product
            driver.findElement(By.cssSelector("label[for='timeRadios-2']")).click();
            Thread.sleep(2000);
            Select selectDay = new Select(driver.findElement(By.cssSelector("#date_shipping")));
            selectDay.selectByVisibleText("19/03/2023");
            Select selectHour = new Select(driver.findElement(By.cssSelector("#time_shipping")));
            selectHour.selectByVisibleText("09:00 - 10:00");
            driver.findElement(By.cssSelector("#btn-cart-accepttime")).click();
            Thread.sleep(2000);
            //Step 7.Verify datetime for shipping product
            String time = driver.findElement(By.cssSelector
                    ("#layout-cart > div.wrapper-mainCart > div > div > div > div.col-lg-4.col-md-12.col-12.sidebarCart-sticky > div > div:nth-child(1) > div.summary-time.summary-picktime > div:nth-child(1) > div.boxtime-title > p.txt-time > span")).getText();
            AssertJUnit.assertEquals(time, "19/03/2023 09:00 - 10:00");
            if (time.equals("19/03/2023 09:00 - 10:00")) {
                System.out.println("Đúng ngày giao");
            }
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //8. Quit browser session
        driver.quit();
    }
}
