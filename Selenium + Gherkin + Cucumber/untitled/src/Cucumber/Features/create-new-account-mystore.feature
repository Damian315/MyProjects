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
  Scenario Outline: Check validation page create new account

    When user completes form sets "<name>", "<surname>", "<password>" with incorrect date email "<email>" and birthdate "<birthdate>"
    And user click save button
    Then user sees validation message and close browser

    Examples:
    | name | surname  | password | email         | birthdate |
    | Jan  | Kowalski | passpass | test123@wp.pl | 01311999  |
