package step_defs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.CheckingPages;
import pages.MainPage;
import utilities.DataBase2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckNewCheckingAltynaiiSteps {

    MainPage main = new MainPage();
    CheckingPages checking = new CheckingPages();
    DataBase2 database = new DataBase2();

    @When("^user clicks on checking account$")
    public void userClicksOnCheckingAccount() throws InterruptedException {
        Thread.sleep(2000);
        main.checkingMenu.click();
        Thread.sleep(2000);
        main.viewChecking.click();
    }

    @Then("^user verifies that date of creation$")
    public void userVerifiesThatDateOfCreation() throws SQLException {
        String date = checking.dateVerifyIcon.getText();
        int indexOfBrackets = date.indexOf("[");

        String query = "SELECT date_opened FROM digitalbank.account WHERE name like 'checking_digital';";

        ResultSet rs = database.queryToRs (query);
        rs.next ();
        String actualDate = rs.getString ("date_opened");
        int indexOfSecondBrackets = actualDate.indexOf("[");

        System.out.println ("Account was created on: " + actualDate);
        Assert.assertTrue(actualDate.contains("2021-04-23"));
    }
}
