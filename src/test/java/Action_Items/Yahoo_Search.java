package Action_Items;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Yahoo_Search extends Abstract_class {

    @Test
    public void QA_Search() throws InterruptedException {
        String text = "Middle Ages";


        logger.log(LogStatus.INFO,"Navigating to Yahoo.com");
        driver.navigate().to("https://www.yahoo.com");
        logger.log(LogStatus.INFO,"Maximizing window");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //search for QA
        Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[@id='header-search-input']","QA","Yahoo Search Field",logger);
        Thread.sleep(2000);
        //click on wikipedia link
        Reusable_Library_Loggers.mouseClick(driver,"//*[contains(text(),'Wikipedia')]","QA Wikipedia Link",logger);
        Thread.sleep(3000);
        //create condition for text "Middle Ages"
        if (driver.getPageSource().contains(text))     {
            System.out.println("The web page includes the text " +text);
            logger.log(LogStatus.PASS,"The web page includes the text " +text);
        }else   {
            System.out.println("The web page does not include the text " +text);
            logger.log(LogStatus.FAIL,"The web page does not include the text " +text);
        }//end of if statement


    }//end of Test


}//end of class
