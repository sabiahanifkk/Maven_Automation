package MetLife_PageObject;

import Reusable_Classes.Abstract_class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Baseclass extends Abstract_class {
    //constructor
    public Metlife_Baseclass(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }//end of constructor


    //object reference for homepage
    public static Metlife_HomePage metlife_homePage(){
        Metlife_HomePage metlife_homePage = new Metlife_HomePage(driver);
        return metlife_homePage;
    }//end of object reference

    //object reference for Takealong Dental homepage
    public static Metlife_TD_home metLife_td_home(){
        Metlife_TD_home metlife_td_home = new Metlife_TD_home(driver);
        return metlife_td_home;
    }//end of object reference

    //object reference for takealong dental search by zip page
    public static Metlife_TD_Zip metlife_td_zip(){
        Metlife_TD_Zip metlife_td_zip = new Metlife_TD_Zip(driver);
        return metlife_td_zip;
    }//end of object reference

    //object reference for Takealong Dental Programs page
    public static Metlife_TD_ProgSelect metlife_td_progSelect(){
        Metlife_TD_ProgSelect metlife_td_progSelect = new Metlife_TD_ProgSelect(driver);
        return metlife_td_progSelect;
    }//end of object reference

    //object reference for Program application start page
    public static Metlife_TD_ProgApp metlife_td_progApp(){
        Metlife_TD_ProgApp metlife_td_progApp = new Metlife_TD_ProgApp(driver);
        return metlife_td_progApp;
    }//end of object reference

}//end of class
