package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class weightwatchers {
    public static void main(String[] args) throws InterruptedException {
        //set property
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/New Java Test/src/Resource/chromedriver");
        ChromeOptions options = new ChromeOptions();
        //set the precondition to maximize
        options.addArguments("incognito");

        //define driver
        WebDriver driver = new ChromeDriver(options);

        //define the elements here so you can call these in the loop
        String findLocation = "//*[@data-e2e-name='find_a workshop']";
        String searchBar = "//*[@name='meetingSearch']";
        String schButton = "//*[@class='btn spice-translated']";
        String results = "//*[@class='meeting-location__top']";
        String address = "//*[@class='location__container']";
        String schedule = "//*[@class='meeting-schedule__schedule']";

        //put the zip codes into an array variable
        String[] myZip = new String[3];
        myZip[0] = "11218";
        myZip[1] = "11230";
        myZip[2] = "10463";
        //open weightwatchers
        driver.navigate().to("https://www.weightwatchers.com");
        String tabTitle = ("Weight Watchers : Lose weight here");
        String actualTitle = driver.getTitle();
        //set condition to test the requirement
        if (tabTitle == actualTitle) {
            System.out.println("Title matches requirement");
        }

        else {

            System.out.println("Title does not match requirement");

        }

        //start loop to search each zip code
        for (int i = 0;i<myZip.length;i++) {
            driver.navigate().to("https://www.weightwatchers.com");

            driver.manage().window().maximize();
            Thread.sleep(3000);

            driver.findElement(By.xpath(findLocation)).click();

            Thread.sleep(3000);

            driver.findElement(By.xpath(searchBar)).sendKeys(myZip[i]);

            Thread.sleep(3000);

            driver.findElement(By.xpath(schButton)).submit();

            Thread.sleep(3000);

            //set condition to print the desired result address and capture the schedule table
            if (i == 0) {

                driver.findElements(By.xpath(results)).get(1).click();

                Thread.sleep(3000);
                //define the string here so you can shorten your print line
                String textAdd =  driver.findElement(By.xpath(address)).getText();
                String schedText = driver.findElement(By.xpath(schedule)).getText();

                System.out.println("My nearest location to " + myZip[i] + " is " + textAdd);

                Thread.sleep(3000);

                System.out.println("The hours of operation for " + textAdd + " are " + schedText);

                Thread.sleep(3000);

            } else if (i == 1){
                driver.findElements(By.xpath(results)).get(2).click();

                Thread.sleep(3000);
                String textAdd =  driver.findElement(By.xpath(address)).getText();
                String schedText = driver.findElement(By.xpath(schedule)).getText();
                System.out.println("My nearest location to " + myZip[i] + " is " + textAdd);

                Thread.sleep(3000);

                System.out.println("The hours of operation for " + textAdd + " are " + schedText);

                Thread.sleep(3000);
            } else if (i == 2) {
                driver.findElements(By.xpath(results)).get(0).click();

                Thread.sleep(3000);
                String textAdd = driver.findElement(By.xpath(address)).getText();
                String schedText = driver.findElement(By.xpath(schedule)).getText();
                System.out.println("My nearest location to " + myZip[i] + " is " + textAdd);

                Thread.sleep(3000);

                System.out.println("The hours of operation for " + textAdd + " are " + schedText);

                Thread.sleep(3000); }//end of if statement

            }//end of loop








        }//end of main method









    }//end of class





