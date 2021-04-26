package step_defs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.WithdrawalPage;
import utilities.DataBase2;
import utilities.Driver;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class AndreiStepDefs {


    MainPage mainPage = new MainPage();
    WithdrawalPage withdrawalPage = new WithdrawalPage();
    DataBase2 dataBase2 = new DataBase2();
    double transactionAmount;

    @When("^user clicks on Withdraw button$")
    public void user_clicks_on_Withdraw_button() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        Thread.sleep(2000);
        mainPage.withdrawMenu.click();
    }

    @When("^user selects KingUnderTheMountain account$")
    public void user_selects_KingUnderTheMountain_account() {
        Select dropdown = new Select(withdrawalPage.accountForWithdrawDropdown);
        List<WebElement> availableOptions = dropdown.getOptions();
//        for (WebElement option : availableOptions) {
//            if (option.getText().equals("KingUnderTheMountain")){
//                option.click();
//            }
//        }
        dropdown.selectByValue(String.valueOf(430));


    }

    @When("^user enters the amount of (\\d+) dollars$")
    public void user_enters_the_amount_of_dollars(double amount) throws InterruptedException {
        Thread.sleep(2000);
        withdrawalPage.withdrawAmountTextBox.click();
        withdrawalPage.withdrawAmountTextBox.sendKeys("34.00");
    }

    @When("^user presses Submit button$")
    public void user_presses_Submit_button() {
        withdrawalPage.submitButton.click();
    }

    @Then("^user sees that withdrawal amount should drop down by (\\d+) dollars$")
    public void user_sees_that_withdrawal_amount_should_drop_down_by_dollars(int arg1) throws Throwable {

        String query = "select  amount \n" +
                "FROM account_transaction\n" +
                "where account_id = 430\n" +
                "ORDER BY date(transaction_date) \n" +
                "desc limit 1";
        ResultSet rs = dataBase2.queryToRs (query);
        rs.next ();
        Assert.assertEquals (rs.getDouble ("amount"), -34.00, .00);
        dataBase2.close ();
//
//        ResultSet rs = dataBase.query (query);
//        List<Map<String, Object>> table = dataBase.convertResultSet (rs);
//        Map<String, Object> accountTable = table.get (0); // get first
//        for (Map.Entry<String, Object> number : accountTable.entrySet ()) {
//            transactionAmount = Double.parseDouble (number.getValue ().toString ());
//        }
//        dataBase.close ();


//        ResultSet rs = dataBase.query("select  amount \n" +
//                "FROM account_transaction\n" +
//                "where account_id = 430\n" +
//                "ORDER BY date(transaction_date) \n" +
//                "desc limit 1");
//        List<Map<String, Object>> table = dataBase.convertResultSet(rs);
//        String s = String.valueOf(table.get(0).get("amount"));
//        System.out.println(s);
//        table.forEach(System.out::println);
//        Assert.assertTrue("The amount does not math", s.contains("34"));
    }
}
