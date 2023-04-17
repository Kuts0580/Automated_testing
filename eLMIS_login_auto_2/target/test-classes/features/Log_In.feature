Feature: eLMIS - Log In Page
  Scenario: Validate Successful Log In
    Given I access the eLMIS Log In Page
    When I enter a user name
    And I enter a password
    And I select a node
    And I click on the login button
    Then I should be able to access eLmis front page