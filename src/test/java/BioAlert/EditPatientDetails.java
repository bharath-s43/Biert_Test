package BioAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class EditPatientDetails {
	
	WebDriver driver = EmailVerification.getdriver();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	@Given("^user clicks on patient profile$")
	public void user_clicks_on_patient_profile() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'PATIENT PROFILE')]")));
		driver.findElement(By.xpath("//button[contains(text(), 'PATIENT PROFILE')]")).click();
	}

	@Then("^click on Edit for patient details$")
	public void click_on_Edit_for_patient_details() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Patient Profile')]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='col-xs-4 col-sm-3 col-md-3 col-lg-3']/input[@value='EDIT']")).click();
		
	}

	@Then("^edit all the fields$")
	public void edit_all_the_fields() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys("Arvind");
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys("Singh");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("arvindsingh@gmail.com");
		Select country_code = new Select(driver.findElement(By.xpath("//div[@class='col-xs-6 col-sm-3 col-md-3 col-lg-3']/select[1]")));
		country_code.selectByVisibleText("United States (+1)");
		
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys("8242424242");
		driver.findElement(By.id("date")).sendKeys("09132002");
	     jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@data-ng-model='patientEdit.address']")).clear();
		driver.findElement(By.xpath("//input[@data-ng-model='patientEdit.address']")).sendKeys("71 Pilgrim Avenue, Chevy Chase");
		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys("United States");
		Thread.sleep(1000);
		driver.findElement(By.id("country")).sendKeys(Keys.TAB);
		driver.findElement(By.id("country")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("Virginia");
		Thread.sleep(1000);
		driver.findElement(By.id("state")).sendKeys(Keys.TAB);
		driver.findElement(By.id("state")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Fairfax");
		Thread.sleep(1000);
		driver.findElement(By.id("city")).sendKeys(Keys.TAB);
		driver.findElement(By.id("city")).sendKeys(Keys.ENTER);
	}

	@Then("^click on update$")
	public void click_on_update() throws Throwable {
		 jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//button[contains(text(), 'UPDATE')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Patient Profile')]")));
	}



}
