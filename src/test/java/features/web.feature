@web
Feature: Test Automation Web

  @login
  Scenario: Test valid login
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    When user click button login
    Then user go to home page

  @login
  Scenario: Test invalid login
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "invalid"
    When user click button login
    Then user able to see error message "Epic sadface: Username and password do not match any user in this service"

  @login
  Scenario: Test invalid login with locked_user
    Given user go to login page
    And user input username "locked_out_user"
    And user input pwd "secret_sauce"
    When user click button login
    Then user able to see error message "Epic sadface: Sorry, this user has been locked out."

  @sort-item
  Scenario: Test sort item Z to A
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click button login
    And user go to home page
    And user click combo box sort item
    When user click sort by name Z to A
    Then item list appear item sort from Z to A

  @sort-item
  Scenario: Test sort item price low to high
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click button login
    And user go to home page
    And user click combo box sort item
    When user click sort by price low to high
    Then item list appear item sort price low to high

  @sort-item
  Scenario: Test sort item price high to low
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click button login
    And user go to home page
    And user click combo box sort item
    When user click sort by price high to low
    Then item list appear item sort price high to low

  @add-to-cart
  Scenario: Test add to cart
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click button login
    And user go to home page
    And user click add to cart button
    And user click add to cart button
    Then verify cart item is match "2"

  @add-to-cart
  Scenario: Test negative add to cart
    Given user go to login page
    And user input username "error_user"
    And user input pwd "secret_sauce"
    And user click button login
    And user go to home page
    And user click add to cart button
    And user click add to cart button
    And user click add to cart button
    Then verify cart item is not match "3"

  @checkout
  Scenario: Test checkout
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click button login
    And user go to home page
    And user click add to cart button
    And user click add to cart button
    And user click cart logo
    And user click checkout button
    And user input first name "ridwan"
    And user input last name "jaya"
    And user input postal code "123"
    And user click continue button
    And user go to checkout overview
    When user click finish button
    Then user get message "Thank you for your order!"

  @checkout
  Scenario: Test negative checkout with no input one of checkout information field
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click button login
    And user go to home page
    And user click add to cart button
    And user click add to cart button
    And user click cart logo
    And user click checkout button
    And user input first name ""
    When user click continue button
    And user get message "Error: First Name is required"
    And user input first name "ridwan"
    And user input last name ""
    When user click continue button
    And user get message "Error: Last Name is required"
    And user input last name "jaya"
    And user input postal code ""
    When user click continue button
    And user get message "Error: Postal Code is required"
    And user input postal code "123"
    Then user click continue button

  @checkout
  Scenario: Test negative checkout finish button error
    Given user go to login page
    And user input username "error_user"
    And user input pwd "secret_sauce"
    And user click button login
    And user go to home page
    And user click add to cart button
    And user click add to cart button
    And user click cart logo
    And user click checkout button
    And user input first name "ridwan"
    And user input last name ""
    And user input postal code "123"
    And user click continue button
    And user go to checkout overview
    When user click finish button
    Then user cant finish checkout

