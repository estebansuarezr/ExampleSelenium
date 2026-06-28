package com.arreglatech.project.runners;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RunnerConstants {

    public static final String BASE = "com.arreglatech.project";

    public static final String PACKAGE_STEP_DEFINITIONS = BASE+".stepdefinitions";
    public static final String PACKAGE_SETUPS = BASE+".setups";

    public static final String PACKAGE_GLUE = RunnerConstants.PACKAGE_STEP_DEFINITIONS+","+RunnerConstants.PACKAGE_SETUPS;

    public static final String PACKAGE_FEATURES = "/features";

    public static final String PRETTY = "pretty";
    public static final String CAMELCASE = "camelcase";
    public static final String CUCUMBER_SERENITY_REPORTER_PARALLEL = "net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel";

    public static final String DIR_REPORT_JSON = "json:build/reports/cucumber/results.json";
    public static final String DIR_REPORT_JUNIT = "junit:build/reports/cucumber/results.xml";
    public static final String DIR_REPORT_HTML = "html:build/reports/cucumber/results.html";

}
