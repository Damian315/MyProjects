@CreateNewAccountMyStore
Feature: Create new account MyStore

  Scenario: Add new user to MyStore-testlab

    Given an open browser with my-store-testlab, and sign up
    When User goes to create new account
    And User completes form
    And User save new account
    Then Enter save sees logged user
    And close browser
