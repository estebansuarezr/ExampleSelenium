package com.arreglatech.project.tasks.general.web;

import com.arreglatech.project.constants.enums.config.serenity.SerenityConf;
import com.arreglatech.project.interactions.web.browser.Navigate;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.commons.lang3.StringUtils;


@AllArgsConstructor
public class EnterToApp implements Task {

    private String url;

    private String path;


    @Override
    public <T extends Actor> void performAs(T actor)
    {

        actor.attemptsTo(
                Navigate.to(this.url+path)
        );

    }


    public static EnterToApp toTest()
    {
       return Tasks.instrumented(
               EnterToApp.class,
               SerenityConf.URL_APP_TEST.getValue(),
               StringUtils.EMPTY
       );
    }


    public static EnterToApp with(String url)
    {
        return Tasks.instrumented(
                EnterToApp.class,
                url,
                StringUtils.EMPTY
        );
    }


    public EnterToApp page(String path)
    {
        this.path = path;
        return this;
    }
}
