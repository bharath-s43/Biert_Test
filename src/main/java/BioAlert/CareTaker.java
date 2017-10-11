package BioAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CareTaker {
	
	WebDriver driver = EmailVerification.getdriver();
	
	@When("^user clicks on the add new caretaker button$")
	public void user_clicks_on_the_add_new_caretaker_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(), 'ADD NEW CARETAKER')]")).click();
	}
	
	@Then("^enter the caretaker registration details$")
	public void enter_the_caretaker_registration_details() throws Throwable {
		driver.findElement(By.name("firstName")).sendKeys("Mark");
		driver.findElement(By.name("firstName")).sendKeys("Thomas");
		driver.findElement(By.name("email_id")).sendKeys("mark@gmail.com");
		Select country_code = new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid']")));
		country_code.selectByVisibleText("India (+91)");
		driver.findElement(By.name("mobile")).sendKeys("6453424234");
		driver.findElement(By.name("sms")).click();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("call")).click();
		
	}
	
	@Then("^click on confirm$")
	public void click_on_confirm() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(), 'CONFIRM')]")).click();
		Thread.sleep(3000);
	}

	@Then("^accept terms and conditions$")
	public void accept_terms_and_conditions() throws Throwable {
		driver.findElement(By.xpath("//input [@class='ng-pristine ng-untouched ng-valid']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'AGREED')]")).click();
		
	}
	@Then("^activate free service$")
	public void activate_free_service() throws Throwable {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("FREE53");
		driver.findElement(By.xpath("//button[contains(text(), 'ACTIVATE SERVICE')]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(), 'LATER')]")).click();
		
	}
	@Then("^activate paid service$")
	public void activate_paid_service() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(), ' ACTIVATE')]")).click();
		Select patient_dropdown = new Select(driver.findElement(By.xpath("//select [@ng-model='selectedPatient']")));
		patient_dropdown.selectByVisibleText("Rohit Kumar");
		Select month_dropdown = new Select(driver.findElement(By.xpath("//select [@ng-model='selectedmonth']")));
		month_dropdown.selectByVisibleText("2 Months");
		driver.findElement(By.name("card")).sendKeys("4242424242424242");
		driver.findElement(By.name("cvc")).sendKeys("845");
		driver.findElement(By.name("expiry")).sendKeys("0624");
		
	}
}
