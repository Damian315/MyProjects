Feature: Google search

  Scenario: user can search any keyword

    Given an open browser with google.com
    When a keyword Korn is entered in input field
    Then the first one should contain Korn
    And close browser