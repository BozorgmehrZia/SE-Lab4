package calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;

public class MyStepdefs {
    private Calculator calculator = new Calculator();
    private int a;
    private int b;
    private double result;

    @Given("Two input values, {int} and {int}")
    public void twoInputValuesAnd(int arg0, int arg1) throws Throwable{
        a = arg0;
        b = arg1;
    }

    @When("I divide two numbers and then get the square root of the result")
    public void iDivideTwoNumbersAndThenGetTheSquareRootOfTheResult() {
        result = calculator.dividingAndSquareRoot(a, b);
    }
    @When("I add the two values")
    public void iAddTheTwoValues() {
        result = calculator.add(a, b);
    }

    @Then("I expect the result {double}")
    public void iExpectTheResult(double expectedResult) {

        Assert.assertEquals(expectedResult, result, 0.001);
    }

}
