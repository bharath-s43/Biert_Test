package BioAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ProfileSettings {
	
	WebDriver driver = EmailVerification.getdriver();
	
	@Given("^go to profile settings page$")
	public void go_to_profile_settings_page() throws Throwable {
	 driver.findElement(By.xpath("//span [@class='caret']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Profile Settings')]")).click();
	 
	}

	@Then("^click on edit profile$")
	public void click_on_edit_profile() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(), 'Edit Profile')]")).click();
	}

	@Then("^edit the details of name$")
	public void edit_the_details_of_name() throws Throwable {
		 driver.findElement(By.xpath("//input [@ng-model='data.firstName']")).clear();
		 driver.findElement(By.xpath("//input [@ng-model='data.firstName']")).sendKeys("Rishi");
		 driver.findElement(By.xpath("//input [@ng-model='data.lastName']")).clear();
		 driver.findElement(By.xpath("//input [@ng-model='data.lastName']")).sendKeys("Shah");
	}

	@Then("^click on save profile$")
	public void click_on_save_profile() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(), 'Save Profile')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
	}
	
	@Then("^change the password$")
	public void change_the_password() throws Throwable {
		 driver.findElement(By.xpath("//input [@ng-model='subscriberemail']")).sendKeys("bharathsb43@gmail.com");
		 driver.findElement(By.xpath("//input [@ng-model='oldpassword']")).sendKeys("#abcd123");
		 driver.findElement(By.xpath("//input [@ng-model='newpassword']")).sendKeys("#abcd1234");
		 driver.findElement(By.xpath("//input [@ng-model='confirmpassword']")).sendKeys("#abcd1234");
			driver.findElement(By.xpath("//button[contains(text(), 'Change Password')]")).click();
		 

	}
}
