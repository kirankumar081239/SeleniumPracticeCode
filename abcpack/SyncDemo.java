package abcpack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SyncDemo {
	WebDriver d;
	
	@Test
	public void testSync() throws Exception
	{
		d.get("http://google.co.in/");
		assertEquals("Google",d.getTitle());
		d.findElement(By.id("gbqfq")).sendKeys("Selenium");
		d.findElement(By.id("gbqfb")).click();
		d.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		d.findElement(By.linkText("Download")).click();
		assertEquals("Selenium IDE",d.findElement(By.xpath("//div[@id='mainContent']/h3")).getText());
		Thread.sleep(5000);
	}
	@Before
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
	}
	@After
	public void tearDown()
	{
		d.quit();
	}
		

}
