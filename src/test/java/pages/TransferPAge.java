package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class TransferPAge {
    ////select[@id='fromAccount']

    public TransferPAge() {
        PageFactory.initElements (Driver.getDriver (),this); }

        @FindBy(id="fromAccount")
    public WebElement selectFrom;

    @FindBy(id="toAccount")
    public WebElement toAccount;

    @FindBy(id="amount")
    public WebElement inputAmountField;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//table[@id=\"transactionTable\"]//tbody//tr//td[5]")
    public WebElement checkBalance;

    public void setSelectFrom(){
        Select dropDown = new Select(selectFrom);
        dropDown.selectByValue("797");
    }

    public void setToAccount(){
        Select dropDown = new Select(toAccount);
        dropDown.selectByValue("800");
    }
}
