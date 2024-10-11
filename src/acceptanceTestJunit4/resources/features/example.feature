# High level grouping of acceptance test scenarios
Feature: Example Feature

  # Lower level grouping of scenarios
  Rule: Response includes name

    # Steps to run at the start of each scenario
    Background:
      Given Bob exists

    # Our test - will be run once
    Scenario: Valid GET request with name param
      Given the request name is set as Bob
      When a request is made to GET greeting
      Then the response code is 200
      And the response has message "Hello, Bob!"

    # Another test, outlines will be run once per row in Examples
    Scenario Outline: Valid GET requests with name param
      Given the request name is set as <name>
      When a request is made to GET greeting
      Then the response code is 200
      And the response has message "Hello, <name>!"

      Examples:
        | name  |
        | Jim   |
        | Judie |

  # Tags help organise tests.  Using tags we can run a subsection of our tests, e.g smoke tests only. See Readme to run via cmd line.
  @NoName
  Rule: Response without name

    Scenario: Valid GET request
      When a request is made to GET greeting
      Then the response code is 200
      And the response has message "Hello, World!"