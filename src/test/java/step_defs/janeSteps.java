package step_defs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.SavingsPages;
import utilities.DataBase2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class janeSteps {

    WebDriver driver;
    MainPage mainPage = new MainPage();
    SavingsPages savingsPages = new SavingsPages();
    double accountBalance;
    Integer accountNumber;
    DataBase2 db2 = new DataBase2();

    @When("^user click on savings account$")
    public void user_click_on_savings_account()  {
        mainPage.clickOnSavingsMenu();
    }

    @When("^user click View Savings$")
    public void user_click_View_Savings()  {
        mainPage.clickOnViewSavingsButton();
    }


    @Then("^user verify \"([^\"]*)\" (\\d+\\.\\d{2})$")
    public void userVerify(String account, double amount) throws SQLException {
        String actualAccount = savingsPages.JS_Account.getText();
        Assert.assertEquals(account,actualAccount);

        String strAccountBalance = savingsPages.JS_AccountBalance.getText ();
        int indexOfColon = strAccountBalance.indexOf (":");
        accountBalance = Double.parseDouble (strAccountBalance.substring (indexOfColon + 3));

        String strAccountNumber = savingsPages.accountNumber486130124.getText ();
        int indexOfColonOfNumber = strAccountNumber.indexOf (":");
        accountNumber = Integer.parseInt (strAccountNumber.substring (indexOfColonOfNumber + 2));
        String getAccountQuery = "SELECT current_balance FROM digitalbank.account WHERE name = 'JS_Account'";
        ResultSet rs = db2.queryToRs(getAccountQuery);
        rs.next ();
        Assert.assertEquals(rs.getDouble ("current_balance"), accountBalance, .00);
        db2.close ();

//        String getAccountQuery = "USE digitalbank;\n" +
//                "SELECT  current_balance\n" +
//                "FROM account\n" +
//                "WHERE name = "+actualAccount+"\n" +
//                "AND account_number= ?;";
//
//        ResultSet rs = db.queryToRs(getAccountQuery,accountNumber);
//        double actualAmount = rs.getDouble("current_balance");
//
//        Assert.assertEquals(amount,actualAmount, .00);

    }


}
