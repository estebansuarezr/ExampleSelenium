package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Arrays;
import java.util.List;

import static com.saucedemo.userinterfaces.HomePageUI.*;

public class SelectArticles implements Task {

    private final String articlesList;

    public SelectArticles(String articlesList) {
        this.articlesList =articlesList;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> articlesListStr = Arrays.stream(articlesList.split(","))
                .map(String::trim)
                .toList();

        articlesListStr.forEach(articleName ->
                actor.attemptsTo(
                        Click.on(ADD_TO_CART.of(articleName))
                )
        );

    }
    public static SelectArticles withNames(String articlesList) {

        return Tasks.instrumented(SelectArticles.class, articlesList);
    }
}
