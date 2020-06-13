package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;


public class Abstract_Data_Driven {
    public static WebDriver driver;
    public static Workbook readableFile;
    public static Sheet readableSheet;
    public static WritableWorkbook writableFile;
    public static WritableSheet writableSheet;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Library_Loggers.setDriver();
        //define the report path as usual
        reports = new ExtentReports("src//main//java//TestReport.html", true);
    }

        @BeforeMethod
        public void getMethodName(Method methodName){
            //start the logger here to capture the method name
            logger = reports.startTest(methodName.getName());

        }//end of before method

        //after method will end each test
        @AfterMethod
        public void endTest(){
            reports.endTest(logger);
        }//end of after method

        //after suite will quit and flush to your report
        @AfterSuite
        public void closeInfo(){
            driver.quit();
            reports.flush();

        }//end of after suite




}
