package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MainPageSwag {

    public MainPageSwag(){
        PageFactory.initElements (Driver.getDriver (),this);
    }

    @FindBy(xpath="//div[@class='product_label']")
    public WebElement label;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement dropdown;

    @FindBy(xpath="//div[@class='inventory_item_price']")
    public List<WebElement> sortedPrices;

    @FindBy(xpath="//div[text()='Sauce Labs Bolt T-Shirt']/../../../div[3]/button")
    public WebElement AddToCart;

    @FindBy(xpath="//div[text()='Sauce Labs Bolt T-Shirt']/../../../div[3]/div")
    public WebElement tShirtPrice;

    @FindBy(xpath="//a[@class='shopping_cart_link fa-layers fa-fw']")
    public WebElement cartIcon;

    @FindBy(xpath="//a[@class='btn_action checkout_button']")
    public WebElement checkoutBtn;

}
