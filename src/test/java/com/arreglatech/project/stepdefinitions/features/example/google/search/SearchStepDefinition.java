package com.arreglatech.project.stepdefinitions.features.example.google.search;


import com.arreglatech.project.questions.features.example.google.search.VerifyResults;
import com.arreglatech.project.stepdefinitions.general.web.BrowserStepDefinition;
import com.arreglatech.project.tasks.features.example.google.search.SearchByText;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.experimental.UtilityClass;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;


@UtilityClass
public class SearchStepDefinition
{

    @Given("^that \"([^\"]*)\" is on the google search.*")
    public static void givenThatIsOnTheGoogleSearch(String actor)
    {
        BrowserStepDefinition.givenThatEnteredHisBrowser(actor);
        BrowserStepDefinition.whenEnterToSUT();
    }

    @When("^search by text \"([^\"]*)\".*")
    public static void whenSearchByText(String text)
    {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        SearchByText.typed(text)
                );
    }

    @Then("^should be presented the information related for \"([^\"]*)\".*")
    public void shouldBePresentedTheInformationRelated(String text)
    {
        OnStage.theActorInTheSpotlight()
                .should(
                        GivenWhenThen.seeThat(
                                VerifyResults.ofTheSearch(text)
                        )
                );
    }

}
