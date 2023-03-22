package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/*
Test Steps:
1. Go to https://ttgshop.vn/
2. Click on image go to all products
3. Stick all brand in menu list brand
4. Verify all brand had sticked
*/
public class testcase11 {
    @Test
    public static void testne3() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            // Step1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");

            // Step2. Click on image go to all products
            driver.findElement(By.cssSelector("body > div.mainBody-theme-container.mainBody-modalshow > main > section.home-productTabs.home-productTabs-1 > div > div.wrapbox.row-mg-parent > div.wrapbox--left > div > a")).click();

            // Step3. Stick all brand in menu list brand
            driver.findElement(By.cssSelector("#data-brand-p2")).click();
            //debug purpose only
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#data-brand-p3")).click();
            //debug purpose only
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#data-brand-p4")).click();
            //debug purpose only
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#data-brand-p5")).click();
            //debug purpose only
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#data-brand-p6")).click();
            //debug purpose only
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#data-brand-p7")).click();
            //debug purpose only
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#data-brand-p8")).click();
            //debug purpose only
            Thread.sleep(5000);

            // Step4. Verify all brand had sticked
            String pending = driver.findElement(By.cssSelector
                            ("#collection-body > div > div > div.col-lg-9.col-md-12.col-12.collection-content > div.collection-heading > div.collection-heading__content > div.collection-filter-tags > div > div.filter_tags.opened > b"))
                    .getText();
            AssertJUnit.assertEquals(pending,"Anker,Eufy,Mocato,Zadez,Uniq,Totu,Titan");
            if (pending.equals("Anker,Eufy,Mocato,Zadez,Uniq,Totu,Titan")) {
                System.out.println("Verify Successful All Brand : " + pending);
            }

            //debug purpose only
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //5. Quit browser session
        driver.quit();
    }
}
