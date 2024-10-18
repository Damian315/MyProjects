Feature: Create new account MyStore

  Background:
    Given an open browser and signUp

  @CreateNewUser
  Scenario Outline: Add new user to MyStore-testlab

    When user completes form sets "<name>", "<surname>", "<password>", "<birthdate>"
    And user save new account
    Then user has logged in MyStore
    And close browser

    Examples:
    | name | surname   | password | birthdate  |
    | Jan  | Kowalski  | passpass | 01/04/1990 |

  @CheckValidation
  Scenario: Check validation page create new account

    And user completes form with incorrect date email and birthdate
    And user click save button
    Then user sees validation message and close browser