package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

/*
Test Steps:
1. Go to https://ttgshop.vn/
2. Click on Search menu
3. Search for product Tai Nghe Baseus Lark EL-01
4. check for search product name;
5. Click on Tai Nghe Baseus Lark EL-01
6. Check inside details correct product name;
7. Compare product names from outside search to in details
*/
public class testcase15 {
    @Test
    public static void testSearchByProductName() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            // Step1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");

            // Step2. Click on Search menu
            driver.findElement(By.cssSelector("#inputSearchAuto-3")).click();

            //debug purpose only
            Thread.sleep(2000);

            // Step 3. Search for product Tai Nghe Baseus Lark EL-01
            driver.findElement(By.cssSelector("#inputSearchAuto-3")).sendKeys("Tai Nghe Baseus Lark EL-01");
            Thread.sleep(4000);

            //step 4. check for search product name;
            WebElement Lark = driver.findElement(By.cssSelector("div[class='title'] a[title='Tai Nghe Baseus Lark EL-01']"));
            String search = Lark.getText();
            System.out.println("Search from list page: " + search);
            //step 5. Click on Tai Nghe Baseus Lark EL-01
            WebElement LarkLink = driver.findElement(By.cssSelector("div[class='title'] a[title='Tai Nghe Baseus Lark EL-01']"));
            LarkLink.click();
            //debug purpose only
            Thread.sleep(2000);
            //step 6. Check inside details correct product name;
            WebElement LarkDetail = driver.findElement(By.cssSelector("div[class='product-heading'] h1"));
            String LarkDetailText = LarkDetail.getText();
            System.out.println("Search from detail page: " + search);
            //step 7.compare product names from outside search to in details
            WebElement LarkDetails = driver.findElement(By.cssSelector("div[class='product-heading'] h1"));
            String LarkDetailsSearch = LarkDetails.getText();
            Assert.assertEquals(search, LarkDetailsSearch);
            if (search.equals(LarkDetailText)){
                System.out.println("The last Search: " + LarkDetailsSearch);
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
