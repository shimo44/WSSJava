package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchResults {

    public static void checkResults(WebDriver driver){
        List<WebElement> elements = driver.findElements(By.xpath("//span[@data-testid='itemDescription'][contains(text(), 'Table')]"));

        int elementCount = elements.size();

        System.out.println("The search query returned: " + elementCount + " tables.");

    }

    /**
     * selectFromLastCount provides an integer to add an item from last to first in the element result list.
     * Could be refactored to start from the beginning of the array list!
     * **/
    public static void selectItem(WebDriver driver, Integer selectFromLastCount){
        List<WebElement> elements = driver.findElements(By.xpath("//input[@data-testid='itemAddCart']"));

        int itemCount = elements.size();

        System.out.println("There are: " + itemCount + " tables available for order.");

        elements.get(itemCount-selectFromLastCount).click();

        System.out.println("Selecting the last available table on the results page to be added to the users cart.");
    }

    public static void viewCart(WebDriver driver){
        WebElement ctaViewCart = driver.findElement(By.xpath("//a[@href=\"/viewcart.cfm\"]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ctaViewCart);

        ctaViewCart.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}
