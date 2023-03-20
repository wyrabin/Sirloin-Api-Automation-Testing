Feature: Testing API Update Product

  @CapStone @Positive-Case @Product
  Scenario: PUT update product with valid parameter id
    Given Put updateProduct with valid parameter 140
    When Send request updateProduct
    Then Should return status code 200
    And Response body should be "success update product"
    And Validate json schema updateProduct


  @CapStone @Positive-Case @Product
  Scenario: PUT update product with valid json
    Given Put updateProduct with valid parameter 140
    When Send request updateProduct
    Then Should return status code 200
    And Response body should be "success update product"
    And Validate json schema updateProduct

  @CapStone @Negative-Case @Product
  Scenario: PUT update product with invalid parameter id
    Given Put updateProduct with invalid parameter "abc"
    When Send request updateProduct Invalid
    Then Should return status code 400

  @CapStone @Positive-Case @Product
  Scenario: PUT update product with valid token
    Given Put updateProduct with valid token and id 140
    When Send request updateProduct
    Then Should return status code 200
    And Response body should be "success update product"
    And Validate json schema updateProduct

  @CapStone @Negative-Case @Product
  Scenario: PUT update product with invalid token
    Given Put updateProduct with invalid token and id 140
    When Send request updateProduct
    Then Should return status code 401
    And Response body page should be "invalid or expired jwt"

  @CapStone @Positive-Case @Product
  Scenario: PUT update product with invalid json
    Given Put updateProduct with invalid json and id 140
    When Send request updateProduct
    Then Should return status code 200
    And Response body page should be "success update product"

