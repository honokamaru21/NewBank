package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty ("browser").toLowerCase ()) {
                default:
                    driver = ChromeWebDriver.loadChromeDriver ();
                    break;
                case "firefox":
                    driver = FirefoxWebDriver.loadFirefoxDriver ();
                    break;
                case "safari":
                    driver = new SafariDriver ();
                    driver.manage ().timeouts ().implicitlyWait (7, TimeUnit.SECONDS);
                    driver.manage ().window ().maximize ();
                    break;
                case "ie":
                    WebDriverManager.iedriver ().setup ();
                    driver = new InternetExplorerDriver ();
                    driver.manage ().timeouts ().implicitlyWait (9, TimeUnit.SECONDS);
                    driver.manage ().window ().maximize ();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close ();
                driver.quit ();
                driver = null;

            }
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }
}
