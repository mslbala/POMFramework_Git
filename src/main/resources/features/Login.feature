Feature: Going to test Home page of Demo application

  @HomePage
  Scenario: Test Search functionality in Home page
    Given User launches Automation Demo page
    When User enters the text "Dresses" in search field and click Search
    Then User should be able to view all the "dresses"
    And User should be able to 5 results found

