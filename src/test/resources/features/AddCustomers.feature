Feature: Testing API Input Customer

  @CapStone @Positive-Case @Customer
  Scenario: POST input customer with valid json
    Given Post inputCustomer with valid json
    When Send request inputCustomer
    Then Should return status code 201
    And Response body page should be "success add new customer"

  @CapStone @Negative-Case @Customer
  Scenario: POST input customer with invalid json
    Given Post inputCustomer with invalid json
    When Send request inputCustomer
    Then Should return status code 400
    And Response body page should be "register customer phone number must be a number"

  @CapStone @Negative-Case @Customer
  Scenario: POST input customer without input email
    Given Post inputCustomer without email
    When Send request inputCustomer
    Then Should return status code 400
    And Response body page should be "required fields must be filled"

  @CapStone @Negative-Case @Customer
  Scenario: POST input customer without input name
    Given Post inputCustomer without name
    When Send request inputCustomer
    Then Should return status code 400
    And Response body page should be "required fields must be filled"


  @CapStone @Negative-Case @Customer
  Scenario: POST input customer without input address
    Given Post inputCustomer without address
    When Send request inputCustomer
    Then Should return status code 400
    And Response body page should be "required fields must be filled"


  @CapStone @Negative-Case @Customer
  Scenario: POST input customer without input phone number
    Given Post inputCustomer without phone number
    When Send request inputCustomer
    Then Should return status code 400
    And Response body page should be "required fields must be filled"


  @CapStone @Negative-Case @Customer
  Scenario: POST input customer with registered email
    Given Post inputCustomer with registered email
    When Send request inputCustomer
    Then Should return status code 409
    And Response body page should be "register new customer email already exist"


  @CapStone @Negative-Case @Customer
  Scenario: POST input customer with registered phone number
    Given Post inputCustomer with registered phone number
    When Send request inputCustomer
    Then Should return status code 409
    And Response body page should be "register new customer phone number already exist"

