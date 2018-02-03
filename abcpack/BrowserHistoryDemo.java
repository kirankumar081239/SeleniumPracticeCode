package abcpack;

import org.testng.Assert;
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserHistoryDemo {
	WebDriver d;
	@Test
	public void testBrowserHistory() throws Exception
	{
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.navigate().to("http://docs.seleniumhq.org/");
		assertEquals("Selenium - Web Browser Automation",d.getTitle());
		d.findElement(By.linkText("Download")).click();
		Thread.sleep(2000);
		d.navigate().back();
		Thread.sleep(2000);
		d.navigate().forward();
		Thread.sleep(2000);
		d.navigate().refresh();
		Thread.sleep(4000);
	}
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
		d.manage().window().maximize();
	}
	

	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
		

}
