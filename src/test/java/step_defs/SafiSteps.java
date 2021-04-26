package step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DepositPage;
import pages.MainPage;
import utilities.DataBase2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SafiSteps {
    MainPage mainPage = new MainPage ();
    DepositPage depositPage = new DepositPage ();
    DataBase2 db2 = new DataBase2 ();
    WebDriver driver;


    @When("^click on Deposit option$")
    public void click_on_Deposit_option() throws InterruptedException {
        Thread.sleep (3000);
        mainPage.clickDeposit ();


    }

    @When("^chose Hobbit account$")
    public void chose_Hobbit_account() throws InterruptedException {
        Thread.sleep (2000);
        depositPage.selectAccount ();
    }

    @And("^enter deposit amount (\\d+)$")
    public void enterDepositAmount(int amount) throws InterruptedException {
        Thread.sleep (2000);
        depositPage.enterDepositAmount (amount);
    }


    @When("^click Submit button$")
    public void click_Submit_button() throws InterruptedException {
        Thread.sleep (2000);
        depositPage.submitBtn.click ();
    }

    @Then("^user should be able to validate current balance$")
    public void user_should_be_able_to_validate_current_balance() throws InterruptedException, SQLException {
        Thread.sleep (2000);
        String query = "SELECT current_balance FROM digitalbank.account WHERE account_number = 486130062;";
        System.out.println ("Query: " + query);

        ResultSet rs = db2.queryToRs (query);
        String balanceStr = depositPage.balance.getText ();
        System.out.println ("Balance: " + balanceStr);
        int index$ = balanceStr.indexOf ('$');
        System.out.println ("Index of $: " + index$);
        double expected = Double.parseDouble (balanceStr.substring (index$ + 1));
        System.out.println ("Expected " + expected);
        rs.next ();
        double actual = rs.getDouble ("current_balance");
        System.out.println ("Actual: " + actual);
        Assert.assertEquals (actual, expected, 0.00);
        db2.close ();


//        while (true){
//            try {
//                if (!rs.next()) break;
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }


    }


}
