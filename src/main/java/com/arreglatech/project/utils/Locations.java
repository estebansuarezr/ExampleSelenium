package com.arreglatech.project.utils;

public enum Locations {
    USER_DIR("user.dir"),
    CONFIG_PROPERTIES("//src//test//resources//config.properties");

    private String msn;

    private Locations(String msn) {

        this.msn = msn;
    }

    public String getMsn() {

        return msn;
    }
}
