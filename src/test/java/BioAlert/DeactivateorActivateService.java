package BioAlert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DeactivateorActivateService {
	
	WebDriver driver = EmailVerification.getdriver();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	@Given("^go to cancel service page$")
	public void go_to_cancel_service_page() throws Throwable {
		driver.findElement(By.xpath("//center[contains(text(), 'Payments')]")).click();
		driver.findElement(By.xpath("//center[contains(text(), 'Cancel Service')]")).click();
	}

	@Then("^click on Deactivate button$")
	public void click_on_Deactivate_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'DE-ACTIVATE')]")));
		driver.findElement(By.xpath("//button[contains(text(), 'DE-ACTIVATE')]")).click();
	}
	
	@Given("^go to patients page$")
	public void go_to_patients_page() throws Throwable {
		driver.findElement(By.xpath("//center[contains(text(), 'Patients')]")).click();
	}

	@Then("^click on Reactivate button$")
	public void click_on_Reactivate_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'RE-ACTIVATE')]")));
		driver.findElement(By.xpath("//button[contains(text(), 'RE-ACTIVATE')]")).click();
	}

	@Given("^select the patient from patient dropdown$")
	public void select_the_patient_from_patient_dropdown() throws Throwable {
		Select patient_dropdown = new Select(driver.findElement(By.xpath("//select [@ng-model='selectedPatient']")));
		patient_dropdown.selectByVisibleText("Arvind Singh");
	}

	@Then("^enter the card details$")
	public void enter_the_card_details() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-4 col-sm-2 col-md-2 col-lg-2']/select")));
		Select month_dropdown = new Select(driver.findElement(By.xpath("//div[@class='col-xs-4 col-sm-2 col-md-2 col-lg-2']/select")));
		month_dropdown.selectByVisibleText("2 Months");
		driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-7 col-md-7 col-lg-7']/div/input")).sendKeys("4242424242424242");
		List <WebElement>cvc=driver.findElements(By.xpath("//input[@placeholder='CVC']"));
		WebElement cvc1 = cvc.get(1);
		cvc1.sendKeys("845");
		
		List <WebElement>mmyy =driver.findElements(By.xpath("//input[@placeholder='mm / yy']"));//sendKeys("0624");
		WebElement mmyy1 = mmyy.get(1);
		mmyy1.sendKeys("0624");
		
	}


}
