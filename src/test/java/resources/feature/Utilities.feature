Feature: Testing Utilities CURD operation using different request on the application.

  Scenario: User can send get request.
    When User sends a GET request to Healthcheckdata Utilities endpoint
    Then User get back a valid status code 200 for Utilities

  Scenario: User can send get request.
    When User sends a GET request to versiondata Utilities endpoint
    Then User get back a valid status code 200 for Utilities