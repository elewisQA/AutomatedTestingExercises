Feature: Attempt Login
  I want to login to the demo site

  Scenario Outline: Log in to the demosite
    Given I am on the login page
    When I enter a username: "<username>"
    And I enter a password: "<password>"
    Then I should see "<status>"

    Examples: 
      | username 	| password	| status  		|
      | abc123	 	| def456		| Successful 	|
      | def456 		| abc123		| Failed	 		|
