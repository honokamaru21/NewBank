Feature: Validate new checking account
# Tags: optional
  Background:
    Given user goes to the main page
    When user logs in with valid credentials

  Scenario:  User verifies that new checking was created
    When user clicks on checking account
    Then user verifies that date of creation
