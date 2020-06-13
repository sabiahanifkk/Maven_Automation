package Tests_With_Abstract;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MetLife_Abstract extends Abstract_class {

    @Test
    public void metlifeDental() throws InterruptedException {
        //navigate to website to test title tab
        logger.log(LogStatus.INFO,"Navigating to metlife homepage");
        driver.navigate().to("https://www.metlife.com");

        //maximize window
        logger.log(LogStatus.INFO,"Maximizing window");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //test tab title
        Reusable_Library_Loggers.verifyTitle(driver, "Insurance and Employee Benefits | MetLife", logger);

        //Hover over Solutions tab
        Reusable_Library_Loggers.mouseHover(driver, "//*[contains(text(),'SOLUTIONS')]", "Solutions tab", logger);
        Thread.sleep(3000);

        //click on Metlife TAKEALONG DENTAL
        Reusable_Library_Loggers.mouseClick(driver, "//*[contains(text(),'MetLife TakeAlong Dental')]", "takealong dental button", logger);
        Thread.sleep(3000);

        //verify title
        Reusable_Library_Loggers.verifyTitle(driver, "MetLife TakeAlong Dental | MetLife", logger);

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10463");
        zipCode.add("10012");

        ArrayList<String> refCode = new ArrayList<>();
        refCode.add("1234");
        refCode.add("0000");
        refCode.add("2020");

        ArrayList<String> dentalProgName = new ArrayList<>();
        dentalProgName.add("PPO-LOW");
        dentalProgName.add("PPO-MEDIUM");
        dentalProgName.add("PPO-HIGH");

        //begin for loop
        for (int i = 0; i < zipCode.size(); i++) {

            //click on "Enroll Now"
            Reusable_Library_Loggers.mouseClick(driver, "//*[contains(text(),'Enroll Now')]", "Enroll now button", logger);
            Thread.sleep(2000);

            //switch to new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            logger.log(LogStatus.INFO,"switching to new window tab that opens");
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(3000);

            //enter zip code (also put in a clear command for previously entered data)
            Reusable_Library_Loggers.userKeys(driver, "//*[@placeholder='Enter Zip Code']", zipCode.get(i), "Zip Code Field", logger);
            Thread.sleep(2000);

            //click go
            Reusable_Library_Loggers.mouseClick(driver, "//*[@id='txtZipCodetxt']", "Go Button", logger);
            Thread.sleep(3000);

            //click on dental program
            Reusable_Library_Loggers.mouseClick(driver, "//*[@class='" + dentalProgName.get(i) + "']", "Dental Program selection", logger);
            Thread.sleep(3000);

            //Click on Enroll in Program Now
            Reusable_Library_Loggers.mouseClick(driver, "//*[@id='topenrolltab']", "Enroll in Program Now button", logger);
            Thread.sleep(2000);

            //enter referral code
            Reusable_Library_Loggers.userKeys(driver, "//*[@id='txtBxPromocode']", refCode.get(i), "Referral Code Field", logger);
            Thread.sleep(2000);

            //click Go
            Reusable_Library_Loggers.mouseClick(driver, "//*[@name='btnEnroll']", "Go button", logger);
            Thread.sleep(1500);

            //print error message
            Reusable_Library_Loggers.captureText(driver, "//*[@id='lblRefCodeError']", "error message", logger);
            Thread.sleep(2000);

            //click on enroll without code
            Reusable_Library_Loggers.mouseClick(driver, "//*[contains(text(),'Enroll without a Referral Code')]", "enroll without code", logger);
            Thread.sleep(2000);

            //capture and verify that it matches Dental Program
            String confirmMessage = Reusable_Library_Loggers.captureText(driver, "//*[@class='col-sm-8']", "Confirmation message", logger);
            String[] confirmArray = confirmMessage.split(" ");
            if (dentalProgName.get(i).equals(confirmArray[3]))  {
                System.out.println("Dental Program Matches");
                logger.log(LogStatus.PASS,"Dental Program Matches");
            }else   {
                System.out.println(dentalProgName.get(i) + " does not match " + confirmArray[3]);
                logger.log(LogStatus.FAIL,dentalProgName.get(i) + " does not match " + confirmArray[3]);
            }

            Thread.sleep(2000);
            logger.log(LogStatus.INFO,"closing driver");
            driver.close();

            logger.log(LogStatus.INFO,"switching back to previous tab");
            driver.switchTo().window(tabs.get(0));

        }//end of loop

    }//end of MetLifePPO test

}//end of class