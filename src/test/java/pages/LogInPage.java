package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogInPage {

    public LogInPage(){
        PageFactory.initElements (Driver.getDriver (),this);
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement signInButton;

}