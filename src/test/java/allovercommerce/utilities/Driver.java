package allovercommerce.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {


    // Driver.getDriver() returns driver object
    private static WebDriver driver;

    // getDriver() is used to instantiate the driver object
    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();   // This is older version of creating driver object
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

            }
            // Following is the latest version (Selenium 4.5)
            //  driver = WebDriverManager.chromedriver().create();  It also closes the driver automatically.
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait will wait for this long only if needed
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    // closeDriver() is used to close the driver
    public static void closeDriver(){
        if (driver!=null){  // if driver is already being instantiated / created and is in use, then quit
            driver.quit();
            driver=null; // make the driver null so when we call getDriver(), our if condition stays true, and we can open the driver again.
        }
    }






}
