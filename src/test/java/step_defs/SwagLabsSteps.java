package step_defs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CheckoutSwagPage;
import pages.LoginPageSwag;
import pages.MainPageSwag;
import utilities.Driver;
import utilities.EnvironmentManager;

import java.util.ArrayList;
import java.util.List;

public class SwagLabsSteps {

    WebDriver driver = Driver.getDriver ();
    LoginPageSwag login = new LoginPageSwag ();
    MainPageSwag main = new MainPageSwag ();
    CheckoutSwagPage checkout = new CheckoutSwagPage ();

    @Given("^user goes to the login page$")
    public void user_goes_to_the_login_page() {
        driver.get (EnvironmentManager.baseUrl);
    }

    @When("^user login with valid credentials$")
    public void user_login_with_valid_credentials() {
        login.usernameField.sendKeys (EnvironmentManager.username);
        login.passwordField.sendKeys (EnvironmentManager.password);
        login.signInButton.click ();
    }

    @Then("^user should see \"([^\"]*)\" title$")
    public void user_should_see_title(String label) {
        Assert.assertTrue (main.label.getText ().contains (label));
    }

    @And("^user sort the product list$")
    public void userSortTheProductList() {
        Select dropdown = new Select (main.dropdown);
        dropdown.selectByIndex (3);
    }

    @Then("^products should be displayed in ascending order$")
    public void productsShouldBeDisplayedInAscendingOrder() {
        List<WebElement> priceList = main.sortedPrices;
        List<Double> list = new ArrayList<> ();
        boolean sorted = false;
        for (WebElement el : priceList) {
            list.add (Double.parseDouble (el.getText ().substring (1)));
        }
        for (int i = 0; i < list.size () - 1; i++) {
            if (list.get (i) <= list.get (i + 1)) {
                sorted = true;
            }
        }
        Assert.assertTrue (sorted);
    }

    @And("^user adds to cart t-shirt$")
    public void userAddsToCartTShirt() {
        main.AddToCart.click ();
    }

    @And("^user goes to cart$")
    public void userGoesToCart() {
        main.cartIcon.click ();
    }


    @And("^user press checkout$")
    public void userPressCheckout() {
        main.checkoutBtn.click ();
    }

    @And("^user input required information and press continue$")
    public void userInputRequiredInformationAndPressContinue() {
        checkout.firstNameInput.sendKeys ("Elon");
        checkout.lastNameInput.sendKeys ("Musk");
        checkout.zipcodeInput.sendKeys ("00011");
        checkout.continueButton.click ();
    }

    @And("^user verifies product name in cart$")
    public void userVerifiesProductNameInCart() {
        Assert.assertTrue (checkout.nameInCart.getText ().contains ("Sauce Labs Bolt T-Shirt"));
    }

    @And("^user verifies item price$")
    public void userVerifiesItemPrice() {
        Assert.assertTrue (checkout.itemPticeInCart.getText ().contains ("15.99"));
    }

    @And("^user press finish$")
    public void userPressFinish() {
        checkout.finishButton.click ();
    }

    @Then("^user should see \"([^\"]*)\" message displayed$")
    public void userShouldSeeMessageDisplayed(String message) {
        Assert.assertTrue (checkout.goodbuyMessage.getText ().contains (message));
    }

}
