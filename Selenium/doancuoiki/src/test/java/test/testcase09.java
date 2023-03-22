package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.io.StringWriter;

/*
Test Steps
Step 1. Go to https://ttgshop.vn/
Step 2. Click on -> PC -> menu
Step 3. Verify Title of the page
Step 4. In the list of all products PC , select SẮP XẾP -> dropdown as name
Step 5. Verify all products are sorted by name
*/
@Test
public class testcase09 {
    @Test
    public static void testne() {
        int scc = 0;
        StringWriter verificationErrors = new StringWriter();
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://ttgshop.vn/
            driver.get("https://ttgshop.vn/");

            //debug purpose only
            Thread.sleep(5000);

            //Step 2. Click on -> PC -> menu
            driver.findElement(By.linkText("PC - Máy tính chơi game , Làm việc")).click();

            //debug purpose only
            Thread.sleep(5000);

            //Step 3. Verify Title of the page
            String demoSite = driver.findElement(By.cssSelector("h1")).getText();
            System.out.println(demoSite);
            try{
                AssertJUnit.assertEquals("PC - Máy tính chơi game , Làm việc",demoSite);
            }catch (Error e){

                verificationErrors.append(e.toString());
            }
            //debug purpose only
            Thread.sleep(5000);

            //Step 4. In the list of all products PC , select SẮP XẾP -> dropdown as name
            driver.findElement(By.cssSelector("#collection-body > div > div > div.col-lg-9.col-md-12.col-12.collection-content > div.collection-heading > div.collection-heading__content > div.dFlex-row > div.heading-sortbyfilter.d-none.d-lg-block > div > div.collection-sortby-filter > div.collection-sortby > div > p")).click();
            driver.findElement(By.cssSelector("#layered_sortby_mobile > ul > li:nth-child(4) > span")).click();

            //debug purpose only
            Thread.sleep(5000);

            //Step 5. Verify all products are sorted by name
            scc = (scc+1);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = "C:\\Study\\Tester\\selenium-dack\\img\\testcase09.png";
            FileUtils.copyFile(scrFile,new File(png));

            //debug purpose only
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //6.Quit browser session
        driver.quit();
    }
}
