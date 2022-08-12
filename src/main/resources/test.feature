Feature: Alpha Login
  Scenario: Log in Alpha
    Given I launch chrome browser
    When I login to Alpha
    Then I access my investment Portfolio
    And I logout of Alpha