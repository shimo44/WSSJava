package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class StoreHome {

    //selectors
    private static WebElement inputTopNavSearch;
    private static WebElement ctaSearch;

    public static WebElement inputSearchStore(WebDriver driver) {
        inputTopNavSearch = driver.findElement(By.xpath("(//input[@data-testid='searchval'])[1]"));

        return inputTopNavSearch;
    }

    public static WebElement ctaSearchStore(WebDriver driver){
        ctaSearch = driver.findElement(By.xpath("(//button[@value='Search'])[1]"));

        return ctaSearch;
    }
}
