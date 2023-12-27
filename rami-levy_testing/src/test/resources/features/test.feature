Feature: My test

  Scenario: login
    When i login with username "mhajnabkr@gmail.com" and password "bakermhajna"
    Then validate i am loged in with "baker" user

  Scenario: Search for a Product on the Homepage
    When I fill 'חלב' in input search
    And click search button
    Then Therefore I get a list of products

  Scenario: product page validate
    When i click product my product
    Then validate the product page

  Scenario: click product
    When i click a specific product
    Then open popup for a product
    And get a barcode of the product "7290017142388"

  Scenario: Filter Results by Category and Verify Count
    Given I choose a fruit and vegetable feature
    When I press the filter button
    And I filter results by a specific category
    Then the displayed product count should match the expect