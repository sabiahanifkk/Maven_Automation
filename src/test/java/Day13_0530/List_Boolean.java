package Day13_0530;

import Reusable_Classes.Reusable_Library;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean {

    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
        //define the report path here as a before suite
        reports = new ExtentReports("src//main//java//HTML_Report//AutomationReport.html",true);



    }//end of before method

    @Test
    public void yahoo_verification() throws InterruptedException    {

        //define and start the test
        logger = reports.startTest("Yahoo verification");
        //navigate to yahoo home page
        logger.log(LogStatus.INFO,"Getting the list count for all links");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(4000);
        //I want to count all the links in yahoo home page and print it
        logger.log(LogStatus.INFO,"Getting the list count for all links");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //verify if the linkCount returns you 12 clicks
        if (linkCount.size() == 12) {
            System.out.println("My yahoo home page link count matches and it is " + linkCount.size());
            logger.log(LogStatus.PASS,"My Yahoo home page link count matches and it is " + linkCount.size());
        }else   {
            System.out.println("My yahoo home page link count doesn't match and the actual count is " + linkCount.size());
            logger.log(LogStatus.FAIL,"My Yahoo home page link count doesnt match and it is " + linkCount.size());

        }//end of if else
        //click on sign in link
        Reusable_Library.click(driver,"//*[@id='header-signin-link']","Sign in");
        //wait
        Thread.sleep(5000);
        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == true){
            System.out.println("Stay signed in checkbox is selected by default");
            logger.log(LogStatus.PASS,"Checkbox is selected by default");
        }else   {
            System.out.println("Stay signed in checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"Checkbox is not selected by default");


        }//end of if else

        reports.endTest(logger);
    }//end of test method


    @AfterSuite
    public void closeSession()  {
        //driver.quit();
        //flushing = writing the logs(loggers) back to your automation report that you defined
        reports.flush();
    }//end of after suite



}//end of main


