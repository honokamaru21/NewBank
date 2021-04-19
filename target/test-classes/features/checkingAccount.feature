Feature: Main Page Validations

  Background:
    Given user goes to the main page
    When user logs in with valid credentials

    Scenario: Withdraw with unselected account verification
    And user selects checking account
    And withdraw with unselected account
    Then user should see "Please select an item in the list."

    Scenario: Withdraw without an amount verification
    And user submit withdraw amount without an amount
    Then user should see "Please fill out this field."