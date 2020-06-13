package Reusable_Classes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Library1 {

    static int timeout = 20;

    public static WebDriver setDriver(){
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver80.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);
        return driver;

    }//end of set driver method

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title matches requirement");
        }   else    {
                System.out.println("Title does not match requirement");
            }//end of if statement

        }//end of verify title method

    public static void dropDownByText(WebDriver driver, String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try     {
            System.out.println("selecting a value from element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dDown = new Select(element);
            dDown.selectByVisibleText(userInput);

        }   catch (Exception e)   {
            System.out.println("Unable to select value from element " + elementName + " " + e);
        }//end of exception
    }//end of drop down method

    public static String captureText(WebDriver driver, String locator, String elementName){
        String result = null;
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try     {
            System.out.println("Capturing text from element" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();

        }   catch (Exception e) {
            System.out.println("unable to capture text from element" + elementName + " " + e);
        }
        return result;



    }//end of capture text method












}// end of java class
