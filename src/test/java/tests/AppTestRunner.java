package tests;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun=true,
		monochrome=true,
		format = {"pretty","html:target/html/"},
		features = "src/test/java/features",
		glue={"stepDefinitions"}
		)


public class AppTestRunner {

}
