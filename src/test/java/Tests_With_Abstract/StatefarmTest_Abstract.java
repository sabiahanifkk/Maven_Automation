package Tests_With_Abstract;
import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.ArrayList;
public class StatefarmTest_Abstract extends Abstract_class {

    @Test
    public void StateFarmTest() throws InterruptedException {

    //declare and define variables
    ArrayList<String> zipCode = new ArrayList<>();
    zipCode.add("11218");
    zipCode.add("10463");

    ArrayList<String> productType = new ArrayList<>();
    productType.add("Auto");
    productType.add("Homeowners");

    for (int i = 0; i < zipCode.size(); i++) {
        //navigate to statefarm home page
        //logger.log(LogStatus.INFO, "navigating to statefarm homepage");
        driver.navigate().to("https://www.statefarm.com");
        Thread.sleep(2500);
        //call my reusable method to compare title
        Reusable_Library_Loggers.verifyTitle(driver, "Auto, Life Insurance", logger);
        Thread.sleep(2000);

        //call my reusable method to select product drop down
        Reusable_Library_Loggers.dropdownByText(driver, "//*[@id='popDropdown']", productType.get(i), "Product Type Dropdown", logger);
        Thread.sleep(2000);

        //call my reusable method to enter a zipcode
        Reusable_Library_Loggers.userKeys(driver, "//*[@id='quote-main-zip-code-input']", zipCode.get(i), "Zipcode field", logger);
        Thread.sleep(2000);

        //call my reusable method to click on quote
        Reusable_Library_Loggers.click(driver, "//*[text()='Start a quote']", "start a quote button", logger);
        Thread.sleep(2000);

        //capture the result
        Reusable_Library_Loggers.captureText(driver,"//*[@class='row-fluid h1-header' or @id='welcomeProductDescription']","Header Message",logger);

        }//end of for loop

    }//end of @Test

}//end of java class

