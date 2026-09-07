package com.digibank.compliance.steps;

import com.digibank.compliance.service.ComplianceService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class ComplianceSteps {

    private ComplianceService complianceService;
    private Double amount;
    private Boolean validationResult;

    @Before
    public void setUp() {
        complianceService = new ComplianceService();
    }

    @Given("a transaction amount of {double}")
    public void a_transaction_amount_of(Double amount) {
        this.amount = amount;
    }

    @Given("a null transaction amount")
    public void a_null_transaction_amount() {
        this.amount = null;
    }

    @When("the amount is validated")
    public void the_amount_is_validated() {
        validationResult = complianceService.validateTransactionAmount(amount);
    }

    @Then("the validation should return true")
    public void the_validation_should_return_true() {
        assertTrue(validationResult);
    }

    @Then("the validation should return false")
    public void the_validation_should_return_false() {
        assertFalse(validationResult);
    }
}
