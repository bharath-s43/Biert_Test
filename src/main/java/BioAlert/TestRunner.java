package BioAlert;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty"},
		features = {"src/test/java/Applause_Qa/ApplauseTest2.feature","src/test/java/Applause_Qa/ApplauseTest3.feature"}
		)

public class TestRunner {
	
	

}
