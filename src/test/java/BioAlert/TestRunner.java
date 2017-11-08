package BioAlert;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty"},
		features = {"src/test/java/Features"},
		plugin= {"html:target/cucumber-html-report","json:target/cucumber.json"}
		
		)

public class TestRunner {
	
						

}
