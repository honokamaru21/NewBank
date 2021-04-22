Feature: Validate deposit option

  Background:
    Given user goes to the main page
    When user logs in with valid credentials

    Scenario:
      And click on Deposit option
      And chose Hobbit account
      And enter deposit amount 5000
      And click Submit button
      Then user should be able to validate current balance


