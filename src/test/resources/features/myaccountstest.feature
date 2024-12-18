@regression
Feature: My account

  As a user
  I want to check my account login log-out register functionality

  Background: I am on home page

  @sanity
  Scenario: User should navigate to register page successfully
    When I click on my account link
    And I call the method selectMyAccountOptions method and pass the parameter "Register"
    Then I should see text register account

  @smoke
  Scenario: User should navigate to login page successfully
    When I click on my account link
    And I call the method selectMyAccountOptions method and pass the parameter "Login"
    Then I should see text returning customer


  Scenario: User should register account successfully
    When I click on my account link
    And I call the method selectMyAccountOptions method and pass the parameter "Register"
    And I enter First Name "prime"
    And I enter Last Name "test"
    And I enter Email "primetest"
    And I enter Telephone "0754543534"
    And I enter Password "prime1234"
    And I enter Confirm Password "prime123"
    And I select Subscribe "Yes" radio button
    And I click on Privacy Policy check box
    And I click on Continue button for registration
    And I should see the message Your Account Has Been Created!
    And I click on Continue button
    And I click on my account link
    And I call the method selectMyAccountOptions method and pass the parameter "Logout"
    And I should see the text Account Logout
    Then I click on Continue button after logout

  Scenario: User should login and logout successfully
    When I click on my account link
    And I call the method selectMyAccountOptions method and pass the parameter "Login"
    And I enter Email "primetest@gmail.com" on login page
    And I enter password "prime1234" on login page
    And I click on login button
    And I should see My Account text
    And I click on my account link
    And I call the method selectMyAccountOptions method and pass the parameter "Logout"
    And I should see the text Account Logout
    Then I click on Continue button after logout