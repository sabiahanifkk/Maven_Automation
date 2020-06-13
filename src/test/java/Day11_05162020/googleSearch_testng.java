package Day11_05162020;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

public class googleSearch_testng {


    WebDriver driver;
//defining the array and making it generic
    ArrayList<String> cars= new ArrayList();
    @Test
    public void googleSearch() throws InterruptedException {

        for(int i=0; i<cars.size();i++) {
            driver.navigate().to("https://www.google.com");
            Thread.sleep(3000);
            //enter keyword car on my search
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars.get(i), "Search Field");
            //click on submit

            Thread.sleep(2000);
            Reusable_Library.submit(driver,"//*[@name='btnK']","clicking submit");
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Results");
            //split the text and print the number
            String[] arraySearch = searchResult.split(" ");
            Reporter.log("searchResult");
            System.out.println("My search number for car is " + arraySearch[1]);
            Reporter.log("My search number ");
        }//end of the for loop
    }//end of the google test

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
        cars.add("BMW");
        cars.add("Lexus");

        driver = Reusable_Library.setDriver();

    }//end of BeforeMethod

    @AfterSuite
    public void quitDriver() {
        driver.quit();


    }//end of AfterMethod
}//end of the java class


