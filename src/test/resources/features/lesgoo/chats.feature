Feature: Add Chats

  Scenario: Add Chats
    When add chats with groupId "asjhdbashjda" and message "halo, apa kabar?" and isSOS "false"
    When send request add chats
    Then Status code should be 200
    And Response body should contain message "ok"

  Scenario: Add Chats without authorization
    When add chats with groupId "asjhdbashjda" and message "halo, apa kabar?" and isSOS "false" without authorization
    When send request add chats
    Then Status code should be 400
    And Response body should contain message "missing or malformed jwt"

