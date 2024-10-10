@CreateNewAccountMyStore
Feature: Create new account mystore

  Scenario: Add new user to mystore-testlab

    Given an open browser with my-store-testlab, and sign up
    When User goes to create new account page
    And User completes form
    And User save new account
    Then User sees "Information successfully updated."
