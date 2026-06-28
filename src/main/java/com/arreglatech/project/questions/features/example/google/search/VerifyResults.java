package com.arreglatech.project.questions.features.example.google.search;


import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;


@Builder
@Data
public class VerifyResults implements Question<Boolean>
{

    private String text;

    @Override
    public Boolean answeredBy(Actor actor)
    {
        return actor.asksFor(
                TheWebPage.title()
        ).contains(text);
    }


    public static VerifyResults ofTheSearch(String text)
    {
        return VerifyResults.builder()
                .text(text)
                .build();
    }
}

