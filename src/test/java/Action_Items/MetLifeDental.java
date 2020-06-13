package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class MetLifeDental {
    public static void main(String[] args) throws InterruptedException {

        //Set the property
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver");
        //chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        //define the driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to website to test title tab
        driver.navigate().to("https://www.metlife.com");
    Thread.sleep(5000);
        //maximize window
        driver.manage().window().maximize();
        //test tab title
        try {
            String tabTitle = "Insurance & Employee Benefit | Metlife";
            String actTitle = driver.getTitle();

            if (tabTitle.equals(actTitle)){
                System.out.println("Title matches requirement");
            }   else    {
                System.out.println("Title does not match requirement");
            }

        }   catch (Exception e)     {
            System.out.println("Unable to test title");
        }

        //array for ZipCode, PPO, and, referral code



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


        //define mouse actions
        Actions mouse = new Actions(driver);



        for (int i = 0;i<zipCode.size();i++)     {

            driver.navigate().to("https://www.metlife.com");
        Thread.sleep(5000);
            driver.manage().window().maximize();

        Thread.sleep(5000);


            //hover over "SOLUTIONS" tab
            try     {
                WebElement solutions = driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]"));
                solutions.click();
            }   catch (Exception e)     {
                System.out.println("Unable to hover on SOLUTIONS " + e);
            }//end of SOLUTIONS exception


            //click on "MetLife TakeAlong Dental"
            try     {
                WebElement takeAlong = driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]"));
                mouse.click(takeAlong).perform();
            }   catch (Exception e)     {
                System.out.println("Unable to click on MetLife TakeAlong Dental" + e);
            }//end of TakeAlong Dental exception

        Thread.sleep(5000);

            //click on "Enroll Now"
            try     {
                WebElement enrollNow = driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]"));
                mouse.click(enrollNow).perform();
            }   catch (Exception e)     {
                System.out.println("Unable to click on 'Enroll Now'" + e);
            }//end of Enroll Now exception


            //switch to new tab that opens
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
        Thread.sleep(5000);
            //enter zip code (also put in a clear command for previously entered data)

            try {
                WebElement zipField = driver.findElement(By.xpath("//*[@placeholder='Enter Zip Code']"));
                zipField.clear();
                zipField.sendKeys(zipCode.get(i));
            }  catch (Exception e) {
                System.out.println("Unable to enter on zipcode field " + e);
            }//end of Zip Code exception
        Thread.sleep(5000);

            try     {
                WebElement Go = driver.findElement(By.xpath("//*[@id='txtZipCodetxt']"));
                mouse.click(Go).perform();
            }   catch (Exception e)     {
                System.out.println("unable to click go" + e);
            }//end of click go exception

        Thread.sleep(5000);
            //click on dental program
            try     {
                ArrayList<WebElement> dentalChk = new ArrayList<>();
                dentalChk.add(driver.findElement(By.xpath("//*[@class='PPO-LOW']")));
                dentalChk.add(driver.findElement(By.xpath("//*[@class='PPO-MEDIUM']")));
                dentalChk.add(driver.findElement(By.xpath("//*[@class='PPO-HIGH']")));


                dentalChk.get(i).click();

            }   catch (Exception e)     {
                System.out.println("unable to select PPO" + e);
            }//end of PPO select exception
        Thread.sleep(5000);
            //Click on Enroll in Program Now
            try     {
                WebElement enrollProg = driver.findElement(By.xpath("//*[@id='topenrolltab']"));
                mouse.click(enrollProg).perform();

            }   catch (Exception e)     {
                System.out.println("unable to click on 'Enroll in Program Now'" + e);
            }//end of Enroll in Program Now exception

        Thread.sleep(3000);
            //enter referral code
            try     {
                WebElement refEnter = driver.findElement(By.xpath("//*[@placeholder='Enter Referral Code']"));
                refEnter.sendKeys(refCode.get(i));
            }   catch (Exception e)     {
                System.out.println("unable to enter referral code" + e);
            }//end of enter referral code exception
        Thread.sleep(3000);
            //click Go
            try     {
                WebElement btnEnroll = driver.findElement(By.xpath("//*[@name='btnEnroll']"));
                btnEnroll.click();
            }   catch (Exception e)     {
                System.out.println("unable to click go" + e);
            }//end of click go exception
        Thread.sleep(3000);
            //print error message
            try     {
                String error = driver.findElement(By.xpath("//*[@id='lblRefCodeError']")).getText();
        Thread.sleep(3000);
                System.out.println(refCode.get(i)+" is not a valid referral code. " + error);
            }   catch (Exception e)     {
                System.out.println("Unable to print error message" + e);
            }//end of print error message exception
        Thread.sleep(2000);
            //click on enroll without code
            try     {
                WebElement enrollWithout = driver.findElement(By.xpath("//*[contains(text(),'Enroll without a Referral Code')]"));
                enrollWithout.click();
            }   catch (Exception e)     {
                System.out.println("Unable to click on enroll without code" + e);
            }//end of Enroll without code exception
        Thread.sleep(3000);
            //capture and verify that it matches Dental Program

            try     {
                String confirmMessage = driver.findElement(By.xpath("//*[@class='col-sm-8']")).getText();
                String[] confirmArray = confirmMessage.split(" ");
                if (dentalProgName.get(i).equals(confirmArray[3]))      {
                    System.out.println( dentalProgName.get(i)+ " matches " + confirmArray[3]);
                }   else    {
                    System.out.println(dentalProgName.get(i)+" does not match " + confirmArray[3]);
                }
            }   catch (Exception e) {
                System.out.println("unable to capture message" + e);
            }//end of confirm message exception


            driver.switchTo().window(tabs.get(1)).close();
            driver.switchTo().window(tabs.get(0));


        }//end of loop


    }//end of main method


}//end of java class
