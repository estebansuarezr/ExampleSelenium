package com.saucedemo.tasks;

import com.saucedemo.utils.UrlMaps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheApplication implements Task {

    private static String url;

    public OpenTheApplication() {
        url = UrlMaps.urlInit();
    }

    public static OpenTheApplication web() {
        return instrumented(OpenTheApplication.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
