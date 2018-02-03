package abcpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MultipleFrames {
	WebDriver d;
	@Test
	public void testMultipleFrames() throws Exception
	{
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.get("http://selenium.googlecode.com/git/docs/api/java/index.html");
		assertEquals("Overview",d.getTitle());
		List<WebElement> f=d.findElements(By.tagName("frame"));
		System.out.println("No of frames:"+f.size());
		d.switchTo().frame(0);
		d.findElement(By.linkText("com.thoughtworks.selenium")).click();
		d.switchTo().defaultContent();
		d.switchTo().frame(1);
		d.findElement(By.linkText("Selenium")).click();
		d.switchTo().defaultContent();
		d.switchTo().frame(2);
		assertEquals("Interface Selenium",d.findElement(By.xpath("//*[@title='Interface Selenium']")).getText());
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
