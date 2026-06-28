package com.arreglatech.project.setups.hooks.production;

import com.arreglatech.project.constants.enums.config.gradle.GradleProp;
import com.arreglatech.project.utils.logs.LogUtil;
import com.arreglatech.project.utils.spoilers.SpoilerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Cameras {

    @Before
    public void init(Scenario scenario)
    {
        LogUtil.info(scenario.getName());
        OnStage.setTheStage(new OnlineCast());

        //Spoiler (.gif evidence) <[SPOILER_GIF_EVIDENCE]>
        if(GradleProp.ACTIVE_SPOILER.getValueParsed())
        {
            SpoilerUtil.prepare(scenario);
        }

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }


    @After
    public void stop(Scenario scenario)
    {
        LogUtil.info("{0}: {1}",scenario.getName(),scenario.getStatus().toString());

        if("FAILED".equalsIgnoreCase(scenario.getStatus().toString()))
        {
            scenario.getStatus();
        }

        //Spoiler (.gif evidence) <[SPOILER_GIF_EVIDENCE]>
        if(GradleProp.ACTIVE_SPOILER.getValueParsed())
        {
            SpoilerUtil.film(scenario);
        }
    }
}

