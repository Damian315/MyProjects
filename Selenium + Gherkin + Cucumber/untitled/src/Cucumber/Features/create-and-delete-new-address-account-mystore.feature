Feature: Create new address and delete address

  Background:
    Given an open browser with MySore, signUp and goes to new address

  @CreateNewAddress
  Scenario Outline: Add new address login user

    When user completes form new address "<alias>", "<address>", "<city>", "<zip/postal code>", "<phone>"
    And save new address data
    Then displays information successfully add address data and close browser

    Examples:
      | alias  | address     | city        | zip/postal code | phone     |
      | test2  | Anielin 10  | Nowe Miasto | PO16 7GZ        | 345678901 |

  @DeleteDataAddress
  Scenario: Delete user data address

    When user goes to address page and delete data address
    Then displays information message: Address successfully deleted!
