package Action_Items;

import Reusable_Classes.Express_Reusable_Methods;
import Reusable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class Express_Checkout {

    public static void main(String[] args) throws Exception {
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Express_Data.xls"));
        Sheet readableSheet = readableFile.getSheet(0);

        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src/Resource/Express_Data_results.xls"),readableFile);
        WritableSheet writableSheet = writeableFile.getSheet(0);

        int rows = writableSheet.getRows();
        int columns = writableSheet.getColumns();

        WebDriver driver = Reusable_Library.setDriver();

        for (int i = 1; i < rows; i ++) {

            String size = writableSheet.getCell(0,i).getContents();
            String qty = writableSheet.getCell(1,i).getContents();
            String firstName = writableSheet.getCell(2,i).getContents();
            String lastName = writableSheet.getCell(3,i).getContents();
            String email = writableSheet.getCell(4,i).getContents();
            String phoneNum = writableSheet.getCell(5,i).getContents();
            String stAdd = writableSheet.getCell(6,i).getContents();
            String zipCode = writableSheet.getCell(7,i).getContents();
            String city = writableSheet.getCell(8,i).getContents();
            String state = writableSheet.getCell(9,i).getContents();
            String credNum = writableSheet.getCell(10,i).getContents();
            String exMonth = writableSheet.getCell(11,i).getContents();
            String exYear = writableSheet.getCell(12,i).getContents();
            String cvv = writableSheet.getCell(13,i).getContents();


                //1. navigate to express home
                driver.navigate().to("https://www.express.com");
                driver.manage().window().maximize();
            Thread.sleep(3000);
                //2. hover to Women tab  //be sure to use your mouseHover method you created
                //3. click on Dresses   //be sure to use your mouseClick method you created
                Express_Reusable_Methods.mouseHover(driver,"//*[@role='menuitem']","Women Tab");
            Thread.sleep(3000);
                Express_Reusable_Methods.mouseClick(driver,"//*[contains(text(),'Dresses')]","Dresses Option");
            Thread.sleep(3000);
                //4. click on first dress only
                Express_Reusable_Methods.mouseClick(driver,"//*[@class='_3TJgM'][2]","First Dress");
            Thread.sleep(3000);
                //5. on next page select a size //this is where you will pass the value from size column in your xpath on click method
                //6. click on ADD TO BAG
                Express_Reusable_Methods.mouseClick(driver,"//*[@value='"+size+"']","Size Button");
                Express_Reusable_Methods.mouseClick(driver,"//*[contains(text(),'Add to Bag')]","Add to bag button");
            Thread.sleep(3000);
                //7. on top right hover to bag icon //use mouse hover method
                //8. click on View Bag &Checkout button
                //9. select a quantity  //this where you will pass the value from quantity on your dropdown method

                Express_Reusable_Methods.mouseHover(driver,"//div[3]/div[1]/button[1]","Shopping bag icon");

            Thread.sleep(3000);
                Express_Reusable_Methods.mouseClick(driver,"//*[contains(text(),'View Bag & Check Out')]","View Bag button");
            Thread.sleep(3000);
                Reusable_Library.dropdownByText(driver,"//select[@id='qdd-0-quantity']",qty,"Quantity Drop Down");

                //10. click on checkout
                //11. click on continue as guest
                Express_Reusable_Methods.mouseClick(driver,"//*[@id='continue-to-checkout']","CHECKOUT button");
            Thread.sleep(3000);
                Express_Reusable_Methods.mouseClick(driver,"//*[contains(text(),'Continue as Guest')]","CONTINUE AS GUEST button");
            Thread.sleep(3000);
                //12. enter first name //this is where you will pass the value from firstName column
                //13. enter last name //this is where you will pass the value from lastName column
                //14. enter email //this is where you will pass the value from email column
                //15. re enter email //this is where you will pass the same value from email column
                //16. enter 10 digit valid/invalid phone number// this is where you will pass the value from phoneNumber column

                Reusable_Library.userKeys(driver,"//*[@name='firstname']",firstName,"First Name input field");
                Reusable_Library.userKeys(driver,"//*[@name='lastname']",lastName,"Last Name input field");
                Reusable_Library.userKeys(driver,"//*[@name='email']",email,"Email input field");
                Reusable_Library.userKeys(driver,"//*[@name='confirmEmail']",email,"Confirm Email input field");
                Reusable_Library.userKeys(driver,"//*[@name='phone']",phoneNum,"phone input field");
                Express_Reusable_Methods.mouseClick(driver,"//*[contains(text(),'Continue')]","Continue Button");
            Thread.sleep(3000);
                //17. enter street address //this is where you will pass value from streeAdd column
                //18. enter postal code //this is where you will pass valid 5 digit zip code from you postalCode column
                //19. enter valid city //this is where you will pass valid city from city column
                //20. select state //leave state as New York only from your state column
                Reusable_Library.userKeys(driver,"//*[@name='shipping.line1']",stAdd,"street address input field");
                Reusable_Library.userKeys(driver,"//*[@name='shipping.postalCode']",zipCode,"zip code input field");
                Reusable_Library.userKeys(driver,"//*[@name='shipping.city']",city,"city input field");
                Reusable_Library.dropdownByText(driver,"//*[@name='shipping.state']",state,"state drop down selector");

                //21. click on Continue button
                //22. click on Continue button again
                Express_Reusable_Methods.mouseClick(driver,"//*[contains(text(),'Continue')]","Continue Button");
            Thread.sleep(3000);
                Express_Reusable_Methods.mouseClick(driver,"//*[contains(text(),'Continue')]","Continue Button");

                //23. enter invalid card number //coming from your cardNumber column
                //24. select exp month //coming from expiration month column
                //25. select exp year //coming from your expiration year column
                //26. enter 3 digit cvv //coming from your cvv column
                Reusable_Library.userKeys(driver,"//*[@name='creditCardNumber']",credNum,"credit card input field");
                Reusable_Library.dropdownByText(driver,"//select[@name='expMonth']",exMonth,"expiration month field");
                Reusable_Library.dropdownByText(driver,"//select[@name='expYear']",exYear,"expiration year drop down selector");
                Reusable_Library.userKeys(driver,"//*[@name='cvv']",cvv,"cvv input field");


                //27. click on place order
                Express_Reusable_Methods.mouseClick(driver,"//*[contains(text(),'Place Order')]","Place order Button");
            Thread.sleep(3000);
                //28. an error message will appear i want you to capture that and send it back to excel on errorMessage column
                String message = Reusable_Library.captureText(driver,"//*[@id='rvn-note-NaN']","Error Message");
            Thread.sleep(3000);
                Label error = new Label(14,i,message);
                writableSheet.addCell(error);


                //29. at the end of your test steps before closing the for loop type the following command to delete all cookies
                driver.manage().deleteAllCookies();
            Thread.sleep(3000);
        }
        //outside of the loop we need to write and close the excel

        Thread.sleep(3000);
        writeableFile.write();
        writeableFile.close();
        readableFile.close();



    }












}
