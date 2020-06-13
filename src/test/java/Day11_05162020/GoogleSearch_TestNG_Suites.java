package Day11_05162020;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;

public class GoogleSearch_TestNG_Suites {
    WebDriver driver;
    String getURL;

    //@Test(priority = 1)
    @Test
//we can set priority depending on multiple test cases
//if dependency is defined there's no need to use priority(parent/child)
    public void SearchInGoogle() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        //enter keyword car on my search field
        Reusable_Library.userKeys(driver, "//*[@name='q']", "Cars", "Search Field");
        //click on submit
        Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");
        Thread.sleep(2000);
        getURL = driver.getCurrentUrl();

    }//end of test priority 1
    //when you use dependsOn Methods in your @Test that means your second test is dependant
    //on your first test if first test fails second test will be skipped
    //on your first test if first test fails second test will be skipped
    //if all test has priorities they might or might not be dependant on each other
    //@Test(priority =2)
    @Test(dependsOnMethods = "SearchInGoogle")
    public void captureTheResult() {
        driver.navigate().to(getURL);
        String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Results");
        //split the text and print the number
        String[] arraySearch = searchResult.split(" ");
        System.out.println("My search number for car is " + arraySearch[1]);

    }//end of the google test

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }//end of AfterMethod
}//end of the java class
