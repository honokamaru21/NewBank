package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WithdrawalPage {
    public WithdrawalPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath = "//select[@id='selectedAccount']")
    public WebElement accountForWithdrawDropdown;

    @FindBy (id = "amount")
    public WebElement withdrawAmountTextBox;

    @FindBy (xpath = "//button[@class = 'btn btn-primary btn-sm']")
    public WebElement submitButton;


}
