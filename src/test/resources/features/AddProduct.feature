Feature: Testing API Add Product

  @CapStone @Positive-Case @Product
  Scenario: POST add product with valid json
    Given Post addProduct with valid json and token
    When Send request addProduct
    Then Should return status code 201
    And Validate json schema addProduct

  @CapStone @Negative-Case @Product
  Scenario: POST add product without input upc
    Given Post addProduct without upc
    When Send request addProduct
    Then Should return status code 400
    And Response body page should be "upc shouldn't be empty"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product without input category
    Given Post addProduct without category
    When Send request addProduct
    Then Should return status code 400
    And Response body page should be "category shouldn't be empty"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product without input product name
    Given Post addProduct without product name
    When Send request addProduct
    Then Should return status code 400
    And Response body page should be "product name shouldn't be empty"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product without input number of stock
    Given Post addProduct without number of stock
    When Send request addProduct
    Then Should return status code 400
    And Response body page should be "stock shouldn't be empty"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product without input minimum stock
    Given Post addProduct without minimum stock
    When Send request addProduct
    Then Should return status code 201
    And Response body page should be "minimum stock shouldn't be empty"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product without input price
    Given Post addProduct without price
    When Send request addProduct
    Then Should return status code 400
    And Response body page should be "price shouldn't be empty"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product without input product image
    Given Post addProduct without product image
    When Send request addProduct
    Then Should return status code 400
    And Response body page should be "product image shouldn't be empty"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product with input existing upc
    Given Post addProduct with existing upc
    When Send request addProduct
    Then Should return status code 409
    And Response body page should be "duplicated product on name"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product with input existing product name
    Given Post addProduct with existing product name
    When Send request addProduct
    Then Should return status code 409
    And Response body page should be "duplicated product on name"
    And Validate json schema addProduct negative case

  @CapStone @Negative-Case @Product
  Scenario: POST add product with valid bearer token
    Given Post addProduct with valid token
    When Send request addProduct
    Then Should return status code 201
    And Validate json schema addProduct

  @CapStone @Negative-Case @Product
  Scenario: POST add product with invalid bearer token
    Given Post addProduct with invalid token
    When Send request addProduct
    Then Should return status code 401
    And Response body page should be "invalid or expired jwt"
    And Validate json schema addProduct negative case
