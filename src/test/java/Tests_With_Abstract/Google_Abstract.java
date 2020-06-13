package Tests_With_Abstract;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Google_Abstract extends Abstract_class {


    @Test
    public void googleTest() throws InterruptedException, WriteException, IOException, BiffException {

        readableFile = Workbook.getWorkbook(new File("src//main//resources//Google_Search.xls"));
        readableSheet = readableFile.getSheet(0);
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Google_Search_Results.xls"), readableFile);
        wSheet = writableFile.getSheet(0);

        //navigate to google home page
        logger.log(LogStatus.INFO,"navigate to google homepage");
        driver.navigate().to("https://www.google.com");
        //maximize window
        logger.log(LogStatus.INFO,"maximizing window");
        driver.manage().window().maximize();

        int rows = wSheet.getRows();

        for (int i = 1; i < rows; i++) {
            //store your column values into a variable
            String cars = wSheet.getCell(0, i).getContents();



            //reusable library to enter car values on search field
            Reusable_Library_Loggers.userTypeAndHitEnter(driver, "//*[@name='q']", cars, "Search Field", logger);
            Thread.sleep(2500);

            String result = Reusable_Library_Loggers.captureText(driver, "//*[@id='result-stats']", "Results line for " + cars, logger);
            String[] resultArray = result.split(" ");

            Label label = new Label(1, i, resultArray[1]);
            //adding back to writable cell
            logger.log(LogStatus.INFO,"adding "+resultArray[1]+" into worksheet");
            wSheet.addCell(label);

            //navigate back to google page
            logger.log(LogStatus.INFO,"navigate to google homepage");
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2500);

        }//end of loop

        logger.log(LogStatus.INFO,"writing to new workbook");
        writableFile.write();
        logger.log(LogStatus.INFO,"closing new workbook");
        writableFile.close();
        logger.log(LogStatus.INFO,"closing old workbook");
        readableFile.close();


    }//end of test

}//end of class
