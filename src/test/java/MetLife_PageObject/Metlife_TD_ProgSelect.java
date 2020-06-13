package MetLife_PageObject;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_TD_ProgSelect extends Abstract_class {
    ExtentTest logger;
    //Constructor
    public Metlife_TD_ProgSelect(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor

    //method for coverage selection
    public Metlife_TD_ProgSelect ppoSelect(String userinput){
        Reusable_Library_Loggers.mouseClick(driver, "//*[@class='" +userinput+  "']", "Dental Program selection", logger);
        return new Metlife_TD_ProgSelect(driver);
    }//end of PPO-Select method

   //method for "enroll in program now" button
    public Metlife_TD_ProgSelect enrollinProg(){
        Reusable_Library_Loggers.mouseClick(driver, "//*[@id='topenrolltab']", "Enroll in Program Now button", logger);
        return new Metlife_TD_ProgSelect(driver);
    }//end of enroll in program method

    //method for referral code field
    public Metlife_TD_ProgSelect refCodeField(String userInput){
        Reusable_Library_Loggers.userKeys(driver, "//*[@id='txtBxPromocode']", userInput, "Referral Code Field", logger);
        return new Metlife_TD_ProgSelect(driver);
    }//end of referral code field method

    //method for "GO" button
    public Metlife_TD_ProgSelect goButton(){
        Reusable_Library_Loggers.mouseClick(driver, "//*[@name='btnEnroll']", "Go button", logger);
        return new Metlife_TD_ProgSelect(driver);
    }//end of "GO" button method

    //method for error message
    public Metlife_TD_ProgSelect errMsg(){
        Reusable_Library_Loggers.captureText(driver, "//*[@id='lblRefCodeError']", "error message", logger);
        return new Metlife_TD_ProgSelect(driver);
    }//end of error message method

    //method for "enroll without referral code" button
    public Metlife_TD_ProgSelect skipRefButton(){
        Reusable_Library_Loggers.mouseClick(driver, "//*[contains(text(),'Enroll without a Referral Code')]", "enroll without code", logger);
        return new Metlife_TD_ProgSelect(driver);
    }//end of "enroll without referral code" button

}//end of class
