package Day6_0426;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Chrome_options {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/Java Test/src/Resource/chromedriver");
        //set some pre conditions using chrome options
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver

        //maximize chrome option doesn't work in mac ios
        options.addArguments("incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to mlcalc.com
        driver.navigate().to("https://www.mlcalc.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        //i want to capture the title of that page
        //System.out.println("my title is " + driver.getTitle());
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("MORTGAGE CALCULATOR & LOAN CALCULATOR")){
            System.out.println("Title Matches with expected");
        } else {
            System.out.println("Title does not match " + actualTitle);
        }

        //if same locator used more than once then store it as a webElement variable
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the field first
        pPrice.clear();
        //enter your new data
        pPrice.sendKeys("400000");

        //store your start momth in WebElement variable and call it on your select command
        WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        //call my Select command and it only works when your dropdown locator is under select tag
        Select sMonthList = new Select(sMonth);
        //select the drop down value by visible text
        sMonthList.selectByVisibleText("May");
//        sMonthList.selectByIndex(0);
//        sMonthList.selectByValue("1");
        //if the drop down menu is not under a select tag then we must click on the drop down and then
        //click on the drop down value
        //lets verify some of the start year to make sure its matching on the drop down

        String[] yearArray = new String[]{"2005","2015","2035"};
        for (int i = 0 ; i < yearArray.length; i++) {

            driver.findElement(By.xpath("//*[@name='sy']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()='" + yearArray[i] + "']")).click();


        }









    }
}
