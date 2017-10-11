package BioAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import BioAlert.EmailVerification;

public class Registration {
	
	public static WebDriver driver = null;
	
	@Given("^go to bioalert portal$")
	public void go_to_bioalert_portal() throws Throwable {
		System.setProperty("webdriver.chrome.driver","Tools/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://54.187.202.249/index.html#/login");
		driver.manage().window().maximize();   
	}

	@Then("^click on the Register button$")
	public void click_on_the_Register_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(), 'REGISTER')]")).click();
	}

	@Then("^enter the user details$")
	public void enter_the_user_details() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		driver.findElement(By.name("firstName")).sendKeys("Bharath");
		driver.findElement(By.name("lastName")).sendKeys("Suresh");
		driver.findElement(By.name("email")).sendKeys("bharathsb43@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("#abcd123");
		driver.findElement(By.name("repasswd")).sendKeys("#abcd123");
	}

	@Then("^click on submit$")
	public void click_on_submit() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(), 'SUBMIT')]")).click();
		Thread.sleep(3000);
	}
	
	@Then("^verify the email$")
	public void verify_the_email() throws Throwable {
		EmailVerification.mailVerify();
	}


}
