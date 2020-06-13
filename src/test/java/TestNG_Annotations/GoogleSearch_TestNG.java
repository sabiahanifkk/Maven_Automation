package TestNG_Annotations;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleSearch_TestNG {
    WebDriver driver;
    ArrayList<String> cars = new ArrayList();


    @Test
    public void googleSearch() throws InterruptedException  {
        for (int i = 0; i < cars.size(); i++) {

            driver.navigate().to("https://www.google.com");
            //enter keyword car on my search field
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars.get(i), "Search Field");

            //click on submit
            Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");

            //capture text and print search number
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Results");
            //split the text and print the number
            String[] arraySearch = searchResult.split(" ");
            Reporter.log("My Search number for " + cars.get(i) + " is " + arraySearch[1]);
            System.out.println("My search number for car is " + arraySearch[1]);
        }//end of for loop
    }//end of google test


    @BeforeMethod
    public void callDriver() throws IOException, InterruptedException   {
        driver = Reusable_Library.setDriver();
        cars.add("BMW");
        cars.add("Lexus");
    }//end of BeforeMethod

    @AfterMethod
    public void quitDriver(){

    }//end of AfterMethod

}//end of class
