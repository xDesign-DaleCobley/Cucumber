Feature: Example Feature
  
  Scenario: Valid GET request with name param
    Given the request name is set as Bob
    When a request is made to GET greeting
    Then the response code is 200
    And the response has message "Hello, Bob!"