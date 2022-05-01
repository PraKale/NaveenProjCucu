Feature: Login page feature

##  @tag1
  Scenario: Login page title
    Given user is on login page
    When user gets the title of page
    Then the page title should be "Your store. Login"
    
    
  Scenario: Successful Login with valid credentials
    Given user is on login page
    When user enters Email as "admin@yourstore.com" and Password as "admin"
    And click on login button
    Then the page title should be "Dashboard / nopCommerce administration"

##  @tag2
##  Scenario Outline: Title of your scenario outline
##    Given I want to write a step with <name>
##  When I check for the <value> in step
##    Then I verify the <status> in step

##    Examples: 
##      | name  | value | status  |
##      | name1 |     5 | success |
##      | name2 |     7 | Fail    |
