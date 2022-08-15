Feature: Login functionality

  Scenario: Login with valid data
    Given login with username "testingqa" and password "qwerty"
    When Send request login
    Then Status code should be 200
    And Response body should contain message "success login"
#    And Get list user assert json validation

  Scenario: Login with invalid username
    Given login with username "" and password "asd123"
    When Send request login
    Then Status code should be 400
    And Response body should contain message "Username or Password Incorrect"

  Scenario: Login with invalid password
    Given login with username "redfox" and password ""
    When Send request login
    Then Status code should be 400
    And Response body should contain message "Username or Password Incorrect"

  Scenario: Login with all invalid data
    Given login with username "" and password ""
    When Send request login
    Then Status code should be 400
    And Response body should contain message "Username or Password Incorrect"

  Scenario: Login with unregistered account
    Given login with username "qweqwe" and password "qweqwe"
    When Send request login
    Then Status code should be 400
    And Response body should contain message "Username or Password Incorrect"






