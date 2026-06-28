package com.arreglatech.project.utils;

import com.arreglatech.project.models.Users;

public class MapUsers {


    public MapUsers() {
        throw new IllegalStateException("Utility class");
    }

    public static Users init(String environment) {

        PropertiesLoader prop = new PropertiesLoader();
        Users users = new Users();

        users.setStrUserId(prop.getProperty("USER"));
        users.setStrPassword(prop.getProperty("PASSWORD"));

        return users;
    }

}
