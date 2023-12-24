Feature: My test

  Background:
    Given Navigate to ramiLevy site

  Scenario:  Go to login page
    When i login with user name "shahdno2001@gmail.com" and password "shahd2001"
    Then validate i am loged in with "shahd" user

