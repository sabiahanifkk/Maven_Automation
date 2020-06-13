package Day7_0502;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_Test_TryCatch {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at least once in one of your main methods
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/Java Test/src/Resource/chromedriver");

        //you declare and define the driver
        WebDriver driver = new ChromeDriver();
        //opening the browser automatically to go to google home page
        //driver.get("https://www.google.com");

        //set the arraylist for the cars
        //dont need to define the size/length of the list and dont need to define the index numbers
        //its a resiszable array
        ArrayList<String> cars = new ArrayList<>();
        cars.add("lexus");
        cars.add("toyota");
        cars.add("bmw");

        for (int i = 0; i < cars.size(); i++) {

            driver.navigate().to("https://www.google.com");

            //maximize your browser
            driver.manage().window().maximize();
            Thread.sleep(3000);
            //using try catch exception to handle error

            try {
                //locate the search field by inspecting it first and then enter a keyword "cars"
                WebElement search = driver.findElement(By.xpath("//*[@name='q']"));
                search.sendKeys(cars.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter data on Search Field" + e);
            }//end of search field exception

            Thread.sleep(3000);

            try {
                //click on google search
                WebElement searchIcon = driver.findElement(By.xpath("//*[@name='btnK']"));
                searchIcon.submit();
            } catch (Exception e) {
                System.out.println("Unable to submit on Search Icon " + e);
            }//end of search icon exception
            Thread.sleep(3000);

            try {
                String schResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
                //using array variable to split the message
                String[] arrayResult = schResult.split(" ");
                System.out.println("My search number is " + arrayResult[1]);
            } catch (Exception e) {
                System.out.println("Unable to capture on Search Result " + e);
            }//end of search result exception

            //when you inspect an element and most of the time it takes you to the lowest tags but check the tags before it as
            //as long as it still highlights the element
        }

        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        //i prefer to use quit

        driver.quit();







    }//end of main method

}//end of java class
