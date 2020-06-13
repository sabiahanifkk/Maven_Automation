package Day13_0530;

import Reusable_Classes.Reusable_Library;
import Reusable_Classes.Reusable_Library_Loggers;
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

public class List_Boolean_practice_htmlReport {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {


        driver = Reusable_Library.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Result.html",true);


    }//end of the before suite

    @Test
    public void operation() throws InterruptedException {
        //Title in extentReport
        logger = reports.startTest("Yahoo Automation");
        //Extent report info for navigating to yahoo
        logger.log(LogStatus.INFO, "navigating to yahoo");
        //open the yahoo browser
        driver.navigate().to("https://www.yahoo.com");


        //count the number of links in the dashboard
        List<WebElement>links= driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        System.out.println("Total number of links is "+links.size());

        if(links.size()==12){
            System.out.println("Number of the links matches and the number is "+ links.size());
            logger.log(LogStatus.PASS,"Number of the link matches and the number is "+ links.size());
        }else{
            System.out.println("Number of the links doesn't match and the number is "+ links.size());
            logger.log(LogStatus.FAIL,"Number of the link doesn't match and the number is "+ links.size());
        }//end of the if else condition

        Reusable_Library_Loggers.click(driver,"//*[@id='header-profile-menu']","Sign in",logger);
        Thread.sleep(3500);
        logger.log(LogStatus.INFO,"checking if the checkbox is selected by default");
        Boolean checkBox= driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();

        if(checkBox==true){
            System.out.println("checkbox is selected by default");
            logger.log(LogStatus.PASS,"checkbox is selected by default");
        }else{
            System.out.println("Checkbox isn't selected by default");
            logger.log(LogStatus.FAIL,"Checkbox isn't selected by default");
        }//end of the if else condition

        reports.endTest(logger);
    }//end of the test suite

    @AfterSuite
    public void quitDriver() {
        driver.quit();
        reports.flush();
    }//end of the after suite
}//end of the java class
