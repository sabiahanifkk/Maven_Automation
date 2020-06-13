package Tests_With_Abstract;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Aetna_Slider_Abstract extends Abstract_class {

    @Test
    public void aetnaSlider() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigating to www.aetna.com");
        driver.navigate().to("https://www.aetna.com");
        logger.log(LogStatus.INFO,"maximizing window");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        Reusable_Library_Loggers.verifyTitle(driver,"Health Insurance Plans | Aetna",logger);


        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10463");
        zipCode.add("10012");


        int[] sliderVal = new int[3];
        //27 Miles
        sliderVal[0] = 10;
        //43 Miles
        sliderVal[1] = 50;
        //64 Miles
        sliderVal[2] = 100;

        for (int i = 0; i < zipCode.size(); i++) {

            logger.log(LogStatus.INFO,"Navigating to www.aetna.com");
            driver.navigate().to("https://www.aetna.com");
            logger.log(LogStatus.INFO,"maximizing window");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            //click on shop for a plan
            Reusable_Library_Loggers.mouseClick(driver,"//*[contains(text(),'Shop for a plan')]","Shop for a plan option",logger);
            Thread.sleep(4000);


            //click on medicare link
            Reusable_Library_Loggers.mouseClick(driver,"//*[contains(text(),'Medicare')]","Medicare option",logger);
            Thread.sleep(4000);

            //click on find a doctor
            Reusable_Library_Loggers.mouseClick(driver,"//*[@data-analytics-name='Find a doctor']","find a doctor option",logger);
            Thread.sleep(4000);

            //click on 2020 plans you purchase yourself
            Reusable_Library_Loggers.mouseClick(driver,"//*[contains(text(),'2020 Medicare plans you purchase yourself')]","2020 medicare plans option",logger);
            Thread.sleep(4000);

            //clear and enter zip code
            Reusable_Library_Loggers.clear(driver,"//*[@placeholder='Enter location here']","ZipCode Field",logger);
            Thread.sleep(1000);
            Reusable_Library_Loggers.userKeys(driver,"//*[@placeholder='Enter location here']",zipCode.get(i),"ZipCode Field",logger);
            Thread.sleep(4000);

            //click on the matching zipcode from drop down
            Reusable_Library_Loggers.mouseClick(driver,"//*[@ng-click='selectMatch(match.model.id)']","Matching Zip Code",logger);
            Thread.sleep(4000);

            //automate slider
            try {


                WebElement slide = driver.findElement(By.xpath("//*[@class='rz-pointer rz-pointer-min']"));
                Actions actions = new Actions(driver);
                //clear the slider
                actions.dragAndDropBy(slide,(int)-150,0).perform();
                actions.sendKeys().perform();

                //move the slider to the value in array
                actions.dragAndDropBy(slide, (int) (sliderVal[i]*4.67),0).perform();
            } catch (Exception e) {
                System.out.println("unable to drag slider " + e);
            }
            Thread.sleep(5000);
            //click on skip plan selection
            try     {
                WebElement skipPlan = driver.findElement(By.xpath("//*[@class='primaryPurple BtnWidth col-md-6 col-xs-12']"));
                skipPlan.click();

            }   catch (Exception e)     {
                System.out.println("Unable to click on skip plan selection " + e);
            }//end of skip plan exception
            Thread.sleep(3000);
            //click on "Medical Doctors & Specialists"
            try     {


                WebElement medDocSpec = driver.findElement(By.xpath("//*[@title='Medical Doctors & Specialists']"));
                medDocSpec.click();

            }   catch (Exception e)     {
                System.out.println("Unable to click on Medical Doctors and Specialists" + e);
            }//end of medical doctor and specialists exception
            Thread.sleep(3000);
            //click on "Doctors (Primary Care)"
            try     {
                WebElement docPrimary = driver.findElement(By.xpath("//*[contains(text(),'Doctors (Primary Care)')]"));
                docPrimary.click();

            }   catch (Exception e)     {
                System.out.println("Unable to click on Doctors (Primary Care)" + e);
            }//end of Doctors (Primary Care) exception
            Thread.sleep(3000);
            //Click on "All Primary Care Physicians"
            try     {
                WebElement allPrimary = driver.findElement(By.xpath("//*[@title='All Primary Care Physicians']"));
                allPrimary.click();

            }   catch (Exception e)     {
                System.out.println("unable to click on All primary care physicians " + e);
            }//end of All Primary Care Physicians exception
            Thread.sleep(5000);
            try     {
                List<WebElement> results = driver.findElements(By.xpath("//*[@class='col-xs-12 pad0 dataGridRow']"));
                String firstResult = results.get(0).getText();

                System.out.println(firstResult);
            }   catch (Exception e)     {
                System.out.println("Unable to capture provider/facility information " + e);
            }//end of print provider facility exception
            Thread.sleep(3000);
            driver.close();


        }//end of for loop









    }//end of main method
}//end of java class
