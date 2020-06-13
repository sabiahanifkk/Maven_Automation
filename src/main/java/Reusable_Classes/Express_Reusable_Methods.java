package Reusable_Classes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Express_Reusable_Methods {
    static int timeout = 20;


    public static void mouseHover(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Hovering over element " + elementName);
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).perform();

        } catch (Exception e) {
            System.out.println("Unable to hover over element " + elementName);
        }

    }//end of mouse action hover method

    public static void mouseClick(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("clicking on element " + elementName);
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();

        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }

        public static void mouseClickMulti(WebDriver driver, String locator, String elementName, int i){
                WebDriverWait wait = new WebDriverWait(driver, timeout);
                try {
                    System.out.println("clicking on element by index" + elementName);
                    Actions actions = new Actions(driver);
                    WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(i);
                    actions.click(element).perform();

                } catch (Exception e) {
                    System.out.println("Unable to click on element by index " + elementName);
                }
    }//end of mouse action click method
}//end of java class
