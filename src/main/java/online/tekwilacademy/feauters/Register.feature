Feature: The register Flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration
    Given The Home Page is displayed
    And Register Page is accessed from the Home Page buttons
    And the register form is populated with data
    And the privacy toggle bar is enabled
    When the continueButton is clicked
    Then the URL contains the folowing keyword "success"


  @run
    Scenario: The system keeps the user on Register page when registering without accepting the privacy rules
      Given The Home Page is displayed
      And Register Page is accessed from the Home Page buttons
      And the register form is populated with data
      And the privacy toggle bar is enabled
      When the continueButton is clicked
      Then the URL contains the folowing keyword "register"
