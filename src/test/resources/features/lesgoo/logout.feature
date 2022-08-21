@loginDefault
Feature: Logout functionality

  Scenario: Logout function
    Given Logout with bearer token
    When Send request logout
    Then Status code should be 200
    And Response body should contain message "success logout"

  Scenario: Logout function without authorization
    Given Logout without bearer token
    When Send request logout
    Then Status code should be 400
    And Response body should contain message "missing or malformed jwt"