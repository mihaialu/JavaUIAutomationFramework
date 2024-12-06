Feature: The register Flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration
    Given The "/" endpoint is accessed
    And Register Page is accessed from the Home Page buttons
    And the register form is populated with data
    And the "privacyToggleBar" from "RegisterPage" is clicked
    When the "continueBtn" from "RegisterPage" is clicked
    Then the URL contains the folowing keyword "success"


  @run
    Scenario: The system keeps the user on Register page when registering without accepting the privacy rules
     Given The "/" endpoint is accessed
      And Register Page is accessed from the Home Page buttons
      And the register form is populated with data
      And the privacy toggle bar is enabled
      When the "continueBtn" from "RegisterPage" is clicked
      Then the URL contains the folowing keyword "register"

    @run
    Scenario Outline: Error message is displayed when registering within invalid <ErrorFieldName> length
      Given  The "/" endpoint is accessed
      And Register Page is accessed from the Home Page buttons
      And the register form is populated as following:
        | firstName | <firstName> |
        | lastName  | <lastName>  |
        | email     | RANDOM      |
        | password  | <password>  |
      And a thread sleep of 5 second is executed
      When the "continueBtn" from "RegisterPage" is clicked
      Then the following list of error message is displayed:
        | <errorFieldName> must be between <min> and <max> characters! |  |  |
        | Warning: You must agree to the privacy Policy!               |  |  |


      Examples:
        | firstName | lastName                                       | password                | errorFieldName | min | max |
        | Random    | Hotineanu                                      | 729                     | Password       | 4   | 20  |
        | Random    | Hotineanu                                      | 12345678901234567890123 | Password       | 4   | 20  |
        | Random    | 1234567890123456789012312345678901234567890123 | 12345678901234567890123 | Last Name      | 1   | 32  |

