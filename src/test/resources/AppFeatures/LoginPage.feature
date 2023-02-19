Feature: Login functionality of SauceDemo website

  Scenario: Successful login
    Given I am on the SauceDemo login page
    When I enter valid username and password
    And I click the login button
    Then I should be on the products page

  Scenario: Invalid login with incorrect password
    Given I am on the SauceDemo login page
    When I enter valid username and incorrect password
    And I click the login button
    Then I should see an error message saying "Epic sadface: Username and password do not match any user in this service"

  Scenario: Invalid login with non-existent user
    Given I am on the SauceDemo login page
    When I enter non-existent username and password
    And I click the login button
    Then I should see an error message saying "Epic sadface: Username and password do not match any user in this service"

