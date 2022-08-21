@access
Feature: Locations

  Scenario Outline: Add valid Location
    When add locations with groupId "<groupId>" and latitude <latitude> and longitude <longitude>
    When send request add locations
    Then Status code should be 200
    And Response body should contain message "ok"
    Examples:
      | groupId                                | latitude       | longitude     |
      | a38a98ca-4552-49cd-93a4-c1637c809d10   | 1.6323423      | -98.71357612  |
      | a38a98ca-4552-49cd-93a4-c1637c809d10   | 106.333        | 50.22         |

  Scenario: Add valid Location without authorization
    When add locations with groupId "qweqwe" and latitude 1.6323423 and longitude -98.71357612 wihtout authorization
    When send request add locations
    Then Status code should be 400
    And Response body should contain message "missing or malformed jwt"

