Feature: Create new address

  @CreateNewAddress
  Scenario Outline: Add new address login user

    Given an open browser with MySore, signUp and goes to new address
    When user completes form new address "<alias>", "<address>", "<city>", "<zip/postal code>", "<phone>"
    And save new address data
    Then displays information successfully add address data and close browser

    Examples:
      | alias  | address     | city        | zip/postal code | phone     |
      | test2  | Anielin 10  | Nowe Miasto | PO16 7GZ        | 345678901 |

