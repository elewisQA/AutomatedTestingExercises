Feature: Create Login
  I want to create a login on the demo site

  Scenario Outline: Create many logins
    Given I am on the add a user page 
    When I enter a username: "<username>"
    And I enter a password: "<password>"
    Then I add a new user

    Examples: 
      | username | password |
      | abc123	 | def456		|
