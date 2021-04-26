package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckoutSwagPage {

    public CheckoutSwagPage(){
        PageFactory.initElements (Driver.getDriver (),this);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    @FindBy(id="last-name")
    public WebElement lastNameInput;

    @FindBy(id="postal-code")
    public WebElement zipcodeInput;

    @FindBy(xpath="//input[@class='btn_primary cart_button']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public WebElement nameInCart;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement itemPticeInCart;

    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    public WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement goodbuyMessage;
}
