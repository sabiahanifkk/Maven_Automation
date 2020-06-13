package Day8_0503;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_MortCalc {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/Juan/Desktop/New Java Test/src/Resource/chromedriver");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.mortgagecalculator.org");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        //declaring and defining javascript

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //0 is the x axis and 5000 is the y axis
        //scrolling down is a positive number and scrolling up is a negative
        //scrolling right is a positive number and scrolling left is a negative
//        jse.executeScript("scroll(0,5000)");
//        Thread.sleep(1000);
//        jse.executeScript("scroll(0,-5000)");

        //scrolling to an element view
        try {
            WebElement loanTerm = driver.findElement(By.xpath("//*[@id='loanterm']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",loanTerm);
        }   catch (Exception e){
            System.out.println("unable to load loanterm" + e);
        }


    }//end of main
}//end of class
