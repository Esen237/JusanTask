package UI.runnerUi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/UI/featuresFilesUI",
        glue = "UI/stepDefsUI",
        tags = "@SmokeTest",
        dryRun = false,
        monochrome = true,
        publish = true,
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        }
)
public class RunnerClass {
}