Feature: Loggin test

  Background: Connected account
    Given logged in user

  Scenario: add item to cart
    When i add item number "373337" to the cart
    Then validate status code
    And validate that the item in the cart

  Scenario: logout from account
    When i press logout button
    Then validate user loged out

  Scenario: delete cart
    When i click delete cart
    Then validate that the cart is empty
