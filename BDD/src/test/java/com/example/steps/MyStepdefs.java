package com.example.steps;

import calculator.Calculator;
import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    private final Calculator calculator;
    private int value1;
    private int value2;
    private int result;

    public MyStepdefs() {
        calculator = new Calculator();
    }

    @Given("Two input values, {int} and {int}")
    public void twoInputValuesAnd(int arg0, int arg1) {
        this.value1 = arg0;
        this.value2 = arg1;
    }

    @When("I add the two values")
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
    }

    @Then("I expect the result {int}")
    public void iExpectTheResult(int expectedResult) {
        assertEquals(expectedResult, result);
    }

    @Given("Two input values, <arg{int}> and <arg{int}>")
    public void twoInputValuesAnd(String arg0, String arg1) {
    }

    @Then("I expect the result {}")
    public void iExpectTheResult(String arg0) {
    }
}
