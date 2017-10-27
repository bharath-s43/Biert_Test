package BioAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PatientRegistration {
	
	WebDriver driver = EmailVerification.getdriver();
	
@When("^user enters the patient details$")
	public void user_enters_the_patient_details() throws Throwable {
		
		
		driver.findElement(By.name("firstName")).sendKeys("Rohit");
		driver.findElement(By.name("lastName")).sendKeys("Kumar");
		driver.findElement(By.name("email")).sendKeys("rohit@gmail.com");
		Select country_code = new Select(driver.findElement(By.xpath("//div[@class='col-xs-6 col-sm-3 col-md-3 col-lg-3']/select[1]")));
		country_code.selectByVisibleText("India (+91)");
		
		driver.findElement(By.name("mobile")).sendKeys("8785745455");
		driver.findElement(By.id("date")).sendKeys("12251999");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.name("address")).sendKeys("A-6 Safal Profitaire,Corporate Road");
		driver.findElement(By.id("country")).sendKeys("India");
		Thread.sleep(1000);
		driver.findElement(By.id("country")).sendKeys(Keys.TAB);
		driver.findElement(By.id("country")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("state")).sendKeys("Karnataka");
		Thread.sleep(1000);
		driver.findElement(By.id("state")).sendKeys(Keys.TAB);
		driver.findElement(By.id("state")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("city")).sendKeys("Bengaluru");
		Thread.sleep(1000);
		driver.findElement(By.id("city")).sendKeys(Keys.TAB);
		driver.findElement(By.id("city")).sendKeys(Keys.ENTER);
	}
@Then("^click on submit button$")
public void click_on_submit_button() throws Throwable {
	driver.findElement(By.xpath("//button[contains(text(), 'SUBMIT')]")).click();
	Thread.sleep(3000);
}
}
