
package com.arreglatech.project.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;



@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @ignore")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.arreglatech.project.stepdefinitions"
        +","+"com.arreglatech.project.setups")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty"
                +","+"io.cucumber.core.plugin.SerenityReporterParallel"
)
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
public class TestRunner
{

    private TestRunner()
    {
        throw new UnsupportedOperationException();
    }

}
