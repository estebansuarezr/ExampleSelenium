package com.arreglatech.project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.arreglatech.project.utils.Locations.CONFIG_PROPERTIES;
import static com.arreglatech.project.utils.Locations.USER_DIR;

public class PropertiesLoader {

    private static PropertiesLoader instance;
    private static Properties properties = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLoader.class);

    public PropertiesLoader() {
        load();
    }

    public static synchronized PropertiesLoader getInstance() {
        if (instance == null) {
            instance = new PropertiesLoader();
        }
        return instance;
    }

    public Properties load() {
        try {


            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(System.getProperty(USER_DIR.getMsn())+CONFIG_PROPERTIES.getMsn());
            if (in == null) {
                properties.load(new FileInputStream(System.getProperty(USER_DIR.getMsn())+CONFIG_PROPERTIES.getMsn()));
            }
            else {
                properties.load(in);
            }
        }
        catch (IOException e) {
            LOGGER.error("IOException in class PropertiesLoader ", e);
        }
        return (Properties) properties.clone();
    }

    public String getProperty(String prop) {
        String value = "";

        value = properties.getProperty(prop);
        if (value == null) {
            LOGGER.error("ERROR propiedad NULA1 {} ", prop);

        }

        return value;
    }

    public String getProperty(String prop, String vDefalult) {

        String value = "";

        value = properties.getProperty(prop, vDefalult);
        if (value == null) {
            LOGGER.error("ERROR propiedad NULA {} ", prop);

        }

        return value;

    }

    public Enumeration<?> getPropertyNames() {
        return properties.propertyNames();
    }

}

