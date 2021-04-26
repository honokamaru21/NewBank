Feature:
  Background:
    Given user goes to the main page
    When user logs in with valid credentials
  Scenario: user verifies that the account balance "KingUnderTheMountain" will be decreased by $66.00
    And user clicks on Withdraw button
    And user selects KingUnderTheMountain account
    And user enters the amount of 34 dollars
    And user presses Submit button
    Then user sees that withdrawal amount should drop down by 34 dollars


#    Scenario Outline: user verifies that the account balance "KingUnderTheMountain" will be decreased by $66.00
#      And user clicks on Withdraw button