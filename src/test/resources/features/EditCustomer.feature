Feature: Testing API Edit Customer

  @CapStone @Positve-Case @Customer
  Scenario: PUT edit customer with valid parameter id
    Given Put editCustomer with valid id 32
    When Send request editCustomer
    Then Should return status code 200
    And Response body should be "success edit customer data"

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer with invalid parameter id
    Given Put editCustomer with invalid id "abc"
    When Send request editCustomer
    Then Should return status code 404
    And Response body should be "customer not found"

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer with valid json
    Given Put editCustomer with valid json and id 32
    When Send request editCustomer
    Then Should return status code 200
    And Response body should be "success edit customer data"

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer with invalid json
    Given Put editCustomer with invalid json and id 32
    When Send request editCustomer
    Then Should return status code 400
    And Response body should be "incorrect update customer email format"

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer with valid token
    Given Put editCustomer with valid token and id 32
    When Send request editCustomer
    Then Should return status code 200
    And Response body should be "success edit customer data"

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer with invalid token
    Given Put editCustomer with invalid token and id 32
    When Send request editCustomer
    Then Should return status code 401
    And Response body should be "invalid or expired jwt"

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer without token
    Given Put editCustomer without token and id 32
    When Send request editCustomer
    Then Should return status code 401
