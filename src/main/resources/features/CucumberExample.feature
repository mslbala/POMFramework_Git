@SampleCucumberTests
Feature: This contains sample test scenarios to understand Cucumber Basics

  @Sum
  Scenario:Find the sum and validate it
    Given User wants to find the sum of 2 and 3
    Then User should get the result 7

  @Sums
  Scenario Outline: Find the sum for different input data
    Given User wants to find the sum of <input1> and <input2>
    Then User should get the result <result>
    Examples:
      | input1 | input2 | result |
      | 2      | 3      | 8      |

  @SingleLineTestData
  Scenario:Find the sum and validate it
    Given User wants to find the sum of below numbers
      | 2 | 3 |
    Then User should get the result 7
