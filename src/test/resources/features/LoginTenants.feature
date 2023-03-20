Feature: Testing API Login Tenant

  @CapStone @Positive-Case @Login
  Scenario: POST login tenant with valid email and password
    Given Post login with valid email and password
    When Send request login
    Then Should return status code 200
    And Validate json schema login

  @CapStone @Negative-Case @Login
  Scenario: Post login tenant with invalid email and valid password
    Given Post login with invalid email and password
    When Send request login
    Then Should return status code 404
    And Response body page should be "wrong email"
    And Validate json schema login negative case


  @CapStone @Negative-Case @Login
  Scenario: Post login tenant with empty email and valid password
    Given Post login with empty email and valid password
    When Send request login
    Then Should return status code 404
    And Response body page should be "wrong email"
    And Validate json schema login negative case

  @CapStone @Negative-Case @Login
  Scenario: Post login tenant with valid email and empty password
    Given Post login with valid email and empty password
    When Send request login
    Then Should return status code 401
    And Response body page should be "wrong password"
    And Validate json schema login negative case


  @CapStone @Negative-Case @Login
  Scenario: Post login tenant with valid email and invalid password
    Given Post login with valid email and invalid password
    When Send request login
    Then Should return status code 401
    And Response body page should be "wrong password"
    And Validate json schema login negative case


  @CapStone @Negative-Case @Login
  Scenario: Post login tenant with empty email and password
    Given Post login with empty email and password
    When Send request login
    Then Should return status code 404
    And Response body page should be "wrong email"
    And Validate json schema login negative case


  @CapStone @Negative-Case @Login
  Scenario: Post login tenant with wrong combination email and password
    Given Post login with wrong combination email and password
    When Send request login
    Then Should return status code 404
    And Response body page should be "wrong email"
    And Validate json schema login negative case


  @CapStone @Negative-Case @Login
  Scenario: Post login tenant with unregistered email
    Given Post login with unregistered email
    When Send request login
    Then Should return status code 404
    And Response body page should be "wrong email"
    And Validate json schema login negative case


  @CapStone @Negative-Case @Login
  Scenario: Post login tenant with invalid path
    Given Post login with invalid path 1
    When Send request login invalid path
    Then Should return status code 404
    And Response body page should be "Not Found"
    And Validate json schema login negative case





