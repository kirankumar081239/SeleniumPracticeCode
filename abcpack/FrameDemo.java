package abcpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FrameDemo {
	WebDriver d;
	@Test
	public void testFrame() throws Exception
	{
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.get("http://jqueryui.com/autocomplete/");
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		List<WebElement> f=d.findElements(By.tagName("iframe"));
		System.out.println("No of frames:"+f.size());
		d.switchTo().frame(0);
		//d.switchTo().frame(d.findElement(By.className("demo-frame")));
		assertTrue(d.findElement(By.id("tags")).isDisplayed());
		d.switchTo().defaultContent();
		assertTrue(d.findElement(By.linkText("Autocomplete")).isDisplayed());
		Thread.sleep(4000);
	}
	@BeforeMethod
	public void setUp()
	{
		//d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
