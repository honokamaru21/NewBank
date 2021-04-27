package step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.MainPage;
import utilities.Driver;
import utilities.EnvironmentManager;

public class Hooks {
    MainPage mainPage = new MainPage ();

    @Before
    public void setUp() throws Exception{
        EnvironmentManager.setUpEnvironment();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException{

        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver ()).getScreenshotAs (OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        }catch (Exception e){
            System.err.println("The error happened while taking screenshot and cleaning up after the test");
            e.printStackTrace();
        }

        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
