@regression
Feature: Desktop page

  As a user i want ot check desktop page and product details

  Background: I am on home page

  @sanity
  Scenario: I should arrange product in alphabetical order successfully
    When I mouse hover and click on desktop tab
    And I select menu "Show AllDesktops"
    And I select product sort by "Name (Z - A)"
    Then I should see product arrange in alphabetical order successfully

  @aaa
  Scenario Outline:I should be able to add product to cart successfully
    When I mouse hover and click on currency dropdown
    And I mouse hover and click on  "£Pound Sterling"
    And I mouse hover and click on desktop tab
    And I select menu "Show AllDesktops"
    And I select product sort by "Name (A - Z)"
    And I select product "<product>"
    And I should view product text "<product>"
    And I enter qty 1
    And I click on add to cart button
    And I should view the message Success: You have added "<product>" to your shopping cart!
    And I click on shopping cart link into success message
    And I should view the shopping cart title
    And I should view the product name "<product>"
    And I should view the model "<model>"
    Then I should view the total "<price>"
    Examples:
      | product      | model      | price   |
      | HTC Touch HD | Product 1  | £74.73  |
      | iPhone       | product 11 | £75.46  |
      | iPod Classic | product 20 | £74.73  |
      | MacBook      | Product 16 | £368.73 |
      | MacBook Air  | Product 17 | £736.23 |
      | Sony VAIO    | Product 19 | £736.23 |

