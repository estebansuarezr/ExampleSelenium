package com.arreglatech.project.stepdefinitions.general.web;


import com.arreglatech.project.tasks.general.web.EnterToApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.experimental.UtilityClass;
import net.serenitybdd.screenplay.actors.OnStage;


@UtilityClass
public class BrowserStepDefinition
{
    @Given("^that \"(.*)\" entered his browser.*")
    public static void givenThatEnteredHisBrowser(String actor)
    {
        OnStage.theActorCalled(actor);
    }

    @When("^enter to System Under Test.*")
    public static void whenEnterToSUT()
    {

        OnStage.theActorInTheSpotlight()
                .wasAbleTo(
                        EnterToApp.toTest()
                );

    }

    @When("^enter to app url \"(.*)\".*")
    public static void whenEnterToAppUrl(String url)
    {
        OnStage.theActorInTheSpotlight()
                .wasAbleTo(
                        EnterToApp.with(url)
                );
    }
}
