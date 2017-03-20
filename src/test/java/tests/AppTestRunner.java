package tests;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun=true,
		monochrome=true,
		features = "src/test/java/features",
		glue={"stepDefinitions"}
		)


public class AppTestRunner {

}
