Feature: Testing API Register Tenant

  @register
  Scenario: Post register tenant with valid json
    Given Post register tenant with valid json file
    When Send request post register tenant
    Then Response code should be 201 created
    And Response body should contains message "success created account"

  @register
  Scenario: Register Tenant without business name
    Given Post register tenant without business name json file
    When Send request post register tenant
    Then Response code should be 400 bad request
    And Response body should contains message "required fields must be filled"


  @register
  Scenario: Post register tenant without email
    Given Post register tenant without email invalid json file
    When Send request post register tenant
    Then Response code should be 400 bad request
    And Response body should contains message "required fields must be filled"

  @register
  Scenario: Post register tenant without password
    Given Post register tenant without password invalid json file
    When Send request post register tenant
    Then Response code should be 400 bad request
    And Response body should contains message "required fields must be filled"

  @register
  Scenario: Post register tenant without phone
    Given Post register tenant without phone invalid json file
    When Send request post register tenant
    Then Response code should be 400 bad request
    And Response body should contains message "required fields must be filled"

  @register
  Scenario: Post register tenant without address
    Given Post register tenant without address invalid json file
    When Send request post register tenant
    Then Response code should be 400 bad request
    And Response body should contains message "required fields must be filled"

  @register
  Scenario: Post register Tenant with email already registered
    Given Post register user already registered with valid json file
    When Send request post register tenant
    Then Response code should be 409 bad request
    And Response body should contains message "register new user email already exist"

  @register
  Scenario: Post register Tenant with invalid format email
    Given Post register user with invalid format email on valid json file
    When Send request post register tenant
    Then Response code should be 400 bad request
    And Response body should contains message "incorrect register business email format"

  @register
  Scenario: Post register Tenant with invalid format phone number
    Given Post register user with invalid format phone on valid json file
    When Send request post register tenant
    Then Response code should be 400 bad request
    And Response body should contains message "register business phone number must be a number"

  @register
  Scenario: Register Tenant with invalid Path
    Given Post register user with invalid Path
    When Send request post register user on invalid path
    Then API response status code should be 404 not found

  @register
  Scenario: Register Tenant With Invalid Format Password
    Given Post register user with invalid format password json file
    When Send request post register tenant
    Then Response code should be 400 bad request
    And Response body should contains message "password must be at least 8 characters long, must contain uppercase letters, must contain lowercase letters, must contain numbers, must not be too general"


