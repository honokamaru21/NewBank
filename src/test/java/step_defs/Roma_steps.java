package step_defs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.MainPage;
import pages.TransferPAge;
import utilities.DataBase2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Roma_steps {
    MainPage mainPage = new MainPage();
    TransferPAge transferPAge = new TransferPAge();
    DataBase2 dataBase2 = new DataBase2();

    @When("^user go to transfer functionality$")
    public void user_go_to_transfer_functionality()  {
    mainPage.transferOptionBetweenMyAccount.click();

    }

    @When("^user chose to transfer from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void user_chose_to_transfer_from_to(String arg1, String arg2) {

        transferPAge.setSelectFrom();
        transferPAge.setToAccount();
        transferPAge.inputAmountField.sendKeys("100");
        transferPAge.SubmitButton.click();


    }
    @Then("^user verify current balance on checking account$")
    public void user_verify_current_balance_on_checking_account() throws SQLException {
       String query ="SELECT current_balance FROM digitalbank.account WHERE account_number = 486130131";

       ResultSet rs  = dataBase2.queryToRs(query);

       rs.next();
       double actual = rs.getDouble ("current_balance");

       double actualBalance = Double.parseDouble(transferPAge.checkBalance.getText().substring(1));

       Assert.assertEquals("wrong input",actual,actualBalance,.00);



    }
}
