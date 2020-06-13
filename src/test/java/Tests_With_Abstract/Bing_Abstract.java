package Tests_With_Abstract;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Bing_Abstract extends Abstract_class {

    @Test
    public void bingSearch() throws InterruptedException {
        //declare your variables into a string array

        ArrayList<String> LandMarks = new ArrayList<>();
        LandMarks.add("Eiffel Tower");
        LandMarks.add("Taj Mahal");
        LandMarks.add("Disney World");
        LandMarks.add("Stonehenge");
        LandMarks.add("Pyramids");

        //start your loop to enter the values and print results

        for (int i = 0; i < LandMarks.size(); i++){
            //open Bing.com
            logger.log(LogStatus.INFO,"Navigating to www.bing.com");
            driver.navigate().to("https://www.bing.com");

            //maximize browser
            logger.log(LogStatus.INFO,"Maximizing window");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            //enter the data into the search field and hit enter
            Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[@id='sb_form_q']",LandMarks.get(i),"Search Field",logger);
            Thread.sleep(3000);

            //capture the result
            String myResults = Reusable_Library_Loggers.captureText(driver,"//*[@class='sb_count']","Result text upon searching "+LandMarks.get(i),logger);

            //Split the text to just print out the number
            String[] resultArray = myResults.split(" ");

            //Print the result
            System.out.println("when I searched for " + LandMarks.get(i) + " I got " +resultArray[0] + " results. ");

        }//end of loop
    }//end of main method
}//end of java class

