Feature: Logout functionality

  Scenario: Login function
    Given login with bearer token
    When Send request logout
    Then Status code should be 200
    And Response body should contain message "success logout"
#    And Get list user assert json validation