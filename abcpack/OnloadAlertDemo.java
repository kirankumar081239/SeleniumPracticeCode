package abcpack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OnloadAlertDemo {
	WebDriver d;
	@Test
	public void testOnloadAlert() throws Exception
	{
		d.get("http://www.dailyfreecode.com/code/simple-display-alert-onload-event-page-2194.aspx");
		Alert al=d.switchTo().alert();
		assertEquals("This is syntax-example.com site.",al.getText());
		al.accept();
		assertTrue(d.findElement(By.id("hlHome")).isDisplayed());
		
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
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
	}
	@After
	public void tearDown()
	{
		d.quit();
	}

}
