Feature:  Testing API Users Tenant
# Get User
  @users
  Scenario: Get Tenant With Valid Path
    Given Get users tenant with valid path
    When Send request get users tenant with valid path
    Then Response code should be 200 OK
    And Validate json schema get user tenant

  @users
  Scenario: Get Tenant With Invalid Path
    Given Get users tenant with invalid path
    When Send request get users tenant with invalid path
    Then Response code should be 404 bad request
    And Response body should contains message "Not Found"

  @users
  Scenario: Get Tenant With Valid Bearer Token
    Given authorization valid bearer token
    And Send request get users tenant
    Then Response code should be 200 OK
    And Validate json schema get user tenant

  @users
  Scenario: Get Tenant With Invalid Bearer Token
    Given authorization invalid bearer token
    When Send request get users tenant
    Then Response code should be 401 Unauthorized
    And Response body should contains message "invalid or expired jwt"

  @users
  Scenario: Get Tenant Without Bearer Token
    Given unauthorized without bearer token
    When Send request get users tenant
    Then Response code should be 401 Unauthorized
    And Response body should contains message "missing or malformed jwt"

  @users
  Scenario: Get Tenant With Valid Bearer Token on Invalid Path
    Given Get users tenant valid bearer token with invalid path
    When Send request get users tenant with invalid path
    Then API response status code should be 404 not found
    And Response body should contains message "Not Found"

# Put User Tenant
  @users
  Scenario: Put update tenant with Valid Json
    Given Put update tenant with valid json
    When Send request update tenant
    Then Response code should be 200 OK
    And Response body should contains message "success update tenant profile"

  @users
  Scenario: Put update tenant with invalid email json file
    Given Put update tenant with invalid email json file
    When Send request update tenant
    Then Response code should be 400 bad request
    And Response body should contains message "incorrect update business email format"

  @users
  Scenario: Put update tenant with invalid phone number json file
    Given Put update tenant with invalid phone number json file
    When Send request update tenant
    Then Response code should be 400 bad request
    And Response body should contains message "update business phone number must be a number"

  @users
  Scenario: Put update tenant with invalid password json file
    Given Put update tenant with invalid password json file
    When Send request update tenant
    Then Response code should be 400 bad request
    And Response body should contains message "password must be at least 8 characters long, must contain uppercase letters, must contain lowercase letters, must contain numbers, must not be too general"

  @users
  Scenario: Put update tenant with valid json file on invalid path
    Given Put update tenant with valid json file on invalid path
    When Send request update tenant with invalid path
    Then API response status code should be 404 not found

# Delete Tenant
  @users
  Scenario: Delete tenant with valid token on invalid path
    Given Delete tenant with valid token on invalid path
    When Send request delete tenant
    Then  API response status code should be 404 not found
























