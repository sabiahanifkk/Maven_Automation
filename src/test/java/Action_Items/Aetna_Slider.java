package Action_Items;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Aetna_Slider {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver");


        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.aetna.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);



        Reusable_Library.verifyTitle(driver,"Health Insurance Plans | Aetna");

//        String title = driver.getTitle();
//        String actTitle = "Health Insurance Plans | Aetna";
//
//        if (title.equals(actTitle))     {
//            System.out.println("Title matches requirement");
//        }else   {
//            System.out.println("Title does not match");
//        }//end of if statement

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

            driver.navigate().to("https://www.aetna.com");
            driver.manage().window().maximize();

            //click on shop for a plan
            try {
                WebElement shopPlan = driver.findElement(By.xpath("//*[contains(text(),'Shop for a plan')]"));
                shopPlan.click();
            } catch (Exception e) {
                System.out.println("unable to click shop for a plan " + e);
            }//end of shop for a plan exception
            Thread.sleep(4000);
            //click on medicare link
            try {
                WebElement medicare = driver.findElement(By.xpath("//*[contains(text(),'Medicare')]"));
                medicare.click();


            } catch (Exception e) {
                System.out.println("unable to click on medicare " + e);
            }//end of medicare exception
            Thread.sleep(4000);
            //click on find a doctor
            try {
                WebElement findDoc = driver.findElement(By.xpath("//*[@data-analytics-name='Find a doctor']"));
                findDoc.click();

            } catch (Exception e) {
                System.out.println("unable to click on Find a Doctor " + e);
            }//end of find a doctor exception
            Thread.sleep(4000);
            //click on 2020 plans you purchase yourself
            try {
                WebElement guestPlan = driver.findElement(By.xpath("//*[contains(text(),'2020 Medicare plans you purchase yourself')]"));
                guestPlan.click();

            } catch (Exception e) {
                System.out.println("unable to click on guest plan " + e);
            }//end of guest plan selection exception
            Thread.sleep(4000);
            //clear and enter zip code
            try {
                WebElement enterZip = driver.findElement(By.xpath("//*[@placeholder='Enter location here']"));
                enterZip.clear();
                enterZip.sendKeys(zipCode.get(i));

            } catch (Exception e) {
                System.out.println("unable to enter zip code " + e);
            }//end of zip code field exception
            Thread.sleep(4000);
            //click on the matching zipcode from drop down
            try {

            WebElement zipMatch = driver.findElement(By.xpath("//*[@ng-click='selectMatch(match.model.id)']"));
            zipMatch.click();

            } catch (Exception e) {
                System.out.println("unable to click on matching zipcode " + e);
            }//end of selecting from drop down exception
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
