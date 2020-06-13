package TestNG_Annotations;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class GoogleSearch_TestNG_Suites {
    WebDriver driver;
    String getUrl;
    @Test(priority = 1)
    public void SearchIngoogle() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        //enter keyword car on my search field
        Reusable_Library.userKeys(driver, "//*[@name='q']", "Cars", "Search Field");
        //click on submit
        Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");
        Thread.sleep(2000);
        getUrl = driver.getCurrentUrl();
    }//end of test priority 1

    @Test(dependsOnMethods = "SearchIngoogle")
    public void capturetheResult() throws InterruptedException {

        driver.navigate().to(getUrl);
        Thread.sleep(2000);
        //capture text and print search number
        String searchResult = Reusable_Library.captureText(driver,"//*[@id='result-stats']","Search Results");
        //split the text and print the number
        Thread.sleep(2000);
        String[] arraySearch = searchResult.split(" ");
        System.out.println("My search number for car is " + arraySearch[1]);

    }//end of google test


    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException   {
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod

    @AfterSuite
    public void quitDriver(){

    }//end of AfterMethod

}//end of class
