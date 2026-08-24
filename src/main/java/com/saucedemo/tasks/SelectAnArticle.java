package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectAnArticle implements Task {

    private final String articleName;

    public SelectAnArticle(String articleName) {
        this.articleName =articleName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(HomePageUI.ADD_TO_CART.of(articleName))
        );
    }
    public static SelectAnArticle withName(String articleName) {

        return Tasks.instrumented(SelectAnArticle.class, articleName);
    }
}
