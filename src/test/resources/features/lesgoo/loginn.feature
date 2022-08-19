@logout
Feature: Login functionality

  Scenario: Login with valid data
    Given login with username "testingqa" and password "qwerty"
    When Send request login
    Then Status code should be 200
    And Response body should contain message "success login"

  Scenario: Login with invalid username
    Given login with username "" and password "qwerty"
    When Send request login
    Then Status code should be 400
    And Response body should contain message "Key: 'LoginFormat.Username' Error:Field validation for 'Username' failed on the 'required' tag"

  Scenario: Login with invalid password
    Given login with username "testingqa" and password ""
    When Send request login
    Then Status code should be 400
    And Response body should contain message "Key: 'LoginFormat.Password' Error:Field validation for 'Password' failed on the 'required' tag"

  Scenario: Login with all invalid data
    Given login with username "" and password ""
    When Send request login
    Then Status code should be 400

  Scenario: Login with unregistered account
    Given login with username "qweqwe" and password "qweqwe"
    When Send request login
    Then Status code should be 400
    And Response body should contain message "record not found"