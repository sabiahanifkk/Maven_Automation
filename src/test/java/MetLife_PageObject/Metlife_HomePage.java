package MetLife_PageObject;

import Reusable_Classes.Abstract_class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_HomePage extends Abstract_class {
    ExtentTest logger;
    //create constructor
    public Metlife_HomePage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of constructor

    //method for tab title text
    public Metlife_HomePage tabTitle(String expectedTitle){
        Reusable_Library_Loggers.verifyTitle(driver, expectedTitle, logger);
        return new Metlife_HomePage(driver);
    }//end of tab title method

//method for Solutions tab
    public Metlife_HomePage SolutionsMenu(){
        Reusable_Library_Loggers.mouseHover(driver, "//*[contains(text(),'SOLUTIONS')]", "Solutions tab", logger);
        return new Metlife_HomePage(driver);
    }//end of Solutions tab method

//method for TakeAlong Dental option
    public Metlife_HomePage takealongDental(){
        Reusable_Library_Loggers.mouseClick(driver, "//*[contains(text(),'MetLife TakeAlong Dental')]", "takealong dental button", logger);
        return new Metlife_HomePage(driver);
    }//end of TakeAlong Dental method
}//end of class
