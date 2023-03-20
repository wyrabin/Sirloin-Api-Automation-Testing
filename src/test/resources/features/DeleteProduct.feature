Feature: Testing API Delete Product

  @CapStone @Positive-Case @Product
  Scenario: DELETE product with valid parameter id
    Given Delete product with valid parameter id 83
    When Send request deleteProduct
    Then Should return status code 200
    And Response body should be "success delete product"
    And Validate json schema deleteProduct

  @CapStone @Negative-Case @Product
  Scenario: DELETE product with invalid parameter id
    Given Delete product with invalid parameter "abc"
    When Send request deleteProduct
    Then Should return status code 400
    And Response body should be "wrong product id parameter"

  @CapStone @Negative-Case @Product
  Scenario: DELETE product with invalid token
    Given Delete product with invalid token with id 80
    When Send request deleteProduct
    Then Should return status code 401
    And Response body should be "invalid or expired jwt"
    And Validate json schema deleteProduct
