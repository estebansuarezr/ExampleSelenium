package com.arreglatech.project.userinterfaces.features.example.google.search;

import net.serenitybdd.screenplay.targets.Target;

public class LogInUI {

    public static final Target USER_TXT = Target.the("Username field")
            .locatedBy("//input[@id='user-name']");
    public static final Target PASSWORD_TXT = Target.the("Password field")
            .locatedBy("//input[@id='password']");
    public static final Target LOGIN_BTN = Target.the("LogIn Button")
            .locatedBy("//input[@id='login-button']");
    public static final Target SAUCE_DEMO_TITLE = Target.the("Sauce Demo Title")
            .locatedBy("//span[@class='title']");

}
