package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragNDropDemo {
	WebDriver d;
	@Test
	public void testDragNDrop() throws Exception
	{
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.get("http://jqueryui.com/droppable/");
		assertEquals("Droppable | jQuery UI",d.getTitle());
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDrop(d.findElement(By.id("draggable")), d.findElement(By.id("droppable"))).perform();
		Thread.sleep(5000);
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
