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
  Scenario: Get invalid users Details
    Given Get user details
    When Send request invalid user Details
    Then Status code should be 404
  Scenario: Get users Details with invalid path
    Given Get user details
    When Send request not valid user Details
    Then Status code should be 404
  Scenario: Update User Data
    Given Put update user with valid json file
    When Send request user Details
    Then Status code should be 200
    And Response body should contain message "Success Operation"
  Scenario: Update User Data with existing data
    Given Put update user with valid json file
    When Send request user Details
    Then Status code should be 400
    And Response body should contain message "Bad Request"
  Scenario: Delete users
    Given login with bearer token
    Given Put update user with valid json file
    When Send request user Delete
    Then Status code should be 200
    And Response body should contain message "Success Operation"
  Scenario: Delete invalid users
    Given login with bearer token
    Given Put update user with valid json file
    When Send request invalid user Delete
    Then Status code should be 400
    And Response body should contain message "Invalid Id"
  Scenario: Delete users without authorization
    Given Put update user with valid json file
    When Send request user Delete
    Then Status code should be 400
    And Response body should contain message "Access Forbidden"
  Scenario: Delete users with invalid path
    Given Put update user with valid json file
    When Send request not valid user Delete
    Then Status code should be 400
    And Response body should contain message "Data Not Found"




