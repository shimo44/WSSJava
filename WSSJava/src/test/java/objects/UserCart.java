package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class UserCart {

    public static void emptyCart(WebDriver driver){


        try{
            WebElement ctaEmptyCart = driver.findElement(By.xpath("//button[contains(text(), 'Empty Cart')]"));

            ctaEmptyCart.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            WebElement ctaConfirmEmptyCart = driver.findElement(By.xpath("//footer//button[contains(text(), 'Empty')]"));
            ctaConfirmEmptyCart.click();

            System.out.println("Successfully emptied cart of all items!");

            Thread.sleep(5000); //Just for demo purposes to hold the cleared cart page

        }catch (Exception e){
            System.out.println("Failed to empty cart of all items..");
            System.out.println("Error: " + e);

        }
    }
}
