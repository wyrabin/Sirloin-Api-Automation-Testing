Feature: Testing API Payment Notification

  @CapStone @Positive-Case @Customer
  Scenario: POST payment notification with valid json
    Given Post paymentnotif with valid json
    When Send request paymentnotif
    Then Should return status code 201

  @CapStone @Positive-Case @Customer
  Scenario: POST payment notification with invalid json
    Given Post paymentnotif with invalid json
    When Send request paymentnotif
    Then Should return status code 400

  @CapStone @Positive-Case @Customer
  Scenario: POST payment notification with token
    Given Post paymentnotif with token
    When Send request paymentnotif
    Then Should return status code 201

  @CapStone @Positive-Case @Customer
  Scenario: POST payment notification with invalid token
    Given Post paymentnotif with invalid token
    When Send request paymentnotif
    Then Should return status code 401
