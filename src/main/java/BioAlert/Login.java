package BioAlert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login {
	
	WebDriver driver = EmailVerification.getdriver();
	
	@Given("^user enters the credentials$")
	public void user_enters_the_credentials(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("password")).sendKeys(data.get(1).get(1));
	}

	@Then("^click on log in button$")
	public void click_on_log_in_button() throws Throwable {
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);

}
}