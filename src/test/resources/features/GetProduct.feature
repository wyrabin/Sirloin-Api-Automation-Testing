Feature: Testing API Get Product

  @CapStone @Positive-Case @Product
  Scenario: Get display all product list
    Given Get display all product
    When Send request getproduct
    Then Should return status code 200
    And Validate json schema getProduct

  @CapStone @Positive-Case @Product
  Scenario: Get display product list by id
    Given Get display product by id 68
    When Send request getproduct by id
    Then Should return status code 200
    And Validate json schema getProduct by id

  @CapStone @Negative-Case @Product
  Scenario: Get display product list by invalid id
    Given Get display product by invalid "abc"
    When Send request getproduct by invalid id
    Then Should return status code 400
    And Response body should be "wrong product id parameter"

  @CapStone @Positive-Case @Product
  Scenario: Get display all product with valid token
    Given Get display all product with valid token
    When Send request getproduct
    Then Should return status code 200
    And Validate json schema getProduct

  @CapStone @Negative-Case @Product
  Scenario: Get display all product with invalid token
    Given Get display all product with invalid token
    When Send request getproduct
    Then Should return status code 401
    And Response body should be "invalid or expired jwt"
    And Validate json schema getProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: Get display all product without token
    Given Get display all product without token
    When Send request getproduct
    Then Should return status code 401






