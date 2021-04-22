package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class DepositPage {
    WebDriver driver;
    public DepositPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@class = 'form-control']")
    public WebElement selectBtn;

    @FindBy(id = "amount")
    public WebElement depositAmount;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    public WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"firstRow\"]/div/div/form/div/div[7]")
    public WebElement balance;



    public void selectAccount(){
     Select dropDown = new Select(selectBtn);
     dropDown.selectByValue("425");

    }

    public void enterDepositAmount(int amount){
        depositAmount.sendKeys(""+amount);
    }



}
