Feature: Product purchasing from a store

  @ProductPurchasing
  Scenario Outline: Purchasing product humming printed sweater

    Given an open browser with MyStore, signUp, choose product and check rabat
    When user choose product size "<size>" and quantity "<quantity>"
    And user adds product to the cart and goes to checkout
    And user confirm address, delivery option and payments type
    And user enter button place order
    Then user sees confirmed order, check quantity "<quantity>", order history and close browser

    Examples:
    | size | quantity |
    | M    | 4         |
#    | L    | 3        |
#    | XL   | 4        |