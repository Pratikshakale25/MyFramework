package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // path under src/test/resources
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefinition,myHooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html, com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
//@ConfigurationParameter(key = MONOCHROME_PROPERTY_NAME, value = "true")
public class TestRunner {
}
