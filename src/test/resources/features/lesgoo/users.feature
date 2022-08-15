Feature: Users

  Background: Login
    Given login with username "testingqa" and password "qwerty"
    When Send request login
    Then Status code should be 200
    And Response body should contain message "success login"
  Scenario: Get users Details
    Given Get user details
    When Send request user Details
    Then Status code should be 200
    And Response body should contain message "Success Operation"


