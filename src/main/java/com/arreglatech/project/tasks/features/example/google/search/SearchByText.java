package com.arreglatech.project.tasks.features.example.google.search;


import com.arreglatech.project.userinterfaces.features.example.google.search.SearchUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;


@AllArgsConstructor
public class SearchByText implements Task
{

    private String text;

    @Override
    public <T extends Actor> void performAs(T actor)
    {

        actor.attemptsTo(
                Enter.theValue(this.text)
                        .into(SearchUI.TXT_SEARCH),

                Hit.the(Keys.ENTER)
                        .into(SearchUI.TXT_SEARCH)
        );
    }


    public static SearchByText typed(String text)
    {
        return Tasks.instrumented(
                SearchByText.class,
                text
        );
    }
}
