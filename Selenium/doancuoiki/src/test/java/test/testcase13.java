package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
Test Steps:
1. Goto https://ttgshop.vn/
2. Click on PC menu
3. In the list of all PC , read the cost of PC TTG RTX 3070TI  (which is 13,990,000₫)
4. Click on PC CypherI5
5. Read the PC CypherI5 from detail page.
6. Compare Product value in list and details page should be equal (which is 13,990,000₫).
*/



public class testcase13 {
    @Test
    public static void testCostEqual() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            // Step1. Goto https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");

            // Step2. Click on PC menu
            driver.findElement(By.cssSelector("a[title='PC - Máy tính chơi game , Làm việc']")).click();


            // Step3. In the list of all PC , read the cost of PC TTG Cypher I5 (which is 13,990,000₫)
            WebElement CypherI5 = driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > span:nth-child(1)"));
            String CypherI5Price = CypherI5.getText();
            System.out.println("CypherI5 price from list page: " + CypherI5Price);

            //Step4. Click on PC CypherI5
            WebElement CypherI5Link = driver.findElement(By.cssSelector("div[id='collection_loop_1'] a[class='quickview-product']"));
            CypherI5Link.click();
            //debug purpose only
            Thread.sleep(2000);

            //Step5. Read the PC CypherI5 from detail page.
            WebElement CypherI5DetailPrice = driver.findElement(By.cssSelector(".pro-price"));
            String CypherI5DetailPriceText = CypherI5DetailPrice.getText();
            System.out.println("CypherI5 price from detail: " + CypherI5Price);

            // Step6. Compare Product value in list and details page should be equal (which is 13,990,000₫)
            WebElement CypherI5Details = driver.findElement(By.cssSelector(".pro-price"));
            String CypherI5DetailsPrice = CypherI5Details.getText();
            Assert.assertEquals(CypherI5Price, CypherI5DetailsPrice);
            if (CypherI5Price.equals(CypherI5DetailPriceText)){
                System.out.println("The cost is equal: " + CypherI5DetailsPrice);
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