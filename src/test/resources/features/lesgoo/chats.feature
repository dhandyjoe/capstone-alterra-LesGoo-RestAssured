Feature: Add Chats

  Scenario: Add Chats
    When add chats with group_id "asjhdbashjda" and message "sahdbsa" and isSOS "false"
    When send request add chats
    Then Status code should be 200
    And Response body should contain message "ok"

