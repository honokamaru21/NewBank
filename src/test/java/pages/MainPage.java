package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.channels.Selector;

public class MainPage {

    public MainPage(){
        PageFactory.initElements (Driver.getDriver (),this);
    }

    @FindBy(xpath = "//img[@alt='User Avatar']/..")
    public WebElement userPicture;

    @FindBy(xpath = "//i[@class='fa fa-power -off']")
    public WebElement logOutButton;

    @FindBy(id="checking-menu")
    public WebElement checkingMenu;

    @FindBy(id="view-checking-menu-item")
    public WebElement viewChecking;

    @FindBy(id="withdraw-menu-item")
    public WebElement withdrawMenu;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
    public WebElement submitButton;

    public void logOutFromMainPage(){
        userPicture.click ();
        logOutButton.click ();
    }


    @FindBy(id = "savings-menu")
    public WebElement savingsMenu;

    public void clickOnSavingsMenu(){
        savingsMenu.click();
    }

    @FindBy(id = "view-savings-menu-item")
    public WebElement viewSavingsButton;

    public void clickOnViewSavingsButton(){
        viewSavingsButton.click();
    }


}
