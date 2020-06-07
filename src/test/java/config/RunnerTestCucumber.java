package config;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	dryRun = false,
	monochrome = true,
	strict = true,
	plugin = {"json:target/cucumber.json"},
	snippets = SnippetType.UNDERSCORE,
	features = {"classpath:features"},
	glue = {"classpath:steps"}
	//tags = {"@tag3"}
	
	//monochrome = true,
		//strict = true,
		//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		//snippets = SnippetType.UNDERSCORE,
		//features = "src/test/java/ffeatures",
		//glue = "teps"
		//tags = {"@tag3"}
		
)

public class RunnerTestCucumber {
	/*@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    
    }*/
}