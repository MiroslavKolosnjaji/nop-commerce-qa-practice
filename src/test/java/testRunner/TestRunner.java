package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Miroslav Kološnjaji
 */
@CucumberOptions(
        features = ".//Features/Login.feature",
        glue = "stepDefinitions",
        dryRun = true,
        monochrome = true,
        plugin = {"pretty", "html:test-output"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
