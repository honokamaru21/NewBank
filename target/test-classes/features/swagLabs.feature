Feature: Swag Validations

  Background:
    Given user goes to the login page
    When user login with valid credentials

  Scenario: Welcome verification
    Then user should see "Products" title

  Scenario: Verify sorting
    And user sort the product list
    Then products should be displayed in ascending order

  Scenario: Checkout verification
    And user adds to cart t-shirt
    And user goes to cart
    And user press checkout
    And user input required information and press continue
    And user verifies product name in cart
    And user verifies item price
    And user press finish
    Then user should see "THANK YOU FOR YOUR ORDER" message displayed










