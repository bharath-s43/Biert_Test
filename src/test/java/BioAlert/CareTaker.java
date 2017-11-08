package BioAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CareTaker {
	

	WebDriver driver = EmailVerification.getdriver();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	@Given("^user click on the edit for caretakers$")
	public void user_click_on_the_edit_for_caretakers() throws Throwable {
		 jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='col-xs-4 col-sm-4 col-md-3 col-lg-3']/input")).click();
	}
	
	
	@When("^user clicks on the add new caretaker button$")
	public void user_clicks_on_the_add_new_caretaker_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'ADD NEW CARETAKER')]")));
		driver.findElement(By.xpath("//button[contains(text(), 'ADD NEW CARETAKER')]")).click();
	}
	
	@Then("^enter the caretaker registration details$")
	public void enter_the_caretaker_registration_details() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		driver.findElement(By.name("firstName")).sendKeys("Mark");
		driver.findElement(By.name("lastName")).sendKeys("Thomas");
		driver.findElement(By.name("email_id")).sendKeys("bharathmails01@gmail.com");
		Select country_code = new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid']")));
		country_code.selectByVisibleText("India (+91)");
		driver.findElement(By.name("mobile")).sendKeys("6453424234");
		driver.findElement(By.name("sms")).click();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("call")).click();
		
	}
	
	@Then("^verify the email for caretaker approval$")
	public void verify_the_email_for_caretaker_approval() throws Throwable {
		CareTakerEmailVerification.mailVerifyForCareTaker();
	}
	

}
