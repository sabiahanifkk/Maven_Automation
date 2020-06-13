package Day5_0425;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_by_xpath {
    public static void main(String[] args) throws InterruptedException {

        String searchIconPath = "//*[@value='Go']";
        String imagePath = "//img[contains(@class,'s-image)]";
        //define your property
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/Java Test/src/Resource/chromedriver");
        //define the driver
        WebDriver driver = new ChromeDriver();
        //navigate to amazon home page
        driver.navigate().to("https://www.amazon.com");
        //maximize your driver window
        driver.manage().window().maximize();
        //wait a few seconds
        Thread.sleep(2000);

        //enter a keyword laptop on amazon search field by using xpath
        //the xpath string starts with "//*" in an array brakete property value goes inside single quotes

        driver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys("laptop");
        driver.findElement(By.xpath("//*[@type='submit' and @value='Go']")).submit();

        Thread.sleep(4000);

        //click on the second image item of the same elements within the page
        driver.findElements(By.xpath(imagePath)).get(4).click();

        //renavigate to home page
        driver.navigate().to("https://www.amazon.com");
    }//end of main





}//end of java class
