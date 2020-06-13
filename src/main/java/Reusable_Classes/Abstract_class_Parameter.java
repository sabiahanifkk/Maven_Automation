package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_class_Parameter {

    // you need to set the global variables as public static in order
    //to be used in your @test classes

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;
    public static Workbook readableFile;
    //readable sheet
    public static Sheet readableSheet;
    //writable workbook
    public static WritableWorkbook writableFile;
    //writable sheet
    public static WritableSheet wSheet;

    //define before suite to set a static driver

    @BeforeSuite
    public void defineDriver(){


        //define the report path as usual
        reports = new ExtentReports("src//main//java//TestReport.html",true);


    }//end of before suite

    //before method will be used to capture a unique @test name that you gave on your test class
    @Parameters("Browser")
    @BeforeMethod
    public void getMethodName(Method methodName, String Browser) throws IOException, InterruptedException {
        if(Browser.equalsIgnoreCase("Chrome")){
        driver = Reusable_Library_Loggers.setDriver();
    }else if(Browser.equalsIgnoreCase("Firefox")){
        System.setProperty("webdriver.gecko.driver","src//main//resources//geckodriver");
        driver = new FirefoxDriver();
    }
    //start the logger here to capture the method name
    logger = reports.startTest(methodName.getName()+ "-" + Browser);
    }//end of before method

    //after method will end each test
    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//end of after method

    //after suite will quit and flush to your report
    @AfterSuite
    public void closeInfo() throws IOException, WriteException {
        driver.quit();
        reports.flush();

    }//end of after suite


}//end of java class
