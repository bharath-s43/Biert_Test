package BioAlert;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty"},
		features = {"src/test/java/BioAlert/01Registration.feature","src/test/java/BioAlert/02Login.feature","src/test/java/BioAlert/03PatientRegistration.feature","src/test/java/BioAlert/04PaidService.feature","src/test/java/BioAlert/05ProfileSettings.feature","src/test/java/BioAlert/06EditPatientDetails.feature","src/test/java/BioAlert/07CareTaker.feature","src/test/java/BioAlert/08DeactivateService.feature"}
		)

public class TestRunner {
	
	

}
