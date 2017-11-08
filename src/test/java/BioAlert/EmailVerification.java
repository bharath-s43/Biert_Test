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

public class EmailVerification {
	
	public static WebDriver driver = null;
	
	public static void mailVerify() throws Throwable {
	System.setProperty("webdriver.chrome.driver","Tools/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.google.com/gmail/");
	driver.manage().window().maximize();
	
	driver.findElement(By.name("identifier")).sendKeys("bharathsb43@gmail.com");
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
	String web = "//span[@class='bog']/b[contains(text(),'Excellent! Please verify your BioLert account to complete the signup.')]";
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
			System.out.println(path[7]);
			path[7]= path[7].replace("Please click on", "");
			path[7]= path[7].replace("to complete registration process!", "");
			path[7] = path[7].trim();
			driver.findElement(By.linkText(path[7])).click();
			Thread.sleep(5000);
			
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(0));
		    driver.close();
		    driver.switchTo().window(tabs2.get(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		
			
		}
	}	
}
	public static WebDriver getdriver() {
		return driver;
	}
}
