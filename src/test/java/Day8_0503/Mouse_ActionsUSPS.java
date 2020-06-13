package Day8_0503;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_ActionsUSPS {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/New Java Test/src/Resource/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.usps.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //define mouse actions
        Actions mouse = new Actions(driver);



        //hover over Mail & Ship
        //.perform must be written in order for the mouse to perform the action
        try {
            WebElement mailNship = driver.findElement(By.xpath("//*[text()='Mail & Ship']"));
            mouse.moveToElement(mailNship).perform();
        } catch (Exception e){
            System.out.println("unable to perform mouse hover" + e);
        }

        try {
            WebElement clickNship = driver.findElement(By.xpath("//*[@class='tool-cns']"));
            mouse.moveToElement(clickNship).click().perform();
        }   catch (Exception e)  {
            System.out.println("unable to perform mouse click" + e);
        }

    }//end of main




}//end of java
