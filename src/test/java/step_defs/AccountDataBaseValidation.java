package step_defs;

import com.sun.xml.internal.ws.util.QNameMap;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CheckingPages;
import pages.MainPage;
import utilities.DataBase;
import utilities.Driver;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class AccountDataBaseValidation {
    public int accountNumber;
    public int actualAccountNumber;
    WebDriver driver = Driver.getDriver ();
    MainPage mainPage = new MainPage ();
    CheckingPages checking = new CheckingPages ();
    DataBase db = new DataBase ();

    @When("^user gets checking account number$")
    public void user_gets_checking_account_number() throws Throwable {
        Thread.sleep (2000);
        mainPage.checkingMenu.click ();
        Thread.sleep (2000);
        mainPage.viewChecking.click ();
        Thread.sleep (2000);
        String actualAccountName = checking.checkingAccountName.getText ();
        Assert.assertTrue (actualAccountName.contains ("Hobbit"));
        String strAccountNumber = checking.checkingAccountNumber.getText ();
        int indexOfColon = strAccountNumber.indexOf (":");
        accountNumber = Integer.parseInt (strAccountNumber.substring (indexOfColon + 2));

    }

    @When("^user gets account number from data base$")
    public void user_gets_account_number_from_data_base() throws Throwable {
        String getAccountQuery = "SELECT account_number FROM digitalbank.account WHERE name = 'Hobbit';";
        ResultSet rs = db.query (getAccountQuery);
        List<Map<String, Object>> table = db.convertResultSet (rs);
        Map<String, Object> accountTable = table.get (0);
        for (Map.Entry<String, Object> number : accountTable.entrySet ()) {
            actualAccountNumber = Integer.parseInt (number.getValue ().toString ());
        }
        db.close ();
    }

    @Then("^account numbers have to match$")
    public void account_numbers_have_to_match() throws Throwable {
        //conflict 1
        System.out.println (accountNumber);
        System.out.println (actualAccountNumber);
        Assert.assertEquals ("Account number validation failed", accountNumber, actualAccountNumber);
       // Assert.assertEquals ("Account number validation failed", 486130062, actualAccountNumber);
    }
}
