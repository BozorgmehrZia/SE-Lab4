@tag
Feature: Calculator
	Scenario: add two numbers
		Given Two input values, 5 and 8
		When I add the two values
		Then I expect the result 13
	Scenario Outline: add two numbers
		Given Two input values, <arg0> and <arg1>
		When I add the two values
		Then I expect the result <expectedResult>
		Examples:
			| arg0 | arg1 | expectedResult |
			| 1    | 12   | 13             |
			| -1   | 6    | 5              |
			| 2    | 2    | 4              |

	Scenario: Dividing And Square Root of Two Numbers
		Given Two input values, 100 and 4
		When I divide two numbers and then get the square root of the result
		Then I expect the result 5
	Scenario Outline: Dividing And Square Root of Two Numbers
		Given Two input values, <a> and <b>
		When I divide two numbers and then get the square root of the result
		Then I expect the result <result>

		Examples:
			|   a    |   b    | result |
			|   4    |   1    |    2   |
			|   36   |   4    |   3    |
			|   150  |   6    |   5    |
			|   1    |   4    |   0.5  |