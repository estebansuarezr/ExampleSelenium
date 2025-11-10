package com.arreglatech.project.constants.enums.config.gradle;

import lombok.Getter;

import java.util.function.Function;


@Getter
public enum GradleProp
{
    //Spoiler (.gif evidence) <[SPOILER_GIF_EVIDENCE]>
    ACTIVE_SPOILER("gradle.props.project.reports.serenity.spoiler.active","false",
             Boolean.class,Boolean::parseBoolean
    ),

    ;

    private final String property;

    private final Class<?> aClass;

    private final Function<String, ?> parser;

    private String defect;

    <T> GradleProp(String property, Class<T> aClass, Function<String, T> parser)
    {
        this.property = property;
        this.aClass = aClass;
        this.parser = parser;
    }

    <T> GradleProp(String property, String defect, Class<T> aClass, Function<String, T> parser)
    {
        this(property, aClass,parser);
        this.defect = defect;
    }

    <T> GradleProp(String property, String defect)
    {
        this(property,defect, String.class,Function.identity());
    }

    public String getValue()
    {
        return System.getProperty(this.getProperty(),this.getDefect());
    }

    public String getValue(String defect)
    {
        return System.getProperty(this.getProperty(),defect);
    }

    @SuppressWarnings("unchecked")
    public <T> T getValueParsed(T defaultValue)
    {
        String raw = this.getValue(String.valueOf(defaultValue));
        return (T) this.parser.apply(raw);
    }

    @SuppressWarnings("unchecked")
    public <T> T getValueParsed()
    {
        return this.getValueParsed((T)this.parser.apply(this.getDefect()));
    }
}
