package abcpack;

import org.testng.Assert;

import static org.testng.Assert.*;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinksDemo {
	WebDriver d;
	@Test(retryAnalyzer=Retry.class)
	public void testLinks() throws Exception
	{
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.navigate().to("http://docs.seleniumhq.org/");
		assertEquals("Selenium - Web Browser Automation",d.getTitle());
		List<WebElement> l=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
		System.out.println("No of links: "+l.size());
		System.out.println("*************************");
		System.out.println("Link names are");
		System.out.println("*************************");
		String links[]=new String[l.size()];
		int i=0;
		for(WebElement e:l)
		{
			links[i]=e.getText();
			System.out.println(links[i]);
			i++;
		}
		for(String s:links)
		{
			d.findElement(By.linkText(s)).click();
			if(d.getTitle().equals("Error 404"))
			{
				System.out.println("Link: "+s+": Not working");
			}
			else
			{
				System.out.println("Link: "+s+": working fine");
			}
		}
		Thread.sleep(4000);
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) throws Exception
	{
		if(browser.equals("FF"))
		{
			DesiredCapabilities b = DesiredCapabilities.firefox();
			d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
			
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","F:\\Selenium_Scripts_Sep14\\Lib\\IEDriverServer.exe");
			DesiredCapabilities b = DesiredCapabilities.internetExplorer();
			d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
		}
		else if(browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Sep14\\Lib\\chromedriver.exe");
			DesiredCapabilities b = DesiredCapabilities.chrome();
			d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
		}
			
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
		

}
