Feature: Users

  Background: Successfully login
    Given login with username "testingqa" and password "qwerty"
    When Send request login
    Then Status code should be 200
    And Response body should contain message "success login"

  Scenario: Get users details
    Given Get user details
    When Send request user details
    Then Status code should be 200
    And Response body should contain message "Success Operation"

  Scenario: Get users details without authorization
    Given Get user details without authorization
    When Send request user details
    Then Status code should be 404

  Scenario: Update user data
    Given Put update user with valid json file
    When Send request user details
    Then Status code should be 200
    And Response body should contain message "Success Operation"

  Scenario: Update user data with existing data
    Given Put update user with valid json file
    When Send request user details
    Then Status code should be 200
    And Response body should contain message "Success Operation"

  Scenario: Delete users
    Given Delete users
    When Send request user delete
    Then Status code should be 200
    And Response body should contain message "Success Operation"




