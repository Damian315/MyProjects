@CreateNewAccountMyStore
Feature: Create new account MyStore

  Scenario: Add new user to MyStore-testlab

    Given an open browser with my-store-testlab, and click sign up
    When user goes to create new account
    And user completes form
    And user save new account
    Then enter save sees logged user
    And close browser


  Scenario: Check validation input email and birthdate

    Given  an open browser with my-store-testlab, and click sign up
    When user goes to create new account
    And user comletes form without email and brithdate
    And user save new account
    Then user sees validation messages
    And close browser