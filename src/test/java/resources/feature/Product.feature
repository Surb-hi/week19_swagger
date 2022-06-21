Feature: Testing Product CURD operation using different request on the application.

  Scenario: User can send get request for Product.
    When User sends a GET request to list Product endpoint
    Then User get back a valid status code 200 for Products

  Scenario: User can create data using post request for Product.
    When User sends a Post request to Product endpoint
    Then User get back a valid status code 201 for Products
    And  Verify that user created sucessfully for Product

  Scenario: User can Update data using patch request.
    When User sends a patch request to Product endpoint
    Then User get back a valid status code 200 for Products
    And  Verify that Product Updated sucessfully

  Scenario: User can Delate Product using delete request.
    When User sends a delete request to Product  endpoint
    Then User get back a valid status code 200 for Products












