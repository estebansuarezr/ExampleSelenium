package com.saucedemo.stepdefinitions;

import com.saucedemo.tasks.GoToArticleDetail;
import com.saucedemo.tasks.GoToCart;
import com.saucedemo.tasks.SelectAnArticle;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.saucedemo.utils.Constants.USERNAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ValidateArticleStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }


    @When("el usuario ingresa al detalle del articulo {string}")
    public void elUsuarioIngresaAlDetalleDelArticulo(String articleName) {
        theActorCalled(USERNAME)
                .wasAbleTo(GoToArticleDetail.page(articleName));
    }

    @Then("el sistema debe mostrar el precio y la descripcion del articulo {string} {string}")
    public void elSistemaDebeMostrarElPrecioYLaDescripcionDelArticulo(
            String precio,
            String descripcion) {

        theActorCalled(USERNAME).attemptsTo(
                /*Ensure.that((String) theActorCalled(USERNAME).recall("articlePriceHomePage"))
                        .isEqualTo(precio),

                Ensure.that((String) theActorCalled(USERNAME).recall("articleDescriptionHomePage"))
                        .isEqualTo(descripcion),*/

                Ensure.that((String) theActorCalled(USERNAME).recall("articlePriceDetail"))
                        .isEqualTo(precio),

                Ensure.that((String) theActorCalled(USERNAME).recall("articleDescriptionDetail"))
                        .isEqualTo(descripcion)
        );
    }


}
