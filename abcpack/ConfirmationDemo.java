package abcpack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationDemo {
	WebDriver d;
	@Test
	public void testConfirmation() throws Exception
	{
		d.get("http://jsbin.com/enifaf");
		d.findElement(By.cssSelector("button[onclick='launchConfirm()']")).click();
		Alert al=d.switchTo().alert();
		assertEquals("Press a button!",al.getText());
		al.dismiss();
		assertEquals("You pressed Cancel!",d.findElement(By.id("chosenButton")).getText());
		Thread.sleep(4000);
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
