package Day4_0419;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_Test {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at least once in one of your main methods
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/Java Test/src/Resource/chromedriver");

        //you declare and define the driver
        WebDriver driver = new ChromeDriver();
        //opening the browser automatically to go to google home page
        //driver.get("https://www.google.com");


        driver.navigate().to("https://www.google.com");

        //maximize your browser
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //locate the search field by inspecting it first and then enter a keyword "cars"
        driver.findElement(By.name("q")).sendKeys("cars");
        Thread.sleep(3000);


        //click on google search
        driver.findElement(By.name("btnK")).submit();

        Thread.sleep(3000);

        String locator = "//*[@id='result-stats']";
        String schResult =  driver.findElement(By.xpath(locator)).getText();
        //using array variable to split the message

        String[] arrayResult = schResult.split(" ");


        ArrayList<String> cars = new ArrayList<>();
        cars.add("");
        cars.add("");
        cars.add("");


        System.out.println("My search number is " + arrayResult[1]);





        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        //i prefer to use quit

        //driver.quit();







    }//end of main method

}//end of java class
