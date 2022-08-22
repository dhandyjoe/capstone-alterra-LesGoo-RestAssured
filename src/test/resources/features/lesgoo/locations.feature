@access
Feature: Locations

  Scenario Outline: Add valid Location
    When add locations with groupId "<groupId>" and latitude <latitude> and longitude <longitude>
    When send request add locations
    Then Status code should be 200
    And Response body should contain message "success update location"
    Examples:
      | groupId                                | latitude       | longitude     |
      | c5e710db-8c4a-48a7-88e0-1ffdd74dd9f1   | 1.6323423      | -98.71357612  |
      | c5e710db-8c4a-48a7-88e0-1ffdd74dd9f1   | 106.333        | 50.22         |

  Scenario: Add valid Location without authorization
    When add locations with groupId "qweqwe" and latitude 1.6323423 and longitude -98.71357612 wihtout authorization
    When send request add locations
    Then Status code should be 400
    And Response body should contain message "missing or malformed jwt"

