Feature: Validate Account

  Background:
    Given user goes to the main page
    When user logs in with valid credentials

  Scenario: Account number validation
    And user gets checking account number
    And user gets account number from data base
    Then account numbers have to match