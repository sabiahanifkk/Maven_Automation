package Yahoo_Page_Object;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Search_Result_Page extends Abstract_class {
ExtentTest logger;
    public Yahoo_Search_Result_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in page object concept
        this.logger = super.logger;
    }//end of constructor

    public Yahoo_Search_Result_Page scrollToBottom(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        logger.log(LogStatus.INFO,"Scrolling to the bottom of the page");
        jse.executeScript("scroll(0,10000)");
        return new Yahoo_Search_Result_Page(driver);
    }//end of scrolling method

    //method to capture the search number
    public Yahoo_Search_Result_Page searchNumber() throws InterruptedException {
        String searchResult = Reusable_Library_Loggers.captureText(driver,"//*[@class='compPagination']","Search Result",logger);
        String[] searchNumber = searchResult.split("Next");
        logger.log(LogStatus.INFO,"My Search number is " + searchNumber[1]);
        return new Yahoo_Search_Result_Page(driver);
    }//end of search number method

}//end of class
//it organizes your elements for a page by creating a class for each page.
//creating a class for a page and defining all the objects on that page
//if your element locator changes, you dont have to change it on all of your tests,
//but rather you change it on your page object class
//it makes it easier for other people to understand your code
//