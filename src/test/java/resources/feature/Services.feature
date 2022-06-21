Feature: Testing services CURD operation using different request on the application.

  Scenario: User can send get request.
    When User sends a GET request to services  endpoint
    Then User get back a valid status code 200 for services

  Scenario: User can create data using post request.
    When User sends a Post request to  services endpoint
    Then User get back a valid status code 201 for services
    And Verify that services created sucessfully

  Scenario: User can Update data using patch request.
    When User sends a patch request to services endpoint
    Then User get back a valid status code 200 for
    And  Verify that services Updated sucessfully

  Scenario: User can Delate data using delete request.
    When User sends a delete request to services endpoint
    Then User get back a valid status code 200 for services












