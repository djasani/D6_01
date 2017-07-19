import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.junit.Assert;
import org.junit.Ignore;
public class SdetTraining_TestCases {

	private WebDriver driver;
	private String baseUrl;

	
	@Test
	public void tc_login() throws InterruptedException{
		baseUrl = "http://sdettraining.com/";
		//System.setProperty("webdriver.ie.driver", "C:\\0717\\alljars\\IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\0717\\alljars\\geckodriver.exe");
		
		//driver = new InternetExplorerDriver();
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "trguitransactions/default.aspx?id=new");
		Thread.sleep(3000);
		driver.findElement(By.id("HeadLoginView_lblLoginStatus")).click();
		driver.findElement(By.xpath(".//*[@id='MainContent_txtUserName']")).clear();
		driver.findElement(By.xpath(".//*[@id='MainContent_txtUserName']")).sendKeys("sdet702@sdettraining.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).clear();
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("Password");
		driver.findElement(By.id("MainContent_btnLogin")).click();
		Thread.sleep(3000);
		Assert.assertEquals("Welcome back!", driver.findElement(By.xpath(".//*[@id='MainContent_lblid']/h1")).getText());
		
	}
	
	@Ignore
	@Test
	public void tc_newmember() {
		// 1. Open browser and navigate to the AUT
		// 2. Click on Login
		// 3. Click on create account button
		// 4. enter user detail
		baseUrl = "http://sdettraining.com/";
		System.setProperty("webdriver.gecko.driver", "C:\\0717\\alljars\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(baseUrl + "/trguitransactions/Account.aspx");
		driver.findElement(By.id("createaccount")).click();
		driver.findElement(By.id("MainContent_txtFirstName")).clear();
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("John");
		driver.findElement(By.id("MainContent_txtLastName")).clear();
		driver.findElement(By.id("MainContent_txtLastName")).sendKeys("Appleseed");
		driver.findElement(By.id("MainContent_Male")).click();
		driver.findElement(By.id("MainContent_txtEmail")).clear();
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("sdet702@sdettraining.com");
		driver.findElement(By.id("MainContent_txtPassword")).clear();
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("Password");
		driver.findElement(By.id("MainContent_txtVerifyPassword")).clear();
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("Password");
		driver.findElement(By.id("MainContent_txtHomePhone")).clear();
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys("703-555-5555");
		driver.findElement(By.id("MainContent_txtCellPhone")).clear();
		driver.findElement(By.id("MainContent_txtCellPhone")).sendKeys("703-555-5555");
		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		driver.findElement(By.id("MainContent_txtInstructions")).clear();
		driver.findElement(By.id("MainContent_txtInstructions")).sendKeys("Notes");
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		Assert.assertEquals("Customer information added successfully", 
						driver.findElement(By.id("MainContent_lblTransactionResult")).getText());

	}
}
