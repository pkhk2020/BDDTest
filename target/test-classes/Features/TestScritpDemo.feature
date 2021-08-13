Feature: Test Script Demo
"""
Below script performs the Acceptance criteria of Codility Test
Script can also be parameterised by sending values in step
Script can also be parameterised by sending values in Examples
"""
  Background:
  Given I Invoke the url

    @Test
  Scenario: Test Script Demo
    Given I add different products to my wish list
    When I view my wish list table
    Then I find total four selected items in my wish list
    When I search for lowest price product
    And I am able to add the lowest price item to my cart
    Then I am able to verify the item in my cart
    And I Close the browser

