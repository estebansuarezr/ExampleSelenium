package com.arreglatech.project.constants.enums.config.serenity;

import lombok.Getter;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;


@Getter
public enum SerenityConf {

    URL_APP_TEST("webdriver.base.url"),

    ;

    private final String property;

    public static final EnvironmentVariables properties = SystemEnvironmentVariables.createEnvironmentVariables();

    public static final EnvironmentSpecificConfiguration setupFile = EnvironmentSpecificConfiguration.from(properties);

    SerenityConf(String property)
    {
        this.property = property;
    }

    public String getValue(String valueDefault)
    {
        return SerenityConf.getPropertyValue(this.getProperty(),valueDefault);
    }

    public String getValue()
    {
        return SerenityConf.getPropertyValue(this.getProperty());
    }

    public static String getPropertyValue(String property, String valueDefault)
    {
        if(property!=null && !property.trim().isEmpty())
        {
            String value = setupFile.getPropertyValue(property);

            return value==null?valueDefault:value;
        }else{
            return valueDefault;
        }
    }

    public static String getPropertyValue(String property)
    {
        return SerenityConf.getPropertyValue(property,null);
    }
}
