Feature: My test

#  Background:
#    Given Navigate to ramiLevy site

#  Scenario:  Go to login page
##    When i login with user name "shahdno2001@gmail.com" and password "shahd2001"
#    When i login with user name "mhajnabkr@gmail.com" and password "bakermhajna"
#    Then validate i am loged in with "baker" user


#  Scenario:  Go to login page
##    When i login with user name "shahdno2001@gmail.com" and password "shahd2001"
#    When i add item number "373337" to the cart



Scenario: product page validate
 When i click product my product
  Then navigate to the product page

Scenario: logout from account
 When i press logout button
 Then navigate to guest page


#Scenario:
# When i click product my product
#  Then navigate to the product page

 Scenario: delete cart
  When i click delete cart
  Then validate that the cart is empty

