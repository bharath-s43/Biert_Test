package BioAlert;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CareTaker {
	

	
	WebDriver driver = EmailVerification.getdriver();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	//@When("^user clicks on the add new caretaker button$")
	public void user_clicks_on_the_add_new_caretaker_button() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'ADD NEW CARETAKER')]")));
		driver.findElement(By.xpath("//button[contains(text(), 'ADD NEW CARETAKER')]")).click();
	}
	
	//@Then("^enter the caretaker registration details$")
	public void enter_the_caretaker_registration_details() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		driver.findElement(By.name("firstName")).sendKeys("Mark");
		driver.findElement(By.name("lastName")).sendKeys("Thomas");
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
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'CONFIRM')]")));
		driver.findElement(By.xpath("//button[contains(text(), 'CONFIRM')]")).click();
		Thread.sleep(3000);
	}

	@Then("^accept terms and conditions$")
public void accept_terms_and_conditions() throws Throwable {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'AGREED')]")).click();
		
	}
	@Then("^activate free service$")
	public void activate_free_service() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'You have special promotion of')]")));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("FREE53");
		driver.findElement(By.xpath("//button[contains(text(), 'ACTIVATE SERVICE')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'LATER')]")).click();
	
	}
	@Then("^activate paid service$")
	public void activate_paid_service() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'PATIENT PROFILE')]")));
		driver.navigate().refresh();
		driver.findElement(By.xpath("//center[contains(text(), 'Payments')]")).click();
		driver.findElement(By.xpath("//center[contains(text(), 'Pay Now')]")).click();
		Select patient_dropdown = new Select(driver.findElement(By.xpath("//select [@ng-model='selectedPatient']")));
		patient_dropdown.selectByVisibleText("Rohit Kumar");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-4 col-sm-2 col-md-2 col-lg-2']/select")));
		Select month_dropdown = new Select(driver.findElement(By.xpath("//div[@class='col-xs-4 col-sm-2 col-md-2 col-lg-2']/select")));
		month_dropdown.selectByVisibleText("2 Months");
		driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-7 col-md-7 col-lg-7']/div/input")).sendKeys("4242424242424242");
		List <WebElement>cvc=driver.findElements(By.xpath("//input[@placeholder='CVC']"));
		WebElement cvc1 = cvc.get(1);
		cvc1.sendKeys("845");
		/*for(int i=0;i<cvc.size();i++) {
			WebElement cvc1 = cvc.get(1);
			cvc1.sendKeys("845");
			break;
		}*/
		List <WebElement>mmyy =driver.findElements(By.xpath("//input[@placeholder='mm / yy']"));//sendKeys("0624");
		WebElement mmyy1 = mmyy.get(1);
		mmyy1.sendKeys("0624");
		/*for(int i=0;i<mmyy.size();i++) {
			WebElement mmyy1 = mmyy.get(1);
			mmyy1.sendKeys("0624");
			break;
		}*/
	}
	@Then("^click on submit button1$")
	public void click_on_submit_button1() throws Throwable {
		Thread.sleep(2000);
		List <WebElement>submit=driver.findElements(By.xpath("//button[@type='submit']"));
		WebElement submit1 = submit.get(1);
		submit1.click();
		Thread.sleep(3000);
	}
	
}
