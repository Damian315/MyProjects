Feature: Update user information after login

  @UpdateUserInformation
  Scenario: Change user birthdate, gender and sign up for a newsletter

    Given user signUp and goes to information account page
    When user change account data
    And user saves information
    Then user sees message Information successfully updated and close browser