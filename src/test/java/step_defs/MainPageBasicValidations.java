package step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LogInPage;
import utilities.Driver;
import utilities.EnvironmentManager;

public class MainPageBasicValidations {

    WebDriver driver = Driver.getDriver ();
    LogInPage loginPage = new LogInPage ();

    @Given("^user goes to the main page$")
    public void user_goes_to_the_main_page()  {
        driver.get (EnvironmentManager.baseUrl);
    }

    @Then("^user should see \"([^\"]*)\" message$")
    public void user_should_see_message(String welcome)  {
        Assert.assertTrue (driver.findElement (By.xpath ("//li[contains(text(),'Welcome')]")).getText ().equals (welcome));
    }

    @Then("^user should see panel with \"([^\"]*)\" information titles$")
    public void user_should_see_panel_with_information_titles(String arg1)  {

    }

    @When("^user logs in with valid credentials$")
    public void userLogsInWithValidCredentials() {
        loginPage.usernameField.sendKeys (EnvironmentManager.username);
        loginPage.passwordField.sendKeys (EnvironmentManager.password);
        loginPage.signInButton.click ();
    }
}
