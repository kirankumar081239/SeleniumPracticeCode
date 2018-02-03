package abcpack;

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

public class NewTabDemo {
	WebDriver d;

	@BeforeMethod
	public void init()
	{
		//d=new FirefoxDriver();
				System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\IEDriverServer.exe");
				//d=new InternetExplorerDriver();
				System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\chromedriver.exe");
				d=new ChromeDriver();
				d.manage().window().maximize();
	}
	@AfterMethod
	public void stop()
	{
		d.quit();
	}
	@Test
	public void testAjax() throws Exception
	{
			
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);	
		d.manage().window().maximize();
		d.get("http://www.google.com");
		WebElement about = d.findElement(By.linkText("About"));
		WebElement you = d.findElement(By.linkText("+You"));
		Actions oAction=new Actions(d);

		oAction.moveToElement(about).keyDown(Keys.CONTROL).click(about)
		                             .keyUp(Keys.CONTROL).build().perform();

		Thread.sleep(1000);
		Actions oAction1=new Actions(d);

		oAction1.moveToElement(you).keyDown(Keys.CONTROL).click(you)
		                             .keyUp(Keys.CONTROL).perform();
		Thread.sleep(4000);
	}

		

}
