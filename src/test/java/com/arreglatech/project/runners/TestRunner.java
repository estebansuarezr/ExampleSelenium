
package com.arreglatech.project.runners;

import lombok.experimental.UtilityClass;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource(RunnerConstants.PACKAGE_FEATURES)
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Actual")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = RunnerConstants.CAMELCASE)
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = RunnerConstants.PACKAGE_GLUE)
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = RunnerConstants.PRETTY
                + "," + RunnerConstants.CUCUMBER_SERENITY_REPORTER_PARALLEL
                + "," + RunnerConstants.DIR_REPORT_JSON
                + "," + RunnerConstants.DIR_REPORT_JUNIT
                + "," + RunnerConstants.DIR_REPORT_HTML
)
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@UtilityClass
public class TestRunner { }
