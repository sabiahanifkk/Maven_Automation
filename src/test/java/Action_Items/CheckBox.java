package Action_Items;


import Reusable_Classes.Reusable_Library;
import Reusable_Classes.Reusable_Library_Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CheckBox {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = Reusable_Library_Loggers.setDriver();
        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html");

        int checkboxSize = driver.findElements(By.xpath("//input[@type='checkbox']")).size();

        for (int i = 0; i < checkboxSize; i++){

            Reusable_Library.mouseClickMulti(driver,"//input[@type='checkbox']","CheckBox",i);


           }//end of loop
        }//end of main

    }//end of class



