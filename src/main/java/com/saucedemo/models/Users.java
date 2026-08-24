package com.saucedemo.models;

public class Users {


    private String StrUserId;
    private String StrPassword;

    public Users(String strUserId, String strPassword, String strUserName) {
        super();
        StrUserId = strUserId;
        StrPassword = strPassword;
    }

    public Users() {
        super();
    }

    public String getStrUserId() {
        return StrUserId;
    }

    public void setStrUserId(String strUserId) {
        StrUserId = strUserId;
    }

    public String getStrPassword() {
        return StrPassword;
    }

    public void setStrPassword(String strPassword) {
        StrPassword = strPassword;
    }

}
