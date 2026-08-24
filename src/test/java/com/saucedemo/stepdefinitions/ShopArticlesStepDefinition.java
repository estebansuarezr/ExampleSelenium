package com.saucedemo.stepdefinitions;

import com.saucedemo.tasks.CompleteCheckout;
import com.saucedemo.tasks.SelectArticles;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.saucedemo.userinterfaces.CheckoutUI.CONFIRMATION_MSG;
import static com.saucedemo.utils.Constants.USERNAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ShopArticlesStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el usuario selecciona los articulos del catalogo {string}")
    public void elUsuarioSeleccionaLosArticulosDelCatalogo(String articulos) {

        theActorCalled(USERNAME)
                .wasAbleTo(SelectArticles.withNames(articulos));
    }

    @When("el usuario realiza el checkout {string} {string} {string}")
    public void elUsuarioRealizaElCheckout(String nombre, String apellido, String codigoZip) {

        theActorCalled(USERNAME)
                .wasAbleTo(CompleteCheckout.with(nombre,apellido,codigoZip));

    }
    @Then("el sistema debe mostrar la confirmación de compra")
    public void elSistemaDebeMostrarLaConfirmaciónDeCompra() {

        theActorCalled(USERNAME).attemptsTo(
                Ensure.that(CONFIRMATION_MSG)
                        .hasText("Thank you for your order!")
        );
    }

}
