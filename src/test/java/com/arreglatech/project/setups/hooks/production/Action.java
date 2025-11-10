package com.arreglatech.project.setups.hooks.production;

import com.arreglatech.project.constants.enums.config.gradle.GradleProp;
import com.arreglatech.project.utils.screenshots.ScreenshotUtil;
import com.arreglatech.project.utils.spoilers.SpoilerUtil;
import net.serenitybdd.core.Serenity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class Action {

    /**
     * Spoiler (.gif evidence)
     * <[SPOILER_GIF_EVIDENCE]>
     */
    @Before("execution(* net.serenitybdd.screenplay.Actor.performTask(..))")
    public void run(JoinPoint jp)
    {
        if(GradleProp.ACTIVE_SPOILER.getValueParsed())
        {
            ScreenshotUtil.screenshot(
                    Serenity.sessionVariableCalled(SpoilerUtil.SPOILER_RELATIVE_PATH).toString()
            );
        }

    }
}
