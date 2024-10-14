Feature: Update user information after login

  @UpdateUserInformation
  Scenario: Change user birthdate, gender and sign up for a newsletter

    Given user is logged in to CodersLab shop
    When user go to UserInformationPage
    And user change date account
    And user saves information
    Then user sees message Information successfully updated and close browser