Feature: Login functionality

  Scenario: Login with valid data
    Given login with username "testingqa" and password "qwerty"
    When Send request login
    Then Status code should be 200
    And Response body should contain message "success login"
#    And Get list user assert json validation