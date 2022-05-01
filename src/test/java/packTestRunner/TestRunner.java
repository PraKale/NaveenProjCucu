package packTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		
		features={".//src//test//resources//Features//Login.feature"},
		glue= {"stepDefinitions","appliHooks.ApplicationHooks"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestRunner {

}
