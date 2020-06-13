package Action_Items;

import MetLife_PageObject.Metlife_Baseclass;
import Reusable_Classes.Abstract_class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Metlife_PO_Test extends Abstract_class {

    @Test
    public void Metlife_Takealong_Dental() throws InterruptedException {
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10463");
        zipCode.add("10012");

        ArrayList<String> refCode = new ArrayList<>();
        refCode.add("1234");
        refCode.add("0000");
        refCode.add("2020");

        ArrayList<String> dentalProgName = new ArrayList<>();
        dentalProgName.add("PPO-LOW");
        dentalProgName.add("PPO-MEDIUM");
        dentalProgName.add("PPO-HIGH");

        Actions actions = new Actions(driver);
        //navigate to website to test title tab
        logger.log(LogStatus.INFO,"Navigating to metlife homepage");
        driver.navigate().to("https://www.metlife.com");
        //maximize window
        logger.log(LogStatus.INFO,"Maximizing window");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //verify title
        Metlife_Baseclass.metlife_homePage().tabTitle("Insurance and Employee Benefits | MetLife");
        Thread.sleep(3000);

        //hover over solutions tab
        Metlife_Baseclass.metlife_homePage().SolutionsMenu();

        //click on takealong dental
        Metlife_Baseclass.metlife_homePage().takealongDental();
        Thread.sleep(3000);

        //verify title
        Metlife_Baseclass.metLife_td_home().tabTitle("MetLife TakeAlong Dental | MetLife");

        for (int i = 0; i < zipCode.size(); i++)    {
            //click on enroll now
            Metlife_Baseclass.metLife_td_home().enrollNow();
            Thread.sleep(2000);
            //switch to new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            //enter zip code
            Metlife_Baseclass.metlife_td_zip().zipcodeField(zipCode.get(i));

            //click go
            Metlife_Baseclass.metlife_td_zip().goButton();
            Thread.sleep(3000);

            //select plan
            Metlife_Baseclass.metlife_td_progSelect().ppoSelect(dentalProgName.get(i));

            //click on "enroll in program now"
            Metlife_Baseclass.metlife_td_progSelect().enrollinProg();
            Thread.sleep(2000);

            //enter referral code
            Metlife_Baseclass.metlife_td_progSelect().refCodeField(refCode.get(i));

            //click "GO"
            Metlife_Baseclass.metlife_td_progSelect().goButton();
            Thread.sleep(1500);

            //capture error message
            Metlife_Baseclass.metlife_td_progSelect().errMsg();
            Thread.sleep(1500);

            //click on "enroll without code"
            Metlife_Baseclass.metlife_td_progSelect().skipRefButton();

            //capture the confirmation header message and verify that it matches the test data entered
            String confirmMessage = Metlife_Baseclass.metlife_td_progApp().confirmHeader().toString();

            String[] confirmArray = confirmMessage.split(" ");
                if (dentalProgName.get(i).equals(confirmArray[3]))  {
                    System.out.println("Dental Program Matches");
                    logger.log(LogStatus.PASS,"Dental Program Matches");
                }else   {
                    System.out.println(dentalProgName.get(i) + " does not match " + confirmArray[3]);
                    logger.log(LogStatus.FAIL,dentalProgName.get(i) + " does not match " + confirmArray[3]);
                }//end of if statement

            Thread.sleep(2000);
            logger.log(LogStatus.INFO,"closing driver");
            driver.close();

            logger.log(LogStatus.INFO,"switching back to previous tab");
            driver.switchTo().window(tabs.get(0));

        }//end of for loop

    }//end of test

}//end of class
