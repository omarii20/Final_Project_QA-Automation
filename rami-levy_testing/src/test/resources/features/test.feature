Feature: My test

  Background:
    Given Navigate to ramiLevy site

#  Scenario:  Go to login page
##   When i login with user name "mhajnabkr@gmail.com" and password "bakermhajna"
#    When i login with user name "mhajnabkr@gmail.com" and password "bakermhajna"
#    Then validate i am loged in with "baker" user

#  Scenario:  Go to login page
##   When i login with user name "shahdno2001@gmail.com" and password "shahd2001"
#    When i add item number "373337" to the cart

# Then validate that the item in the cart
# Scenario:
#  When i click product my product
#  Then navigate to the product page

#
#Scenario: product page validate
# When i click product my product
#  Then navigate to the product page

#Scenario: logout from account
# When i press logout button
# Then navigate to guest page
#

  Scenario: Go to login page
    When i click a specific product
    Then open popup for a product
    And get a barcode of the product "7290017142388"

# Scenario: product page validate
 # When i click product my product
 # Then navigate to the product page

# Scenario: logout from account
 # When i press logout button
 # Then navigate to guest page

# Scenario: delete cart
#  When i click delete cart
#  Then validate that the cart is empty


 Scenario: Filter Results by Category and Verify Count
  Given I choose a fruit and vegetable feature
  When I press the filter button
  And I filter results by a specific category
 Then the displayed product count should match the expect