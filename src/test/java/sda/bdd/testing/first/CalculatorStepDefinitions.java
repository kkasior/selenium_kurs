package sda.bdd.testing.first;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sda.bdd.testing.first.calculator.Calculator;
import sda.bdd.testing.first.smoothie.MorningFreshnessMember;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefinitions {

    Calculator calculator;
    Integer result;

    MorningFreshnessMember michael;
    String resultMichaelOrder;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer a, Integer b) {
        result = calculator.add(a, b);
    }

    @Then("I should get {int}")
    public void i_should_get(Integer c) {
        assertThat(result).isEqualTo(c);
    }


    @Given("Michael is a morningFreshness member")
    public void michael_is_a_morningFreshness_member() {
        michael = new MorningFreshnessMember();
    }

    @When("He orders an {string}")
    public void he_orders_an(String michaelorder) {
        michael.order(michaelorder);
        resultMichaelOrder = michaelorder;
    }

    @Then("His order should be placed in the preparation queue")
    public void his_order_should_be_placed_in_the_preparation_queue() {
        assertThat(michael.preparationQueue).contains(resultMichaelOrder);
    }


}
