package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CheckingPages {

    public CheckingPages(){
        PageFactory.initElements (Driver.getDriver (),this);
    }

    @FindBy(xpath = "//div[@contenteditable ='true'][1]")
    public WebElement checkingAccountName;  //hobbit

    @FindBy(xpath = "//small[contains(text(),'Account Number')]")
    public WebElement checkingAccountNumber;

    @FindBy(xpath = "//table[@id=\"transactionTable\"]")
    public WebElement wholeTable;

    @FindBy(xpath = "//table[@id=\"transactionTable\"]//tbody//tr//td[1]")
    public WebElement dateVerifyIcon;





}
