package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static DummyTel.DummyTel.getCallCost;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCallCostSteps {
	String startTime;
	long duration;
	double cost;

	@Given("I make a call at {string} that lasts {int} minutes")
	public void i_make_a_call_at_that_lasts_minutes(String startTime, Integer duration) {
		// Write code here that turns the phrase above into concrete actions
		this.startTime = startTime;
		this.duration = duration;
	}

	@When("I calculate the cost")
	public void i_calculate_the_cost() {
		// Write code here that turns the phrase above into concrete actions
		this.cost = getCallCost(startTime, duration);
	}

	@Then("The cost should be half off, costing {double}")
	public void the_cost_should_be_half_off_costing(Double expectedOutput) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(expectedOutput, cost, 0.01);
	}

	@Then("The cost should be full price, costing {double}")
	public void the_cost_should_be_full_price_costing(Double expectedOutput) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(expectedOutput, cost, 0.01);
	}
}
