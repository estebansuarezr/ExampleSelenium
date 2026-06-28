package com.arreglatech.project.stepdefinitions;

import com.arreglatech.project.tasks.Authenticate;
import com.arreglatech.project.tasks.OpenTheApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.arreglatech.project.userinterfaces.features.example.google.search.LogInUI.SAUCE_DEMO_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class LogInStepDefinition

{
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        theActorCalled("Juan")
                .wasAbleTo(OpenTheApplication.web());
    }
    @When("the user logs in with user and password")
    public void the_user_logs_in_with_user_and_password() {
        theActorCalled("Juan")
                .wasAbleTo(Authenticate.withTheCredentials());
    }
    @Then("the Products page should be displayed")
    public void the_products_page_should_be_displayed() {
        theActorCalled("Juan")
                .should(seeThat(the(SAUCE_DEMO_TITLE), isVisible())
                );
    }
}
