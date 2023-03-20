Feature: Testing API Admin Tenant

  @admin
#    /products/admin
  Scenario: Product Admin With Bearer Token and valid Path
    Given Get Product Admin With Bearer Token on valid Path
    When Send request get product admin on valid path
    Then Response code should be 200 OK
    And Response body should contains message "success show all products"

  @admin
  Scenario: Product Admin With Bearer Token and invalid Path
    Given Get Product Admin with Bearer Token on invalid Path
    When Send request get product admin with invalid path
    Then Response code should be 400 bad request


  @admin
  Scenario: Product Admin Without Bearer Token and valid path
    Given Get Product Admin without Bearer Token on valid path
    When Send request get product admin on valid path
    Then Response code should be 401 Unauthorized
    And Response body should contains message "missing or malformed jwt"

#       /transactions/admin

  @admin
  Scenario: Transaction Admin With Bearer Token on valid path
    Given Get Transaction Admin with Bearer Token on valid path
    When Send request get transaction admin with valid path
    Then Response code should be 200 OK
    And Response body should contains message "success get admin transaction history"

  @admin
  Scenario: Transaction Admin With Bearer Token on invalid path
    Given Get Transaction Admin with Bearer Token on invalid path
    When Send request get transaction admin with invalid path
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (data not found)"

  @admin
  Scenario: Transaction Admin Without Bearer Token on valid path
    Given Get Transaction Admin without Bearer Token on valid path
    When Send request get transaction admin with valid path
    Then Response code should be 401 Unauthorized
    And Response body should contains message "missing or malformed jwt"

#      /transactions/1/admin
  @admin
  Scenario: Get admin transaction history With valid id on valid path
    Given Get admin Transaction history with valid id 1 on valid path
    When Send request get admin transaction history on valid path
    Then Response code should be 200 OK
    And Response body should contains message "success get admin transaction history"

  @admin
  Scenario: Get admin transaction history With invalid id on invalid path
    Given Get admin Transaction history with invalid id "aaa" on invalid path
    When Send request get admin transaction history on invalid path
    Then Response code should be 404
    And Response body should contains message "Not Found"

  @admin
  Scenario: Get admin transaction history with valid id on invalid path
    Given Get admin Transaction history with valid id 1 on invalid path
    When Send request get admin transaction history on invalid path
    Then API response status code should be 404 not found
    And Response body should contains message "Not Found"


  @admin
  Scenario Outline: Get admin transaction history with empty id on valid path
    Given Get admin Transaction history with empty "<id>" on valid path
    When Send request get admin transaction history on empty id
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (data not found)"
  Examples:
    | id |
    |    |

