package BioAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DeactivateService {
	
	WebDriver driver = EmailVerification.getdriver();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	@Given("^go to cancel service page$")
	public void go_to_cancel_service_page() throws Throwable {
		driver.findElement(By.xpath("//center[contains(text(), 'Payments')]")).click();
		driver.findElement(By.xpath("//center[contains(text(), 'Cancel Service')]")).click();
	}

	@Then("^click on Deactivate button$")
	public void click_on_Deactivate_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(), 'DE-ACTIVATE')]")).click();
	}

}
