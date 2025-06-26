package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/pratikshakale/IdeaProjects/Study/MyFramework/src/src/test/resources/features/",   // path to feature files
        glue = "stepDefinition",                    // package name of step defs
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class TestRunner {
}
