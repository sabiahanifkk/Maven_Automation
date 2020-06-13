package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionItem_Bing {

    public static void main(String[] args) throws InterruptedException {
        //Set the Chrome Driver Path
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/Java Test/src/Resource/chromedriver");

        //declare and set the driver
        WebDriver driver = new ChromeDriver();

        //declare your variables into a string array
        String[] LandMarks = new String[5];
        LandMarks[0] = "Eiffel Tower";
        LandMarks[1] = "Taj Mahal";
        LandMarks[2] = "Disney World";
        LandMarks[3] = "Stonehenge";
        LandMarks[4] = "Pyramids";

        //start your loop to enter the values and print results

        for (int i = 0; i < LandMarks.length; i++){
            //open Bing.com
            driver.navigate().to("https://www.bing.com");

            //maximize browser
            driver.manage().window().maximize();

            Thread.sleep(3000);

            //enter the data into the search field
            driver.findElement(By.id("sb_form_q")).sendKeys(LandMarks[i]);

            //click enter
            driver.findElement(By.id("sb_form_go")).submit();
            Thread.sleep(3000);

            //capture the result
            String myResults = driver.findElement(By.className("sb_count")).getText();
            //Split the text to just print out the number
            String[] resultArray = myResults.split(" ");

            //Print the result
            System.out.println("when I searched for " + LandMarks[i] + " I got " +resultArray[0] + " results. ");

        }//end of loop


        //quit browser
        driver.quit();



    }//end of main method
}//end of java class

