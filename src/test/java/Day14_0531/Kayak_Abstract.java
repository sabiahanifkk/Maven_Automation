package Day14_0531;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_Abstract extends Abstract_class {


    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;


    @Test
    public void kayakSearch() throws InterruptedException, WriteException, IOException, BiffException {
        int row = wSheet.getRows();

        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//resources//Kayak_Search.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Kayak_Search_Results.xls"),readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);
        //defined the driver
        driver = Reusable_Library.setDriver();
        //define the report path
        reports = new ExtentReports("src//main//java//HTML_Report//Kayak_Report.html",true);

        for (int i = 1; i < row; i++)   {

            //define column values into strings
            String airport = wSheet.getCell(0,i).getContents();
            String startDate = wSheet.getCell(1,i).getContents();
            String startTime = wSheet.getCell(2,i).getContents();
            String endDate = wSheet.getCell(3,i).getContents();
            String endTime = wSheet.getCell(4,i).getContents();
            String vehicleSize = wSheet.getCell(5,i).getContents();


//            1. navigate to kayak.com //this should go inside for loop so you can re-navigate again on same page
            driver.navigate().to("https://www.kayak.com");
//            2. click on search field
            Reusable_Library_Loggers.click(driver,"//*[@aria-label='Pick-up location']","Airport Search Field",logger);
//            3. enter an airport on input field  //your airPortName column value goes here
            Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[@name='pickup']",airport,"Airport Search Field",logger);
//            4. click on enter date calendar **click on end date first because there is an issue when select start date before end i will show it in a video
            Reusable_Library_Loggers.click(driver,"//*[contains(@id,'dateRangeInput-display-end')]","End Date Input",logger);
            Thread.sleep(3000);
//            5. on calendar screen enter a future end date like next month(June) enter as format mm/dd/yyyy coming from your column endDate.  End date shouldn't exceed more than 28 days from stat date. //use  userTypeAndHitEnter method
            Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[contains(@id,'dropoff-date-input')]",endDate,"End Date input",logger);
            Thread.sleep(3000);
//            6. click somewhere outside to close the calendar screen
            Reusable_Library_Loggers.click(driver,"//*[@class='title-section']","clicking outside",logger);
            Thread.sleep(3000);
//            7. click on end time
            Reusable_Library_Loggers.click(driver,"//*[contains(@id,'dateRangeInput-end-time-select-display')]","End Time Select",logger);
            Thread.sleep(3000);
//            8. choose by clicking on an end time //your value from endTime column should be passed here as an xpath as text value
            Reusable_Library_Loggers.mouseClick(driver,"//*[contains(@id,'dateRangeInput-end-time-select')and @data-title='"+endTime+"']","end time selection",logger);
            Thread.sleep(3000);
//            9. click on start date calendar screen
            Reusable_Library_Loggers.click(driver,"//*[contains(@id,'dateRangeInput-display-start')]","start Date Input",logger);
            Thread.sleep(3000);
//            10. on calendar screen enter a future start date like next month. Follow date format mm/dd/yyyy use  userTypeAndHitEnter method for this
            Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[contains(@id,'pickup-date-input')]",startDate,"Start Date input",logger);
            Thread.sleep(3000);
//            11. click somewhere outside to close start date screen
            Reusable_Library_Loggers.click(driver,"//*[@class='title-section']","clicking outside",logger);
            Thread.sleep(3000);
//            12. choose by clicking on a start time //your value from startTime column should be passed here as an xpath as text value
            Reusable_Library_Loggers.click(driver,"//*[contains(@id,'dateRangeInput-start-time-select-display')]","Start Time Select",logger);
            Thread.sleep(3000);

            Reusable_Library_Loggers.mouseClick(driver,"//*[contains(@id,'dateRangeInput-start-time-select')and @data-title='"+startTime+"']","start time selection",logger);
            Thread.sleep(3000);
//            13. click on search icon
            Reusable_Library_Loggers.click(driver,"//*[contains(@id,'submit-wrapper')]","submit button",logger);
            Thread.sleep(3000);
//            14. click on checkbox to select size //should be stored on xpath from column vehicleSize
            Reusable_Library_Loggers.click(driver,"//*[@id='cars-topFilter-"+vehicleSize+"-checkbox_label']","Vehicle size checkbox",logger);
            Thread.sleep(3000);

//            15. click on second index for 'View Deal' on first available car appears on the picture //use clickByindex method for this
            Reusable_Library_Loggers.clickByIndex(driver,"//*[contains(text(),'View Deal')]",1,"Second Result",logger);
            Thread.sleep(3000);
//           16. new tabs open so you need to switch to new tab using arraylist
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
//           17. on new tab i want you to capture car info and pass that info to vehicleInfo on excel //vehicle info is to capture arrival and departure info

            Thread.sleep(4000);
            String summary = Reusable_Library.captureText(driver,"//*[@class='Checkout-Car-Book-Main-CarSummary' or contains(@id,'res_summary_collapse')]","Summary");
            Thread.sleep(3000);

            Label label = new Label(6,i,summary);
            wSheet.addCell(label);
            Thread.sleep(3000);

            driver.switchTo().window(tabs.get(0));

//           18 use manage.deleteallcookies command inside loop to c learcache
            driver.manage().deleteAllCookies();

        }//end of loop


        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of Kayak test





}//end of class


