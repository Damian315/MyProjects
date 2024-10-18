Feature: Product purchasing from a store

  @ProductPurchasing
  Scenario Outline: Purchasing product humming printed sweater

    Given an open browser with MyStore, signUp, choose product and check rabat
    When user choose product size "<size>" and quantity "<quantity>"

    Examples:
    | size | quantity |
    | S    | 4         |
#    | M    | 2        |
#    | L    | 3        |
#    | XL   | 4        |