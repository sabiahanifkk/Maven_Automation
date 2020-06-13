package MetLife_PageObject;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_TD_ProgApp extends Abstract_class {
    ExtentTest logger;
    //Constructor
    public Metlife_TD_ProgApp(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor
    String result = null;
    //method for confirmation header text
    public Metlife_TD_ProgApp confirmHeader(){
        Reusable_Library_Loggers.captureText(driver, "//*[@class='col-sm-8']", "Confirmation message",logger);
        return new Metlife_TD_ProgApp(driver);
    }//end of confirmation header text method
}//end of class
