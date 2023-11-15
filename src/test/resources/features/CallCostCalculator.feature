Feature: Get Cost of a Call
  Get the cost of a call as described in the problem
  50% discount before 8 and after 18
  Tax 5%
  15% discount duration > 60 min
  Cost per min is 0.5

  Scenario: Call before 8:00 and after 18:00 price are half off
    Given I make a call at "07:00" that lasts 30 minutes
    When I calculate the cost
    Then The cost should be half off, costing 7.88

  Scenario Outline: Call before 8:00 and after 18:00 price are half off
    Given I make a call at <startTime> that lasts <duration> minutes
    When I calculate the cost
    Then The cost should be half off, costing <expectedOutput>
    Examples:
      | startTime | duration | expectedOutput |
      | "06:00"   | 60       | 15.75          |
      | "07:00"   | 30       | 7.88           |
      | "19:00"   | 90       | 20.08          |

  Scenario Outline: Call between 8:00 and 18:00 cost is full price
    Given I make a call at <startTime> that lasts <duration> minutes
    When I calculate the cost
    Then The cost should be full price, costing <expectedOutput>
    Examples:
      | startTime | duration | expectedOutput |
      | "17:00"   | 60       | 31.5           |
      | "17:00"   | 90       | 40.16          |
