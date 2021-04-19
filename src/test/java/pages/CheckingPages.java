package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckingPages {

    public CheckingPages(){
        PageFactory.initElements (Driver.getDriver (),this);
    }

    @FindBy(xpath = "//div[@contenteditable ='true'][1]")
    public WebElement checkingAccountName;

    @FindBy(xpath = "//small[contains(text(),'Account Number')]")
    public WebElement checkingAccountNumber;
}
