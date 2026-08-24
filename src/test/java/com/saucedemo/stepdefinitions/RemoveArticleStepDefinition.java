package com.saucedemo.stepdefinitions;

import com.saucedemo.tasks.GoToCart;
import com.saucedemo.tasks.RemoveArticle;
import com.saucedemo.tasks.SelectAnArticle;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.saucedemo.userinterfaces.CartUI.ARTICLE_NAME;
import static com.saucedemo.utils.Constants.USERNAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class RemoveArticleStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el usuario selecciona un articulo del catalogo {string}")
    public void elUsuarioSeleccionaUnArticuloDelCatalogo(String articleName) {

        theActorCalled(USERNAME)
                .wasAbleTo(SelectAnArticle.withName(articleName));

    }

    @When("el usuario ingresa al carrito")
    public void elUsuarioIngresaAlCarrito() {
        theActorCalled(USERNAME)
                .wasAbleTo(GoToCart.page());
    }

    @When("el usuario remueve el articulo {string} del carrito")
    public void elUsuarioRemueveElArticuloDelCarrito(String articleName) {

        theActorCalled(USERNAME)
                .wasAbleTo(RemoveArticle.ofTheCart(articleName));
    }
    @Then("el sistema debe mostrar el carrito vacio {string}")
    public void elSistemaDebeMostrarElCarritoVacio(String articleName) {


        theActorCalled(USERNAME).attemptsTo(
                Ensure.that(ARTICLE_NAME.of(articleName))
                        .isNotDisplayed()
        );
    }
}
