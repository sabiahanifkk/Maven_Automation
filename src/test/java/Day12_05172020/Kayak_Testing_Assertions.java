package Day12_05172020;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Kayak_Testing_Assertions {
    //declare the webDriver outside of all method to be reusable
    WebDriver driver;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {

         driver = Reusable_Library.setDriver();
    }//end of before suite

    @Test
    public void KayakTestCase() throws InterruptedException {
        driver.navigate().to("https://www.kayak.com");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        //verify the title using hard assertion
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getTitle(), "Search Flights, Hotels & Rental Cars | KAYAK");

        // Assert.assertEquals("Search Fligths","Search Hotels, Cars");
      Reusable_Library.click(driver,"//*[@data-placeholder='Enter an airport or city']","clicking search field");
      Thread.sleep(2000);
      //enter the airport
        Reusable_Library.userKeys(driver, "//div[@name='pickup']", "JFK", "Search field");
//pass assertAll that way it doesn't skip all your test steps
        sAssert.assertAll();

    }//end of the test methodSearch Flights, Hotels & Rental Cars | KAYAK

    @AfterSuite
    public void closeSession() {
        driver.quit();

    }//end of after suite


}//end of the java class
