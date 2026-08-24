package com.saucedemo.stepdefinitions;

import com.saucedemo.tasks.Authenticate;
import com.saucedemo.tasks.OpenTheApplication;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.saucedemo.userinterfaces.LogInUI.SAUCE_DEMO_TITLE;
import static com.saucedemo.utils.Constants.USERNAME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class LogInStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el usuario se encuentra en la pagina de inicio")
    public void elUsuarioSeEncuentraEnLaPaginaDeInicio() {
        theActorCalled(USERNAME)
                .wasAbleTo(OpenTheApplication.web());
    }
    @When("el usuario inicie sesion con sus credenciales")
    public void elUsuarioInicieSesionConSusCredenciales() {
        theActorCalled(USERNAME)
                .wasAbleTo(Authenticate.withTheCredentials());
    }
    @Then("el sistema debe mostrar la pagina SwagLabs")
    public void elSistemaDebeMostrarLaPaginaSwagLabs() {
        theActorCalled(USERNAME)
                .should(seeThat(the(SAUCE_DEMO_TITLE), isVisible())
                );
    }
}
