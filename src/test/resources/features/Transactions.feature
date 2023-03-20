Feature: Testing API Transactions

#  /transactions
  @transaction
  Scenario: POST Create New Transaction Unauthorized User
    Given Post create new transaction unauthorized with valid json file
    When Send request post create new transaction
    Then Response code should be 401 Unauthorized
    And Response body should contains message "missing or malformed jwt"

  @transaction
  Scenario: POST Create New Transaction Authorized with valid bearer token user and valid json file
    Given Post create new transaction authorized with valid bearer token user and valid json file
    When Send request post create new transaction
    Then Response code should be 201 created
    And Response body should contains message "transaction created"
    And Validate json schema post create new transaction

  @transaction
  Scenario: POST Create New Transaction Authorized with invalid bearer token user
    Given Post create new transaction authorized with invalid bearer token user
    When Send request post create new transaction
    Then Response code should be 401 Unauthorized
    And Response body should contains message "invalid or expired jwt"

  @transaction
  Scenario: POST Create New Transaction Authorized with valid bearer token super admin and valid json file
    Given Post create new transaction authorized with valid bearer token super admin and valid json file
    When Send request post create new transaction
    Then Response code should be 400 bad request
    And Response body should contains message "items should only belong to the user"

  @transaction
  Scenario: Post Create new transaction Authorized with invalid path
    Given Post Create new transaction Authorized with invalid path
    When Send request post create new transaction invalid path
    Then API response status code should be 404 not found
    And Response body should contains message "Not Found"

  @transaction
  Scenario: Post Create new transaction authorized with not enough products json file
    Given Post Create new transaction authorized with not enough products json file
    When Send request post create new transaction
    Then Response code should be 400 bad request
    And Response body should contains message "product stock is not enough"

  @transaction
  Scenario: Post Create new transaction Authorized with invalid id products json file
    Given Post Create new transaction Authorized with invalid id products json file
    When Send request post create new transaction
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (bad request)"

  @transaction
  Scenario: Post Create new transaction Authorized with invalid id customer json file
    Given Post Create new transaction Authorized with invalid id customer json file
    When Send request post create new transaction
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (bad request)"

  @transaction
  Scenario: Post Create new transaction Authorized with empty products json file
    Given Post Create new transaction Authorized with empty products json file
    When Send request post create new transaction
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (bad request)"

  @transaction
  Scenario: Post Create new transaction Authorized with empty quantity json file
    Given Post Create new transaction Authorized with empty quantity json file
    When Send request post create new transaction
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (bad request)"

#    bug
  @transaction
  Scenario: Post Create new transaction Authorized with null payment method json file
    Given Post Create new transaction Authorized with null payment method json file
    When Send request post create new transaction
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (bad request)"

#  Get Sell/Buy History

  @transaction
  Scenario: Get transaction detail sell order history with valid path
    Given Get transaction sell order history with valid path
    When Send request get transaction sell order history valid path
    Then Response code should be 200 OK


  @transaction
  Scenario: Get transaction detail sell order history with invalid path
    Given Get transaction sell order history with invalid path
    When Send request get transaction sell order history invalid path
    Then API response status code should be 404 not found


# Update transaction history

  @transaction
  Scenario: Put Update transaction history with valid id transaction and valid bearer token
    Given Put update transaction history with valid id 106 and valid bearer token
    When Send request update transaction history
    Then Response code should be 200 OK
    And Response body should contains message "success update order"

  @transaction
  Scenario: Put Update transaction history with invalid id transaction and valid bearer token
    Given  Put update transaction history with invalid id "a" and valid bearer token
    When Send request update transaction history
    Then Response code should be 400 bad request
    And Response body should contains message "fail to read parameter"

  @transaction
  Scenario: Put update transaction history with valid id and invalid bearer token
    Given Put update transaction history with valid id 106 and invalid bearer token
    When Send request update transaction history
    Then Response code should be 401 Unauthorized
    And Response body should contains message "invalid or expired jwt"

  @transaction
  Scenario Outline: Put update transaction history without id and valid bearer token
    Given Put update transaction history without id "<id>" and valid bearer token
    When Send request update transaction history
    Then Response code should be 405
    And Response body should contains message "Method Not Allowed"
    Examples:
      | id |
      |    |

