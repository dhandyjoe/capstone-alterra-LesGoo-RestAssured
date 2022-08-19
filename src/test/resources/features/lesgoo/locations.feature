Feature: Locations

  Scenario: Add valid Location
    When add locations with groupId "asjhdbashjda" and latitude 1.6323423 and longitude -98.71357612
    When send request add locations
    Then Status code should be 200
    And Response body should contain message "ok"

  Scenario: Add valid Location without authorization
    When add locations with groupId "asjhdbashjda" and latitude 1.6323423 and longitude -98.71357612 wihtout authorization
    When send request add locations
    Then Status code should be 400
    And Response body should contain message "missing or malformed jwt"

