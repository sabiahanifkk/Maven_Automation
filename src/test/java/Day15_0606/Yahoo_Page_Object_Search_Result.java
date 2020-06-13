package Day15_0606;

import Reusable_Classes.Abstract_class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Yahoo_Page_Object_Search_Result extends Abstract_class {
    @Test
    public void Yahoo_Search_Result() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigating to homepage");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2500);
        //enter value in search field
        Yahoo_Base_Class.yahoo_homepage().searchField("cars");
        //click on search icon
        Yahoo_Base_Class.yahoo_homepage().searchIcon();
        Thread.sleep(2500);
        //scroll to bottom for the search results
        Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
        //capture the search result number
        Thread.sleep(2500);
        Yahoo_Base_Class.yahoo_search_result_page().searchNumber();

    }//end of test method

}//end of java class
