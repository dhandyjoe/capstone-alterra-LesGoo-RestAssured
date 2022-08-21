@logoutDefault
Feature: Login functionality

  Scenario Outline: Login with valid data
    Given login with username "<username>", password "<password>", fcm_token "<fcm_token>"
    When Send request login
    Then Status code should be 200
    And Response body should contain message "success login"
    Examples:
    | username      | password    | fcm_token   |
    | hiruka        | qwerty      | fcm_token   |
    | jenny2        | qwerty      | fcm_token   |

  Scenario Outline: Login with invalid username
    Given login with username "<username>", password "<password>", fcm_token "<fcm_token>"
    When Send request login
    Then Status code should be 400
#    And Response body should contain message "Key: 'LoginFormat.Username' Error:Field validation for 'Username' failed on the 'required' tag"
    Examples:
      | username      | password    | fcm_token   |
      |               | qwerty      | fcm_token   |

  Scenario Outline: Login with invalid password
    Given login with username "<username>", password "<password>", fcm_token "<fcm_token>"
    When Send request login
    Then Status code should be 400
#    And Response body should contain message "Key: 'LoginFormat.Password' Error:Field validation for 'Password' failed on the 'required' tag"
    Examples:
      | username      | password    | fcm_token   |
      | hiruka        |             | fcm_token   |

  Scenario Outline: Login with all invalid data
    Given login with username "<username>", password "<password>", fcm_token "<fcm_token>"
    When Send request login
    Then Status code should be 400
    Examples:
      | username      | password    | fcm_token   |
      |               |             |             |

  Scenario Outline: Login with unregistered account
    Given login with username "<username>", password "<password>", fcm_token "<fcm_token>"
    When Send request login
    Then Status code should be 400
    And Response body should contain message "record not found"
    Examples:
      | username      | password    | fcm_token   |
      | qweqwe        | qweqwe      | fcm_token   |
