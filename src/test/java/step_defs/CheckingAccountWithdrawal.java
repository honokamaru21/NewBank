package step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import utilities.Driver;

import java.nio.channels.Selector;

public class CheckingAccountWithdrawal {
    WebDriver driver = Driver.getDriver ();
    MainPage mainPage = new MainPage ();

    @When("^user selects checking account$")
    public void user_selects_checking_account() throws InterruptedException{
        Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait (driver, 15);
//        wait.until (ExpectedConditions.visibilityOf(mainPage.withdrawMenu)).click ();
        mainPage.withdrawMenu.click ();
    }

    @When("^withdraw with unselected account$")
    public void withdraw_with_unselected_account() throws InterruptedException {
        Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait (driver, 15);
//        wait.until (ExpectedConditions.visibilityOf (mainPage.submitButton)).click ();
        mainPage.submitButton.click ();
    }

    @Then("^user should see \"([^\"]*)\"$")
    public void user_should_see(String error) {
        Assert.assertEquals ("Failed to show the error message",
                error, driver.switchTo ().activeElement ().getAttribute ("validationMessage"));
    }

    @And("^user submit withdraw amount without an amount$")
    public void userSubmitWithdrawAmountWithoutAnAmount() {


    }
}
