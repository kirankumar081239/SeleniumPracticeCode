package abcpack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {
	WebDriver d;
	@Test
	public void testAlert() throws Exception
	{
		d.get("https://retail.onlinesbi.com/retail/login.htm#");
		assertEquals("State Bank of India",d.getTitle());
		d.findElement(By.cssSelector(".phisingcontinueButton")).click();
		d.findElement(By.id("Button2")).click();
		Alert al=d.switchTo().alert();
		assertEquals("Enter username",al.getText());
		al.accept();
		d.findElement(By.id("username")).sendKeys("Selenium");
		d.findElement(By.id("Button2")).click();
		assertEquals("Enter password",al.getText());
		al.accept();
		d.findElement(By.id("label2")).sendKeys("Selenium");
		Thread.sleep(5000);
		
		
	}
	@Before
	public void setUp()
	{
		//d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
	}
	@After
	public void tearDown()
	{
		d.quit();
	}

}
