Feature: Validate current balance in savings account

  Background:
    Given user goes to the main page
    When user logs in with valid credentials


  Scenario Outline: user verify balance "77000.00" in "JS_Account" savings account
    And user click on savings account
    And user click View Savings
    Then user verify "<savings account>" <amount>
    Examples:
      |savings account|amount|
      |JS_Account   |77000.00|



#    Then user verify "<savings account>" $77000.00
#  Examples:
#    |savings account|
#    |JS_Account   |