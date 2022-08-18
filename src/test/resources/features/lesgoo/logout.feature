@logout
Feature: Logout functionality

  Background:
    Given login with username "testingqa" and password "qwerty"
    When Send request login
    Then Status code should be 200
    And Response body should contain message "success login"

  Scenario: Logout function
    Given Logout with bearer token
    When Send request logout
    Then Status code should be 200
    And Response body should contain message "success logout"