#  POST Create new buying
  @transaction
  Scenario: Post transaction buy with valid Authorized bearer token user and valid json file
    Given Post transaction buy with valid authorized bearer token user and valid json file
    When Send request post create transaction buy
    Then Response code should be 201 created
    And Response body should contains message "transaction created"
    And Validate json schema post create transaction buy user

  @transaction
  Scenario: Post transaction buy with valid authorized bearer token super admin and valid json file
    Given Post transaction buy with valid authorized bearer token super admin and valid json file
    When Send request post create transaction buy
    Then Response code should be 201 created
    And Response body should contains message "transaction created"
    And Validate json schema post create transaction buy super admin

  @transaction
  Scenario: Post transaction buy with invalid authorized bearer token user and valid json file
    Given Post transaction buy with invalid authorized bearer token user and valid json file
    When Send request post create transaction buy
    Then Response code should be 401 Unauthorized
    And Response body should contains message "invalid or expired jwt"

  @transaction
  Scenario: Post transaction buy with invalid authorized bearer token super admin and valid json file
    Given Post transaction buy with invalid authorized bearer token super admin and valid json file
    When Send request post create transaction buy
    Then Response code should be 401 Unauthorized
    And Response body should contains message "invalid or expired jwt"

  @transaction
  Scenario: Post transaction buy with valid authorized bearer token user and invalid product id json file
    Given Post transaction buy with valid authorized bearer token user and invalid product id json file
    When Send request post create transaction buy
    Then Response code should be 400 bad request
    And Response body should contains message "items should only belong to the super admin"

  @transaction
  Scenario:  Post transaction buy with valid authorized bearer token super admin and invalid product id json file
    Given Post transaction buy with valid authorized bearer token super admin and invalid product id json
    When Send request post create transaction buy
    Then Response code should be 400 bad request
    And Response body should contains message "items should only belong to the super admin"

  @transaction
  Scenario: Post transaction buy with valid authorized bearer token user and too much quantity json file
    Given Post transaction buy with invalid authorized bearer token user and too much quantity product json file
    When Send request post create transaction buy
    Then Response code should be 400 bad request
    And Response body should contains message "product stock is not enough"

  @transaction
  Scenario: Post transaction buy with valid authorized bearer token super admin and too much quantity json file
    Given Post transaction buy with invalid authorized bearer token super admin and too much quantity product json file
    When Send request post create transaction buy
    Then Response code should be 400 bad request
    And Response body should contains message "product stock is not enough"

  @transaction
  Scenario: Post transaction buy with unauthorized bearer token and valid json file
    Given Post transaction but with unauthorized bearer token user and valid json file
    When Send request post create transaction buy
    Then Response code should be 401 Unauthorized
    And Response body should contains message "missing or malformed jwt"

  @transaction
  Scenario: Post transaction buy with valid authorized bearer token user and with null product json file
    Given Post transaction buy with valid authorized bearer token user and with null product json file
    When Send request post create transaction buy
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (bad request)"

  @transaction
  Scenario: Post transaction buy with valid authorized bearer token user and with invalid customer id json file
    Given Post transaction buy with valid authorized bearer token user and invalid customer id json file
    When Send request post create transaction buy
    Then Response code should be 500
    And Response body should contains message "server problem"

  @transaction
  Scenario: Post transaction buy with valid authorized bearer token user and with empty product id and quantity json file
    Given Post transaction buy with valid authorized bearer token user and empty product id
    When Send request post create transaction buy
    Then Response code should be 400 bad request
    And Response body should contains message "wrong input (bad request)"

  @transaction
  Scenario: Post transaction buy valid authorized bearer token user and with invalid path
    Given Post transaction buy with valid authorized bearer token user and valid json file with invalid path
    When Send request post create invalid transaction buy
    Then Response code should be 405
    And Response body should contains message "Method Not Allowed"





























