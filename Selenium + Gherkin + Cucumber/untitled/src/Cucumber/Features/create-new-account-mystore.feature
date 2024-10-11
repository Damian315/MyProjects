@CreateNewUser
Feature: Create new account MyStore

  Scenario: Add new user to MyStore-testlab

    Given an open browser with my-store-testlab
    When user signUp and goes to create new account
    And user completes form
    And user save new account
    Then enter save sees logged user
    And close browser