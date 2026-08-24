package com.saucedemo.utils;

public class UrlMaps {
    private UrlMaps() {
        throw new IllegalStateException("Utility class");
    }

    public static String urlInit() {

        String url = null;

        PropertiesLoader prop = new PropertiesLoader();

        url = prop.getProperty("URL");

        return url;
    }

}