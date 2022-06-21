Feature: Testing stores CURD operation using different request on the application.

  Scenario: User can send get request.
    When User sends a GET request to stores list endpoint
    Then User get back a valid status code 200 for stores

  Scenario: User can create data using post request.
    When User sends a Post request to stores endpoint
    Then User get back a valid status code 201 for stores
    And Verify that stores created sucessfully

  Scenario: User can Update data using patch request.
    When User sends a patch request to stores endpoint
    Then User get back a valid status code 200 for stores
    And  Verify that stores Updated sucessfully

  Scenario: User can Delate data using delete request.
    When User sends a delete request to stores list endpoint
    Then User get back a valid status code 200 for stores












