package com.arreglatech.project.interactions.web.browser;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;


@AllArgsConstructor
public class Navigate implements Interaction
{
    private String url;


    @Override
    public <T extends Actor> void performAs(T actor)
    {

        actor.attemptsTo(
            Open.url(this.url)
        );
    }


    public static Navigate to(String url)
    {
       return Tasks.instrumented(
               Navigate.class,
               url
       );
    }
}
