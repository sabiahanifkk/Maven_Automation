package MetLife_PageObject;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_TD_Zip extends Abstract_class {
    ExtentTest logger;
    //Constructor
    public Metlife_TD_Zip(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor

    //method for zipCode field
    public Metlife_TD_Zip zipcodeField(String userinput){
        Reusable_Library_Loggers.userKeys(driver, "//*[@placeholder='Enter Zip Code']", userinput, "Zip Code Field", logger);
        return new Metlife_TD_Zip(driver);
    }//end of zipcode field method

    //method for "Go" button
    public Metlife_TD_Zip goButton(){
        Reusable_Library_Loggers.mouseClick(driver, "//*[@id='txtZipCodetxt']", "Go Button", logger);
        return new Metlife_TD_Zip(driver);
    }//end of "Go" button method

}//end of class

