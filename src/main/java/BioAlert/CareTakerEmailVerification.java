package BioAlert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareTakerEmailVerification {
	
public static WebDriver driver = null;
	
	public static void mailVerifyForCareTaker() throws Throwable {
	System.setProperty("webdriver.chrome.driver","Tools/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.google.com/gmail/");
	driver.manage().window().maximize();
	
	driver.findElement(By.name("identifier")).sendKeys("bharathmails01@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
	Thread.sleep(2000);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	driver.findElement(By.name("password")).sendKeys("#abcd123");
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Next')]")));
	driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
	Thread.sleep(2000);
	String web = "//span[@class='bog']/b[contains(text(),'Approval request to assign you as a caretaker for Arvind')]";
	//String web = "//span[text()='Excellent! Please verify your BioLert account to complete the signup.']";
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(web)));
	driver.findElement(By.xpath(web)).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> email = driver.findElements(By.xpath("//div[@class='gs']/div[7]/div[1]"));
	System.out.println(email.size());
	for(int i =0;i<email.size();i++){
		System.out.println(email.get(i));
		if(i==email.size()-1){
			System.out.println("anadadnad"+email.get(i));
			String [] path = email.get(i).getText().split("\\n");
			System.out.println(path[5]);
			path[5]= path[5].replace("Please provide your approval for receiving email and sms notifications at", "");
			path[5]= path[5].replace(" (You can copy and paste this link to browser address bar in case your email client prevents clicking link in email).", "");
			path[5] = path[5].trim();
			driver.findElement(By.linkText(path[5])).click();
			 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(0));
			    driver.close();
			    driver.switchTo().window(tabs2.get(1));
			    driver.findElement(By.xpath("//button[contains(text(), 'CONFIRM')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'OK')]")));
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		    driver.close();
		    
			
		}
	}	
}
 
	
}

