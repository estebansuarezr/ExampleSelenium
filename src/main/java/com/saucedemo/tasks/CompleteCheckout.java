package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.userinterfaces.CartUI.CHECKOUT_BTN;
import static com.saucedemo.userinterfaces.CheckoutUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class CompleteCheckout implements Task {

    private final String firstName;
    private final String lastName;
    private final String zipcode;

    public CompleteCheckout(String firstName, String lastName, String zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(CHECKOUT_BTN),
                Enter.theValue(firstName).into(FIRST_NAME_TXT),
                Enter.theValue(lastName).into(LAST_NAME_TXT),
                Enter.theValue(zipcode).into(ZIP_CODE_TXT),
                Click.on(CONTINUE_BTN),
                Scroll.to(FINISH_BTN),
                Click.on(FINISH_BTN),
                WaitUntil.the(CONFIRMATION_MSG, isPresent()).forNoMoreThan(1).seconds()
        );
    }

    public static CompleteCheckout with (String firstName, String lastName, String zipcode){
        return Tasks.instrumented(CompleteCheckout.class, firstName, lastName, zipcode);
    }
}
