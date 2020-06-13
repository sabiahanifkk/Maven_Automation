package MetLife_PageObject;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_TD_home extends Abstract_class {
    ExtentTest logger;
    //constructor
    public Metlife_TD_home(WebDriver driver)    {
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor

    //method for tab title text
    public Metlife_TD_home tabTitle(String expectedTitle){
        Reusable_Library_Loggers.verifyTitle(driver, expectedTitle, logger);
        return new Metlife_TD_home(driver);
    }//end of tab title method

    //method for clicking on enroll now button
    public Metlife_TD_home enrollNow(){
        Reusable_Library_Loggers.mouseClick(driver, "//*[contains(text(),'Enroll Now')]", "Enroll now button", logger);
        return new Metlife_TD_home(driver);
    }//end of enroll now method


}//end of class
