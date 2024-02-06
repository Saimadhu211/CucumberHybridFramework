package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features",
		glue={"stepdefinitions","hooks"},

		plugin= {"pretty",
				"html:target/CucumberReports/CucumberReport.html",
				"json:target/CucumberReports/CucumberReport.json",
				"junit:target/CucumberReports/CucumberReport.junit"
				}
		        )
public class TestRunner extends AbstractTestNGCucumberTests{

}
