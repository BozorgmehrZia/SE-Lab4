Feature: Calculator

	Scenario Outline: add two numbers
		Given Two input values, <arg0> and <arg1>
		When I add the two values
		Then I expect the result <expectedResult>
		Examples:
			| arg0 | arg1 | expectedResult |
			| 1    | 12   | 13             |
			| -1   | 6    | 5              |
			| 2    | 2    | 4              |
