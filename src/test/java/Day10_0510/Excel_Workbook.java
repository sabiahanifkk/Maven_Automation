package Day10_0510;

import Reusable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Excel_Workbook {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //STEP 1:
        //Locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Google_Search"));


        //STEP 2:
        //Locate the worksheet
        Sheet readableSheet = readableFile.getSheet(0);


        //STEP 3:
        //we need to create a writeable workbook to mimic readable file because we shouldn't be writing on readable file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/Resource/Google_Search_Results"),readableFile);
        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableSheet.getRows();

        //define the web driver using reusable library
        WebDriver driver = Reusable_Library.setDriver();

        //define the for loop
        for(int i = 1; i < rows; i++){
            //STEP 4
            //store the cars column values as a string variable
            //columns are always hardcoded whereas the rows are dynamic based on your i
            String category = writableSheet.getCell(0,i).getContents();


            //navigate to google page
            driver.navigate().to("https://www.google.com");
            //timeout
            Thread.sleep(2500);

            //reusable library to enter car values on search field
            Reusable_Library.userKeys(driver,"//*[@name='q']",category,"Search Field");

            //timeout
            Thread.sleep(2500);

            String result = Reusable_Library.captureText(driver,"//*[@id='result-stats']","Search Result");
            String[] resultArray = result.split(" ");
            System.out.println("My search number is " + resultArray[1]);

            //STEP 5:
            //write the search number result back to writable sheet
            Label label = new Label(1,i,resultArray[1]);
            //adding back to writable cell
            writableSheet.addCell(label);

        }//end of loop

        //outside of the loop we need to write and close the excel
        writableFile.write();
        writableFile.close();
        readableFile.close();



    }//end of main



}//end of Java class








