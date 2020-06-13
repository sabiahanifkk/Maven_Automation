package Tests_With_Abstract;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Weightwatchers_Abstract extends Abstract_class {


    @Test
    public void weightWatchersLocation() throws InterruptedException {
        //define the elements here so you can call these in the loop
        String findLocation = "//*[@data-e2e-name='find_a workshop']";
        String searchBar = "//*[@name='meetingSearch']";
        String schButton = "//*[@class='btn spice-translated']";
        String results = "//*[@class='meeting-location__top']";
        String address = "//*[@class='location__container']";
        String schedule = "//*[@class='meeting-schedule__schedule']";

        //put the zip codes into an array variable

        ArrayList<String> myZip = new ArrayList<>();
        myZip.add("11218");
        myZip.add("11230");
        myZip.add("10463");
        //open weightwatchers
        logger.log(LogStatus.INFO,"navigating to weightwatchers homepage");
        driver.navigate().to("https://www.weightwatchers.com");

        Reusable_Library_Loggers.verifyTitle(driver,"WW (Weight Watchers): Weight Loss & Wellness Help | WW USA",logger);

        //start loop to search each zip code
        for (int i = 0;i<myZip.size();i++)  {
            logger.log(LogStatus.INFO,"navigating to weightwatchers homepage");
            driver.navigate().to("https://www.weightwatchers.com");

            logger.log(LogStatus.INFO,"maximizing window");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            Reusable_Library_Loggers.click(driver,findLocation,"Find a Workshop",logger);
            Thread.sleep(3000);

            Reusable_Library_Loggers.userKeys(driver,searchBar,myZip.get(i),"Zip Field",logger);
            Thread.sleep(3000);

            Reusable_Library_Loggers.submit(driver,schButton,"Search Button",logger);
            Thread.sleep(3000);

            //set condition to print the desired result address and capture the schedule table
            if (i == 0)         {
                //click on 2nd location
                Reusable_Library_Loggers.mouseClickMulti(driver,results,"Address result",1,logger);
                Thread.sleep(3000);
                //define the string here so you can shorten your print line
            }else if (i == 1)   {
                Reusable_Library_Loggers.mouseClickMulti(driver,results,"Address result",2,logger);
                Thread.sleep(3000);
            }else if (i == 2)   {
                Reusable_Library_Loggers.mouseClickMulti(driver,results,"Address result",0,logger);
                Thread.sleep(3000);
            }//end of if statement

            Reusable_Library_Loggers.captureText(driver,address,"Address for "+myZip.get(i),logger);
            Thread.sleep(3000);
            Reusable_Library_Loggers.captureText(driver,schedule,"Schedule for "+myZip.get(i),logger);
            Thread.sleep(3000);

        }//end of loop

    }//end of main method

}//end of class





