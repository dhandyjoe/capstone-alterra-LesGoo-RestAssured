@access
Feature: Add Chats

  Scenario Outline: Add Chats
    When add chats with groupId "<groupId>" and message "<message>" and isSOS "<isSOS>"
    When send request add chats
    Then Status code should be 200
    And Response body should contain message "ok"
    Examples:
      | groupId                                | message          | isSOS   |
      | a38a98ca-4552-49cd-93a4-c1637c809d10   | halo, apa kabar? | false   |
      | a38a98ca-4552-49cd-93a4-c1637c809d10   | namaku Hirukaaaa | false   |

  Scenario: Add Chats without authorization
    When add chats with groupId "qweqwe" and message "halo, apa kabar?" and isSOS "false" without authorization
    When send request add chats
    Then Status code should be 400
    And Response body should contain message "missing or malformed jwt"

