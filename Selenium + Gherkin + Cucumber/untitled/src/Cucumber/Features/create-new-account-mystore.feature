Feature: Create new account MyStore

  Background:
    Given an open browser with my-store-testlab
    When user signUp and goes to create new account

  @CreateNewUser
  Scenario: Add new user to MyStore-testlab

    And user completes form
    And user save new account
    Then enter save user sees logged account
    And close browser

  @CheckValidation
  Scenario: Check validation page create new account

    And user completes form without birthdate
#    And user click save button
#    Then user sees validation message
#    And close browser