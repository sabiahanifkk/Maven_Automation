package Day7_0502;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Met_Life_tabs {

    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at least once in one of your main methods
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/Java Test/src/Resource/chromedriver");

        //you declare and define the driver
        WebDriver driver = new ChromeDriver();
        //opening the browser automatically to go to google home page
        //driver.get("https://www.google.com");


        driver.navigate().to("https://www.metlife.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
     try {
         driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
     }  catch (Exception e) {
         System.out.println("Unable to click on SOLUTIONS " + e);
     }//end of solutions exception

        Thread.sleep(3000);

     try    {
         driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();

     }catch (Exception e)   {
         System.out.println("Unable to click on MetLife TakeAlong Dental " + e);

     }//end of metlife takealong dental exception

     //click on enroll now
     try    {
         driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();

        }   catch (Exception e) {
         System.out.println("Unable to click on Enroll Now " + e);
        }//end of enroll now exception



        //now define the Array List to handle all current window tabs
         ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
         //switch to second tab
         driver.switchTo().window(tabs.get(1));
         //enter your zip code
         try {
             driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11218");

         }  catch (Exception e) {
             System.out.println("Unable to enter on search field " + e);
         }//end of Zip Code exception
            Thread.sleep(3000);
         //i want to close this tab
         driver.close();
         Thread.sleep(3000);
         driver.quit();

     }//end of main method

}//end of java class

