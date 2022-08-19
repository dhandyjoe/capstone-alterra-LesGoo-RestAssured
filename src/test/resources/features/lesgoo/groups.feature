Feature: Groups functionality

  Scenario: Create a new group with valid req body
    Given Create a new group with valid req body
    When Send request create group
    Then Status code should be 201
    And Response body should contain message "Success Create New Groups"

  Scenario: Create a new group with invalid name
    Given Create a new group with invalid name
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with invalid description
    Given Create a new group with invalid description
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with invalid start_dest
    Given Create a new group with invalid start_dest
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with invalid final_dest
    Given create a new group with invalid final_dest
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with invalid start_date
    Given Create a new group with invalid start_date
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with invalid end_date
    Given Create a new group with invalid end_date
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with invalid groupimg
    Given Create a new group with invalid groupimg
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with invalid latitude
    Given Create a new group with invalid latitude
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with invalid longitude
    Given Create a new group with invalid longitude
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Create a new group with no body req
    Given Create a new group with no body req
    When Send request create group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Get detail group with valid id
    Given Get detail group with valid id "1"
    When Send request get detail group
    Then Status code should be 200
    And Response body should contain message "Success"
    And Response body should contain group name "Trip Rinjani"

  Scenario: Get detail group with invalid id
    Given Get detail group with invalid id "qweqwe"
    When Send request get detail group
    Then Status code should be 400
    And Response body should contain message "Invalid Id"

  Scenario: Post join group by valid data
    Given Post join group by valid data
    When Send request post join group
    Then Status code should be 200
    And Response body should contain message "Success Join Group"

  Scenario: Post join group by invalid data
    Given Post join group by invalid data
    When Send request post join group
    Then Status code should be 400
    And Response body should contain message "Invalid Param"

  Scenario: Delete group with valid id
    Given Delete group with valid id "a38a98ca-4552-49cd-93a4-c1637c809d10"
    When Send request delete group
    Then Status code should be 200
    And Response body should contain message "Success Operation"

  Scenario: Delete group with invalid id
    Given Delete group with invalid id "qweqwe"
    When Send request delete group
    Then Status code should be 400
    And Response body should contain message "Invalid Id"

  Scenario: Get all chat + participant location with valid groupId
    Given Get all chat + participant location with valid groupId
    When Send request get chats
    Then Status code should be 200
    And Response body should contain message "Success get data group chat"

  Scenario: Get all chat + participant location with valid groupId
    Given Get all chat + participant location with invalid groupId
    When Send request get chats
    Then Status code should be 200
    And Response body should contain message "Success get data group chat"

  Scenario: Leave group
    Given Leave group
    When Send request leave group
    Then Status code should be 200
    And Response body should contain message "ok"

  Scenario: Leave group with invalid groupId
    Given Leave group with invalid groupId
    When Send request leave group
    Then Status code should be 200
    And Response body should contain message "ok"
