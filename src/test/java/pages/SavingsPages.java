package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SavingsPages {

    public SavingsPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='h4 m-0' and contains(text(),'JS_Account')]")
    public WebElement JS_Account;

    @FindBy(xpath = "//div[text()='Balance: $77000.00']")
    public WebElement JS_AccountBalance;

    @FindBy(xpath = "//small[contains(text(),'Account Number: 486130124')]")
    public WebElement accountNumber486130124;


}
