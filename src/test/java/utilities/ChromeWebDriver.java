package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeWebDriver {

    public static WebDriver loadChromeDriver(){
        WebDriverManager.chromedriver ().setup ();

        ChromeOptions options = new ChromeOptions ();
        options.addArguments ("--start-maximized");
        options.addArguments ("--disable-extensions");
        options.addArguments ("--window-size=1920,1080");//change based on requirements

        if(ConfigReader.getProperty ("headless").equalsIgnoreCase ("true")) {
            options.addArguments ("--headless");
        }

//      options.addArguments ("--no-sandbox");//research
//      options.addArguments ("--disable-gpu");//research

        WebDriver driver = new ChromeDriver (options); //creates default chrome browser ChromeDriver (options) but with options
        driver.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);

        return driver;
    }
}