Feature: Users

  @access
  Scenario: Get users details
    Given Get user details
    When Send request user details
    Then Status code should be 302
    And Response body should contain message "Success Operation"
    And Username response should be "hiruka" and email should be "hiruka@gmail.com"

  Scenario: Get users details without authorization
    Given Get user details without authorization
    When Send request user details
    Then Status code should be 400
    And Response body should contain message "missing or malformed jwt"

  @update
  Scenario: Update user data
    Given Put update user with username "abcd", email "abcd@gmail.com", phone "123456"
    When Send request user update
    Then Status code should be 200
    And Response body should contain message "success operation"

  @update
  Scenario: Update user data with existing data
    Given Put update user with username "abcd", email "abcd@gmail.com", phone "123456"
    When Send request user update
    Then Status code should be 200
    And Response body should contain message "success operation"

    @registerlogin
  Scenario: Delete users
    Given Delete users
    When Send request user delete
    Then Status code should be 200
    And Response body should contain message "Success Operation"




