Feature: Logout functionality

  Scenario: register with valid data
    When register with username "hiruka" and email "hiruka@gmail.com" phone "0545" and password "qwerty"
    When Send request register
    Then Status code should be 201
    And Response body should contain message "success operation"

  Scenario: register with invalid username
    When register with username "" and email "wakanda@gmail.com" phone "123" and password "qwerty"
    When Send request register
    Then Status code should be 400
    And Response body should contain message "Invalid Username"

  Scenario: register with invalid email
    When register with username "wakanda" and email "" phone "123" and password "qwerty"
    When Send request register
    Then Status code should be 400
    And Response body should contain message "Invalid Email"

  Scenario: register with invalid password
    When register with username "wakanda" and email "wakanda@gmail.com" phone "123" and password ""
    When Send request register
    Then Status code should be 400
    And Response body should contain message "Invalid Password"

  Scenario: register with invalid phone number
    When register with username "wakanda" and email "wakanda@gmail.com" phone "" and password "qwerty"
    When Send request register
    Then Status code should be 400
    And Response body should contain message "Invalid Phone"

  Scenario: register with existing username
    When register with username "hiruka" and email "hiruka@gmail.com" phone "666" and password "qwerty"
    When Send request register
    Then Status code should be 400
    And Response body should contain message "username or email or Telephone Number Already Exist"

  Scenario: register without body response
    When register with username "" and email "" phone "" and password ""
    When Send request register
    Then Status code should be 400
    And Response body should contain message "Invalid Username"



