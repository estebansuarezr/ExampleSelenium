package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.saucedemo.userinterfaces.CartUI.REMOVE_ARTICLE;

public class RemoveArticle implements Task {


    private final String articleName;

    public RemoveArticle(String articleName) {
        this.articleName =articleName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(REMOVE_ARTICLE.of(articleName))
        );
    }
    public static RemoveArticle ofTheCart(String articleName){
        return Tasks.instrumented(RemoveArticle.class, articleName);
    }
}
