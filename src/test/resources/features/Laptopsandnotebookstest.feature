@regression
Feature: Laptop and notebook

  As a user
  I want to check functionality of laptop and notebook page

  Background: I am on home page

  @sanity
  Scenario: I should arrange product in price high to low order successfully
    When I mouse hover and click on laptop and notebook tab
    And I select menu "Show AllLaptops & Notebooks"
    And I select Product shorting menu "Price (High > Low)"
    Then I should view product arrange in price high to low order successfully


  @smoke
  Scenario: User should place order successfully
    When I mouse hover and click on currency dropdown
    And I mouse hover and click on  "£Pound Sterling"
    When I mouse hover and click on laptop and notebook tab
    And I select menu "Show AllLaptops & Notebooks"
    And I select product sort by "Price (High > Low)"
    And I select product "HP LP3065"
    And I should view product text "HP LP3065"
    And I click on add to cart button
    And I should view the message Success: You have added "HP LP3065" to your shopping cart!
    And I click on shopping cart link into success message
    And I should view the shopping cart title
    And I should view the product name "HP LP3065"
    And I change quantity "2" for product
    And I click on update quantity
    And I should view cart modified message
    And I should view the total "£149.45"