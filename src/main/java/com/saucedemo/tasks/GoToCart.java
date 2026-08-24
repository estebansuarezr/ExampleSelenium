package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class GoToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(HomePageUI.CART_BTN)
        );

    }
    public static GoToCart page(){
        return Tasks.instrumented(GoToCart.class);
    }
}
