package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.StoreHome;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableSearch {

    static WebDriver driver;
    static String browser = "edge";

    @BeforeEach
    void setup(){
        switch(browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void testSearchStainlessWorkTable(){
        //Start
        driver.get("https://www.webstaurantstore.com");


        //Verification
        String pageTitle = driver.getTitle();
        assertThat(pageTitle).contains("WebstaurantStore: Restaurant Supplies & Foodservice Equipment");


        //Functional
        StoreHome.inputSearchStore(driver).sendKeys("stainless work table");

        //Functional
        StoreHome.ctaSearchStore(driver).click();

        System.out.println("We meet again, Java!");

    }



}
