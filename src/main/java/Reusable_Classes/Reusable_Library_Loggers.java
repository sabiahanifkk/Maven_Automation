package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;


public class Reusable_Library_Loggers {

     static int timeout = 20;


     //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws IOException, InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver");
        //kill all chrome driver instance
//        Thread.sleep(1800);
////        Runtime.getRuntime().exec("taskkill /F /IM chromedriver /T");
////        Thread.sleep(1800);
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

    //method to compare expected with actual title
    public static void verifyTitle(WebDriver driver,String expectedTitle, ExtentTest logger){
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Expected title matches with Actual " + expectedTitle);
            logger.log(LogStatus.PASS,"Expected title matches with Actual " + expectedTitle);
        } else {
            System.out.println("Expected doesn't match actual title. Actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Expected doesn't match actual title. Actual title is " + actualTitle);
            getScreenShot(driver,logger,"Title Verification");
        }
    }//end of verify title method


    //method to select a drop down value by visible text
    public static void dropdownByText(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
              WebDriverWait wait = new WebDriverWait(driver,timeout);
              try{
                  System.out.println("Selecting a value on element " + elementName);
                  logger.log(LogStatus.INFO,"Selecting a value on element " + elementName);
                  WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                  Select dDown = new Select(element);
                  dDown.selectByVisibleText(userInput);
              } catch (Exception e) {
                System.out.println("Unable to select element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to select element " + elementName + " " + e);
                getScreenShot(driver,logger,"Drop Down" + elementName );
             }
    }//end of drop down by text method

    //method to enter user input on send keys
    public static void userKeys(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of sendkeys method

    //method to click on an element
    public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver,String locator,String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Submitting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Submitting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to return text from an element
    public static String captureText(WebDriver driver,String locator,String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            System.out.println("Capturing a text from element " + elementName);
            logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println(elementName+ " is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }

        return result;
    }//end of click method

    //method to click by index on an element
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value by index " + index + " on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to click by index " + index + " on element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to enter user input on send keys
    public static void userTypeAndHitEnter(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of userTypeAndHitEnter method


    public static void mouseClick(WebDriver driver, String locator, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("clicking on element " + elementName);
            logger.log(LogStatus.INFO,"clicking on element " + elementName);
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();

        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName);
            getScreenShot(driver,logger,elementName);
        }
    }

    public static void mouseHover(WebDriver driver, String locator, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("clicking on element " + elementName);
            logger.log(LogStatus.INFO,"clicking on element " + elementName);
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).perform();

        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName);
            getScreenShot(driver,logger,elementName);
        }
    }


    public static void mouseClickMulti(WebDriver driver, String locator, String elementName, int i, ExtentTest logger)  {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("clicking on element by index" + elementName);
            logger.log(LogStatus.INFO,"clicking on element by index" + elementName);
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(i);
            actions.moveToElement(element).click().perform();

        } catch (Exception e) {
            System.out.println("Unable to click on element by index " + elementName);
            logger.log(LogStatus.FAIL,"Unable to click on element by index " + elementName);
            getScreenShot(driver,logger,elementName);
        }
    }//end of mouse action click method


    public static void getScreenShot(WebDriver driver, ExtentTest logger, String imageName) {
        try {
            String fileName = imageName + ".png";
            String directory = "src//main//java//HTML_Report//Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots//" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();

        }
    }

    public static void clear(WebDriver driver, String locator, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("clearing a value from element " + elementName);
            logger.log(LogStatus.INFO,"Clearing a value ofrom element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
        } catch (Exception e) {
            System.out.println("Unable to clear element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to clear element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method


        }//end of java class
