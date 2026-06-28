package com.arreglatech.project.userinterfaces.features.example.google.search;

import net.serenitybdd.screenplay.targets.Target;

public class SearchUI {

    public static Target TXT_SEARCH = Target.the("search field")
            .locatedBy("//*[@name='q']");
}
