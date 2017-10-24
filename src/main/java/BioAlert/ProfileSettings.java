package BioAlert;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ProfileSettings {
	
	WebDriver driver = EmailVerification.getdriver();
	
	@Given("^go to profile settings page$")
	public void go_to_profile_settings_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'HOME')]")));	
		driver.findElement(By.xpath("//button[contains(text(), 'HOME')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'PATIENT PROFILE')]")));
		driver.findElement(By.xpath("//center[contains(text(), 'Payments')]")).click();
		driver.findElement(By.xpath("//center[contains(text(), 'Profile Settings')]")).click();
	 
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
		Thread.sleep(2000);
		//.btn.btn-primary.ng-binding
		driver.findElement(By.xpath("//*[@id='updateprofile']/div/div[3]/center/button")).click();
		
	}
	
	@Then("^change the password$")
	public void change_the_password() throws Throwable {
		 driver.findElement(By.xpath("//input [@ng-model='subscriberemail']")).sendKeys("bharathsb43@gmail.com");
		 driver.findElement(By.xpath("//input [@ng-model='oldpassword']")).sendKeys("#abcd123");
		 driver.findElement(By.xpath("//input [@ng-model='newpassword']")).sendKeys("#abcd1234");
		 driver.findElement(By.xpath("//input [@ng-model='confirmpassword']")).sendKeys("#abcd1234");
		 ((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(By.xpath("//button[contains(text(), 'Change Password')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='changepassword']/div/div[3]/center/button")).click();
		 
	}
	
	@Given("^logout of the portal$")
	public void logout_of_the_portal() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
	}
}
